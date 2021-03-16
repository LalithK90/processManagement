package lk.custom_process_management.asset.vessel_order.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VesselOrderStatus {
  PROCESSING("Processing"),
  VALID("Valid"),
  BIDEN("Biden"),
  SUSPEND("Suspend"),
  INVALID("Invalid"),
  APPROVE("Approve");

  private final String vesselOrderStatus;
}
