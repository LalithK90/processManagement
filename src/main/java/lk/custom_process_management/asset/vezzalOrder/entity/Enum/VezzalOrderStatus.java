package lk.custom_process_management.asset.vezzalOrder.entity.Enum;

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
