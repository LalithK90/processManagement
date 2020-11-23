package lk.custom_process_management.asset.payment.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.payment.entity.enums.PaymentMethod;
import lk.custom_process_management.asset.vezzal_order_item_approved.entity.VezzalOrderItemApproved;
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
@JsonFilter( "VezzalOrderItemApproved" )
public class Payment extends AuditEntity {

  @Column( nullable = false, precision = 10, scale = 2 )
  private BigDecimal amount;

  private String bankName;

  private String remarks;

  @Column(nullable = false, unique = true)
  private String code;

  @Enumerated( EnumType.STRING)
  private PaymentMethod paymentMethod;

  @ManyToOne
  private VezzalOrderItemApproved vezzalOrderItemApproved;
}
