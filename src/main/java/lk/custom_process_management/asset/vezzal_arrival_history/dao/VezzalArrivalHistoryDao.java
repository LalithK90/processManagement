package lk.custom_process_management.asset.vezzal_arrival_history.dao;

import lk.custom_process_management.asset.vezzal.entity.Vezzal;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.VezzalArrivalHistory;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.enums.VezzalDepartureArrivalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VezzalArrivalHistoryDao extends JpaRepository< VezzalArrivalHistory, Integer > {
  List< VezzalArrivalHistory > findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus vezzalDepartureArrivalStatus);

  VezzalArrivalHistory findFirstByVezzalOrderByIdDesc(Vezzal vezzal);
}
