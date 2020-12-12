package lk.custom_process_management.asset.vezzal_order_item_bid.service;

import lk.custom_process_management.asset.vezzal_order_item_bid.dao.VezzalOrderItemBidDao;
import lk.custom_process_management.asset.vezzal_order_item_bid.entity.VezzalOrderItemBid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VezzalOrderItemBidService {
  private final VezzalOrderItemBidDao vezzalOrderItemBidDao;

  public VezzalOrderItemBidService(VezzalOrderItemBidDao vezzalOrderItemBidDao) {
    this.vezzalOrderItemBidDao = vezzalOrderItemBidDao;
  }

  public List< VezzalOrderItemBid > findAll() {
    return vezzalOrderItemBidDao.findAll();
  }

  public VezzalOrderItemBid findById(Integer id) {
    return vezzalOrderItemBidDao.getOne(id);
  }

  public VezzalOrderItemBid persist(VezzalOrderItemBid vezzalOrderItemBid) {
    return vezzalOrderItemBidDao.save(vezzalOrderItemBid);
  }

  public boolean delete(Integer id) {
    vezzalOrderItemBidDao.deleteById(id);
    return true;
  }

  public List< VezzalOrderItemBid > search(VezzalOrderItemBid vezzalOrderItemBid) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VezzalOrderItemBid > vezzalOrderItemApprovedExample = Example.of(vezzalOrderItemBid, matcher);
    return vezzalOrderItemBidDao.findAll(vezzalOrderItemApprovedExample);
  }

  public void saveAll(List< VezzalOrderItemBid > vezzalOrderItemBids) {
    vezzalOrderItemBidDao.saveAll(vezzalOrderItemBids);
  }
}
