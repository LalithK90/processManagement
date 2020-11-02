package lk.custom_process_management.asset.payment.entity.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
  CASH("Cash"),
  CHEQUE("Cheque"),
  CREDIT("Credit card");
  private final String paymentMethod;
}
