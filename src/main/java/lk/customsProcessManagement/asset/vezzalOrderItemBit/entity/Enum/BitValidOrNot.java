package lk.customsProcessManagement.asset.vezzalOrderItemBit.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BitValidOrNot {
  SELECT("Select"),
  REJECT("Reject");

  private final String bitValidOrNot;
}
