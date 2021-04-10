package lk.custom_process_management.asset.payment.controller;


import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details.entity.enums.RelevantParty;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.vessel_arrival_history.service.VesselArrivalHistoryService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/payment" )
public class PaymentController {

  private final PaymentService paymentService;
  private final DateTimeAgeService dateTimeAgeService;
  private final UserService userService;
  private final VesselArrivalHistoryService vesselArrivalHistoryService;

  public PaymentController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService,
                           UserService userService, VesselArrivalHistoryService vesselArrivalHistoryService) {
    this.paymentService = paymentService;
    this.dateTimeAgeService = dateTimeAgeService;
    this.userService = userService;
    this.vesselArrivalHistoryService = vesselArrivalHistoryService;
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

//todo: check here
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
    paymentService.persist(payment);
    return "redirect:/payment";
  }

  @GetMapping( "/delete/{id}" )
  public String delete(@PathVariable Integer id, Model model) {
    paymentService.delete(id);
    return "redirect:/payment";
  }

  @GetMapping( "/{id}" )
  public String view(@PathVariable Integer id, Model model) {
    model.addAttribute("paymentDetails", paymentService.findById(id));
    return "payment/payment-detail";
  }
}
