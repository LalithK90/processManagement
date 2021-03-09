package lk.custom_process_management.asset.vessel_order_item_approved.dao;

import lk.custom_process_management.asset.vessel_order_item_approved.entity.VesselOrderItemApproved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselOrderItemApprovedDao extends JpaRepository< VesselOrderItemApproved, Integer > {
}
