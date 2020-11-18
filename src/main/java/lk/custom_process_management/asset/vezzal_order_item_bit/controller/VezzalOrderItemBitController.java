package lk.custom_process_management.asset.vezzal_order_item_bit.controller;

import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzal_order.service.VezzalOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( "/vezzalOrderItemBit" )
public class VezzalOrderItemBitController {
  private final VezzalOrderService vezzalOrderService;

  public VezzalOrderItemBitController(VezzalOrderService vezzalOrderService) {
    this.vezzalOrderService = vezzalOrderService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vezzalOrders", vezzalOrderService.findByVezzalOrderStatus(VezzalOrderStatus.PROCESSING));
    return "vezzalOrder/vezzalOrder";
  }

  @GetMapping( "/bit/{id}" )
  public String addForm(@PathVariable Integer id, Model model) {
    model.addAttribute("vezzalOrderDetail", vezzalOrderService.findById(id));
    return "vezzalOrderItemBit/addVezzalOrderItemBit";
  }

}
