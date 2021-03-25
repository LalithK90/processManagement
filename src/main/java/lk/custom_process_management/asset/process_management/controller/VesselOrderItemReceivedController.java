package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.payment.service.PaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vesselOrderItemReceived")
public class VesselOrderItemReceivedController {
private final PaymentService paymentService;

  public VesselOrderItemReceivedController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @GetMapping
  public String pendingVesselOrderReceiveList(Model model){

    return "vesselOrderItemReceived/vesselOrderItemReceived";
  }
}
