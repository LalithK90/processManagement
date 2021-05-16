package lk.custom_process_management.asset.vessel_order_item_bid_payment.dao;

import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VesselOrderItemBidPaymentDao extends JpaRepository< VesselOrderItemBidPayment, Integer > {
  List< VesselOrderItemBidPayment> findByCreatedAtIsBetween(LocalDateTime startAt, LocalDateTime endAt);

    List<VesselOrderItemBidPayment> findByPayment(Payment paymentDb);
}
