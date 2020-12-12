package lk.custom_process_management.asset.vezzal_order_item_approved.controller;

import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzal_order.service.VezzalOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vezzalOrderItemApproval")
public class VezzalOrderItemApprovalController {
private final VezzalOrderService vezzalOrderService;

  public VezzalOrderItemApprovalController(VezzalOrderService vezzalOrderService) {
    this.vezzalOrderService = vezzalOrderService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vezzalOrders", vezzalOrderService.findByVezzalOrderStatus(VezzalOrderStatus.BITTED));
    return "vezzalOrder/vezzalOrder";
  }

  @GetMapping("/{id}")
  public String getItemsToApprove(@PathVariable Integer id, Model model){


    return "vezzalOrderItemApproval/vezzalOrderItemApproval";
  }
}
