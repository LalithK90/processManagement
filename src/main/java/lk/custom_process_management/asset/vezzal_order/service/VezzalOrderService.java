package lk.custom_process_management.asset.vezzal_order.service;

import lk.custom_process_management.asset.vezzal_order.dao.VezzalOrderDao;
import lk.custom_process_management.asset.vezzal_order.entity.VezzalOrder;
import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VezzalOrderService implements AbstractService< VezzalOrder, Integer > {
  private final VezzalOrderDao vezzalOrderDao;

  public VezzalOrderService(VezzalOrderDao vezzalOrderDao) {
    this.vezzalOrderDao = vezzalOrderDao;
  }

  public List< VezzalOrder > findAll() {
    return vezzalOrderDao.findAll();
  }

  public VezzalOrder findById(Integer id) {
    return vezzalOrderDao.getOne(id);
  }

  public VezzalOrder persist(VezzalOrder vezzalOrder) {
    return vezzalOrderDao.save(vezzalOrder);
  }

  //delete is not applicable on this module
  public boolean delete(Integer id) {
    return false;
  }

  public List< VezzalOrder > search(VezzalOrder vezzalOrder) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VezzalOrder > vezzalOrderExample = Example.of(vezzalOrder, matcher);
    return vezzalOrderDao.findAll(vezzalOrderExample);
  }

  public VezzalOrder findLastVezzalOrder() {
    return vezzalOrderDao.findFirstByOrderByIdDesc();
  }

  public List< VezzalOrder > findByVezzalOrderStatus(VezzalOrderStatus vezzalOrderStatus) {
    return vezzalOrderDao.findByVezzalOrderStatus(vezzalOrderStatus);
  }

  public List< VezzalOrder > findByVezzalOrderStatusAndClosingDateBefore(VezzalOrderStatus vezzalOrderStatus,
                                                                         LocalDate date) {
    return vezzalOrderDao.findByVezzalOrderStatusAndClosingDateBefore(vezzalOrderStatus, date);
  }

  public void saveAll(List< VezzalOrder > vezzalOrders) {
    vezzalOrderDao.saveAll(vezzalOrders);
  }
}
