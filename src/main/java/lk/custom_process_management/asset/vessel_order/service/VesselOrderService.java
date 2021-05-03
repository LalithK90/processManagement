package lk.custom_process_management.asset.vessel_order.service;

import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel_arrival_history.entity.VesselArrivalHistory;
import lk.custom_process_management.asset.vessel_order.dao.VesselOrderDao;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Service
public class VesselOrderService implements AbstractService< VesselOrder, Integer > {
  private final VesselOrderDao vesselOrderDao;

  public VesselOrderService(VesselOrderDao vesselOrderDao) {
    this.vesselOrderDao = vesselOrderDao;
  }

  public List< VesselOrder > findAll() {
    return vesselOrderDao.findAll();
  }

  public VesselOrder findById(Integer id) {
    return vesselOrderDao.getOne(id);
  }

  public VesselOrder persist(VesselOrder vesselOrder) {
    return vesselOrderDao.save(vesselOrder);
  }

  //delete is not applicable on this module
  public boolean delete(Integer id) {
    return false;
  }

  public List< VesselOrder > search(VesselOrder vesselOrder) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VesselOrder > vesselOrderExample = Example.of(vesselOrder, matcher);
    return vesselOrderDao.findAll(vesselOrderExample);
  }

  public VesselOrder findLastVesselOrder() {
    return vesselOrderDao.findFirstByOrderByIdDesc();
  }

  public List< VesselOrder > findByVesselOrderStatus(VesselOrderStatus vesselOrderStatus) {
    return vesselOrderDao.findByVesselOrderStatus(vesselOrderStatus);
  }

  public List< VesselOrder > findByVesselOrderStatusAndClosingDateBefore(VesselOrderStatus vesselOrderStatus,
                                                                         LocalDate date) {
    return vesselOrderDao.findByVesselOrderStatusAndClosingDateBefore(vesselOrderStatus, date);
  }

  public void saveAll(List< VesselOrder > vesselOrders) {
    vesselOrderDao.saveAll(vesselOrders);
  }

  public List< VesselOrder > findByVesselArrivalHistory(VesselArrivalHistory vesselArrivalHistory) {

  return vesselOrderDao.findByVesselArrivalHistory(vesselArrivalHistory);
  }

  public List< VesselOrder> findByCreatedAtIsBetween(LocalDateTime startAt, LocalDateTime endAt) {
  return vesselOrderDao.findByCreatedAtIsBetween(startAt,endAt);
  }
}
