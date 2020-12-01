package lk.custom_process_management.asset.vezzal_order_item_bit.controller;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.user_details_chandler.service.UserDetailsChandlerService;
import lk.custom_process_management.asset.user_management.entity.User;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzal_order.service.VezzalOrderService;
import lk.custom_process_management.asset.vezzal_order_item_bit.entity.VezzalOrderItemBit;
import lk.custom_process_management.asset.vezzal_order_item_bit.entity.enums.BitValidOrNot;
import lk.custom_process_management.asset.vezzal_order_item_bit.model.VezzalOrderBit;
import lk.custom_process_management.asset.vezzal_order_item_bit.service.VezzalOrderItemBitService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/vezzalOrderItemBit" )
public class VezzalOrderItemBitController {
  private final VezzalOrderService vezzalOrderService;
  private final UserService userService;
  private final UserDetailsChandlerService userDetailsChandlerService;
  private final VezzalOrderItemBitService vezzalOrderItemBitService;
  private final ChandlerService chandlerService;

  public VezzalOrderItemBitController(VezzalOrderService vezzalOrderService, UserService userService,
                                      UserDetailsChandlerService userDetailsChandlerService,
                                      VezzalOrderItemBitService vezzalOrderItemBitService,
                                      ChandlerService chandlerService) {
    this.vezzalOrderService = vezzalOrderService;
    this.userService = userService;
    this.userDetailsChandlerService = userDetailsChandlerService;
    this.vezzalOrderItemBitService = vezzalOrderItemBitService;
    this.chandlerService = chandlerService;
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

  @PostMapping( "/save" )
  public String saveBit(@Valid @ModelAttribute VezzalOrderBit vezzalOrderBit, BindingResult bindingResult) {
    if ( bindingResult.hasErrors() ) {
      return "redirect:/vezzalOrderItemBit/bit/" + vezzalOrderBit.getId();
    }
    User authUser = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

    Chandler chandler = null;
    if ( authUser == null ) {
      chandler = chandlerService.findById(1);
    } else {
      userDetailsChandlerService.findByUserDetails(authUser.getUserDetails()).getChandler();
    }
    List< VezzalOrderItemBit > vezzalOrderItemBits = new ArrayList<>();

    for ( VezzalOrderItemBit vezzalOrderItemBit : vezzalOrderBit.getVezzalOrderItemBits() ) {
      //check what is available amount and unite price on vezzal order item bit
      if ( vezzalOrderItemBit.getAmount() != null && vezzalOrderItemBit.getUnitPrice() != null ) {
        VezzalOrderItemBit vezzalOrderItemBitNew = new VezzalOrderItemBit();
   /*     VezzalOrderItem vezzalOrderItem = new VezzalOrderItem();
        vezzalOrderItem.setId(vezzalOrderItemBit.getVezzalOrderItem().getId());*/

        vezzalOrderItemBitNew.setAmount(vezzalOrderItemBit.getAmount());
        vezzalOrderItemBitNew.setUnitPrice(vezzalOrderItemBit.getUnitPrice());
        vezzalOrderItemBitNew.setBitValidOrNot(BitValidOrNot.PEN);
        vezzalOrderItemBitNew.setChandler(chandler);
        vezzalOrderItemBitNew.setVezzalOrderItem(vezzalOrderItemBit.getVezzalOrderItem());
        vezzalOrderItemBits.add(vezzalOrderItemBitNew);
      }
    }
    vezzalOrderItemBitService.saveAll(vezzalOrderItemBits);
    return "redirect:/vezzalOrderItemBit";
  }

}
