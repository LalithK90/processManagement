package lk.custom_process_management.asset.vessel_arrival_history.dao;

import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel.entity.Vessel;
import lk.custom_process_management.asset.vessel_arrival_history.entity.VesselArrivalHistory;
import lk.custom_process_management.asset.vessel_arrival_history.entity.enums.VesselDepartureArrivalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VesselArrivalHistoryDao extends JpaRepository< VesselArrivalHistory, Integer > {
  List< VesselArrivalHistory > findByVesselDepartureArrivalStatus(VesselDepartureArrivalStatus vesselDepartureArrivalStatus);

  VesselArrivalHistory findFirstByVesselOrderByIdDesc(Vessel vessel);

  List< VesselArrivalHistory> findByShipAgent(ShipAgent shipAgent);

  List< VesselArrivalHistory> findByShipAgentAndCreatedAtIsBetween(ShipAgent shipAgent, LocalDateTime startAt, LocalDateTime endAt);

  List< VesselArrivalHistory> findByVesselAndCreatedAtIsBetween(Vessel vessel, LocalDateTime startAt, LocalDateTime endAt);
}
