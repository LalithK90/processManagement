package lk.custom_process_management.asset.vessel_order_item.service;

import lk.custom_process_management.asset.vessel_order_item.dao.VesselOrderItemDao;
import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VesselOrderItemService {
  private final VesselOrderItemDao vesselOrderItemDao;

  public VesselOrderItemService(VesselOrderItemDao vesselOrderItemDao) {
    this.vesselOrderItemDao = vesselOrderItemDao;
  }

  public List< VesselOrderItem > findAll() {
    return vesselOrderItemDao.findAll();
  }

  public VesselOrderItem findById(Integer id) {
    return vesselOrderItemDao.getOne(id);
  }

  public VesselOrderItem persist(VesselOrderItem vesselOrderItem) {
    return vesselOrderItemDao.save(vesselOrderItem);
  }

  public boolean delete(Integer id) {
    vesselOrderItemDao.deleteById(id);
    return true;
  }

  public List< VesselOrderItem > search(VesselOrderItem vesselOrderItem) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VesselOrderItem > vesselOrderItemExample = Example.of(vesselOrderItem, matcher);
    return vesselOrderItemDao.findAll(vesselOrderItemExample);
  }
}
