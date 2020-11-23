package lk.custom_process_management.asset.vezzal_order_item.dao;

import lk.custom_process_management.asset.vezzal_order_item.entity.VezzalOrderItem;
import lk.custom_process_management.asset.vezzal_order_item_approved.entity.VezzalOrderItemApproved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VezzalOrderItemDao extends JpaRepository< VezzalOrderItem, Integer > {
}
