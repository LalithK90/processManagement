package lk.custom_process_management.asset.userManagement.controller;

import lk.custom_process_management.asset.userDetails.entity.UserDetails;
import lk.custom_process_management.asset.userDetails.entity.Enum.Designation;
import lk.custom_process_management.asset.userDetails.entity.Enum.EmployeeStatus;
import lk.custom_process_management.asset.userDetails.service.UserDetailsService;
import lk.custom_process_management.asset.userManagement.entity.User;
import lk.custom_process_management.asset.userManagement.service.RoleService;
import lk.custom_process_management.asset.userManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping( "/user" )
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserController(UserService userService, UserDetailsService userDetailsService, RoleService roleService
                         ) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.roleService = roleService;
    }

    @GetMapping
    public String userPage(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/user";
    }

    @GetMapping( value = "/{id}" )
    public String userView(@PathVariable( "id" ) Integer id, Model model) {
        model.addAttribute("userDetail", userService.findById(id));
        return "user/user-detail";
    }

    private String commonCode(Model model) {
        model.addAttribute("employeeDetailShow", true);
        model.addAttribute("employeeNotFoundShow", false);
        model.addAttribute("roleList", roleService.findAll());
        /*model.addAttribute("districtUrl", MvcUriComponentsBuilder
                .fromMethodName(WorkingPlaceRestController.class, "getDistrict", "")
                .build()
                .toString());
        model.addAttribute("stationUrl", MvcUriComponentsBuilder
                .fromMethodName(WorkingPlaceRestController.class, "getStation", "")
                .build()
                .toString());*/
        return "user/addUser";
    }

    @GetMapping( value = "/edit/{id}" )
    public String editUserFrom(@PathVariable( "id" ) Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("addStatus", false);
        return commonCode(model);
    }

    @GetMapping( value = "/add" )
    public String userAddFrom(Model model) {
        model.addAttribute("addStatus", true);
        model.addAttribute("employeeDetailShow", false);
        model.addAttribute("employee", new UserDetails());
        return "user/addUser";
    }

    //Send a searched employee to add working place
    @PostMapping( value = "/workingPlace" )
    public String addUserEmployeeDetails(@ModelAttribute( "employee" ) UserDetails userDetails, Model model) {

        List< UserDetails > userDetailList = userDetailsService.search(userDetails)
                .stream()
                .filter(userService::findByEmployee)
                .collect(Collectors.toList());

        if ( userDetailList.size() == 1 ) {
            model.addAttribute("user", new User());
            model.addAttribute("employee", userDetailList.get(0));
            model.addAttribute("addStatus", true);
            return commonCode(model);
        }
        model.addAttribute("addStatus", true);
        model.addAttribute("employee", new UserDetails());
        model.addAttribute("employeeDetailShow", false);
        model.addAttribute("employeeNotFoundShow", true);
        model.addAttribute("employeeNotFound", "There is not employee in the system according to the provided details" +
                " or that employee already be a user in the system" +
                " \n Could you please search again !!");

        return "user/addUser";
    }

    // Above method support to send data to front end - All List, update, edit
    //Bellow method support to do back end function save, delete, update, search

    @PostMapping( value = {"/add", "/update"} )
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {

        if ( userService.findUserByEmployee(user.getUserDetails()) != null ) {
            ObjectError error = new ObjectError("employee", "This employee already defined as a user");
            result.addError(error);
        }
        if ( user.getId() != null ) {
            User dbUser = userService.findById(user.getId());
            dbUser.setEnabled(true);
            dbUser.setPassword(user.getPassword());
            dbUser.setUserDetails(user.getUserDetails());
            dbUser.setRoles(user.getRoles());
            userService.persist(dbUser);
            return "redirect:/user";
        }
        if ( result.hasErrors() ) {
            System.out.println("result to string    " + result.toString());
            model.addAttribute("addStatus", false);
            model.addAttribute("user", user);
            return commonCode(model);
        }
        //user is super senior office need to provide all working palace to check
        UserDetails userDetails = userDetailsService.findById(user.getUserDetails().getId());
        Designation designation = userDetails.getDesignation();

        // userService.persist(user);
        if ( userDetails.getEmployeeStatus().equals(EmployeeStatus.WORKING) ) {
            user.setEnabled(true);
        } else {
            user.setEnabled(false);
        }
        user.setRoles(user.getRoles());
        user.setEnabled(true);
        userService.persist(user);
        return "redirect:/user";
    }


    @GetMapping( value = "/remove/{id}" )
    public String removeUser(@PathVariable Integer id) {
        // user can not be deleted
        //userService.delete(id);
        return "redirect:/user";
    }

    @GetMapping( value = "/search" )
    public String search(Model model, User user) {
        model.addAttribute("userDetail", userService.search(user));
        return "user/user-detail";
    }
}
