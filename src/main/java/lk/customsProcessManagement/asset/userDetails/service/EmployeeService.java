package lk.customsProcessManagement.asset.userDetails.service;


import lk.customsProcessManagement.asset.userDetails.dao.EmployeeDao;
import lk.customsProcessManagement.asset.userDetails.entity.Employee;
import lk.customsProcessManagement.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// spring transactional annotation need to tell spring to this method work through the project
@CacheConfig( cacheNames = "employee" )
public class EmployeeService implements AbstractService<Employee, Integer > {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Cacheable
    public List< Employee > findAll() {
        return employeeDao.findAll();
    }

    @Cacheable
    public Employee findById(Integer id) {
        return employeeDao.getOne(id);
    }

    @Caching( evict = {@CacheEvict( value = "employee", allEntries = true )},
            put = {@CachePut( value = "employee", key = "#employee.id" )} )
    @Transactional
    public Employee persist(Employee employee) {
        return employeeDao.save(employee);
    }

    @CacheEvict( allEntries = true )
    public boolean delete(Integer id) {
        employeeDao.deleteById(id);
        return false;
    }

    @Cacheable
    public List< Employee > search(Employee employee) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< Employee > employeeExample = Example.of(employee, matcher);
        return employeeDao.findAll(employeeExample);
    }

    public boolean isEmployeePresent(Employee employee) {
        return employeeDao.equals(employee);
    }


    public Employee lastEmployee() {
        return employeeDao.findFirstByOrderByIdDesc();
    }

    @Cacheable
    public Employee findByNic(String nic) {
        return employeeDao.findByNic(nic);
    }
}
