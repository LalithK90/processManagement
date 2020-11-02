package lk.custom_process_management.asset.chandler_license.service;

import lk.custom_process_management.asset.chandler_license.dao.ChandlerLicenseDao;
import lk.custom_process_management.asset.chandler_license.entity.ChandlerLicense;
import lk.custom_process_management.asset.chandler_license.entity.enums.LicenseStatus;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChandlerLicenseService implements AbstractService< ChandlerLicense, Integer > {
    private final ChandlerLicenseDao chandlerLicenseDao;

    public ChandlerLicenseService(ChandlerLicenseDao chandlerLicenseDao) {
        this.chandlerLicenseDao = chandlerLicenseDao;
    }

    public List< ChandlerLicense > findAll() {
        return chandlerLicenseDao.findAll();
    }

    public ChandlerLicense findById(Integer id) {
        return chandlerLicenseDao.getOne(id);
    }

    public ChandlerLicense persist(ChandlerLicense chandlerLicense) {
        return chandlerLicenseDao.save(chandlerLicense);
    }

    public boolean delete(Integer id) {
        return false;
    }

    public List< ChandlerLicense > search(ChandlerLicense chandlerLicense) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< ChandlerLicense > chandlerLicenseExample = Example.of(chandlerLicense, matcher);
        return chandlerLicenseDao.findAll(chandlerLicenseExample);
    }

    public List< ChandlerLicense> findByLicenseStatus(LicenseStatus licenseStatus) {
        return chandlerLicenseDao.findByLicenseStatus(licenseStatus);
    }

    public ChandlerLicense findLastChandlerLicense(){
        return chandlerLicenseDao.findFirstByOrderByIdDesc();
    }
}
