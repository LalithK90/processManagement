package lk.customsProcessManagement.asset.vezzalOrderItem.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customsProcessManagement.asset.item.entity.Item;
import lk.customsProcessManagement.asset.vezzalOrder.entity.VezzalOrder;
import lk.customsProcessManagement.asset.vezzalOrderItem.entity.Enum.VezzalOrderItemStatus;
import lk.customsProcessManagement.asset.vezzalOrderItemBit.entity.VezzalOrderItemBit;
import lk.customsProcessManagement.util.audit.AuditEntity;
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
