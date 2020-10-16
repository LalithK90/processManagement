package lk.customsProcessManagement.asset.vezzalOrderItemBit.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customsProcessManagement.asset.chandler.entity.Chandler;
import lk.customsProcessManagement.asset.vezzalOrderItem.entity.VezzalOrderItem;
import lk.customsProcessManagement.asset.vezzalOrderItemBit.entity.Enum.BitValidOrNot;
import lk.customsProcessManagement.util.audit.AuditEntity;
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
