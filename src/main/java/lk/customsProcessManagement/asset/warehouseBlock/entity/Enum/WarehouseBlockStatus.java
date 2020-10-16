package lk.customsProcessManagement.asset.warehouseBlock.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WarehouseBlockStatus {

    AVAILABLE("Available"),
    PROCESSING("Processing"),
    FILL("Fill"),
    UNAVAILABLE("Unavailable");

    private final String warehouseBlockStatus;
}
