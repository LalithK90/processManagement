package lk.customsProcessManagement.asset.vezzalOrderItemApproved.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customsProcessManagement.asset.chandler.entity.Chandler;
import lk.customsProcessManagement.asset.payment.entity.Payment;
import lk.customsProcessManagement.asset.shipAgent.entity.ShipAgent;
import lk.customsProcessManagement.asset.vezzalOrder.entity.VezzalOrder;
import lk.customsProcessManagement.asset.vezzalOrderItemApproved.entity.Enum.PaymentStatus;
import lk.customsProcessManagement.util.audit.AuditEntity;
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
@JsonFilter( "VezzalOrderItemApproved" )

public class VezzalOrderItemApproved extends AuditEntity {

  @NotEmpty
  @Column( nullable = false )
  private String itemCount;

  @Column( nullable = false, precision = 10, scale = 2 )
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;

  @ManyToOne
  private VezzalOrder vezzalOrder;

  @ManyToOne
  private Chandler chandler;

  @ManyToOne
  private ShipAgent shipAgent;

  @OneToMany(mappedBy = "vezzalOrderItemApproved")
  private List< Payment > payments;
}
