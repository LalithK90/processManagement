package lk.custom_process_management.asset.vessel_order_item_bid_payment.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
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
@JsonFilter( "VesselOrderItemBidPayment" )
public class VesselOrderItemBidPayment extends AuditEntity {

  @ManyToOne
  private Payment payment;

  @ManyToOne
  private VesselOrderItemBid vesselOrderItemBid;
}
