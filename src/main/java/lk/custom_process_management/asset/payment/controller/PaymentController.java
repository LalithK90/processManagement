package lk.custom_process_management.asset.payment.controller;


import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/payment" )
public class PaymentController {

  private final PaymentService paymentService;
  private final DateTimeAgeService dateTimeAgeService;

  public PaymentController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService) {
    this.paymentService = paymentService;
    this.dateTimeAgeService = dateTimeAgeService;
  }

  private String commonFindAll(Model model, LocalDate from, LocalDate to) {

    model.addAttribute("payments",
                       paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(from), dateTimeAgeService.dateTimeToLocalDateEndInDay(to))
                           .stream()
                           .filter(x -> x.getStatusConformation().equals(StatusConformation.PEN))
                           .collect(Collectors.toList()));

    model.addAttribute("message",
                       "Following table show details belongs from " + from.toString() + " to " + to.toString() +
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
