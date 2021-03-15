package lk.custom_process_management.asset.warehouse_block.entity;


import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.warehouse_block.entity.enums.WarehouseBlockStatus;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseBlock extends AuditEntity {

  @Size( min = 5, message = "Your name cannot be accepted" )
  private String name;

  private String area;

  @Enumerated( EnumType.STRING )
  private WarehouseBlockStatus warehouseBlockStatus;

  @OneToMany( mappedBy = "warehouseBlock" )
  private List< VesselOrder > vesselOrders;

}

