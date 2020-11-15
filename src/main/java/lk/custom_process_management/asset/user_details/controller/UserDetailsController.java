package lk.custom_process_management.asset.user_details.controller;


import lk.custom_process_management.asset.common_asset.model.enums.Gender;
import lk.custom_process_management.asset.common_asset.model.enums.Title;
import lk.custom_process_management.asset.common_asset.service.CommonService;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details.entity.UserDetailsFiles;
import lk.custom_process_management.asset.user_details.entity.enums.RelevantParty;
import lk.custom_process_management.asset.user_details.service.UserDetailsFilesService;
import lk.custom_process_management.asset.user_details.service.UsersDetailsService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping( "/userDetails" )
public class UserDetailsController {
  private final UsersDetailsService usersDetailsService;
  private final UserDetailsFilesService userDetailsFilesService;
  private final CommonService commonService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;


  @Autowired
  public UserDetailsController(UsersDetailsService usersDetailsService, UserDetailsFilesService userDetailsFilesService,
                               CommonService commonService,
                               MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
    this.usersDetailsService = usersDetailsService;
    this.userDetailsFilesService = userDetailsFilesService;


    this.commonService = commonService;


    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
  }

  // Common things for an userDetails add and update
  private String commonThings(Model model) {
    model.addAttribute("title", Title.values());
    model.addAttribute("gender", Gender.values());
    model.addAttribute("relevantParties", RelevantParty.values());
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
    List<UserDetails> userDetailsList = usersDetailsService.findAll();
    model.addAttribute("userDetailses", userDetailsList.remove(0));
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
    userDetails.setMobileOne(commonService.commonMobileNumberLengthValidator(userDetails.getMobileOne()));
    userDetails.setMobileTwo(commonService.commonMobileNumberLengthValidator(userDetails.getMobileTwo()));
    userDetails.setLand(commonService.commonMobileNumberLengthValidator(userDetails.getLand()));
    //after save userDetails files and save userDetails
    UserDetails userDetailsDb = usersDetailsService.persist(userDetails);
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
                                          "There is already in the system. \n Error happened because of Image. \n System message -->" + e.toString());
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
