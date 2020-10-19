package lk.customsProcessManagement.asset.vezzalArrivalHistory.controller;

import lk.customsProcessManagement.asset.shipAgent.service.ShipAgentService;
import lk.customsProcessManagement.asset.vezzal.entity.Vezzal;
import lk.customsProcessManagement.asset.vezzal.service.VezzalService;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.Enum.VezzalDepartureArrivalStatus;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.VezzalArrivalHistory;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.service.VezzalArrivalHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    return commonFindAll("All accepting vezzals",
                         vezzalArrivalHistoryService.findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.NOAR), model);
  }

  //AR("Arrival"),
  @GetMapping( "/arrival" )
  public String findArrivalAll(Model model) {
    return commonFindAll("All arrival vezzals",
                         vezzalArrivalHistoryService.findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus.AR), model);
  }

  //DP("Departure");
  @GetMapping( "/departure" )
  public String findDepartureAll(Model model) {
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
      bindingResult.getAllErrors().forEach(x -> System.out.println(x.toString()));
      return commonAddMethod(model, vezzalService.findById(vezzalArrivalHistory.getVezzal().getId()), true,
                             vezzalArrivalHistory);
    }
    vezzalArrivalHistoryService.persist(vezzalArrivalHistory);
    return "redirect:/vezzalArrivalHistory";
  }


  public String edit(Integer id, Model model) {
    return null;
  }


  public String delete(Integer id, Model model) {
    return null;
  }


  public String view(Integer id, Model model) {
    return null;
  }

}
