package lk.custom_process_management.asset.chandler_license.dao;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.chandler_license.entity.ChandlerLicense;
import lk.custom_process_management.asset.chandler_license.entity.enums.LicenseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChandlerLicenseDao extends JpaRepository< ChandlerLicense, Integer > {
  List< ChandlerLicense > findByLicenseStatus(LicenseStatus licenseStatus);

  ChandlerLicense findFirstByOrderByIdDesc();

  List< ChandlerLicense > findByChandler(Chandler chandler);
}
