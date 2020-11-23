package lk.custom_process_management.asset.vezzal_order_item_approved.service;
import lk.custom_process_management.asset.vezzal_order_item_approved.dao.VezzalOrderItemApprovedDao;
import lk.custom_process_management.asset.vezzal_order_item_approved.entity.VezzalOrderItemApproved;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VezzalOrderItemApprovedService {
  private final VezzalOrderItemApprovedDao vezzalOrderItemApprovedDao;

  public VezzalOrderItemApprovedService(VezzalOrderItemApprovedDao vezzalOrderItemApprovedDao) {
    this.vezzalOrderItemApprovedDao = vezzalOrderItemApprovedDao;
  }

  public List< VezzalOrderItemApproved > findAll() {
    return vezzalOrderItemApprovedDao.findAll();
  }

  public VezzalOrderItemApproved findById(Integer id) {
    return vezzalOrderItemApprovedDao.getOne(id);
  }

  public VezzalOrderItemApproved persist(VezzalOrderItemApproved vezzalOrderItemApproved) {
    return vezzalOrderItemApprovedDao.save(vezzalOrderItemApproved);
  }

  public boolean delete(Integer id) {
    vezzalOrderItemApprovedDao.deleteById(id);
    return true;
  }

  public List< VezzalOrderItemApproved > search(VezzalOrderItemApproved vezzalOrderItemApproved) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VezzalOrderItemApproved > vezzalOrderItemApprovedExample = Example.of(vezzalOrderItemApproved, matcher);
    return vezzalOrderItemApprovedDao.findAll(vezzalOrderItemApprovedExample);
  }
}
