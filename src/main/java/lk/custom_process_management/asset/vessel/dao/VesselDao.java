package lk.custom_process_management.asset.vessel.dao;


import lk.custom_process_management.asset.vessel.entity.Vessel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselDao extends JpaRepository< Vessel, Integer> {
    Vessel findFirstByOrderByIdDesc();
}
