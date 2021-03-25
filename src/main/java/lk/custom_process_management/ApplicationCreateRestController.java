package lk.custom_process_management;



import lk.custom_process_management.asset.common_asset.model.enums.Gender;
import lk.custom_process_management.asset.common_asset.model.enums.Title;
import lk.custom_process_management.asset.user_details.entity.enums.RelevantParty;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details.service.UsersDetailsService;
import lk.custom_process_management.asset.user_management.entity.Role;
import lk.custom_process_management.asset.user_management.entity.User;
import lk.custom_process_management.asset.user_management.service.RoleService;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.util.service.MakeAutoGenerateNumberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;
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
    String[] roles = {"ADMIN","Ship_agent","Chandler","Inspector", "Superintendent","Assistant_superintendent","Guard"};
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
    userDetails.setRelevantParty(RelevantParty.SLC);
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
