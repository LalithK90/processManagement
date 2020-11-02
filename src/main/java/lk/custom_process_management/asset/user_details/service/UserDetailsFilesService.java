package lk.custom_process_management.asset.user_details.service;


import lk.custom_process_management.asset.common_asset.model.FileInfo;
import lk.custom_process_management.asset.user_details.controller.UserDetailsController;
import lk.custom_process_management.asset.user_details.dao.UserDetailsFilesDao;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details.entity.UserDetailsFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;

@Service
@CacheConfig( cacheNames = "employeeFiles" )
public class UserDetailsFilesService {
  private final UserDetailsFilesDao userDetailsFilesDao;

  @Autowired
  public UserDetailsFilesService(UserDetailsFilesDao userDetailsFilesDao) {
    this.userDetailsFilesDao = userDetailsFilesDao;
  }

  public UserDetailsFiles findByName(String filename) {
    return userDetailsFilesDao.findByName(filename);
  }

  public void persist(UserDetailsFiles storedFile) {
    userDetailsFilesDao.save(storedFile);
  }


  public List< UserDetailsFiles > search(UserDetailsFiles userDetailsFiles) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< UserDetailsFiles > employeeFilesExample = Example.of(userDetailsFiles, matcher);
    return userDetailsFilesDao.findAll(employeeFilesExample);
  }

  public UserDetailsFiles findById(Integer id) {
    return userDetailsFilesDao.getOne(id);
  }

  public UserDetailsFiles findByNewID(String filename) {
    return userDetailsFilesDao.findByNewId(filename);
  }

  public UserDetailsFiles findByUserDetails(UserDetails userDetails){
    return userDetailsFilesDao.findByUserDetails(userDetails);
  }
  @Cacheable
  public FileInfo userDetailsFileDownloadLinks(UserDetails userDetails) {
    UserDetailsFiles userDetailsFiles = userDetailsFilesDao.findByUserDetails(userDetails);
      if (userDetailsFiles != null) {
          String filename = userDetailsFiles.getName();
          String url = MvcUriComponentsBuilder
              .fromMethodName(UserDetailsController.class, "downloadFile", userDetailsFiles.getNewId())
              .build()
              .toString();
          return new FileInfo(filename, userDetailsFiles.getCreatedAt(), url);
      }
      return null;
  }
}
