package lk.custom_process_management.asset.vezzal_order_item_bit.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BitValidOrNot {
  SELECT("Select"),
  REJECT("Reject");

  private final String bitValidOrNot;
}
