package lk.customsProcessManagement.asset.vezzalOrder.dao;

import lk.customsProcessManagement.asset.vezzalOrder.entity.VezzalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VezzalOrderDao extends JpaRepository< VezzalOrder, Integer > {
VezzalOrder findFirstByOrderByIdDesc();
}
