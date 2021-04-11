package lk.custom_process_management.asset.vessel_order_item_bid.service;

import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.vessel_order_item_bid.dao.VesselOrderItemBidDao;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VesselOrderItemBidService {
  private final VesselOrderItemBidDao vesselOrderItemBidDao;

  public VesselOrderItemBidService(VesselOrderItemBidDao vesselOrderItemBidDao) {
    this.vesselOrderItemBidDao = vesselOrderItemBidDao;
  }

  public List< VesselOrderItemBid > findAll() {
    return vesselOrderItemBidDao.findAll();
  }

  public VesselOrderItemBid findById(Integer id) {
    return vesselOrderItemBidDao.getOne(id);
  }

  public VesselOrderItemBid persist(VesselOrderItemBid vesselOrderItemBid) {
    return vesselOrderItemBidDao.save(vesselOrderItemBid);
  }

  public boolean delete(Integer id) {
    vesselOrderItemBidDao.deleteById(id);
    return true;
  }

  public List< VesselOrderItemBid > search(VesselOrderItemBid vesselOrderItemBid) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VesselOrderItemBid > vesselOrderItemApprovedExample = Example.of(vesselOrderItemBid, matcher);
    return vesselOrderItemBidDao.findAll(vesselOrderItemApprovedExample);
  }

  public List< VesselOrderItemBid > saveAll(List< VesselOrderItemBid > vesselOrderItemBids) {
    return vesselOrderItemBidDao.saveAll(vesselOrderItemBids);
  }

  public List< VesselOrderItemBid > findByVesselOrderItem(VesselOrderItem vesselOrderItem) {
    return vesselOrderItemBidDao.findByVesselOrderItem(vesselOrderItem);
  }

  public List< VesselOrderItemBid> findByCreatedAtIsBetween(LocalDateTime startAt, LocalDateTime endAt) {
    return vesselOrderItemBidDao.findByCreatedAtIsBetween(startAt, endAt);
  }
}
