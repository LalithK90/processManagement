package lk.custom_process_management.asset.vezzal_order.dao;

import lk.custom_process_management.asset.vezzal_order.entity.VezzalOrder;
import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VezzalOrderDao extends JpaRepository< VezzalOrder, Integer > {
  VezzalOrder findFirstByOrderByIdDesc();

  List< VezzalOrder > findByVezzalOrderStatus(VezzalOrderStatus vezzalOrderStatus);

  List< VezzalOrder > findByVezzalOrderStatusAndClosingDateBefore(VezzalOrderStatus vezzalOrderStatus,
                                                                  LocalDate closingDate);
}
