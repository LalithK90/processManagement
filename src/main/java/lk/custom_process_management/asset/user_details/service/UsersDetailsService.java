package lk.custom_process_management.asset.user_details.service;


import lk.custom_process_management.asset.user_details.dao.UserDetailsDao;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import org.springframework.cache.annotation.*;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// spring transactional annotation need to tell spring to this method work through the project
@CacheConfig( cacheNames = "userDetails" )
public class UsersDetailsService {

  private final UserDetailsDao userDetailsDao;


  public UsersDetailsService(UserDetailsDao userDetailsDao) {
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

  @Caching( evict = {@CacheEvict( value = "userDetails", allEntries = true )},
      put = {@CachePut( value = "userDetails", key = "#userDetails.id" )} )
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

  @Cacheable
  public UserDetails findByNic(String nic) {
    return userDetailsDao.findByNic(nic);
  }

  public UserDetails findLastUserDetails() {
    return userDetailsDao.findFirstByOrderByIdDesc();
  }
}
