package lk.custom_process_management.asset.user_details.controller;


import lk.custom_process_management.asset.chandler.controller.ChandlerController;
import lk.custom_process_management.asset.chandler.service.ChandlerService;
import lk.custom_process_management.asset.common_asset.model.enums.Gender;
import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.common_asset.model.enums.Title;
import lk.custom_process_management.asset.ship_agent.controller.ShipAgentController;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.ship_agent.service.ShipAgentService;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details.entity.UserDetailsFiles;
import lk.custom_process_management.asset.user_details.entity.enums.RelevantParty;
import lk.custom_process_management.asset.user_details.service.UserDetailsFilesService;
import lk.custom_process_management.asset.user_details.service.UsersDetailsService;
import lk.custom_process_management.asset.user_details_chandler.entity.UserDetailsChandler;
import lk.custom_process_management.asset.user_details_chandler.service.UserDetailsChandlerService;
import lk.custom_process_management.asset.user_details_ship_agent.entity.UserDetailsShipAgent;
import lk.custom_process_management.asset.user_details_ship_agent.service.UserDetailsShipAgentService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/userDetails" )
public class UserDetailsController {
  private final UsersDetailsService usersDetailsService;
  private final UserDetailsFilesService userDetailsFilesService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;
  private final ChandlerService chandlerService;
  private final ShipAgentService shipAgentService;
  private final UserDetailsChandlerService userDetailsChandlerService;
  private final UserDetailsShipAgentService userDetailsShipAgentService;

  @Autowired
  public UserDetailsController(UsersDetailsService usersDetailsService, UserDetailsFilesService userDetailsFilesService,
                               MakeAutoGenerateNumberService makeAutoGenerateNumberService,
                               ChandlerService chandlerService, ShipAgentService shipAgentService,
                               UserDetailsChandlerService userDetailsChandlerService,
                               UserDetailsShipAgentService userDetailsShipAgentService) {
    this.usersDetailsService = usersDetailsService;
    this.userDetailsFilesService = userDetailsFilesService;
    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
    this.chandlerService = chandlerService;
    this.shipAgentService = shipAgentService;
    this.userDetailsChandlerService = userDetailsChandlerService;
    this.userDetailsShipAgentService = userDetailsShipAgentService;
  }

  // Common things for an userDetails add and update
  private String commonThings(Model model) {
    model.addAttribute("title", Title.values());
    model.addAttribute("gender", Gender.values());
    model.addAttribute("relevantParties", RelevantParty.values());
    model.addAttribute("findAllShipAgentUri", MvcUriComponentsBuilder
        .fromMethodName(ShipAgentController.class, "findAll", "")
        .build()
        .toString());
    model.addAttribute("findAllChandlerUri", MvcUriComponentsBuilder
        .fromMethodName(ChandlerController.class, "findAll", "")
        .build()
        .toString());
    return "userDetails/addUserDetails";
  }

  //When scr called file will send to
  @GetMapping( "/file/{filename}" )
  public ResponseEntity< byte[] > downloadFile(@PathVariable( "filename" ) String filename) {
    UserDetailsFiles file = userDetailsFilesService.findByNewID(filename);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
        .body(file.getPic());
  }

  //Send all userDetails data
  @RequestMapping
  public String findAll(Model model) {
    List< UserDetails > userDetailsList = new ArrayList<>();

    for ( UserDetails userDetails : usersDetailsService.findAll()
        .stream()
        .filter(x -> LiveDead.ACTIVE.equals(x.getLiveDead()))
        .collect(Collectors.toList())
    ) {
      userDetails.setFileInfo(userDetailsFilesService.userDetailsFileDownloadLinks(userDetails));
      userDetailsList.add(userDetails);
    }
    model.addAttribute("userDetailses", userDetailsList);
    model.addAttribute("contendHeader", "User Details Registration");
    return "userDetails/userDetails";
  }

  //Send on userDetails details
  @GetMapping( value = "/{id}" )
  public String view(@PathVariable( "id" ) Integer id, Model model) {
    UserDetails userDetails = usersDetailsService.findById(id);
    model.addAttribute("userDetail", userDetails);
    model.addAttribute("file", userDetailsFilesService.userDetailsFileDownloadLinks(userDetails));
    return "userDetails/userDetails-detail";
  }

  //Send userDetails data edit
  @GetMapping( value = "/edit/{id}" )
  public String editForm(@PathVariable( "id" ) Integer id, Model model) {
    UserDetails userDetails = usersDetailsService.findById(id);
    model.addAttribute("userDetails", userDetails);
    model.addAttribute("addStatus", false);
    model.addAttribute("file", userDetailsFilesService.userDetailsFileDownloadLinks(userDetails));
    return commonThings(model);
  }

  //Send an userDetails add form
  @GetMapping( value = {"/add"} )
  public String addForm(Model model) {
    model.addAttribute("addStatus", true);
    model.addAttribute("userDetails", new UserDetails());
    return commonThings(model);
  }

  //Employee add and update
  @PostMapping( value = {"/save", "/update"} )
  public String add(@Valid @ModelAttribute UserDetails userDetails, BindingResult result, Model model
                   ) {
    if ( result.hasErrors() ) {
      model.addAttribute("addStatus", true);
      model.addAttribute("userDetails", userDetails);
      return commonThings(model);
    }
    if ( userDetails.getId() == null ) {
      //if there is not item in db
      if ( usersDetailsService.findLastUserDetails() == null ) {
        //need to generate new one
        userDetails.setNumber("SLCU" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
      } else {
        //if there is item in db need to get that item's code and increase its value
        String previousCode = usersDetailsService.findLastUserDetails().getNumber().substring(4);
        userDetails.setNumber("SLCU" + makeAutoGenerateNumberService.numberAutoGen(previousCode).toString());
      }
    }
    userDetails.setMobileOne(makeAutoGenerateNumberService.phoneNumberLengthValidator(userDetails.getMobileOne()));
    userDetails.setMobileTwo(makeAutoGenerateNumberService.phoneNumberLengthValidator(userDetails.getMobileTwo()));
    userDetails.setLand(makeAutoGenerateNumberService.phoneNumberLengthValidator(userDetails.getLand()));

    //after save userDetails files and save userDetails
    UserDetails userDetailsDb = usersDetailsService.persist(userDetails);
    System.out.println("relevant party id " + userDetails.getRelevantPartyId());
    //if user belongs to chandler
    if ( userDetails.getRelevantParty().equals(RelevantParty.SLCC) ) {
      UserDetailsChandler userDetailsChandler = userDetailsChandlerService.findByUserDetails(userDetailsDb);
      if ( userDetailsChandler == null ) {
        userDetailsChandler = new UserDetailsChandler();
      }
      userDetailsChandler.setUserDetails(userDetailsDb);
      userDetailsChandler.setChandler(chandlerService.findById(userDetails.getRelevantPartyId()));
      userDetailsChandlerService.persist(userDetailsChandler);
    }

    //if user belongs to shipAgent
    if ( userDetails.getRelevantParty().equals(RelevantParty.SLCS) ) {
      UserDetailsShipAgent userDetailsShipAgent = userDetailsShipAgentService.findByUserDetails(userDetailsDb);
      if ( userDetailsShipAgent == null ) {
        userDetailsShipAgent = new UserDetailsShipAgent();
      }
      userDetailsShipAgent.setUserDetails(userDetailsDb);
      userDetailsShipAgent.setShipAgent(shipAgentService.findById(userDetails.getRelevantPartyId()));
      userDetailsShipAgentService.persist(userDetailsShipAgent);
    }


    try {
      //save userDetails images file
      if ( userDetails.getFile() != null ) {
        UserDetailsFiles userDetailsFiles =
            userDetailsFilesService.findByUserDetails(userDetailsDb);
        if ( userDetailsFiles != null ) {
          // update new contents
          userDetailsFiles.setPic(userDetails.getFile().getBytes());
          // Save all to database
        } else {
          userDetailsFiles = new UserDetailsFiles(userDetails.getFile().getOriginalFilename(),
                                                  userDetails.getFile().getContentType(),
                                                  userDetails.getFile().getBytes(),
                                                  userDetails.getNic().concat("-" + LocalDateTime.now()),
                                                  UUID.randomUUID().toString().concat("userDetails"));
          userDetailsFiles.setUserDetails(userDetails);
        }
        userDetailsFilesService.persist(userDetailsFiles);
      }
      return "redirect:/userDetails";

    } catch ( Exception e ) {
      ObjectError error = new ObjectError("userDetails",
                                          "There is already in the system. \n Error happened because of Image. \n " +
                                              "System message -->" + e.toString());
      result.addError(error);
      model.addAttribute("addStatus", true);
      model.addAttribute("userDetails", userDetails);
      return commonThings(model);
    }
  }

  @GetMapping( value = "/remove/{id}" )
  public String remove(@PathVariable Integer id) {
    usersDetailsService.delete(id);
    return "redirect:/userDetails";
  }

  //To search userDetails any giving userDetails parameter
  @GetMapping( value = "/search" )
  public String search(Model model, UserDetails userDetails) {
    model.addAttribute("userDetails", usersDetailsService.search(userDetails));
    return "userDetails/userDetails-detail";
  }

}
