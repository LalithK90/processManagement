package lk.custom_process_management.asset.userDetails.service;


import lk.custom_process_management.asset.userDetails.dao.UserDetailsDao;
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
public class UserDetailsService implements AbstractService< UserDetails, Integer > {

    private final UserDetailsDao userDetailsDao;

    @Autowired
    public UserDetailsService(UserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    @Cacheable
    public List< UserDetails > findAll() {
        return userDetailsDao.findAll();
    }

    @Cacheable
    public UserDetails findById(Integer id) {
        return userDetailsDao.getOne(id);
    }

    @Caching( evict = {@CacheEvict( value = "employee", allEntries = true )},
            put = {@CachePut( value = "employee", key = "#userDetails.id" )} )
    @Transactional
    public UserDetails persist(UserDetails userDetails) {
        return userDetailsDao.save(userDetails);
    }

    @CacheEvict( allEntries = true )
    public boolean delete(Integer id) {
        userDetailsDao.deleteById(id);
        return false;
    }

    @Cacheable
    public List< UserDetails > search(UserDetails userDetails) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< UserDetails > employeeExample = Example.of(userDetails, matcher);
        return userDetailsDao.findAll(employeeExample);
    }

    public boolean isEmployeePresent(UserDetails userDetails) {
        return userDetailsDao.equals(userDetails);
    }


    public UserDetails lastEmployee() {
        return userDetailsDao.findFirstByOrderByIdDesc();
    }

    @Cacheable
    public UserDetails findByNic(String nic) {
        return userDetailsDao.findByNic(nic);
    }
}
