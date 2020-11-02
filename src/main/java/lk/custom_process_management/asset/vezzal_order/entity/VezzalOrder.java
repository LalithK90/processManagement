package lk.custom_process_management.asset.vezzal_order.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.VezzalArrivalHistory;
import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzal_order_item.entity.VezzalOrderItem;
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
@JsonFilter( "VezzalOrder" )
public class VezzalOrder extends AuditEntity {


  @Column(unique = true, nullable = false)
  private String number;


  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(nullable = false)
  private LocalDate closingDate;

  @Enumerated( EnumType.STRING )
  private VezzalOrderStatus vezzalOrderStatus;

  @ManyToOne
  private VezzalArrivalHistory vezzalArrivalHistory;

//  @ManyToOne
//  private ShipAgent shipAgent;

  @ManyToOne
  private WarehouseBlock warehouseBlock;

  @OneToMany(mappedBy = "vezzalOrder",cascade = CascadeType.MERGE)
  private List< VezzalOrderItem > vezzalOrderItems;

}
