package lk.customsProcessManagement.asset.vezzalOrderItemApproved.entity.Enum;

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