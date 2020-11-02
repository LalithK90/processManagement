package lk.custom_process_management.asset.vezzal_order_item_bit.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.vezzal_order_item.entity.VezzalOrderItem;
import lk.custom_process_management.asset.vezzal_order_item_bit.entity.Enum.BitValidOrNot;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VezzalOrderItemBit" )

public class VezzalOrderItemBit extends AuditEntity {

  @Column( nullable = false, precision = 10, scale = 2 )
  private BigDecimal amount;

  @Enumerated( EnumType.STRING )
  private BitValidOrNot bitValidOrNot;

  @ManyToOne
  private VezzalOrderItem vezzalOrderItem;

  @ManyToOne
  private Chandler chandler;

}
