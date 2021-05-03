package lk.custom_process_management.asset.payment.dao;


import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.StatusConformation;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentDao extends JpaRepository< Payment, Integer> {
  Payment findFirstByOrderByIdDesc();

  List< Payment> findByCreatedAtIsBetween(LocalDateTime from, LocalDateTime to);

  List< Payment> findByStatusConformation(StatusConformation statusConformation);

  List< Payment> findByVesselOrder(VesselOrder vesselOrder);
}
