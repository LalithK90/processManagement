package lk.custom_process_management.asset.userDetails.controller;


import lk.custom_process_management.asset.userDetails.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/userDetails" )
public class UserDetailsRestController {
    private final UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsRestController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

   /* @GetMapping( value = "/getEmployee" )
    public MappingJacksonValue getEmployeeByWorkingPlace(@RequestParam( "designation" ) String designation,
                                                         @RequestParam( "id" ) Integer id) {
        Employee userDetails = new Employee();
        userDetails.setDesignation(Designation.valueOf(designation));

        //MappingJacksonValue
        List< Employee > employees = employeeService.search(userDetails);
        //employeeService.findByWorkingPlace(workingPlaceService.findById(id));

        //Create new mapping jackson value and set it to which was need to filter
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employees);

        //simpleBeanPropertyFilter :-  need to give any id to addFilter method and created filter which was mentioned
        // what parameter's necessary to provide
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "payRoleNumber", "designation");
        //filters :-  set front end required value to before filter

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("Employee", simpleBeanPropertyFilter);
        //Employee :- need to annotate relevant class with JsonFilter  {@JsonFilter("Employee") }
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
*/
}
