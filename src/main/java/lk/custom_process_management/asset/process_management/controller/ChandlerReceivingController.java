package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/chandlerReceiving" )
public class ChandlerReceivingController {

  private final PaymentService paymentService;
  private final DateTimeAgeService dateTimeAgeService;

  public ChandlerReceivingController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService) {
    this.paymentService = paymentService;
    this.dateTimeAgeService = dateTimeAgeService;
  }


  private String commonFindAll(Model model, LocalDate from, LocalDate to) {

    model.addAttribute("payments",
                       paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(from)
                           , dateTimeAgeService.dateTimeToLocalDateEndInDay(to))
                           .stream()
                           .filter(x -> x.getStatusConformation().equals(StatusConformation.RECEVINGPAYMENT))
                           .collect(Collectors.toList()));

    model.addAttribute("message",
                       "Following table show details belongs from " + from + " to " + to +
                           "there month. if you need to more please search using above method");
    model.addAttribute("searchUrl", "shipAgentPayment");
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
  public String addPayment(@PathVariable( "id" ) Integer id, Model model) {
    Payment payment = paymentService.findById(id);
    payment.setStatusConformation(StatusConformation.RECEVINGPAYMENT);
    model.addAttribute("chandlerDetail", payment.getChandler());
    model.addAttribute("payment", payment);
    model.addAttribute("addStatus", true);
    return "payment/addPayment";
  }

  @GetMapping( "/reject/{id}" )
  public String addPaymentReject(@PathVariable( "id" ) Integer id, Model model) {
    Payment payment = paymentService.findById(id);
    payment.setStatusConformation(StatusConformation.REJECTCHA);
    paymentService.persist(payment);
    return "redirect:/chandlerReceiving";
  }

  @GetMapping( "/reject" )
  public String addPaymentRejectAll(Model model) {
    return commonReject(model, paymentService.findByStatusConformation(StatusConformation.REJECTCHA), "All Rejected " +
        "Payment By Chandler");
  }

  @PostMapping( "/reject" )
  public String addPaymentRejectSearch(@ModelAttribute TwoDate twoDate, Model model) {

    List< Payment > payments =
        paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(twoDate.getStartDate())
        , dateTimeAgeService.dateTimeToLocalDateEndInDay(twoDate.getEndDate()))
        .stream()
        .filter(x -> x.getStatusConformation().equals(StatusConformation.REJECTCHA))
        .collect(Collectors.toList());

    return commonReject(model, payments,
                        "All Rejected Payment By Chandler since" + twoDate.getStartDate() + " to " + twoDate.getEndDate());
  }

  private String commonReject(Model model, List< Payment > payments, String message) {
    model.addAttribute("payments", payments);
    model.addAttribute("message", message);
    model.addAttribute("searchUrl", "reject");
    return "vesselOrderItemBidReceived/vesselOrderItemBidReceived";
  }

}
