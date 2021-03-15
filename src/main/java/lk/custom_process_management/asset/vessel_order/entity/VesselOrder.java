package lk.custom_process_management.asset.vessel_order.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.vessel_arrival_history.entity.VesselArrivalHistory;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
import lk.custom_process_management.asset.warehouse_block.entity.WarehouseBlock;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VesselOrder" )
public class VesselOrder extends AuditEntity {

  @Column( unique = true, nullable = false )
  private String number;

  @DateTimeFormat( pattern = "yyyy-MM-dd" )
  @Column( nullable = false )
  private LocalDate closingDate;

  @Enumerated( EnumType.STRING )
  private VesselOrderStatus vesselOrderStatus;

  @ManyToOne
  private VesselArrivalHistory vesselArrivalHistory;

  @ManyToOne
  private WarehouseBlock warehouseBlock;

  @OneToMany( mappedBy = "vesselOrder", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true )
  private List< VesselOrderItem > vesselOrderItems;

}
