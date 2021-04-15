package lk.custom_process_management.asset.vessel_arrival_history.service;

import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel.entity.Vessel;
import lk.custom_process_management.asset.vessel_arrival_history.dao.VesselArrivalHistoryDao;
import lk.custom_process_management.asset.vessel_arrival_history.entity.enums.VesselDepartureArrivalStatus;
import lk.custom_process_management.asset.vessel_arrival_history.entity.VesselArrivalHistory;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VesselArrivalHistoryService implements AbstractService< VesselArrivalHistory, Integer> {
private final VesselArrivalHistoryDao vesselArrivalHistoryDao;

  public VesselArrivalHistoryService(VesselArrivalHistoryDao vesselArrivalHistoryDao) {
    this.vesselArrivalHistoryDao = vesselArrivalHistoryDao;
  }

  public List< VesselArrivalHistory > findAll() {
    return vesselArrivalHistoryDao.findAll();
  }

  public VesselArrivalHistory findById(Integer id) {
    return vesselArrivalHistoryDao.getOne(id);
  }

  public VesselArrivalHistory persist(VesselArrivalHistory vesselArrivalHistory) {
    return vesselArrivalHistoryDao.save(vesselArrivalHistory);
  }

  public boolean delete(Integer id) {
    vesselArrivalHistoryDao.deleteById(id);
    return true;
  }

  public List< VesselArrivalHistory > search(VesselArrivalHistory vesselArrivalHistory) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VesselArrivalHistory > vesselArrivalHistoryExample = Example.of(vesselArrivalHistory, matcher);
return vesselArrivalHistoryDao.findAll(vesselArrivalHistoryExample);
  }

  public List< VesselArrivalHistory> findByVesselDepartureArrivalStatus(VesselDepartureArrivalStatus vesselDepartureArrivalStatus) {
  return vesselArrivalHistoryDao.findByVesselDepartureArrivalStatus(vesselDepartureArrivalStatus);
  }

  public VesselArrivalHistory lastVesselHistoryByVessel(Vessel vessel) {
  return vesselArrivalHistoryDao.findFirstByVesselOrderByIdDesc(vessel);
  }

  public List< VesselArrivalHistory> findByShipAgentAndCreatedAtIsBetween(ShipAgent shipAgent, LocalDateTime startAt, LocalDateTime endAt) {
    return vesselArrivalHistoryDao.findByShipAgentAndCreatedAtIsBetween(shipAgent,startAt,endAt);
  }

}
