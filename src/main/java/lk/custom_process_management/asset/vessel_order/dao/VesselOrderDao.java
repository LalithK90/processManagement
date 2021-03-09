package lk.custom_process_management.asset.vessel_order.dao;

import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VesselOrderDao extends JpaRepository< VesselOrder, Integer > {
  VesselOrder findFirstByOrderByIdDesc();

  List< VesselOrder > findByVesselOrderStatus(VesselOrderStatus vesselOrderStatus);

  List< VesselOrder > findByVesselOrderStatusAndClosingDateBefore(VesselOrderStatus vesselOrderStatus,
                                                                  LocalDate closingDate);
}
