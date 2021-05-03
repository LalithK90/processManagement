package lk.custom_process_management.asset.report_management.model;


import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel.entity.Vessel;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipAgentDetail {
  private ShipAgent shipAgent;
  private int vesselOrderCount;
  private List< VesselOrder > VesselOrders;
  private List< Vessel > vessels;
  private BigDecimal totalAmount;
}
