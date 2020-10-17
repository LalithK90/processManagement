package lk.customsProcessManagement.asset.userDetails.controller;


import lk.customsProcessManagement.asset.userDetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/employee" )
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

   /* @GetMapping( value = "/getEmployee" )
    public MappingJacksonValue getEmployeeByWorkingPlace(@RequestParam( "designation" ) String designation,
                                                         @RequestParam( "id" ) Integer id) {
        Employee employee = new Employee();
        employee.setDesignation(Designation.valueOf(designation));

        //MappingJacksonValue
        List< Employee > employees = employeeService.search(employee);
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
