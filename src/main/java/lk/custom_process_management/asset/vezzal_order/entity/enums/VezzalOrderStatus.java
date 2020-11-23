package lk.custom_process_management.asset.vezzal_order.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VezzalOrderStatus {
  PROCESSING("Processing"),
  VALID("Valid"),
  SUSPEND("Suspend"),
  INVALID("Invalid");

  private final String vezzalOrderStatus;
}
