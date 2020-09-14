package lk.customsProcessManagement.asset.chandlerLicense.service;

import lk.customsProcessManagement.asset.chandlerLicense.dao.ChandlerLicenseDao;
import lk.customsProcessManagement.asset.chandlerLicense.entity.ChandlerLicense;
import lk.customsProcessManagement.asset.chandlerLicense.entity.Enum.LicenseStatus;
import lk.customsProcessManagement.util.interfaces.AbstractService;
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
}
