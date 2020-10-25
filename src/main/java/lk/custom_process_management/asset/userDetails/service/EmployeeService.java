package lk.custom_process_management.asset.userDetails.service;


import lk.custom_process_management.asset.userDetails.dao.EmployeeDao;
import lk.custom_process_management.asset.userDetails.entity.UserDetails;
import lk.custom_process_management.util.interfaces.AbstractService;
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
public class EmployeeService implements AbstractService< UserDetails, Integer > {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Cacheable
    public List< UserDetails > findAll() {
        return employeeDao.findAll();
    }

    @Cacheable
    public UserDetails findById(Integer id) {
        return employeeDao.getOne(id);
    }

    @Caching( evict = {@CacheEvict( value = "employee", allEntries = true )},
            put = {@CachePut( value = "employee", key = "#userDetails.id" )} )
    @Transactional
    public UserDetails persist(UserDetails userDetails) {
        return employeeDao.save(userDetails);
    }

    @CacheEvict( allEntries = true )
    public boolean delete(Integer id) {
        employeeDao.deleteById(id);
        return false;
    }

    @Cacheable
    public List< UserDetails > search(UserDetails userDetails) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< UserDetails > employeeExample = Example.of(userDetails, matcher);
        return employeeDao.findAll(employeeExample);
    }

    public boolean isEmployeePresent(UserDetails userDetails) {
        return employeeDao.equals(userDetails);
    }


    public UserDetails lastEmployee() {
        return employeeDao.findFirstByOrderByIdDesc();
    }

    @Cacheable
    public UserDetails findByNic(String nic) {
        return employeeDao.findByNic(nic);
    }
}
