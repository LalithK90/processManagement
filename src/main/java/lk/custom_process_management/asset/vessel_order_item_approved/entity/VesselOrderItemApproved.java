package lk.custom_process_management.asset.vessel_order_item_approved.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order_item_approved.entity.enums.PaymentStatus;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VesselOrderItemApproved" )

public class VesselOrderItemApproved extends AuditEntity {

  @NotEmpty
  @Column( nullable = false )
  private String itemCount;

  @Column( nullable = false, precision = 10, scale = 2 )
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;

  @ManyToOne
  private VesselOrder vesselOrder;

  @ManyToOne
  private Chandler chandler;

  @ManyToOne
  private ShipAgent shipAgent;

  @OneToMany(mappedBy = "vesselOrderItemApproved")
  private List< Payment > payments;
}
