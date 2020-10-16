package lk.customsProcessManagement.asset.vezzalOrder.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customsProcessManagement.asset.shipAgent.entity.ShipAgent;
import lk.customsProcessManagement.asset.vezzal.entity.Vezzal;
import lk.customsProcessManagement.asset.vezzalOrder.entity.Enum.VezzalOrderStatus;
import lk.customsProcessManagement.asset.vezzalOrderItem.entity.VezzalOrderItem;
import lk.customsProcessManagement.asset.warehouseBlock.entity.WarehouseBlock;
import lk.customsProcessManagement.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VezzalOrder" )
public class VezzalOrder extends AuditEntity {

  @NotEmpty
  @Column(unique = true, nullable = false)
  private String number;

  @NotEmpty
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(nullable = false)
  private LocalDate closingDate;

  @Enumerated( EnumType.STRING )
  private VezzalOrderStatus vezzalOrderStatus;

  @ManyToOne
  private Vezzal vezzal;

  @ManyToOne
  private ShipAgent shipAgent;

  @ManyToOne
  private WarehouseBlock warehouseBlock;

  @OneToMany(mappedBy = "vezzalOrder")
  private List< VezzalOrderItem > vezzalOrderItems;

}
