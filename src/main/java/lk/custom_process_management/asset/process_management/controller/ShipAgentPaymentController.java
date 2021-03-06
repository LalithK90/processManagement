package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping( "/shipAgentPayment" )
public class ShipAgentPaymentController {
  private final PaymentService paymentService;
  private final DateTimeAgeService dateTimeAgeService;
  private final UserService userService;
private final ChandlerReceivingController chandlerReceivingController;
  public ShipAgentPaymentController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService, UserService userService, ChandlerReceivingController chandlerReceivingController) {
    this.paymentService = paymentService;
    this.dateTimeAgeService = dateTimeAgeService;
    this.userService = userService;
    this.chandlerReceivingController = chandlerReceivingController;
  }


  private String commonFindAll(Model model, LocalDate from, LocalDate to) {
    chandlerReceivingController.commonForPayment(model, from, to, userService, paymentService, dateTimeAgeService);


    model.addAttribute("message",
                       "Following table show details belongs from " + from + " to " + to +
                           " there month. if you need to more please search using above method");
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
    payment.setStatusConformation(StatusConformation.PAIDSHIPAGENT);
    model.addAttribute("chandlerDetail", payment.getChandler());
    model.addAttribute("payment", payment);
    model.addAttribute("addStatus", false);
    return "payment/addPayment";
  }

}
