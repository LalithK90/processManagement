package lk.custom_process_management.asset.vezzal_arrival_history.dao;

import lk.custom_process_management.asset.vezzal_arrival_history.entity.Enum.VezzalDepartureArrivalStatus;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.VezzalArrivalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VezzalArrivalHistoryDao extends JpaRepository< VezzalArrivalHistory, Integer > {
  List< VezzalArrivalHistory> findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus vezzalDepartureArrivalStatus);
}
