package lk.custom_process_management.asset.userDetails.service;


import lk.custom_process_management.asset.commonAsset.model.FileInfo;
import lk.custom_process_management.asset.userDetails.controller.UserDetailsController;
import lk.custom_process_management.asset.userDetails.dao.UserDetailsFilesDao;
import lk.custom_process_management.asset.userDetails.entity.UserDetails;
import lk.custom_process_management.asset.userDetails.entity.UserDetailsFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

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

    @Cacheable
    public List< FileInfo > employeeFileDownloadLinks(UserDetails userDetails) {
        return userDetailsFilesDao.findByUserDetails(userDetails)
                .stream()
                .map(userDetailsFiles -> {
                    String filename = userDetailsFiles.getName();
                    String url = MvcUriComponentsBuilder
                            .fromMethodName(UserDetailsController.class, "downloadFile", userDetailsFiles.getNewId())
                            .build()
                            .toString();
                    return new FileInfo(filename, userDetailsFiles.getCreatedAt(), url);
                })
                .collect(Collectors.toList());
    }
}
