package lk.custom_process_management.asset.vessel_order_item.dao;

import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.vessel_order_item_approved.entity.VesselOrderItemApproved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselOrderItemDao extends JpaRepository< VesselOrderItem, Integer > {
}
