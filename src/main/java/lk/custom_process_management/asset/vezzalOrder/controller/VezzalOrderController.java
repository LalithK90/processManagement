package lk.custom_process_management.asset.vezzalOrder.controller;

import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.item.service.ItemService;
import lk.custom_process_management.asset.vezzalArrivalHistory.service.VezzalArrivalHistoryService;
import lk.custom_process_management.asset.vezzalOrder.entity.Enum.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzalOrder.entity.VezzalOrder;
import lk.custom_process_management.asset.vezzalOrder.service.VezzalOrderService;
import lk.custom_process_management.asset.vezzalOrderItem.entity.Enum.VezzalOrderItemStatus;
import lk.custom_process_management.asset.vezzalOrderItem.entity.VezzalOrderItem;
import lk.custom_process_management.asset.warehouseBlock.service.WarehouseBlockService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/vezzalOrder" )
public class VezzalOrderController {
  private final VezzalOrderService vezzalOrderService;
  private final VezzalArrivalHistoryService vezzalArrivalHistoryService;
  private final ItemService itemService;
  private final WarehouseBlockService warehouseBlockService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;

  public VezzalOrderController(VezzalOrderService vezzalOrderService,
                               VezzalArrivalHistoryService vezzalArrivalHistoryService, ItemService itemService,
                               WarehouseBlockService warehouseBlockService,
                               MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
    this.vezzalOrderService = vezzalOrderService;
    this.vezzalArrivalHistoryService = vezzalArrivalHistoryService;
    this.itemService = itemService;
    this.warehouseBlockService = warehouseBlockService;
    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("vezzalOrders", vezzalOrderService.findAll());
    return "vezzalOrder/vezzalOrder";
  }

  private String commonAdd(Model model, VezzalOrder vezzalOrder, boolean addStatus) {
    model.addAttribute("vezzalOrder", vezzalOrder);
    model.addAttribute("addStatus", addStatus);
    //TODO -> need to filter login user if user has privilege to manage relevant vezzal that will be pop up
    model.addAttribute("vezzalOderHistories", vezzalArrivalHistoryService.findAll());
    //TODO -> warehouse blocks which is currently available
    model.addAttribute("warehouseBlocks", warehouseBlockService.findAll());
    List< Item > itemList;
    itemList = itemService.findAll();
    if ( vezzalOrder.getVezzalOrderItems() != null ) {
      for ( VezzalOrderItem vezzalOrderItem : vezzalOrder.getVezzalOrderItems() ) {
        itemList.remove(vezzalOrderItem.getItem());
      }
    }
    model.addAttribute("items", itemList);
    return "vezzalOrder/addVezzalOrder";
  }

  @GetMapping( "/add" )
  public String addForm(Model model) {
    return commonAdd(model, new VezzalOrder(), true);
  }

  @PostMapping( value = {"/save", "/update"} )
  public String persist(@Valid @ModelAttribute VezzalOrder vezzalOrder, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes,Model model) {
    if ( bindingResult.hasErrors() || vezzalOrder.getVezzalOrderItems().isEmpty() ) {
      return commonAdd(model, vezzalOrder, true);
    }
    if ( vezzalOrder.getId() == null ) {
      //if there is not item in db
      if ( vezzalOrderService.findLastVezzalOrder() == null ) {
        //need to generate new one
        vezzalOrder.setNumber("SLCO" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
      } else {
        //if there is item in db need to get that item's code and increase its value
        String previousCode = vezzalOrderService.findLastVezzalOrder().getNumber().substring(4);
        vezzalOrder.setNumber("SLCO" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
      }
      vezzalOrder.setVezzalOrderStatus(VezzalOrderStatus.PROCESSING);
    }
    vezzalOrder.getVezzalOrderItems()
        .forEach(vezzalOrderItem -> {
          vezzalOrderItem.setVezzalOrder(vezzalOrder);
          vezzalOrderItem.setVezzalOrderItemStatus(VezzalOrderItemStatus.PROCESSING);
        });
    VezzalOrder vezzalOrderDb=   vezzalOrderService.persist(vezzalOrder);
    redirectAttributes.addFlashAttribute("vezzalOrderDetail",vezzalOrderDb );
    redirectAttributes.addFlashAttribute("vezzalArrivalHistoryDetail", vezzalOrderDb.getVezzalArrivalHistory());
    redirectAttributes.addFlashAttribute("vezzalDetail", vezzalOrderDb.getVezzalArrivalHistory().getVezzal());


    return "redirect:/vezzalOrder";
  }

  @GetMapping( "/edit/{id}" )
  public String edit(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model model) {
    VezzalOrder vezzalOrder = vezzalOrderService.findById(id);
    if ( vezzalOrder.getVezzalOrderStatus().equals(VezzalOrderStatus.PROCESSING) ) {
      return commonAdd(model, vezzalOrder, false);
    } else {
      redirectAttributes.addFlashAttribute("message", "This order is processing you can not edit further more. \n " +
          "Hence please contact office who works in Sri Lanka Custom");
      return "redirect:/vezzalOrder";
    }
    //TODO -> first check order is processing or not
    //second logged user is custom or not and order status is valid
    //so then we can give permission to edit custom officers
  }

  //delete method is not applicable this part
  @GetMapping( "/view/{id}" )
  public String view(@PathVariable Integer id, Model model) {
    VezzalOrder vezzalOrder = vezzalOrderService.findById(id);
    model.addAttribute("vezzalOrderDetail",vezzalOrder );
    model.addAttribute("vezzalArrivalHistoryDetail", vezzalOrder.getVezzalArrivalHistory());
    model.addAttribute("vezzalDetail", vezzalOrder.getVezzalArrivalHistory().getVezzal());
    return "vezzalOrder/vezzalOrder-detail";
  }
}
