package lk.custom_process_management;



import lk.custom_process_management.asset.commonAsset.model.Enum.Gender;
import lk.custom_process_management.asset.commonAsset.model.Enum.Title;
import lk.custom_process_management.asset.userDetails.entity.UserDetails;
import lk.custom_process_management.asset.userDetails.service.UsersDetailsService;
import lk.custom_process_management.asset.userManagement.entity.Role;
import lk.custom_process_management.asset.userManagement.entity.User;
import lk.custom_process_management.asset.userManagement.service.RoleService;
import lk.custom_process_management.asset.userManagement.service.UserService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
public class ApplicationCreateRestController {
  private final RoleService roleService;
  private final UserService userService;
  private final UsersDetailsService usersDetailsService;
  private final MakeAutoGenerateNumberService makeAutoGenerateNumberService;

  public ApplicationCreateRestController(RoleService roleService, UserService userService,
                                         UsersDetailsService usersDetailsService, MakeAutoGenerateNumberService makeAutoGenerateNumberService) {
    this.roleService = roleService;
    this.userService = userService;
    this.usersDetailsService = usersDetailsService;
    this.makeAutoGenerateNumberService = makeAutoGenerateNumberService;
  }


  @GetMapping( "/select/user" )
  public String saveUser() {
    //roles list start
    String[] roles = {"ADMIN"};
    for ( String s : roles ) {
      Role role = new Role();
      role.setRoleName(s);
      roleService.persist(role);
    }

//Employee
    UserDetails userDetails = new UserDetails();
    userDetails.setNumber("SLCU" + makeAutoGenerateNumberService.numberAutoGen(null).toString());
    userDetails.setName("Admin User");
    userDetails.setCallingName("Admin");
    userDetails.setName("908670000V");
    userDetails.setMobileOne("0750000000");
    userDetails.setTitle(Title.DR);
    userDetails.setGender(Gender.MALE);
    userDetails.setDateOfBirth(LocalDate.now().minusYears(18));
    UserDetails userDetailsDb = usersDetailsService.persist(userDetails);


    //admin user one
    User user = new User();
    user.setUserDetails(userDetailsDb);
    user.setUsername("admin");
    user.setPassword("admin");
    String message = "Username:- " + user.getUsername() + "\n Password:- " + user.getPassword();
    user.setEnabled(true);
    user.setRoles(roleService.findAll()
                      .stream()
                      .filter(role -> role.getRoleName().equals("ADMIN"))
                      .collect(Collectors.toList()));
    userService.persist(user);

    return message;
  }


}
