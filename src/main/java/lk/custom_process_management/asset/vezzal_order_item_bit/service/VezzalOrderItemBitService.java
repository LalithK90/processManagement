package lk.custom_process_management.asset.vezzal_order_item_bit.service;

import lk.custom_process_management.asset.vezzal_order_item_bit.dao.VezzalOrderItemBitDao;
import lk.custom_process_management.asset.vezzal_order_item_bit.entity.VezzalOrderItemBit;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VezzalOrderItemBitService {
  private final VezzalOrderItemBitDao vezzalOrderItemBitDao;

  public VezzalOrderItemBitService(VezzalOrderItemBitDao vezzalOrderItemBitDao) {
    this.vezzalOrderItemBitDao = vezzalOrderItemBitDao;
  }

  public List< VezzalOrderItemBit > findAll() {
    return vezzalOrderItemBitDao.findAll();
  }

  public VezzalOrderItemBit findById(Integer id) {
    return vezzalOrderItemBitDao.getOne(id);
  }

  public VezzalOrderItemBit persist(VezzalOrderItemBit vezzalOrderItemBit) {
    return vezzalOrderItemBitDao.save(vezzalOrderItemBit);
  }

  public boolean delete(Integer id) {
    vezzalOrderItemBitDao.deleteById(id);
    return true;
  }

  public List< VezzalOrderItemBit > search(VezzalOrderItemBit vezzalOrderItemBit) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VezzalOrderItemBit > vezzalOrderItemApprovedExample = Example.of(vezzalOrderItemBit, matcher);
    return vezzalOrderItemBitDao.findAll(vezzalOrderItemApprovedExample);
  }

  public void saveAll(List< VezzalOrderItemBit > vezzalOrderItemBits) {
    vezzalOrderItemBitDao.saveAll(vezzalOrderItemBits);
  }
}
