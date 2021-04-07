package lk.custom_process_management.asset.common_asset.model;

import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.asset.vessel_order_item_bid.entity.VesselOrderItemBid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemVesselOrderItemBid {
private Item item;
private List< VesselOrderItemBid > vesselOrderItemBids;
}
