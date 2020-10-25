package lk.custom_process_management.asset.userDetails.service;


import lk.custom_process_management.asset.commonAsset.model.FileInfo;
import lk.custom_process_management.asset.userDetails.controller.EmployeeController;
import lk.custom_process_management.asset.userDetails.dao.EmployeeFilesDao;
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
public class EmployeeFilesService {
    private final EmployeeFilesDao employeeFilesDao;

    @Autowired
    public EmployeeFilesService(EmployeeFilesDao employeeFilesDao) {
        this.employeeFilesDao = employeeFilesDao;
    }

    public UserDetailsFiles findByName(String filename) {
        return employeeFilesDao.findByName(filename);
    }

    public void persist(UserDetailsFiles storedFile) {
        employeeFilesDao.save(storedFile);
    }


    public List< UserDetailsFiles > search(UserDetailsFiles userDetailsFiles) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< UserDetailsFiles > employeeFilesExample = Example.of(userDetailsFiles, matcher);
        return employeeFilesDao.findAll(employeeFilesExample);
    }

    public UserDetailsFiles findById(Integer id) {
        return employeeFilesDao.getOne(id);
    }

    public UserDetailsFiles findByNewID(String filename) {
        return employeeFilesDao.findByNewId(filename);
    }

    @Cacheable
    public List< FileInfo > employeeFileDownloadLinks(UserDetails userDetails) {
        return employeeFilesDao.findByEmployeeOrderByIdDesc(userDetails)
                .stream()
                .map(userDetailsFiles -> {
                    String filename = userDetailsFiles.getName();
                    String url = MvcUriComponentsBuilder
                            .fromMethodName(EmployeeController.class, "downloadFile", userDetailsFiles.getNewId())
                            .build()
                            .toString();
                    return new FileInfo(filename, userDetailsFiles.getCreatedAt(), url);
                })
                .collect(Collectors.toList());
    }
}
