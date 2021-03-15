package lk.custom_process_management.asset.vessel_arrival_history.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.asset.vessel.entity.Vessel;
import lk.custom_process_management.asset.vessel.service.VesselService;
import lk.custom_process_management.asset.vessel_arrival_history.entity.VesselArrivalHistory;
import lk.custom_process_management.asset.vessel_arrival_history.entity.enums.VesselDepartureArrivalStatus;
import lk.custom_process_management.asset.vessel_arrival_history.service.VesselArrivalHistoryService;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping( "/vesselArrivalHistory" )
public class VesselArrivalHistoryController {
  private final VesselArrivalHistoryService vesselArrivalHistoryService;
  private final VesselService vesselService;
  private final ShipAgentService shipAgentService;

  public VesselArrivalHistoryController(VesselArrivalHistoryService vesselArrivalHistoryService,
                                        VesselService vesselService, ShipAgentService shipAgentService) {

    this.vesselArrivalHistoryService = vesselArrivalHistoryService;
    this.vesselService = vesselService;
    this.shipAgentService = shipAgentService;
  }

  private String commonFindAll(String message, List< VesselArrivalHistory > vesselArrivalHistories, Model model) {
    model.addAttribute("message", message);
    model.addAttribute("vesselArrivalHistories", vesselArrivalHistories);
    return "vesselArrivalHistory/vesselArrivalHistory";
  }

  @GetMapping
  public String findAll(Model model) {
    return commonFindAll("All vessels not arrival, arrival and departure ", vesselArrivalHistoryService.findAll(),
                         model);
  }

  //NOAR("Still Not Arrival"),
  @GetMapping( "/notArrival" )
  public String findNotArrivalAll(Model model) {
    model.addAttribute("notArrival", true);
    return commonFindAll("All accepting vessels",
                         vesselArrivalHistoryService.findByVesselDepartureArrivalStatus(VesselDepartureArrivalStatus.NOAR), model);
  }

  //AR("Arrival"),
  @GetMapping( "/arrival" )
  public String findArrivalAll(Model model) {
    model.addAttribute("arrival", true);
    return commonFindAll("All arrival vessels",
                         vesselArrivalHistoryService.findByVesselDepartureArrivalStatus(VesselDepartureArrivalStatus.AR), model);
  }

  //DP("Departure");
  @GetMapping( "/departure" )
  public String findDepartureAll(Model model) {
    model.addAttribute("departure", true);
    return commonFindAll("All departure vessels",
                         vesselArrivalHistoryService.findByVesselDepartureArrivalStatus(VesselDepartureArrivalStatus.DP), model);
  }

  @GetMapping( "/add/{id}" )
  public String addForm(@PathVariable Integer id, Model model) {
    Vessel vessel = vesselService.findById(id);
    VesselArrivalHistory vesselArrivalHistory = new VesselArrivalHistory();
    vesselArrivalHistory.setVessel(vessel);
    return commonAddMethod(model, vessel, true, vesselArrivalHistory);
  }

  private String commonAddMethod(Model model, Vessel vessel, boolean addStatus,
                                 VesselArrivalHistory vesselArrivalHistory) {
    model.addAttribute("vesselDetail", vessel);
    model.addAttribute("addStatus", addStatus);
    model.addAttribute("vesselArrivalHistory", vesselArrivalHistory);
    model.addAttribute("shipAgents", shipAgentService.findAll());
    return "vesselArrivalHistory/addVesselArrivalHistory";
  }

  @PostMapping( value = {"/save", "/update"} )
  public String persist(@Valid @ModelAttribute VesselArrivalHistory vesselArrivalHistory, BindingResult bindingResult,
                        Model model) {
    if ( bindingResult.hasErrors() ) {
      return commonAddMethod(model, vesselService.findById(vesselArrivalHistory.getVessel().getId()), true,
                             vesselArrivalHistory);
    }
    //new vessel arrival save
    if ( vesselArrivalHistory.getId() == null ) {
      vesselArrivalHistory.setVesselDepartureArrivalStatus(VesselDepartureArrivalStatus.NOAR);

      VesselArrivalHistory lastVesselArrivalHistory =
          vesselArrivalHistoryService.lastVesselHistoryByVessel(vesselArrivalHistory.getVessel());

      if ( lastVesselArrivalHistory != null && !lastVesselArrivalHistory.getVesselDepartureArrivalStatus().equals(VesselDepartureArrivalStatus.DP) ) {

        ObjectError error = new ObjectError("vesselArrivalHistory",
                                            "There is already this vessel on harbor");
        bindingResult.addError(error);
        return commonAddMethod(model, vesselService.findById(vesselArrivalHistory.getVessel().getId()), true,
                               vesselArrivalHistory);
      }

    }

    vesselArrivalHistoryService.persist(vesselArrivalHistory);
    return "redirect:/vesselArrivalHistory";
  }

  //not arrival vessel -> state change to arrival
  @GetMapping( "/arrival/{id}" )
  public String notArrivalToArrival(@PathVariable Integer id) {
    VesselArrivalHistory vesselArrivalHistory = vesselArrivalHistoryService.findById(id);
    vesselArrivalHistory.setVesselDepartureArrivalStatus(VesselDepartureArrivalStatus.AR);
    vesselArrivalHistoryService.persist(vesselArrivalHistory);
    return "redirect:/vesselArrivalHistory/notArrival";
  }

  //arrival vessel -> state change to departure
  @GetMapping( "/departure/{id}" )
  public String arrivalToDeparture(@PathVariable Integer id) {
    VesselArrivalHistory vesselArrivalHistory = vesselArrivalHistoryService.findById(id);
    vesselArrivalHistory.setVesselDepartureArrivalStatus(VesselDepartureArrivalStatus.DP);
    vesselArrivalHistoryService.persist(vesselArrivalHistory);
    return "redirect:/vesselArrivalHistory/arrival";
  }

  @GetMapping( "/edit/{id}" )
  public String edit(@PathVariable Integer id, Model model) {
    VesselArrivalHistory vesselArrivalHistory = vesselArrivalHistoryService.findById(id);
    return commonAddMethod(model, vesselService.findById(vesselArrivalHistory.getVessel().getId()), false,
                           vesselArrivalHistory);
  }

  //delete is not a applicable
  public String delete(Integer id, Model model) {
    return null;
  }

  @GetMapping( "/{id}" )
  public String view(@PathVariable Integer id, Model model) {
    VesselArrivalHistory vesselArrivalHistory = vesselArrivalHistoryService.findById(id);
    model.addAttribute("vesselArrivalHistoryDetail", vesselArrivalHistory);
    model.addAttribute("vesselDetail", vesselArrivalHistory.getVessel());
    model.addAttribute("historyShow", true);
    return "vesselArrivalHistory/vesselArrivalHistory-detail";
  }

  @GetMapping("/getDepartureDate/{id}")
  @ResponseBody
  public MappingJacksonValue  getDepartureDate(@PathVariable("id") Integer id){
    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(vesselArrivalHistoryService.findById(id));

    SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
        .filterOutAllExcept("sailingDate");

    FilterProvider filters = new SimpleFilterProvider()
        .addFilter("VesselArrivalHistory", simpleBeanPropertyFilter);
    mappingJacksonValue.setFilters(filters);
    return mappingJacksonValue;
  }

}
