package lk.custom_process_management.asset.vessel_order_item_approved.controller;

import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.asset.vessel_order_item_bid.service.VesselOrderItemBidService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/vesselOrderItemApproval" )
public class VesselOrderItemApprovalController {
  private final VesselOrderService vesselOrderService;
  private final VesselOrderItemBidService vesselOrderItemBidService;

  public VesselOrderItemApprovalController(VesselOrderService vesselOrderService,
                                           VesselOrderItemBidService vesselOrderItemBidService) {
    this.vesselOrderService = vesselOrderService;
    this.vesselOrderItemBidService = vesselOrderItemBidService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vesselOrders", vesselOrderService.findByVesselOrderStatus(VesselOrderStatus.BITTED));
    return "vesselOrder/vesselOrder";
  }

  @GetMapping( "/{id}" )
  public String getItemsToApprove(@PathVariable Integer id, Model model) {
    VesselOrder vesselOrder = vesselOrderService.findById(id);
    List< VesselOrderItemBid > vesselOrderItemBidList = new ArrayList<>();
    //compare by item
    Comparator< VesselOrderItem > itemComparator =
        Comparator.comparing(VesselOrderItem::getId);
    //compare by price
    Comparator< VesselOrderItemBid > compareByBidenPrice =
        Comparator.comparing(VesselOrderItemBid::getAmount);
    vesselOrder.getVesselOrderItems()
        .stream()
        .sorted(itemComparator)
        .collect(Collectors.toList())
        .forEach(
            (x) -> vesselOrderItemBidList.addAll(vesselOrderItemBidService.findByVesselOrderItem(x)
                                                     .stream()
                                                     .sorted(compareByBidenPrice)
                                                     .collect(Collectors.toList())));


    model.addAttribute("biddenItems", vesselOrderItemBidList);

    return "vesselOrderItemApproval/vesselOrderItemApproval";
  }

  @PostMapping("/save")
  public String saveApproved(){

    return "redirect:/vesselOrderItemApproval";
  }
}
