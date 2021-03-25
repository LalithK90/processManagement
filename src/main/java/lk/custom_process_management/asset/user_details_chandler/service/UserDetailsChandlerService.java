package lk.custom_process_management.asset.user_details_chandler.service;


import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details_chandler.dao.UserDetailsChandlerDao;
import lk.custom_process_management.asset.user_details_chandler.entity.UserDetailsChandler;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "userDetailsChandler" )
public class UserDetailsChandlerService implements AbstractService<UserDetailsChandler, Integer> {
private final UserDetailsChandlerDao userDetailsChandlerDao;

    public UserDetailsChandlerService(UserDetailsChandlerDao userDetailsChandlerDao) {
        this.userDetailsChandlerDao = userDetailsChandlerDao;
    }

    public List<UserDetailsChandler> findAll() {
        return userDetailsChandlerDao.findAll();
    }

    public UserDetailsChandler findById(Integer id) {
        return userDetailsChandlerDao.getOne(id);
    }

    public UserDetailsChandler persist(UserDetailsChandler vessel) {
        return userDetailsChandlerDao.save(vessel);
    }

    public boolean delete(Integer id) {
        userDetailsChandlerDao.deleteById(id);
        return false;
    }

    public List<UserDetailsChandler> search(UserDetailsChandler vessel) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<UserDetailsChandler> vesselExample = Example.of(vessel, matcher);
        return userDetailsChandlerDao.findAll(vesselExample);
    }

    public UserDetailsChandler lastVessel(){
        return userDetailsChandlerDao.findFirstByOrderByIdDesc();
    }

    public UserDetailsChandler findByUserDetails(UserDetails userDetails) {
    return userDetailsChandlerDao.findByUserDetails(userDetails);
    }
}
