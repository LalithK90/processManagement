package lk.custom_process_management.asset.warehouse_block.controller;


import lk.custom_process_management.asset.warehouse_block.entity.WarehouseBlock;
import lk.custom_process_management.asset.warehouse_block.service.WarehouseBlockService;
import lk.custom_process_management.util.interfaces.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/warehouseBlock")
   public  class WarehouseBlockController implements AbstractController< WarehouseBlock, Integer> {
        private final WarehouseBlockService warehouseBlockService;

    @Autowired
    public WarehouseBlockController(WarehouseBlockService warehouseBlockService) {
        this.warehouseBlockService = warehouseBlockService;
    }

    private String commonThings(Model model, WarehouseBlock warehouseBlock, Boolean addState) {
        model.addAttribute("warehouseBlock", warehouseBlock);
        model.addAttribute("addStatus", addState);
        return "warehouseBlock/addWarehouseBlock";
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("warehouseBlocks", warehouseBlockService.findAll());
        return "warehouseBlock/warehouseBlock";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        return commonThings(model, new WarehouseBlock(), true);
    }

    @PostMapping( value = {"/save", "/update"} )
    public String persist(@Valid @ModelAttribute WarehouseBlock warehouseBlock, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if ( bindingResult.hasErrors() ) {
            return commonThings(model, warehouseBlock, true);
        }
        redirectAttributes.addFlashAttribute("warehouseDetail", warehouseBlockService.persist(warehouseBlock));
        // branchService.persist(warehouseBlock);
        return "redirect:/warehouseBlock";
    }

    @GetMapping( "/edit/{id}" )
    public String edit(@PathVariable Integer id, Model model) {
        return commonThings(model, warehouseBlockService.findById(id), false);
    }

    @GetMapping( "/delete/{id}" )
    public String delete(@PathVariable Integer id, Model model) {
        warehouseBlockService.delete(id);
        return "redirect:/warehouseBlock";
    }

    @GetMapping( "/{id}" )
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("warehouseBlockDetail", warehouseBlockService.findById(id));
        return "warehouseBlock/warehouseBlock-detail";
    }
}

