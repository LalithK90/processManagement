package lk.custom_process_management.asset.vezzal_order.dao;

import lk.custom_process_management.asset.vezzal_order.entity.VezzalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VezzalOrderDao extends JpaRepository< VezzalOrder, Integer > {
VezzalOrder findFirstByOrderByIdDesc();
}
