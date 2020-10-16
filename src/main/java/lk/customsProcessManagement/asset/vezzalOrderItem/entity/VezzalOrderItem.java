package lk.customsProcessManagement.asset.vezzalOrderItem.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customsProcessManagement.asset.item.entity.Item;
import lk.customsProcessManagement.asset.vezzalOrder.entity.VezzalOrder;
import lk.customsProcessManagement.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VezzalOrderItem" )
public class VezzalOrderItem extends AuditEntity {

  @NotEmpty
  @Column(nullable = false)
  private String quantity;

  @ManyToOne
  private Item item;

  @ManyToOne
  private VezzalOrder vezzalOrder;
}
