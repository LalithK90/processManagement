package lk.custom_process_management.asset.vezzalOrder.dao;

import lk.custom_process_management.asset.vezzalOrder.entity.VezzalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VezzalOrderDao extends JpaRepository< VezzalOrder, Integer > {
VezzalOrder findFirstByOrderByIdDesc();
}
