package lk.customsProcessManagement.asset.vezzalOrder.service;

import lk.customsProcessManagement.asset.vezzalOrder.dao.VezzalOrderDao;
import lk.customsProcessManagement.asset.vezzalOrder.entity.VezzalOrder;
import lk.customsProcessManagement.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

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

  public VezzalOrder findLastVezzalOrder(){
    return vezzalOrderDao.findFirstByOrderByIdDesc();
  }
}
