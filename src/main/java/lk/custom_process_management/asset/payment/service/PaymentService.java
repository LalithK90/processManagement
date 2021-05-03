package lk.custom_process_management.asset.payment.service;


import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.payment.dao.PaymentDao;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService implements AbstractService< Payment, Integer > {

  private final PaymentDao paymentDao;

  @Autowired
  public PaymentService(PaymentDao paymentDao) {
    this.paymentDao = paymentDao;
  }


  public List< Payment > findAll() {
    return paymentDao.findAll().stream().filter(x -> x.getLiveDead().equals(LiveDead.ACTIVE)).collect(Collectors.toList());
  }


  public Payment findById(Integer id) {
    return paymentDao.getOne(id);
  }


  public Payment persist(Payment payment) {
    if ( payment.getId() == null ) {
      payment.setLiveDead(LiveDead.ACTIVE);
    }
    return paymentDao.save(payment);
  }


  public boolean delete(Integer id) {
    Payment payment = paymentDao.getOne(id);
    payment.setLiveDead(LiveDead.STOP);
    paymentDao.save(payment);
    return false;
  }


  public List< Payment > search(Payment payment) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< Payment > paymentExample = Example.of(payment, matcher);
    return paymentDao.findAll(paymentExample);
  }

  public Payment lastPayment() {
    return paymentDao.findFirstByOrderByIdDesc();
  }

  public List< Payment > findByCreatedAtIsBetween(LocalDateTime from, LocalDateTime to) {
    List< Payment > payments = paymentDao.findByCreatedAtIsBetween(from, to);
    return payments;
  }

  public List< Payment > findByStatusConformation(StatusConformation statusConformation) {
    return paymentDao.findByStatusConformation(statusConformation);
  }

  public List< Payment> findByVesselOrder(VesselOrder vesselOrder) {
  return paymentDao.findByVesselOrder(vesselOrder);
  }
}
