package lk.custom_process_management.asset.ship_agent.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lk.custom_process_management.asset.category.entity.Category;
import lk.custom_process_management.asset.item.entity.enums.MainCategory;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.util.interfaces.AbstractController;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/shipAgent" )
public class ShipAgentController implements AbstractController< ShipAgent, Integer > {
  private final ShipAgentService shipAgentService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;

  public ShipAgentController(ShipAgentService shipAgentService,
                             MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
    this.shipAgentService = shipAgentService;
    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
  }

  private String commonThings(Model model, ShipAgent shipAgent, Boolean addState) {
    model.addAttribute("shipAgent", shipAgent);
    model.addAttribute("addStatus", addState);
    return "shipAgent/addShipAgent";
  }

  @GetMapping
  public String findAll(Model model) {
    model.addAttribute("shipAgents", shipAgentService.findAll());
    return "shipAgent/shipAgent";
  }

  @GetMapping( "/add" )
  public String addForm(Model model) {
    return commonThings(model, new ShipAgent(), true);
  }

  @PostMapping( value = {"/add", "/save", "/update"} )
  public String persist(@Valid @ModelAttribute ShipAgent shipAgent, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes,
                        Model model) {
    if ( bindingResult.hasErrors() ) {
      return commonThings(model, shipAgent, true);
    }

//if vezzal has id that vezzal is not a new vezzal
    if ( shipAgent.getId() == null ) {
      //if there is not vezzal in db
      if ( shipAgentService.lastShipAgent() == null ) {
        //need to generate new onecustomer
        shipAgent.setCode("LKCSA" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
      } else {
        //if there is vezzal in db need to get that vezzal's code and increase its value
        String previousCode = shipAgentService.lastShipAgent().getCode().substring(5);
        shipAgent.setCode("LKCSA" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
      }

    }

    redirectAttributes.addFlashAttribute("shipAgentDetail", shipAgentService.persist(shipAgent));
    return "redirect:/shipAgent";
  }

  @GetMapping( "/edit/{id}" )
  public String edit(@PathVariable Integer id, Model model) {
    return commonThings(model, shipAgentService.findById(id), false);
  }

  @GetMapping( "/delete/{id}" )
  public String delete(@PathVariable Integer id, Model model) {
    shipAgentService.delete(id);
    return "redirect:/shipAgent";
  }

  @GetMapping( "/view/{id}" )
  public String view(@PathVariable Integer id, Model model) {
    model.addAttribute("shipAgentDetail", shipAgentService.findById(id));
    return "shipAgent/shipAgent-detail";
  }

  @GetMapping( value = "/findAll" )
  @ResponseBody
  public MappingJacksonValue findAll() {

    //MappingJacksonValue
    List<ShipAgent> shipAgents = shipAgentService.findAll();
    //Create new mapping jackson value and set it to which was need to filter
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(shipAgents);

    //simpleBeanPropertyFilter :-  need to give any id to addFilter method and created filter which was mentioned
    // what parameter's necessary to provide
    SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
        .filterOutAllExcept("id", "name");

    FilterProvider filters = new SimpleFilterProvider()
        .addFilter("ShipAgent", simpleBeanPropertyFilter);
    mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;
  }

}
