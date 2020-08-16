package lk.customs.processManagement.asset.chandlerLicense.dao;

import lk.customs.processManagement.asset.chandlerLicense.entity.ChandlerLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChandlerLicenseDao extends JpaRepository< ChandlerLicense, Integer > {
}
