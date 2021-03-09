package lk.custom_process_management.asset.vessel_order.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VesselOrderStatus {
  PROCESSING("Processing"),
  VALID("Valid"),
  BITTED("Bitted"),
  SUSPEND("Suspend"),
  INVALID("Invalid");

  private final String vesselOrderStatus;
}
