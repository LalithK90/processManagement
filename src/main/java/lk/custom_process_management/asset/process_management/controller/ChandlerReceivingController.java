package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.common_asset.model.TwoDate;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.asset.user_details.entity.enums.RelevantParty;
import lk.custom_process_management.asset.user_details_chandler.service.UserDetailsChandlerService;
import lk.custom_process_management.asset.user_details_ship_agent.service.UserDetailsShipAgentService;
import lk.custom_process_management.asset.user_management.entity.User;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.util.service.DateTimeAgeService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/chandlerReceiving")
public class ChandlerReceivingController {

    private final PaymentService paymentService;
    private final DateTimeAgeService dateTimeAgeService;
    private final UserService userService;
    private final UserDetailsChandlerService userDetailsChandlerService;
    private final UserDetailsShipAgentService userDetailsShipAgentService;
    private final ShipAgentService shipAgentService;
    private final ChandlerService chandlerService;
    private final VesselOrderService vesselOrderService;

    public ChandlerReceivingController(PaymentService paymentService, DateTimeAgeService dateTimeAgeService, UserService userService, UserDetailsChandlerService userDetailsChandlerService, UserDetailsShipAgentService userDetailsShipAgentService, ShipAgentService shipAgentService, ChandlerService chandlerService, VesselOrderService vesselOrderService) {
        this.paymentService = paymentService;
        this.dateTimeAgeService = dateTimeAgeService;
        this.userService = userService;
        this.userDetailsChandlerService = userDetailsChandlerService;
        this.userDetailsShipAgentService = userDetailsShipAgentService;
        this.shipAgentService = shipAgentService;
        this.chandlerService = chandlerService;
        this.vesselOrderService = vesselOrderService;
    }


    private String commonFindAll(Model model, LocalDate from, LocalDate to) {
        commonForPayment(model, from, to, userService, paymentService, dateTimeAgeService);


        model.addAttribute("message",
                "Following table show details belongs from " + from + " to " + to +
                        "there month. if you need to more please search using above method");
        model.addAttribute("searchUrl", "shipAgentPayment");
        return "vesselOrderItemBidReceived/vesselOrderItemBidReceived";
    }

    public void commonForPayment(Model model, LocalDate from, LocalDate to, UserService userService, PaymentService paymentService, DateTimeAgeService dateTimeAgeService) {
        User user = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Payment> payments =
                paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(from)
                        , dateTimeAgeService.dateTimeToLocalDateEndInDay(to))
                        .stream()
                        .filter(x ->
                                (x.getStatusConformation().equals(StatusConformation.INR) && (x.getVesselOrder().getClosingDate().isAfter(LocalDate.now())) ||
                                        (x.getVesselOrder().getClosingDate().equals(LocalDate.now()) && x.getVesselOrder().getVesselOrderStatus().equals(VesselOrderStatus.APPROVE))))
                        .collect(Collectors.toList());

        if (user.getUserDetails().getRelevantParty().equals(RelevantParty.SLC)) {
          payments =payments;
        } else if (user.getUserDetails().getRelevantParty().equals(RelevantParty.SLCC)) {
            payments = payments.stream().filter(x -> x.getChandler().equals(user.getUserDetails().getUserDetailsChandler().getChandler())).collect(Collectors.toList());

        } else {
            payments = payments.stream().filter(x ->
                    vesselOrderService.findById(x.getVesselOrder().getId())
                            .getVesselArrivalHistory().getShipAgent()
                            .equals(user.getUserDetails().getUserDetailsShipAgent().getShipAgent()))
                    .collect(Collectors.toList());
        }
        model.addAttribute("payments", payments);
    }

    @GetMapping
    public String findAll(Model model) {
        return commonFindAll(model, dateTimeAgeService.getPastDateByMonth(3), LocalDate.now());
    }

    @PostMapping
    public String findAll(@ModelAttribute TwoDate twoDate, Model model) {
        return commonFindAll(model, twoDate.getStartDate(), twoDate.getEndDate());

    }

    @GetMapping("/{id}")
    public String addPayment(@PathVariable("id") Integer id, Model model) {
        Payment payment = paymentService.findById(id);
        payment.setStatusConformation(StatusConformation.RECEVINGPAYMENT);
        model.addAttribute("chandlerDetail", payment.getChandler());
        model.addAttribute("payment", payment);
        model.addAttribute("addStatus", true);
        return "payment/addPayment";
    }

    @GetMapping("/reject/{id}")
    public String addPaymentReject(@PathVariable("id") Integer id, Model model) {
        Payment payment = paymentService.findById(id);
        payment.setStatusConformation(StatusConformation.REJECTCHA);
        paymentService.persist(payment);
        return "redirect:/chandlerReceiving";
    }

    @GetMapping("/reject")
    public String addPaymentRejectAll(Model model) {
        return commonReject(model, paymentService.findByStatusConformation(StatusConformation.REJECTCHA), "All Rejected " +
                "Payment By Chandler");
    }

    @PostMapping("/reject")
    public String addPaymentRejectSearch(@ModelAttribute TwoDate twoDate, Model model) {

        List<Payment> payments =
                paymentService.findByCreatedAtIsBetween(dateTimeAgeService.dateTimeToLocalDateStartInDay(twoDate.getStartDate())
                        , dateTimeAgeService.dateTimeToLocalDateEndInDay(twoDate.getEndDate()))
                        .stream()
                        .filter(x -> x.getStatusConformation().equals(StatusConformation.REJECTCHA))
                        .collect(Collectors.toList());

        return commonReject(model, payments,
                "All Rejected Payment By Chandler since" + twoDate.getStartDate() + " to " + twoDate.getEndDate());
    }

    private String commonReject(Model model, List<Payment> payments, String message) {
        model.addAttribute("payments", payments);
        model.addAttribute("message", message);
        model.addAttribute("searchUrl", "reject");
        return "vesselOrderItemBidReceived/vesselOrderItemBidReceived";
    }

}
