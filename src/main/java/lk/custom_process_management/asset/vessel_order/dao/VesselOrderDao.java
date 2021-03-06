package lk.custom_process_management.asset.vessel_order.dao;

import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel_arrival_history.entity.VesselArrivalHistory;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VesselOrderDao extends JpaRepository< VesselOrder, Integer > {
  VesselOrder findFirstByOrderByIdDesc();

  List< VesselOrder > findByVesselOrderStatus(VesselOrderStatus vesselOrderStatus);

  List< VesselOrder > findByVesselOrderStatusAndClosingDateBefore(VesselOrderStatus vesselOrderStatus,
                                                                  LocalDate closingDate);

  List< VesselOrder> findByVesselArrivalHistory(VesselArrivalHistory vesselArrivalHistory);

  List< VesselOrder> findByCreatedAtIsBetween(LocalDateTime startAt, LocalDateTime endAt);
}
