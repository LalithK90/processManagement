package lk.custom_process_management.asset.userDetails.controller;


import lk.custom_process_management.asset.commonAsset.model.Enum.BloodGroup;
import lk.custom_process_management.asset.commonAsset.model.Enum.CivilStatus;
import lk.custom_process_management.asset.commonAsset.model.Enum.Gender;
import lk.custom_process_management.asset.commonAsset.model.Enum.Title;
import lk.custom_process_management.asset.commonAsset.service.CommonService;
import lk.custom_process_management.asset.userDetails.entity.UserDetails;
import lk.custom_process_management.asset.userDetails.entity.UserDetailsFiles;
import lk.custom_process_management.asset.userDetails.entity.Enum.EmployeeStatus;
import lk.custom_process_management.asset.userDetails.service.EmployeeFilesService;
import lk.custom_process_management.asset.userDetails.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeFilesService employeeFilesService;
    private final DateTimeAgeService dateTimeAgeService;
    private final CommonService commonService;
    private final UserService userService;


    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeFilesService employeeFilesService,
                              DateTimeAgeService dateTimeAgeService, CommonService commonService,
                              UserService userService) {
        this.employeeService = employeeService;
        this.employeeFilesService = employeeFilesService;

        this.dateTimeAgeService = dateTimeAgeService;
        this.commonService = commonService;
        this.userService = userService;

    }

    // Common things for an employee add and update
    private String commonThings(Model model) {
        model.addAttribute("title", Title.values());
        model.addAttribute("gender", Gender.values());
        model.addAttribute("civilStatus", CivilStatus.values());
        model.addAttribute("employeeStatus", EmployeeStatus.values());

        model.addAttribute("bloodGroup", BloodGroup.values());
        return "employee/addEmployee";
    }

    //When scr called file will send to
    @GetMapping("/file/{filename}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("filename") String filename) {
        UserDetailsFiles file = employeeFilesService.findByNewID(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getPic());
    }

    //Send all employee data
    @RequestMapping
    public String employeePage(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("contendHeader", "Employee Registration");
        return "employee/employee";
    }

    //Send on employee details
    @GetMapping(value = "/{id}")
    public String employeeView(@PathVariable("id") Integer id, Model model) {
        UserDetails userDetails = employeeService.findById(id);
        model.addAttribute("employeeDetail", userDetails);
        model.addAttribute("addStatus", false);
        model.addAttribute("files", employeeFilesService.employeeFileDownloadLinks(userDetails));
        return "employee/employee-detail";
    }

    //Send employee data edit
    @GetMapping(value = "/edit/{id}")
    public String editEmployeeForm(@PathVariable("id") Integer id, Model model) {
        UserDetails userDetails = employeeService.findById(id);
        model.addAttribute("employee", userDetails);
        model.addAttribute("newEmployee", userDetails.getPayRoleNumber());
        model.addAttribute("addStatus", false);
        model.addAttribute("files", employeeFilesService.employeeFileDownloadLinks(userDetails));
        return commonThings(model);
    }

    //Send an employee add form
    @GetMapping(value = {"/add"})
    public String employeeAddForm(Model model) {
        model.addAttribute("addStatus", true);
        model.addAttribute("employee", new UserDetails());
        return commonThings(model);
    }

    //Employee add and update
    @PostMapping(value = {"/save", "/update"})
    public String addEmployee(@Valid @ModelAttribute UserDetails userDetails, BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("addStatus", true);
            model.addAttribute("employee", userDetails);
            return commonThings(model);
        }
        try {
            userDetails.setMobileOne(commonService.commonMobileNumberLengthValidator(userDetails.getMobileOne()));
            userDetails.setMobileTwo(commonService.commonMobileNumberLengthValidator(userDetails.getMobileTwo()));
            userDetails.setLand(commonService.commonMobileNumberLengthValidator(userDetails.getLand()));
            //after save employee files and save employee
            employeeService.persist(userDetails);

            //if employee state is not working he or she cannot access to the system
            if (!userDetails.getEmployeeStatus().equals(EmployeeStatus.WORKING)) {
                User user = userService.findUserByEmployee(employeeService.findByNic(userDetails.getNic()));
                //if employee not a user
                if (user != null) {
                    user.setEnabled(false);
                    userService.persist(user);
                }
            }
            //save employee images file
                if ( userDetails.getFile().getOriginalFilename() != null) {
                    UserDetailsFiles userDetailsFiles = employeeFilesService.findByName(userDetails.getFile().getOriginalFilename());
                    if ( userDetailsFiles != null) {
                        // update new contents
                        userDetailsFiles.setPic(userDetails.getFile().getBytes());
                        // Save all to database
                    } else {
                        userDetailsFiles = new UserDetailsFiles(userDetails.getFile().getOriginalFilename(),
                                                                userDetails.getFile().getContentType(),
                                                                userDetails.getFile().getBytes(),
                                                                userDetails.getNic().concat("-" + LocalDateTime.now()),
                                                                UUID.randomUUID().toString().concat("employee"));
                        userDetailsFiles.setUserDetails(userDetails);
                    }
                    employeeFilesService.persist(userDetailsFiles);
                }
            return "redirect:/employee";

        } catch (Exception e) {
            ObjectError error = new ObjectError("employee",
                                                "There is already in the system. <br>System message -->" + e.toString());
            result.addError(error);
            model.addAttribute("addStatus", true);
            model.addAttribute("employee", userDetails);
            return commonThings(model);
        }
    }

    //If need to employee {but not applicable for this }
    @GetMapping(value = "/remove/{id}")
    public String removeEmployee(@PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }

    //To search employee any giving employee parameter
    @GetMapping(value = "/search")
    public String search(Model model, UserDetails userDetails) {
        model.addAttribute("employeeDetail", employeeService.search(userDetails));
        return "employee/employee-detail";
    }

}
