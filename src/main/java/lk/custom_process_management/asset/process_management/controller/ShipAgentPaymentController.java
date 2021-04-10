package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/shipAgentPayment" )
public class ShipAgentPaymentController {
  private final PaymentService paymentService;
  private final DateTimeAgeService dateTimeAgeService;
  private final ShipAgentService shipAgentService;
  private final ChandlerService chandlerService;

  public ShipAgentPaymentController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService,
                                    ShipAgentService shipAgentService,
                                    ChandlerService chandlerService) {
    this.paymentService = paymentService;
    this.dateTimeAgeService = dateTimeAgeService;
    this.shipAgentService = shipAgentService;
    this.chandlerService = chandlerService;
  }


  private String commonFindAll(Model model, LocalDate from, LocalDate to) {

    model.addAttribute("payments",
                       paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(from)
                           , dateTimeAgeService.dateTimeToLocalDateEndInDay(to))
                           .stream()
                           .filter(x -> x.getStatusConformation().equals(StatusConformation.REC))
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

  @GetMapping( "/id" )
  public String addPayment(@PathVariable( "id" ) Integer id, Model model) {
    model.addAttribute("payment", paymentService.findById(id));
    return "payment/addPayment";
  }

}
