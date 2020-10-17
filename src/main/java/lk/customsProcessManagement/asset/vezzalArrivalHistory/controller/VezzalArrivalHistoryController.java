package lk.customsProcessManagement.asset.vezzalArrivalHistory.controller;

import lk.customsProcessManagement.asset.vezzal.service.VezzalService;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.Enum.VezzalDepartureArrivalStatus;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.VezzalArrivalHistory;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.service.VezzalArrivalHistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping( "/vezzalArrivalHistory" )
public class VezzalArrivalHistoryController {
  private final VezzalService vezzalService;
  private final VezzalArrivalHistoryService vezzalArrivalHistoryService;

  public VezzalArrivalHistoryController(VezzalService vezzalService,
                                        VezzalArrivalHistoryService vezzalArrivalHistoryService) {
    this.vezzalService = vezzalService;
    this.vezzalArrivalHistoryService = vezzalArrivalHistoryService;
  }

  private String commonFindAll(String message, List< VezzalArrivalHistory > vezzalArrivalHistories, Model model) {
    model.addAttribute("message", message);
    model.addAttribute("vezzalArrivalHistories", vezzalArrivalHistories);
    return "vezzalArrivalHistory/vezzalArrivalHistory";
  }

  @GetMapping
  public String findAll(Model model) {
    return commonFindAll("All vezzals not arrival, arrival and departure ", vezzalArrivalHistoryService.findAll(), model);
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


  public String addForm(Model model) {
    return null;
  }


  public String persist(VezzalArrivalHistory vezzalArrivalHistory, BindingResult bindingResult,
                        RedirectAttributes redirectAttributes, Model model) throws Exception {
    return null;
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
