package lk.custom_process_management.asset.payment.controller;


import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.PaymentStatus;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details.entity.enums.RelevantParty;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.vessel_arrival_history.service.VesselArrivalHistoryService;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.vessel_order_item.service.VesselOrderItemService;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.service.VesselOrderItemBidPaymentService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import lk.custom_process_management.util.service.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/payment" )
public class PaymentController {

  private final PaymentService paymentService;
  private final DateTimeAgeService dateTimeAgeService;
  private final UserService userService;
  private final VesselArrivalHistoryService vesselArrivalHistoryService;
  private final VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService;
  private final EmailService emailService;
  private final ShipAgentService shipAgentService;
  private final VesselOrderService vesselOrderService;
  private final ChandlerService chandlerService;
  private final VesselOrderItemService vesselOrderItemService;

  public PaymentController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService,
                           UserService userService, VesselArrivalHistoryService vesselArrivalHistoryService,
                           VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService,
                           EmailService emailService, ShipAgentService shipAgentService,
                           VesselOrderService vesselOrderService, ChandlerService chandlerService,
                           VesselOrderItemService vesselOrderItemService) {
    this.paymentService = paymentService;
    this.dateTimeAgeService = dateTimeAgeService;
    this.userService = userService;
    this.vesselArrivalHistoryService = vesselArrivalHistoryService;
    this.vesselOrderItemBidPaymentService = vesselOrderItemBidPaymentService;
    this.emailService = emailService;
    this.shipAgentService = shipAgentService;
    this.vesselOrderService = vesselOrderService;
    this.chandlerService = chandlerService;
    this.vesselOrderItemService = vesselOrderItemService;
  }

  private String commonFindAll(Model model, LocalDate from, LocalDate to) {

    List< Payment > payments =
        paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(from),
                                                dateTimeAgeService.dateTimeToLocalDateEndInDay(to));

    UserDetails userDetails =
        userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).getUserDetails();

    if ( userDetails.getRelevantParty().equals(RelevantParty.SLCC) ) {
      model.addAttribute("payments", payments
          .stream()
          .filter(x -> x.getChandler().equals(userDetails.getUserDetailsChandler().getChandler()))
          .collect(Collectors.toList()));
    }

    if ( userDetails.getRelevantParty().equals(RelevantParty.SLCS) ) {
      model.addAttribute("payments", payments
          .stream()
          .filter(x ->
                      vesselArrivalHistoryService.findById(x.getVesselOrder().getVesselArrivalHistory().getId()).getShipAgent()
                          .equals(userDetails.getUserDetailsShipAgent().getShipAgent()))
          .collect(Collectors.toList()));
    }

    if ( userDetails.getRelevantParty().equals(RelevantParty.SLC) ) {
      model.addAttribute("payments", payments);
    }


    model.addAttribute("message",
                       "Following table show details belongs from " + from + " to " + to +
                           "there month. if you need to more please search using above method");
    return "payment/payment";
  }

  @GetMapping
  public String findAll(Model model) {
    return commonFindAll(model, dateTimeAgeService.getPastDateByMonth(3), LocalDate.now());
  }

  @PostMapping( "/search" )
  public String invoiceSearch(@ModelAttribute TwoDate twoDate, Model model) {
    return commonFindAll(model, twoDate.getStartDate(), twoDate.getEndDate());
  }

  // check here : edit can not be happend
  @GetMapping( "/edit/{id}" )
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("payment", paymentService.findById(id));
    model.addAttribute("addStatus", false);
    return "payment/addPayment";
  }

  @PostMapping( value = {"/add", "/update"} )
  public String addComponent(@Valid @ModelAttribute Payment payment, BindingResult result, Model model) {
    if ( result.hasErrors() ) {
      model.addAttribute("payment", payment);
      model.addAttribute("addStatus", true);
      return "payment/addPayment";
    }

    Payment paymentDb = paymentService.persist(payment);

    if ( paymentDb.getStatusConformation().equals(StatusConformation.PAIDSHIPAGENT) ) {
      paymentDb.getVesselOrderItemBidPayments().forEach(x -> {
        VesselOrderItemBidPayment vesselOrderItemBidPayment = vesselOrderItemBidPaymentService.findById(x.getId());
        vesselOrderItemBidPayment.setPaymentStatus(PaymentStatus.PAID);
        vesselOrderItemBidPaymentService.persist(vesselOrderItemBidPayment);
      });
      if ( paymentDb.getChandler().getEmail() != null ) {
        String message = "According to vessel order number " + paymentDb.getVesselOrder().getNumber() + "\n Amount " +
            "(Rs). " + paymentDb.getAmount() + " was received. \n Please check and Confirm it \n Thanks\n" + paymentDb.getUpdatedBy();
        emailService.sendEmail(paymentDb.getChandler().getEmail(), "Payment Has Confirm", message);
      }
    }
    if ( payment.getStatusConformation().equals(StatusConformation.RECEVINGPAYMENT) ) {
      ShipAgent shipAgent =
          shipAgentService.findById(paymentDb.getVesselOrder().getVesselArrivalHistory().getShipAgent().getId());
      if ( shipAgent.getEmail() != null ) {

        String message = "According to vessel order number " + paymentDb.getVesselOrder().getNumber() + "\n Amount " +
            "(Rs). " + paymentDb.getAmount() + " was confirmed. \n Thanks\n" + paymentDb.getUpdatedBy();
        emailService.sendEmail(shipAgent.getEmail(), "Payment was Confirmed", message);
      }
    }

    return "redirect:/payment";
  }

  @GetMapping( "/delete/{id}" )
  public String delete(@PathVariable Integer id, Model model) {
    paymentService.delete(id);
    return "redirect:/payment";
  }

  @GetMapping( "/{id}" )
  public String view(@PathVariable Integer id, Model model) {
    Payment payment = paymentService.findById(id);
    model.addAttribute("paymentDetail", payment);
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
    return "payment/payment-detail";
  }
}
