package lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VezzalDepartureOrArrivalStatus {
  NOAR("Still Not Arrival"),
  AR("Arrival"),
  DP("Departure");
  private final String vezzalDepartureOrArrivalStatus;
}
