package lk.custom_process_management.asset.vessel_order_item_bid.controller;

import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.payment.service.PaymentService;
import lk.custom_process_management.asset.user_details_chandler.service.UserDetailsChandlerService;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.enums.BidValidOrNot;
import lk.custom_process_management.asset.vessel_order_item_bid.model.VesselOrderBid;
import lk.custom_process_management.asset.vessel_order_item_bid.service.VesselOrderItemBidService;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.service.VesselOrderItemBidPaymentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/vesselOrderItemApproval" )
public class VesselOrderItemBidApprovalController {
  private final VesselOrderService vesselOrderService;
  private final UserService userService;
  private final UserDetailsChandlerService userDetailsChandlerService;
  private final VesselOrderItemBidService vesselOrderItemBidService;
  private final ChandlerService chandlerService;
  private final VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService;
  private final PaymentService paymentService;

  public VesselOrderItemBidApprovalController(VesselOrderService vesselOrderService, UserService userService,
                                              UserDetailsChandlerService userDetailsChandlerService,
                                              VesselOrderItemBidService vesselOrderItemBidService,
                                              ChandlerService chandlerService,
                                              VesselOrderItemBidPaymentService vesselOrderItemBidPaymentService,
                                              PaymentService paymentService) {
    this.vesselOrderService = vesselOrderService;
    this.userService = userService;
    this.userDetailsChandlerService = userDetailsChandlerService;
    this.vesselOrderItemBidService = vesselOrderItemBidService;
    this.chandlerService = chandlerService;
    this.vesselOrderItemBidPaymentService = vesselOrderItemBidPaymentService;
    this.paymentService = paymentService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vesselOrders", vesselOrderService.findByVesselOrderStatus(VesselOrderStatus.BIDEN));
    return "vesselOrderItemApproval/vesselOrderItemApproval";
  }

  @GetMapping( "/{id}" )
  public String addForm(@PathVariable Integer id, Model model) {
    Comparator< VesselOrderItemBid > compareByBidenPrice =
        Comparator.comparing(VesselOrderItemBid::getAmount);

    List< VesselOrderItemBid > vesselOrderItemBids = new ArrayList<>();

    VesselOrder vesselOrder = vesselOrderService.findById(id);

    vesselOrder.getVesselOrderItems().forEach(
        x -> vesselOrderItemBidService.findByVesselOrderItem(x)
            .stream()
            .sorted(compareByBidenPrice)
            .collect(Collectors.toList()).forEach(y -> {
              y.setItem(x.getItem());
              y.setBidValidOrNot(BidValidOrNot.REJECT);
              vesselOrderItemBids.add(y);
            }));

    model.addAttribute("vesselOrderItemBids", vesselOrderItemBids);

    model.addAttribute("vesselOrderDetail", vesselOrder);
    model.addAttribute("vesselDetail", vesselOrder.getVesselArrivalHistory().getVessel());
    List< BidValidOrNot > bidValidOrNots = new ArrayList<>();
    bidValidOrNots.add(BidValidOrNot.REJECT);
    bidValidOrNots.add(BidValidOrNot.SELECT);
    model.addAttribute("bidValidOrNots", bidValidOrNots);
    model.addAttribute("vesselOrderBid", new VesselOrderBid());
    return "vesselOrderItemApproval/addVesselOrderItemApproval";
  }

  @PostMapping( "/save" )
  public String saveApprove(@Valid @ModelAttribute VesselOrderBid vesselOrderBid, BindingResult bindingResult) {

    return "redirect:/vesselOrderItemBid";
  }

}
