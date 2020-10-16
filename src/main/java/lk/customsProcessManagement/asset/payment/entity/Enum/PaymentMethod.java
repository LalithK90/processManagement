package lk.customsProcessManagement.asset.payment.entity.Enum;


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
