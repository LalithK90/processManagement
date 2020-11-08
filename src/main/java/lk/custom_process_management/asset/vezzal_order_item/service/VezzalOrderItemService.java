package lk.custom_process_management.asset.vezzal_order_item.service;

import lk.custom_process_management.asset.vezzal_order_item.dao.VezzalOrderItemDao;
import lk.custom_process_management.asset.vezzal_order_item.entity.VezzalOrderItem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VezzalOrderItemService {
  private final VezzalOrderItemDao vezzalOrderItemDao;

  public VezzalOrderItemService(VezzalOrderItemDao vezzalOrderItemDao) {
    this.vezzalOrderItemDao = vezzalOrderItemDao;
  }

  public List< VezzalOrderItem > findAll() {
    return vezzalOrderItemDao.findAll();
  }

  public VezzalOrderItem findById(Integer id) {
    return vezzalOrderItemDao.getOne(id);
  }

  public VezzalOrderItem persist(VezzalOrderItem vezzalOrderItem) {
    return vezzalOrderItemDao.save(vezzalOrderItem);
  }

  public boolean delete(Integer id) {
    vezzalOrderItemDao.deleteById(id);
    return true;
  }

  public List< VezzalOrderItem > search(VezzalOrderItem vezzalOrderItem) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VezzalOrderItem > vezzalOrderItemExample = Example.of(vezzalOrderItem, matcher);
    return vezzalOrderItemDao.findAll(vezzalOrderItemExample);
  }
}
