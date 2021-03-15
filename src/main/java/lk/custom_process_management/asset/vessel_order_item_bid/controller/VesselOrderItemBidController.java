package lk.custom_process_management.asset.vessel_order_item_bid.controller;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.user_details_chandler.service.UserDetailsChandlerService;
import lk.custom_process_management.asset.user_management.entity.User;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.enums.BidValidOrNot;
import lk.custom_process_management.asset.vessel_order_item_bid.model.VesselOrderBid;
import lk.custom_process_management.asset.vessel_order_item_bid.service.VesselOrderItemBidService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/vesselOrderItemBid" )
public class VesselOrderItemBidController {
  private final VesselOrderService vesselOrderService;
  private final UserService userService;
  private final UserDetailsChandlerService userDetailsChandlerService;
  private final VesselOrderItemBidService vesselOrderItemBidService;
  private final ChandlerService chandlerService;

  public VesselOrderItemBidController(VesselOrderService vesselOrderService, UserService userService,
                                      UserDetailsChandlerService userDetailsChandlerService,
                                      VesselOrderItemBidService vesselOrderItemBidService,
                                      ChandlerService chandlerService) {
    this.vesselOrderService = vesselOrderService;
    this.userService = userService;
    this.userDetailsChandlerService = userDetailsChandlerService;
    this.vesselOrderItemBidService = vesselOrderItemBidService;
    this.chandlerService = chandlerService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vesselOrders", vesselOrderService.findByVesselOrderStatus(VesselOrderStatus.PROCESSING));
    return "vesselOrder/vesselOrder";
  }

  @GetMapping( "/bid/{id}" )
  public String addForm(@PathVariable Integer id, Model model) {
    model.addAttribute("vesselOrderDetail", vesselOrderService.findById(id));
    model.addAttribute("vesselOrderBid", new VesselOrderItemBid());
    return "vesselOrderItemBid/addVesselOrderItemBid";
  }

  @PostMapping( "/save" )
  public String saveBit(@Valid @ModelAttribute VesselOrderBid vesselOrderBid, BindingResult bindingResult) {
    if ( bindingResult.hasErrors() ) {
      return "redirect:/vesselOrderItemBit/bid/" + vesselOrderBid.getId();
    }
    User authUser = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

    Chandler chandler;
    if ( authUser == null ) {
      chandler = chandlerService.findById(1);
    } else {
      chandler = userDetailsChandlerService.findByUserDetails(authUser.getUserDetails()).getChandler();
    }

    List< VesselOrderItemBid > vesselOrderItemBids = new ArrayList<>();

    for ( VesselOrderItemBid vesselOrderItemBid : vesselOrderBid.getVesselOrderItemBids() ) {
      //check what is available amount and unite price on vessel order item bid
      if ( vesselOrderItemBid.getAmount() != null && vesselOrderItemBid.getUnitPrice() != null ) {
        VesselOrderItemBid vesselOrderItemBidNew = new VesselOrderItemBid();
   /*     VesselOrderItem vesselOrderItem = new VesselOrderItem();
        vesselOrderItem.setId(vesselOrderItemBit.getVesselOrderItem().getId());*/

        vesselOrderItemBidNew.setAmount(vesselOrderItemBid.getAmount());
        vesselOrderItemBidNew.setUnitPrice(vesselOrderItemBid.getUnitPrice());
        vesselOrderItemBidNew.setBidValidOrNot(BidValidOrNot.PEN);
        vesselOrderItemBidNew.setChandler(chandler);
        vesselOrderItemBidNew.setVesselOrderItem(vesselOrderItemBid.getVesselOrderItem());
        vesselOrderItemBids.add(vesselOrderItemBidNew);
      }
    }
    vesselOrderItemBidService.saveAll(vesselOrderItemBids);
    return "redirect:/vesselOrderItemBid";
  }

}
