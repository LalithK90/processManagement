package lk.custom_process_management.asset.vezzal_order_item_bid.dao;

import lk.custom_process_management.asset.vezzal_order_item_bid.entity.VezzalOrderItemBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VezzalOrderItemBidDao extends JpaRepository< VezzalOrderItemBid, Integer > {
}
