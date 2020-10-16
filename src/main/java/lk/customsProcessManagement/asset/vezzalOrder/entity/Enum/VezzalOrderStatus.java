package lk.customsProcessManagement.asset.vezzalOrder.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VezzalOrderStatus {
VALID("Valid"),
  SUSPEND("Suspend"),
  INVALID("Invalid");

private final String vezzalOrderStatus;
}
