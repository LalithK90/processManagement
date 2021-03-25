package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.PaymentStatus;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item.service.VesselOrderItemService;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.enums.BidValidOrNot;
import lk.custom_process_management.asset.vessel_order_item_bid.model.VesselOrderBid;
import lk.custom_process_management.asset.vessel_order_item_bid.service.VesselOrderItemBidService;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.service.VesselOrderItemBidPaymentService;
import lk.custom_process_management.util.service.EmailService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/vesselOrderItemApproval" )
public class VesselOrderItemBidApprovalController {
  private final VesselOrderService vesselOrderService;
  private final VesselOrderItemService vesselOrderItemService;
  private final VesselOrderItemBidService vesselOrderItemBidService;
  private final VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService;
  private final PaymentService paymentService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;
  private final EmailService emailService;

  public VesselOrderItemBidApprovalController(VesselOrderService vesselOrderService,
                                              VesselOrderItemService vesselOrderItemService,
                                              VesselOrderItemBidService vesselOrderItemBidService,
                                              VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService,
                                              PaymentService paymentService,
                                              MakeAutoGenerateNumberService makeAutoGenerateNumberService,
                                              EmailService emailService) {
    this.vesselOrderService = vesselOrderService;
    this.vesselOrderItemService = vesselOrderItemService;
    this.vesselOrderItemBidService = vesselOrderItemBidService;
    this.vesselOrderItemBidPaymentService = vesselOrderItemBidPaymentService;
    this.paymentService = paymentService;
    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    this.emailService = emailService;
  }


  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vesselOrders", vesselOrderService.findByVesselOrderStatus(VesselOrderStatus.BIDEN));
    return "vesselOrderItemApproval/vesselOrderItemApproval";
  }

  @GetMapping( "/{id}" )
  public String addForm(@PathVariable Integer id, Model model) {
    Comparator< VesselOrderItemBid > compareByBidenPrice =
        Comparator.comparing(VesselOrderItemBid::getAmount);

    List< VesselOrderItemBid > vesselOrderItemBids = new ArrayList<>();

    VesselOrder vesselOrder = vesselOrderService.findById(id);

    vesselOrder.getVesselOrderItems().forEach(
        x -> vesselOrderItemBidService.findByVesselOrderItem(x)
            .stream()
            .sorted(compareByBidenPrice)
            .collect(Collectors.toList()).forEach(y -> {
              y.setItem(x.getItem());
              y.setBidValidOrNot(BidValidOrNot.REJECT);
              vesselOrderItemBids.add(y);
            }));

    model.addAttribute("vesselOrderItemBids", vesselOrderItemBids);

    model.addAttribute("vesselOrderDetail", vesselOrder);
    model.addAttribute("vesselDetail", vesselOrder.getVesselArrivalHistory().getVessel());
    List< BidValidOrNot > bidValidOrNots = new ArrayList<>();
    bidValidOrNots.add(BidValidOrNot.REJECT);
    bidValidOrNots.add(BidValidOrNot.SELECT);
    model.addAttribute("bidValidOrNots", bidValidOrNots);
    model.addAttribute("vesselOrderBid", new VesselOrderBid());
    return "vesselOrderItemApproval/addVesselOrderItemApproval";
  }

  @PostMapping( "/save" )
  public String saveApprove(@ModelAttribute VesselOrderBid vesselOrderBid) {

    vesselOrderBid.getVesselOrderItemBids().forEach(x -> System.out.println(x.getId()));

    List< VesselOrderItemBid > vesselOrderItemBids =
        vesselOrderItemBidService.saveAll(vesselOrderBid.getVesselOrderItemBids());

    for ( VesselOrder vesselOrder : vesselOrders(vesselOrderItemBids) ) {
      for ( Chandler chandler : chandlers(vesselOrderItemBids) ) {
        //make payment
        Payment payment = new Payment();
        //last payment
        Payment lastPayment = paymentService.lastPayment();
        if ( lastPayment == null ) {
          payment.setCode("SLCP" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
        } else {
          String previousCode = lastPayment.getCode().substring(4);
          payment.setCode("SLCP" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
        }

        List< BigDecimal > totalAmount = new ArrayList<>();
        List< VesselOrderItemBid > vesselOrderItemBidsFiltered = vesselOrderItemBids
            .stream()
            .filter(x -> x.getChandler().equals(chandler) && x.getVesselOrderItem().getVesselOrder().equals(vesselOrder))
            .collect(Collectors.toList());
        vesselOrderItemBidsFiltered.forEach(x -> totalAmount.add(x.getAmount()));
        //amount
        BigDecimal totalPrice = totalAmount.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        payment.setAmount(totalPrice);
        //statusConformation
        payment.setStatusConformation(StatusConformation.INR);
        //chandler
        payment.setChandler(chandler);
        //vesselOrder
        payment.setVesselOrder(vesselOrder);

        Payment paymentDb = paymentService.persist(payment);
        vesselOrderItemBidsFiltered.forEach(x -> {
          VesselOrderItemBidPayment vesselOrderItemBidPayment = new VesselOrderItemBidPayment();
          vesselOrderItemBidPayment.setVesselOrderItemBid(x);
          vesselOrderItemBidPayment.setPaymentStatus(PaymentStatus.ITEMNR);
          vesselOrderItemBidPayment.setPayment(paymentDb);
          vesselOrderItemBidPaymentService.persist(vesselOrderItemBidPayment);
        });

        //need to send email

        StringBuilder message =
            new StringBuilder(" Dear \n" + chandler.getName() + "\n According to this vessel order number  " + vesselOrder.getNumber() + " below item was approved \n\n\n\n" + "\t\t Item Name \t\t\t Quantity \t\t\t Unit Price(Rs.) \t\t\t Total");

        for ( VesselOrderItemBid vesselOrderItemBid : vesselOrderItemBidsFiltered ) {
          message.append("\t\t").append(vesselOrderItemBid.getVesselOrderItem().getItem().getName()).append("\t\t\t").append(vesselOrderItemBid.getVesselOrderItem().getQuantity()).append("\t\t\t").append(vesselOrderItemBid.getUnitPrice()).append("\t\t\t").append(vesselOrderItemBid.getAmount().toString());
        }
        if ( chandler.getEmail() != null ) {
          emailService.sendEmail(chandler.getEmail(), "Inform Biden Vessel Order Status " + vesselOrder.getNumber(),
                                 message.toString());
        }

      }
//vesselOrder save after changing vesselOrder order status
      vesselOrder.setVesselOrderStatus(VesselOrderStatus.APPROVE);
      vesselOrderService.persist(vesselOrder);
    }


    return "redirect:/vesselOrderItemApproval";
  }

  private List< Chandler > chandlers(List< VesselOrderItemBid > vesselOrderItemBids) {
    List< Chandler > chandlers = new ArrayList<>();
    vesselOrderItemBids.forEach(x -> chandlers.add(x.getChandler()));
    return chandlers.stream().distinct().collect(Collectors.toList());
  }

  private List< VesselOrder > vesselOrders(List< VesselOrderItemBid > vesselOrderItemBids) {
    List< VesselOrder > vesselOrders = new ArrayList<>();

    for ( VesselOrderItemBid vesselOrderItemBid : vesselOrderItemBids ) {
      vesselOrders.add(vesselOrderItemService.findById(vesselOrderItemBid.getVesselOrderItem().getId()).getVesselOrder());
    }
    return vesselOrders.stream().distinct().collect(Collectors.toList());
  }

}
