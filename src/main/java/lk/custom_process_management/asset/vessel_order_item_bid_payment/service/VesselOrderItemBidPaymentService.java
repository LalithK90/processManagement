package lk.custom_process_management.asset.vessel_order_item_bid_payment.service;

import lk.custom_process_management.asset.vessel_order_item_bid_payment.dao.VesselOrderItemBidPaymentDao;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VesselOrderItemBidPaymentService {
  private final VesselOrderItemBidPaymentDao vesselOrderItemBidPaymentDao;

  public VesselOrderItemBidPaymentService(VesselOrderItemBidPaymentDao vesselOrderItemBidPaymentDao) {
    this.vesselOrderItemBidPaymentDao = vesselOrderItemBidPaymentDao;
  }

  public List< VesselOrderItemBidPayment > findAll() {
    return vesselOrderItemBidPaymentDao.findAll();
  }

  public VesselOrderItemBidPayment findById(Integer id) {
    return vesselOrderItemBidPaymentDao.getOne(id);
  }

  public VesselOrderItemBidPayment persist(VesselOrderItemBidPayment vesselOrderItemBidPayment) {
    return vesselOrderItemBidPaymentDao.save(vesselOrderItemBidPayment);
  }

  public boolean delete(Integer id) {
    vesselOrderItemBidPaymentDao.deleteById(id);
    return true;
  }

  public List< VesselOrderItemBidPayment > search(VesselOrderItemBidPayment vesselOrderItemBidPayment) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VesselOrderItemBidPayment > vesselOrderItemExample = Example.of(vesselOrderItemBidPayment, matcher);
    return vesselOrderItemBidPaymentDao.findAll(vesselOrderItemExample);
  }

  public List< VesselOrderItemBidPayment> findByCreatedAtIsBetween(LocalDateTime startAt, LocalDateTime endAt) {
  return  vesselOrderItemBidPaymentDao.findByCreatedAtIsBetween(startAt, endAt);
  }
}
