package lk.custom_process_management.asset.vezzal_order_item_approved.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
  NPAID("Not Paid"),
  PPAID("Patialy Paid"),
  CPAID("Payment Completed");
  private final String paymentStatus;
}
