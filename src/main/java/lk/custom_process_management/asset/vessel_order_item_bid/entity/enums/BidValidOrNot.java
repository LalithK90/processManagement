package lk.custom_process_management.asset.vessel_order_item_bid.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BidValidOrNot {
  PEN("Pending"),
  SELECT("Select"),
  REJECT("Reject");

  private final String bidValidOrNot;
}
