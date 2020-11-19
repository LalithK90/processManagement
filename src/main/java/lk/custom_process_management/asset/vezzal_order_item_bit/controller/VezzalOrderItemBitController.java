package lk.custom_process_management.asset.vezzal_order_item_bit.controller;

import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzal_order.service.VezzalOrderService;
import lk.custom_process_management.asset.vezzal_order_item_bit.entity.VezzalOrderItemBit;
import lk.custom_process_management.asset.vezzal_order_item_bit.model.VezzalOrderBit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    model.addAttribute("vezzalOrderBit", new VezzalOrderItemBit());
    return "vezzalOrderItemBit/addVezzalOrderItemBit";
  }

  @PostMapping("/save")
  public String saveBit(@Valid @ModelAttribute VezzalOrderBit vezzalOrderBit, BindingResult bindingResult){
    if ( bindingResult.hasErrors() ){
      return "redirect:/vezzalOrderItemBit/bit/"+vezzalOrderBit.getId();
    }

    return "redirect:/vezzalOrderItemBit";
  }

}
