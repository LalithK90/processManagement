package lk.custom_process_management.asset.vessel_order_item_bid_payment.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.payment.entity.enums.PaymentStatus;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VesselOrderItemBidPayment" )
public class VesselOrderItemBidPayment extends AuditEntity {

  @Enumerated( EnumType.STRING )
  private PaymentStatus paymentStatus;

  @ManyToOne
  private Payment payment;

  @ManyToOne
  private VesselOrderItemBid vesselOrderItemBid;
}
