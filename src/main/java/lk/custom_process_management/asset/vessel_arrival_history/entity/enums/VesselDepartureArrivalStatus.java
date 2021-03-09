package lk.custom_process_management.asset.vessel_arrival_history.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VesselDepartureArrivalStatus {
  NOAR("Still Not Arrival"),
  AR("Arrival"),
  DP("Departure");
  private final String vesselDepartureArrivalStatus;
}
