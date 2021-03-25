package lk.custom_process_management.asset.vessel_order_item.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order_item.entity.enums.VesselOrderItemStatus;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VesselOrderItem" )
public class VesselOrderItem extends AuditEntity {

  @Column( nullable = false )
  private String quantity;

  @Enumerated( EnumType.STRING )
  private VesselOrderItemStatus vesselOrderItemStatus;

  @ManyToOne
  private Item item;

  @ManyToOne
  private VesselOrder vesselOrder;

  @OneToMany( mappedBy = "vesselOrderItem" )
  private List< VesselOrderItemBid > vesselOrderItemBid;
}
