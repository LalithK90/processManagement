package lk.custom_process_management.asset.vessel_order.controller;

import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.item.service.ItemService;
import lk.custom_process_management.asset.vessel_arrival_history.service.VesselArrivalHistoryService;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.vessel_order_item.entity.enums.VesselOrderItemStatus;
import lk.custom_process_management.asset.warehouse_block.entity.enums.WarehouseBlockStatus;
import lk.custom_process_management.asset.warehouse_block.service.WarehouseBlockService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/vesselOrder" )
public class VesselOrderController {
  private final VesselOrderService vesselOrderService;
  private final VesselArrivalHistoryService vesselArrivalHistoryService;
  private final ItemService itemService;
  private final WarehouseBlockService warehouseBlockService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;

  public VesselOrderController(VesselOrderService vesselOrderService,
                               VesselArrivalHistoryService vesselArrivalHistoryService, ItemService itemService,
                               WarehouseBlockService warehouseBlockService,
                               MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
    this.vesselOrderService = vesselOrderService;
    this.vesselArrivalHistoryService = vesselArrivalHistoryService;
    this.itemService = itemService;
    this.warehouseBlockService = warehouseBlockService;
    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vesselOrders", vesselOrderService.findAll());
    model.addAttribute("addStatus", false);
    return "vesselOrder/vesselOrder";
  }

  private String commonAdd(Model model, VesselOrder vesselOrder, boolean addStatus) {
    model.addAttribute("vesselOrder", vesselOrder);
    model.addAttribute("addStatus", addStatus);
    //TODO -> need to filter login user if user has privilege to manage relevant vessel that will be pop up
    model.addAttribute("vesselOderHistories", vesselArrivalHistoryService.findAll());
    model.addAttribute("warehouseBlocks",
                       warehouseBlockService.findByWarehouseBlockStatus(WarehouseBlockStatus.AVAILABLE));
    List< Item > itemList;
    itemList = itemService.findAll();
    if ( vesselOrder.getVesselOrderItems() != null ) {
      for ( VesselOrderItem vesselOrderItem : vesselOrder.getVesselOrderItems() ) {
        itemList.remove(vesselOrderItem.getItem());
      }
    }
    model.addAttribute("items", itemList);
    return "vesselOrder/addVesselOrder";
  }

  @GetMapping( "/add" )
  public String addForm(Model model) {
    return commonAdd(model, new VesselOrder(), true);
  }

  @PostMapping( value = {"/save", "/update"} )
  public String persist(@Valid @ModelAttribute VesselOrder vesselOrder, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes, Model model) {
    if ( bindingResult.hasErrors() || vesselOrder.getVesselOrderItems().isEmpty() ) {
      return commonAdd(model, vesselOrder, true);
    }
    if ( vesselOrder.getId() == null ) {
      //if there is not item in db
      if ( vesselOrderService.findLastVesselOrder() == null ) {
        //need to generate new one
        vesselOrder.setNumber("SLCO" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
      } else {
        //if there is item in db need to get that item's code and increase its value
        String previousCode = vesselOrderService.findLastVesselOrder().getNumber().substring(4);
        vesselOrder.setNumber("SLCO" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
      }
      vesselOrder.setVesselOrderStatus(VesselOrderStatus.PROCESSING);
    }
    vesselOrder.getVesselOrderItems()
        .forEach(vesselOrderItem -> {
          vesselOrderItem.setVesselOrder(vesselOrder);
          vesselOrderItem.setVesselOrderItemStatus(VesselOrderItemStatus.PROCESSING);
        });
    VesselOrder vesselOrderDb = vesselOrderService.persist(vesselOrder);
    redirectAttributes.addFlashAttribute("vesselOrderDetail", vesselOrderDb);
    redirectAttributes.addFlashAttribute("vesselArrivalHistoryDetail", vesselOrderDb.getVesselArrivalHistory());
    redirectAttributes.addFlashAttribute("vesselDetail", vesselOrderDb.getVesselArrivalHistory().getVessel());

    return "redirect:/vesselOrder";
  }

  @GetMapping( "/edit/{id}" )
  public String edit(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model model) {
    VesselOrder vesselOrder = vesselOrderService.findById(id);
    if ( vesselOrder.getVesselOrderStatus().equals(VesselOrderStatus.PROCESSING) ) {
      return commonAdd(model, vesselOrder, false);
    } else {
      redirectAttributes.addFlashAttribute("message", "This order is processing you can not edit further more. \n " +
          "Hence please contact office who works in Sri Lanka Custom");
      return "redirect:/vesselOrder";
    }
    //TODO -> first check order is processing or not
    //second logged user is custom or not and order status is valid
    //so then we can give permission to edit custom officers
  }

  //delete method is not applicable this part
  @GetMapping( "/view/{id}" )
  public String view(@PathVariable Integer id, Model model) {
    VesselOrder vesselOrder = vesselOrderService.findById(id);
    model.addAttribute("vesselOrderDetail", vesselOrder);
    model.addAttribute("vesselArrivalHistoryDetail", vesselOrder.getVesselArrivalHistory());
    model.addAttribute("vesselDetail", vesselOrder.getVesselArrivalHistory().getVessel());
    return "vesselOrder/vesselOrder-detail";
  }
}
