package lk.custom_process_management.asset.vessel_order_item_bid.dao;

import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VesselOrderItemBidDao extends JpaRepository< VesselOrderItemBid, Integer > {
  List< VesselOrderItemBid> findByVesselOrderItem(VesselOrderItem vesselOrderItem);

  List< VesselOrderItemBid> findByCreatedAtIsBetween(LocalDateTime startAt, LocalDateTime endAt);
}
