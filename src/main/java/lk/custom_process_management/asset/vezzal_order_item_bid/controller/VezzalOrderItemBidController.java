package lk.custom_process_management.asset.vezzal_order_item_bid.controller;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.user_details_chandler.service.UserDetailsChandlerService;
import lk.custom_process_management.asset.user_management.entity.User;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzal_order.service.VezzalOrderService;
import lk.custom_process_management.asset.vezzal_order_item_bid.entity.VezzalOrderItemBid;
import lk.custom_process_management.asset.vezzal_order_item_bid.entity.enums.BidValidOrNot;
import lk.custom_process_management.asset.vezzal_order_item_bid.model.VezzalOrderBid;
import lk.custom_process_management.asset.vezzal_order_item_bid.service.VezzalOrderItemBidService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/vezzalOrderItemBid" )
public class VezzalOrderItemBidController {
  private final VezzalOrderService vezzalOrderService;
  private final UserService userService;
  private final UserDetailsChandlerService userDetailsChandlerService;
  private final VezzalOrderItemBidService vezzalOrderItemBidService;
  private final ChandlerService chandlerService;

  public VezzalOrderItemBidController(VezzalOrderService vezzalOrderService, UserService userService,
                                      UserDetailsChandlerService userDetailsChandlerService,
                                      VezzalOrderItemBidService vezzalOrderItemBidService,
                                      ChandlerService chandlerService) {
    this.vezzalOrderService = vezzalOrderService;
    this.userService = userService;
    this.userDetailsChandlerService = userDetailsChandlerService;
    this.vezzalOrderItemBidService = vezzalOrderItemBidService;
    this.chandlerService = chandlerService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vezzalOrders", vezzalOrderService.findByVezzalOrderStatus(VezzalOrderStatus.PROCESSING));
    return "vezzalOrder/vezzalOrder";
  }

  @GetMapping( "/bid/{id}" )
  public String addForm(@PathVariable Integer id, Model model) {
    model.addAttribute("vezzalOrderDetail", vezzalOrderService.findById(id));
    model.addAttribute("vezzalOrderBid", new VezzalOrderItemBid());
    return "vezzalOrderItemBid/addVezzalOrderItemBid";
  }

  @PostMapping( "/save" )
  public String saveBit(@Valid @ModelAttribute VezzalOrderBid vezzalOrderBid, BindingResult bindingResult) {
    if ( bindingResult.hasErrors() ) {
      return "redirect:/vezzalOrderItemBit/bid/" + vezzalOrderBid.getId();
    }
    User authUser = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

    Chandler chandler = null;
    if ( authUser == null ) {
      chandler = chandlerService.findById(1);
    } else {
      userDetailsChandlerService.findByUserDetails(authUser.getUserDetails()).getChandler();
    }
    List< VezzalOrderItemBid > vezzalOrderItemBids = new ArrayList<>();

    for ( VezzalOrderItemBid vezzalOrderItemBid : vezzalOrderBid.getVezzalOrderItemBids() ) {
      //check what is available amount and unite price on vezzal order item bid
      if ( vezzalOrderItemBid.getAmount() != null && vezzalOrderItemBid.getUnitPrice() != null ) {
        VezzalOrderItemBid vezzalOrderItemBidNew = new VezzalOrderItemBid();
   /*     VezzalOrderItem vezzalOrderItem = new VezzalOrderItem();
        vezzalOrderItem.setId(vezzalOrderItemBit.getVezzalOrderItem().getId());*/

        vezzalOrderItemBidNew.setAmount(vezzalOrderItemBid.getAmount());
        vezzalOrderItemBidNew.setUnitPrice(vezzalOrderItemBid.getUnitPrice());
        vezzalOrderItemBidNew.setBidValidOrNot(BidValidOrNot.PEN);
        vezzalOrderItemBidNew.setChandler(chandler);
        vezzalOrderItemBidNew.setVezzalOrderItem(vezzalOrderItemBid.getVezzalOrderItem());
        vezzalOrderItemBids.add(vezzalOrderItemBidNew);
      }
    }
    vezzalOrderItemBidService.saveAll(vezzalOrderItemBids);
    return "redirect:/vezzalOrderItemBit";
  }

}
