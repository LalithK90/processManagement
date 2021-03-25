package lk.custom_process_management.asset.vessel_order_item_bid_payment.dao;

import lk.custom_process_management.asset.vessel_order_item_bid_payment.entity.VesselOrderItemBidPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselOrderItemBidPaymentDao extends JpaRepository< VesselOrderItemBidPayment, Integer > {
}
