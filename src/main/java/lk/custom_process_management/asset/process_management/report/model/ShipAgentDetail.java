package lk.custom_process_management.asset.process_management.report.model;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel.entity.Vessel;
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
private List< Vessel >  vessels;
private BigDecimal totalAmount;
}
