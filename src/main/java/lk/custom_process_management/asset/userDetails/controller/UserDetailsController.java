package lk.custom_process_management.asset.userDetails.controller;


import lk.custom_process_management.asset.commonAsset.model.Enum.BloodGroup;
import lk.custom_process_management.asset.commonAsset.model.Enum.CivilStatus;
import lk.custom_process_management.asset.commonAsset.model.Enum.Gender;
import lk.custom_process_management.asset.commonAsset.model.Enum.Title;
import lk.custom_process_management.asset.commonAsset.service.CommonService;
import lk.custom_process_management.asset.userDetails.entity.UserDetails;
import lk.custom_process_management.asset.userDetails.entity.UserDetailsFiles;
import lk.custom_process_management.asset.userDetails.entity.Enum.EmployeeStatus;
import lk.custom_process_management.asset.userDetails.service.UserDetailsFilesService;
import lk.custom_process_management.asset.userDetails.service.UserDetailsService;
import lk.custom_process_management.asset.userManagement.entity.User;
import lk.custom_process_management.asset.userManagement.service.UserService;
import lk.custom_process_management.util.service.DateTimeAgeService;
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
import java.util.UUID;

@Controller
@RequestMapping("/userDetails")
public class UserDetailsController {
    private final UserDetailsService userDetailsService;
    private final UserDetailsFilesService userDetailsFilesService;
    private final DateTimeAgeService dateTimeAgeService;
    private final CommonService commonService;
    private final UserService userService;


    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService, UserDetailsFilesService userDetailsFilesService,
                                 DateTimeAgeService dateTimeAgeService, CommonService commonService,
                                 UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userDetailsFilesService = userDetailsFilesService;

        this.dateTimeAgeService = dateTimeAgeService;
        this.commonService = commonService;
        this.userService = userService;

    }

    // Common things for an userDetails add and update
    private String commonThings(Model model) {
        model.addAttribute("title", Title.values());
        model.addAttribute("gender", Gender.values());
        model.addAttribute("civilStatus", CivilStatus.values());
        model.addAttribute("employeeStatus", EmployeeStatus.values());

        model.addAttribute("bloodGroup", BloodGroup.values());
        return "userDetails/addEmployee";
    }

    //When scr called file will send to
    @GetMapping("/file/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("filename") String filename) {
        UserDetailsFiles file = userDetailsFilesService.findByNewID(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getPic());
    }

    //Send all userDetails data
    @RequestMapping
    public String employeePage(Model model) {
        model.addAttribute("employees", userDetailsService.findAll());
        model.addAttribute("contendHeader", "Employee Registration");
        return "userDetails/userDetails";
    }

    //Send on userDetails details
    @GetMapping(value = "/{id}")
    public String employeeView(@PathVariable("id") Integer id, Model model) {
        UserDetails userDetails = userDetailsService.findById(id);
        model.addAttribute("userDetail", userDetails);
        model.addAttribute("addStatus", false);
        model.addAttribute("files", userDetailsFilesService.employeeFileDownloadLinks(userDetails));
        return "userDetails/userDetails-detail";
    }

    //Send userDetails data edit
    @GetMapping(value = "/edit/{id}")
    public String editEmployeeForm(@PathVariable("id") Integer id, Model model) {
        UserDetails userDetails = userDetailsService.findById(id);
        model.addAttribute("userDetails", userDetails);
        model.addAttribute("newEmployee", userDetails.getPayRoleNumber());
        model.addAttribute("addStatus", false);
        model.addAttribute("files", userDetailsFilesService.employeeFileDownloadLinks(userDetails));
        return commonThings(model);
    }

    //Send an userDetails add form
    @GetMapping(value = {"/add"})
    public String employeeAddForm(Model model) {
        model.addAttribute("addStatus", true);
        model.addAttribute("userDetails", new UserDetails());
        return commonThings(model);
    }

    //Employee add and update
    @PostMapping(value = {"/save", "/update"})
    public String addEmployee(@Valid @ModelAttribute UserDetails userDetails, BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("addStatus", true);
            model.addAttribute("userDetails", userDetails);
            return commonThings(model);
        }
        try {
            userDetails.setMobileOne(commonService.commonMobileNumberLengthValidator(userDetails.getMobileOne()));
            userDetails.setMobileTwo(commonService.commonMobileNumberLengthValidator(userDetails.getMobileTwo()));
            userDetails.setLand(commonService.commonMobileNumberLengthValidator(userDetails.getLand()));
            //after save userDetails files and save userDetails
            userDetailsService.persist(userDetails);

            //if userDetails state is not working he or she cannot access to the system
            if (!userDetails.getEmployeeStatus().equals(EmployeeStatus.WORKING)) {
                User user = userService.findUserByEmployee(userDetailsService.findByNic(userDetails.getNic()));
                //if userDetails not a user
                if (user != null) {
                    user.setEnabled(false);
                    userService.persist(user);
                }
            }
            //save userDetails images file
                if ( userDetails.getFile().getOriginalFilename() != null) {
                    UserDetailsFiles userDetailsFiles = userDetailsFilesService.findByName(userDetails.getFile().getOriginalFilename());
                    if ( userDetailsFiles != null) {
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

        } catch (Exception e) {
            ObjectError error = new ObjectError("userDetails",
                                                "There is already in the system. <br>System message -->" + e.toString());
            result.addError(error);
            model.addAttribute("addStatus", true);
            model.addAttribute("userDetails", userDetails);
            return commonThings(model);
        }
    }

    @GetMapping(value = "/remove/{id}")
    public String removeEmployee(@PathVariable Integer id) {
        userDetailsService.delete(id);
        return "redirect:/userDetails";
    }

    //To search userDetails any giving userDetails parameter
    @GetMapping(value = "/search")
    public String search(Model model, UserDetails userDetails) {
        model.addAttribute("userDetails", userDetailsService.search(userDetails));
        return "userDetails/userDetails-detail";
    }

}
