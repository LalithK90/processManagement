package lk.custom_process_management.asset.vezzal_arrival_history.service;

import lk.custom_process_management.asset.vezzal_arrival_history.dao.VezzalArrivalHistoryDao;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.enums.VezzalDepartureArrivalStatus;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.VezzalArrivalHistory;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VezzalArrivalHistoryService implements AbstractService< VezzalArrivalHistory, Integer> {
private final VezzalArrivalHistoryDao vezzalArrivalHistoryDao;

  public VezzalArrivalHistoryService(VezzalArrivalHistoryDao vezzalArrivalHistoryDao) {
    this.vezzalArrivalHistoryDao = vezzalArrivalHistoryDao;
  }

  public List< VezzalArrivalHistory > findAll() {
    return vezzalArrivalHistoryDao.findAll();
  }

  public VezzalArrivalHistory findById(Integer id) {
    return vezzalArrivalHistoryDao.getOne(id);
  }

  public VezzalArrivalHistory persist(VezzalArrivalHistory vezzalArrivalHistory) {
    return vezzalArrivalHistoryDao.save(vezzalArrivalHistory);
  }

  public boolean delete(Integer id) {
    vezzalArrivalHistoryDao.deleteById(id);
    return true;
  }

  public List< VezzalArrivalHistory > search(VezzalArrivalHistory vezzalArrivalHistory) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< VezzalArrivalHistory > vezzalArrivalHistoryExample = Example.of(vezzalArrivalHistory, matcher);
return vezzalArrivalHistoryDao.findAll(vezzalArrivalHistoryExample);
  }

  public List< VezzalArrivalHistory> findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus vezzalDepartureArrivalStatus) {
  return vezzalArrivalHistoryDao.findByVezzalDepartureArrivalStatus(vezzalDepartureArrivalStatus);
  }
}
