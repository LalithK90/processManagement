package lk.custom_process_management.asset.vezzal_order_item_bid.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.vezzal_order_item.entity.VezzalOrderItem;
import lk.custom_process_management.asset.vezzal_order_item_bid.entity.enums.BidValidOrNot;
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
public class VezzalOrderItemBid extends AuditEntity {

  @Column( nullable = false, precision = 10, scale = 2 )
  private BigDecimal amount;

  @Column( nullable = false, precision = 10, scale = 2 )
  private BigDecimal unitPrice;

  @Enumerated( EnumType.STRING )
  private BidValidOrNot bidValidOrNot;

  @ManyToOne
  private VezzalOrderItem vezzalOrderItem;

  @ManyToOne
  private Chandler chandler;


}
