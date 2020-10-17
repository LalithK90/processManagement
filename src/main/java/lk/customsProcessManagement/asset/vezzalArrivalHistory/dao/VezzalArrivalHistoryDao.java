package lk.customsProcessManagement.asset.vezzalArrivalHistory.dao;

import lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.Enum.VezzalDepartureArrivalStatus;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.VezzalArrivalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VezzalArrivalHistoryDao extends JpaRepository< VezzalArrivalHistory, Integer > {
  List< VezzalArrivalHistory> findByVezzalDepartureArrivalStatus(VezzalDepartureArrivalStatus vezzalDepartureArrivalStatus);
}
