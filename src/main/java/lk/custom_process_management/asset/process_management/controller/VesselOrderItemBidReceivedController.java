package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.PaymentStatus;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.vessel_order_item.service.VesselOrderItemService;
import lk.custom_process_management.asset.vessel_order_item_bid.service.VesselOrderItemBidService;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.service.VesselOrderItemBidPaymentService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import lk.custom_process_management.util.service.EmailService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/vesselOrderItemBidReceived" )
public class VesselOrderItemBidReceivedController {
  private final VesselOrderService vesselOrderService;
  private final PaymentService paymentService;
  private final VesselOrderItemService vesselOrderItemService;
  private final VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService;
  private final ChandlerService chandlerService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;
  private final EmailService emailService;
  private final VesselOrderItemBidService vesselOrderItemBidService;

  public VesselOrderItemBidReceivedController(VesselOrderService vesselOrderService,
                                              VesselOrderItemService vesselOrderItemService,
                                              VesselOrderItemBidService vesselOrderItemBidService,
                                              VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService,
                                              PaymentService paymentService,
                                              ChandlerService chandlerService, MakeAutoGenerateNumberService makeAutoGenerateNumberService,
                                              EmailService emailService, DateTimeAgeService dateTimeAgeService) {
    this.vesselOrderService = vesselOrderService;
    this.vesselOrderItemService = vesselOrderItemService;
    this.vesselOrderItemBidService = vesselOrderItemBidService;
    this.vesselOrderItemBidPaymentService = vesselOrderItemBidPaymentService;
    this.paymentService = paymentService;
    this.chandlerService = chandlerService;
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
                           //todo: finaly need to remove this .filter(x -> x.getStatusConformation().equals
                           // (StatusConformation.INR) && (x.getVesselOrder().getClosingDate().isAfter(LocalDate.now
                           // ()) || x.getVesselOrder().getClosingDate().equals(LocalDate.now())) && x.getVesselOrder
                           // ().getVesselOrderStatus().equals(VesselOrderStatus.APPROVE))
                           .filter(x -> x.getStatusConformation().equals(StatusConformation.INR))
                           .collect(Collectors.toList()));

    model.addAttribute("message",
                       "Following table show details belongs from " + from.toString() + " to " + to.toString() +
                           "there month. if you need to more please search using above method");
    model.addAttribute("searchUrl", "vesselOrderItemBidReceived");
    return "vesselOrderItemBidReceived/vesselOrderItemBidReceived";
  }

  @GetMapping
  public String findAll(Model model) {
    return commonFindAll(model, dateTimeAgeService.getPastDateByMonth(3), LocalDate.now());

  }

  @PostMapping
  public String findAll(@ModelAttribute TwoDate twoDate, Model model) {
    return commonFindAll(model, twoDate.getStartDate(), twoDate.getEndDate());

  }
  @GetMapping( "/{id}" )
  public String toReceiveConfirmView(@PathVariable( "id" ) Integer id, Model model) {
    Payment payment = paymentService.findById(id);
    model.addAttribute("payment", payment);
    VesselOrder vesselOrder = vesselOrderService.findById(payment.getVesselOrder().getId());
    model.addAttribute("vesselOrderDetail", vesselOrder);
    model.addAttribute("vesselArrivalHistoryDetail", vesselOrder.getVesselArrivalHistory());
    model.addAttribute("vesselDetail", vesselOrder.getVesselArrivalHistory().getVessel());


    List< VesselOrderItem > vesselOrderItems = new ArrayList<>();
    for ( VesselOrderItemBidPayment vesselOrderItemBidPayment : payment.getVesselOrderItemBidPayments() ) {
      vesselOrderItems.add(
          vesselOrderItemService.findById(vesselOrderItemBidPayment.getVesselOrderItemBid().getVesselOrderItem().getId()));
    }

    model.addAttribute("chandlerDetail", chandlerService.findById(payment.getChandler().getId()));

    model.addAttribute("vesselOrderItems", vesselOrderItems);

    return "vesselOrderItemBidReceived/vesselOrderReceived";
  }


  @GetMapping( "/received/{id}" )
  public String toReceiveConfirm(@PathVariable( "id" ) Integer id) {
    Payment payment = paymentService.findById(id);
    payment.setStatusConformation(StatusConformation.REC);
    Payment paymentDb = paymentService.persist(payment);

    paymentDb.getVesselOrderItemBidPayments().forEach(x -> {
      VesselOrderItemBidPayment vesselOrderItemBidPayment = vesselOrderItemBidPaymentService.findById(x.getId());
      vesselOrderItemBidPayment.setPaymentStatus(PaymentStatus.NOTPAID);
      vesselOrderItemBidPaymentService.persist(vesselOrderItemBidPayment);
    });

    return "redirect:/vesselOrderItemBidReceived";
  }


}
