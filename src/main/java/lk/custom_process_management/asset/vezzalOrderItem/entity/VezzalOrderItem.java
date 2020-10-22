package lk.custom_process_management.asset.vezzalOrderItem.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.vezzalOrder.entity.VezzalOrder;
import lk.custom_process_management.asset.vezzalOrderItem.entity.Enum.VezzalOrderItemStatus;
import lk.custom_process_management.asset.vezzalOrderItemBit.entity.VezzalOrderItemBit;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VezzalOrderItem" )
public class VezzalOrderItem extends AuditEntity {

  @NotEmpty
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
