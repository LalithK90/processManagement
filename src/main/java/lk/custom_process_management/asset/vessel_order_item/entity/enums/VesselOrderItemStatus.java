package lk.custom_process_management.asset.vessel_order_item.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VesselOrderItemStatus {

    PROCESSING("Processing"),
    AVAILABLE("Available"),
    FILL("Fill"),
    UNAVAILABLE("Unavailable");

    private final String vesselOrderItemStatus;
}
