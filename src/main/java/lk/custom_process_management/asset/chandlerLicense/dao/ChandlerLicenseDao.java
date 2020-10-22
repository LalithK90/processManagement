package lk.custom_process_management.asset.chandlerLicense.dao;

import lk.custom_process_management.asset.chandlerLicense.entity.ChandlerLicense;
import lk.custom_process_management.asset.chandlerLicense.entity.Enum.LicenseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChandlerLicenseDao extends JpaRepository< ChandlerLicense, Integer > {
    List< ChandlerLicense> findByLicenseStatus(LicenseStatus licenseStatus);

    ChandlerLicense findFirstByOrderByIdDesc();
}
