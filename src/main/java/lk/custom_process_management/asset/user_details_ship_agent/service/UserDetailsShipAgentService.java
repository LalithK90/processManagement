package lk.custom_process_management.asset.user_details_ship_agent.service;


import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details_ship_agent.dao.UserDetailsShipAgentDao;
import lk.custom_process_management.asset.user_details_ship_agent.entity.UserDetailsShipAgent;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "userDetailsChandler" )
public class UserDetailsShipAgentService implements AbstractService< UserDetailsShipAgent, Integer > {
  private final UserDetailsShipAgentDao userDetailsShipAgentDao;

  public UserDetailsShipAgentService(UserDetailsShipAgentDao userDetailsShipAgentDao) {
    this.userDetailsShipAgentDao = userDetailsShipAgentDao;
  }

  public List< UserDetailsShipAgent > findAll() {
    return userDetailsShipAgentDao.findAll();
  }

  public UserDetailsShipAgent findById(Integer id) {
    return userDetailsShipAgentDao.getOne(id);
  }

  public UserDetailsShipAgent persist(UserDetailsShipAgent userDetailsShipAgent) {
    return userDetailsShipAgentDao.save(userDetailsShipAgent);
  }

  public boolean delete(Integer id) {
    userDetailsShipAgentDao.deleteById(id);
    return false;
  }

  public List< UserDetailsShipAgent > search(UserDetailsShipAgent userDetailsShipAgent) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< UserDetailsShipAgent > vezzalExample = Example.of(userDetailsShipAgent, matcher);
    return userDetailsShipAgentDao.findAll(vezzalExample);
  }

  public UserDetailsShipAgent lastVezzal() {
    return userDetailsShipAgentDao.findFirstByOrderByIdDesc();
  }

  public UserDetailsShipAgent findByUserDetails(UserDetails userDetails) {
  return userDetailsShipAgentDao.findByUserDetails(userDetails);
  }
}