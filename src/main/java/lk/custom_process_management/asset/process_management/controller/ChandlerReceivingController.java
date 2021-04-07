package lk.custom_process_management.asset.process_management.controller;

import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chandlerReceiving")
public class ChandlerReceivingController {
  private final PaymentService paymentService;
  private final ShipAgentService shipAgentService;
  private final ChandlerService chandlerService;

  public ChandlerReceivingController(PaymentService paymentService, ShipAgentService shipAgentService,
                                     ChandlerService chandlerService) {
    this.paymentService = paymentService;
    this.shipAgentService = shipAgentService;
    this.chandlerService = chandlerService;
  }
}
