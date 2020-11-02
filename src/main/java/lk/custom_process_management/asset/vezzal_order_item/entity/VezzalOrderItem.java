package lk.custom_process_management.asset.vezzal_order_item.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.vezzal_order.entity.VezzalOrder;
import lk.custom_process_management.asset.vezzal_order_item.entity.Enum.VezzalOrderItemStatus;
import lk.custom_process_management.asset.vezzal_order_item_bit.entity.VezzalOrderItemBit;
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
@JsonFilter( "VezzalOrderItem" )
public class VezzalOrderItem extends AuditEntity {

  @Column( nullable = false )
  private String quantity;

  @Enumerated( EnumType.STRING )
  private VezzalOrderItemStatus vezzalOrderItemStatus;

  @ManyToOne
  private Item item;

  @ManyToOne
  private VezzalOrder vezzalOrder;

  @OneToMany( mappedBy = "vezzalOrderItem" )
  private List< VezzalOrderItemBit > vezzalOrderItemBit;
}
