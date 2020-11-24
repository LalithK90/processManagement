package lk.custom_process_management.asset.vezzal_arrival_history.controller;

import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.asset.vezzal.entity.Vezzal;
import lk.custom_process_management.asset.vezzal.service.VezzalService;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.VezzalArrivalHistory;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.enums.VezzalDepartureArrivalStatus;
import lk.custom_process_management.asset.vezzal_arrival_history.service.VezzalArrivalHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/vezzalArrivalHistory" )
public class VezzalArrivalHistoryController {
  private final VezzalArrivalHistoryService vezzalArrivalHistoryService;
  private final VezzalService vezzalService;
  private final ShipAgentService shipAgentService;

  public VezzalArrivalHistoryController(VezzalArrivalHistoryService vezzalArrivalHistoryService,
                                        VezzalService vezzalService, ShipAgentService shipAgentService) {

    this.vezzalArrivalHistoryService = vezzalArrivalHistoryService;
    this.vezzalService = vezzalService;
    this.shipAgentService = shipAgentService;
  }

  private String commonFindAll(String message, List< VezzalArrivalHistory > vezzalArrivalHistories, Model model) {
    model.addAttribute("message", message);
    model.addAttribute("vezzalArrivalHistories", vezzalArrivalHistories);
    return "vezzalArrivalHistory/vezzalArrivalHistory";
  }

  @GetMapping
  public String findAll(Model model) {
    return commonFindAll("All vezzals not arrival, arrival and departure ", vezzalArrivalHistoryService.findAll(),
                         model);
  }

  //NOAR("Still Not Arrival"),
  @GetMapping( "/notArrival" )
  public String findNotArrivalAll(Model model) {
    model.addAttribute("notArrival", true);
    return commonFindAll("All accepting vezzals",
                         vezzalArrivalHistoryService.findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.NOAR), model);
  }

  //AR("Arrival"),
  @GetMapping( "/arrival" )
  public String findArrivalAll(Model model) {
    model.addAttribute("arrival", true);
    return commonFindAll("All arrival vezzals",
                         vezzalArrivalHistoryService.findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.AR), model);
  }

  //DP("Departure");
  @GetMapping( "/departure" )
  public String findDepartureAll(Model model) {
    model.addAttribute("departure", true);
    return commonFindAll("All departure vezzals",
                         vezzalArrivalHistoryService.findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.DP), model);
  }

  @GetMapping( "/add/{id}" )
  public String addForm(@PathVariable Integer id, Model model) {
    Vezzal vezzal = vezzalService.findById(id);
    VezzalArrivalHistory vezzalArrivalHistory = new VezzalArrivalHistory();
    vezzalArrivalHistory.setVezzal(vezzal);
    return commonAddMethod(model, vezzal, true, vezzalArrivalHistory);
  }

  private String commonAddMethod(Model model, Vezzal vezzal, boolean addStatus,
                                 VezzalArrivalHistory vezzalArrivalHistory) {
    model.addAttribute("vezzalDetail", vezzal);
    model.addAttribute("addStatus", addStatus);
    model.addAttribute("vezzalArrivalHistory", vezzalArrivalHistory);
    model.addAttribute("shipAgents", shipAgentService.findAll());
    return "vezzalArrivalHistory/addVezzalArrivalHistory";
  }

  @PostMapping( value = {"/save", "/update"} )
  public String persist(@Valid @ModelAttribute VezzalArrivalHistory vezzalArrivalHistory, BindingResult bindingResult,
                        Model model) {
    if ( bindingResult.hasErrors() ) {
      return commonAddMethod(model, vezzalService.findById(vezzalArrivalHistory.getVezzal().getId()), true,
                             vezzalArrivalHistory);
    }
    //new vezzal arrival save
    if ( vezzalArrivalHistory.getId() == null ) {
      vezzalArrivalHistory.setVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.NOAR);

      VezzalArrivalHistory lastVezzalArrivalHistory =
          vezzalArrivalHistoryService.lastVezzalHistoryByVezzal(vezzalArrivalHistory.getVezzal());

      if ( lastVezzalArrivalHistory != null && !lastVezzalArrivalHistory.getVezzalDepartureArrivalStatus().equals(VezzalDepartureArrivalStatus.DP) ) {

        ObjectError error = new ObjectError("vezzalArrivalHistory",
                                            "There is already this vezzal on harbor");
        bindingResult.addError(error);
        return commonAddMethod(model, vezzalService.findById(vezzalArrivalHistory.getVezzal().getId()), true,
                               vezzalArrivalHistory);
      }

    }

    vezzalArrivalHistoryService.persist(vezzalArrivalHistory);
    return "redirect:/vezzalArrivalHistory";
  }

  //not arrival vezzal -> state change to arrival
  @GetMapping( "/arrival/{id}" )
  public String notArrivalToArrival(@PathVariable Integer id) {
    System.out.println("asdasda");
    VezzalArrivalHistory vezzalArrivalHistory = vezzalArrivalHistoryService.findById(id);
    vezzalArrivalHistory.setVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.AR);
    vezzalArrivalHistoryService.persist(vezzalArrivalHistory);
    return "redirect:/vezzalArrivalHistory/notArrival";
  }

  //arrival vezzal -> state change to departure
  @GetMapping( "/departure/{id}" )
  public String arrivalToDeparture(@PathVariable Integer id) {
    VezzalArrivalHistory vezzalArrivalHistory = vezzalArrivalHistoryService.findById(id);
    vezzalArrivalHistory.setVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.DP);
    vezzalArrivalHistoryService.persist(vezzalArrivalHistory);
    return "redirect:/vezzalArrivalHistory/arrival";
  }

  @GetMapping( "/edit/{id}" )
  public String edit(@PathVariable Integer id, Model model) {
    VezzalArrivalHistory vezzalArrivalHistory = vezzalArrivalHistoryService.findById(id);
    return commonAddMethod(model, vezzalService.findById(vezzalArrivalHistory.getVezzal().getId()), false,
                           vezzalArrivalHistory);
  }

  //delete is not a applicable
  public String delete(Integer id, Model model) {
    return null;
  }

  @GetMapping( "/{id}" )
  public String view(@PathVariable Integer id, Model model) {
    VezzalArrivalHistory vezzalArrivalHistory = vezzalArrivalHistoryService.findById(id);
    model.addAttribute("vezzalArrivalHistoryDetail", vezzalArrivalHistory);
    model.addAttribute("vezzalDetail", vezzalArrivalHistory.getVezzal());
    return "vezzalArrivalHistory/vezzalArrivalHistory-detail";
  }

}
