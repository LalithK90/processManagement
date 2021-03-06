package lk.custom_process_management.asset.payment.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {

    PAID("Payment Done"),
    ITEMNR("Item Not Recived"),
    NOTPAID("Not Paid");

    private final String paymentStatus;

}
