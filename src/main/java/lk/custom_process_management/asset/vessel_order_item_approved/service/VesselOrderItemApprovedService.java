package lk.custom_process_management.asset.vessel_order_item_approved.service;
import lk.custom_process_management.asset.vessel_order_item_approved.dao.VesselOrderItemApprovedDao;
import lk.custom_process_management.asset.vessel_order_item_approved.entity.VesselOrderItemApproved;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VesselOrderItemApprovedService {
  private final VesselOrderItemApprovedDao vesselOrderItemApprovedDao;

  public VesselOrderItemApprovedService(VesselOrderItemApprovedDao vesselOrderItemApprovedDao) {
    this.vesselOrderItemApprovedDao = vesselOrderItemApprovedDao;
  }

  public List< VesselOrderItemApproved > findAll() {
    return vesselOrderItemApprovedDao.findAll();
  }

  public VesselOrderItemApproved findById(Integer id) {
    return vesselOrderItemApprovedDao.getOne(id);
  }

  public VesselOrderItemApproved persist(VesselOrderItemApproved vesselOrderItemApproved) {
    return vesselOrderItemApprovedDao.save(vesselOrderItemApproved);
  }

  public boolean delete(Integer id) {
    vesselOrderItemApprovedDao.deleteById(id);
    return true;
  }

  public List< VesselOrderItemApproved > search(VesselOrderItemApproved vesselOrderItemApproved) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VesselOrderItemApproved > vesselOrderItemApprovedExample = Example.of(vesselOrderItemApproved, matcher);
    return vesselOrderItemApprovedDao.findAll(vesselOrderItemApprovedExample);
  }
}
