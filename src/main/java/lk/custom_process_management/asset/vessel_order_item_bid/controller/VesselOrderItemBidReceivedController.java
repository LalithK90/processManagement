package lk.custom_process_management.asset.vessel_order_item_bid.controller;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.PaymentStatus;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item.service.VesselOrderItemService;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.asset.vessel_order_item_bid.model.VesselOrderBid;
import lk.custom_process_management.asset.vessel_order_item_bid.service.VesselOrderItemBidService;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.service.VesselOrderItemBidPaymentService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import lk.custom_process_management.util.service.EmailService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/vesselOrderItemBidReceived" )
public class VesselOrderItemBidReceivedController {
  private final VesselOrderService vesselOrderService;
  private final VesselOrderItemService vesselOrderItemService;
  private final VesselOrderItemBidService vesselOrderItemBidService;
  private final VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService;
  private final PaymentService paymentService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;
  private final EmailService emailService;

  public VesselOrderItemBidReceivedController(VesselOrderService vesselOrderService,
                                              VesselOrderItemService vesselOrderItemService,
                                              VesselOrderItemBidService vesselOrderItemBidService,
                                              VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService,
                                              PaymentService paymentService,
                                              MakeAutoGenerateNumberService makeAutoGenerateNumberService,
                                              EmailService emailService, DateTimeAgeService dateTimeAgeService) {
    this.vesselOrderService = vesselOrderService;
    this.vesselOrderItemService = vesselOrderItemService;
    this.vesselOrderItemBidService = vesselOrderItemBidService;
    this.vesselOrderItemBidPaymentService = vesselOrderItemBidPaymentService;
    this.paymentService = paymentService;
    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    this.emailService = emailService;
    this.dateTimeAgeService = dateTimeAgeService;
  }


  private final DateTimeAgeService dateTimeAgeService;


  private String commonFindAll(Model model, LocalDate from, LocalDate to) {

    model.addAttribute("payments",
                       paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(from)
                           , dateTimeAgeService.dateTimeToLocalDateEndInDay(to))
                           .stream()
                           .filter(x -> x.getStatusConformation().equals(StatusConformation.INR) && (x.getVesselOrder().getClosingDate().isAfter(LocalDate.now()) || x.getVesselOrder().getClosingDate().equals(LocalDate.now())) && x.getVesselOrder().getVesselOrderStatus().equals(VesselOrderStatus.APPROVE))
                           .collect(Collectors.toList()));

    model.addAttribute("message",
                       "Following table show details belongs from " + from.toString() + " to " + to.toString() +
                           "there month. if you need to more please search using above method");
    return "vesselOrderItemBidReceived/vesselOrderItemBidReceived";
  }

  @GetMapping
  public String findAll(Model model) {
    return commonFindAll(model, dateTimeAgeService.getPastDateByMonth(3), LocalDate.now());

  }

  @PostMapping( "/search" )
  public String invoiceSearch(@ModelAttribute TwoDate twoDate, Model model) {
    return commonFindAll(model, twoDate.getStartDate(), twoDate.getEndDate());
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
        payment.setStatusConformation(StatusConformation.PEN);
        //chandler
        payment.setChandler(chandler);
        //vesselOrder
        payment.setVesselOrder(vesselOrder);

        Payment paymentDb = paymentService.persist(payment);
        vesselOrderItemBidsFiltered.forEach(x -> {
          VesselOrderItemBidPayment vesselOrderItemBidPayment = new VesselOrderItemBidPayment();
          vesselOrderItemBidPayment.setVesselOrderItemBid(x);
          vesselOrderItemBidPayment.setPaymentStatus(PaymentStatus.NOTPAID);
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


    return "redirect:/vesselOrderItemBidReceived";
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
