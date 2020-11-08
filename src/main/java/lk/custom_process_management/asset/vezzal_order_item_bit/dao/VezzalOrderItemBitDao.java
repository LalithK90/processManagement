package lk.custom_process_management.asset.vezzal_order_item_bit.dao;

import lk.custom_process_management.asset.vezzal_order_item_bit.entity.VezzalOrderItemBit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VezzalOrderItemBitDao extends JpaRepository< VezzalOrderItemBit, Integer > {
}
