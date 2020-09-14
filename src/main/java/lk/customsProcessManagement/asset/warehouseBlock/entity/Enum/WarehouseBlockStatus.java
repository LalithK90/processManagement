package lk.customsProcessManagement.asset.warehouseBlock.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WarehouseBlockStatus {
    //1.available,  2. unavailable,  3. Processing, 4. fill
    AVAILABLE("Available"),
    PROCESSING("Processing"),
    FILL("Fill"),
    UNAVAILABLE("Unavailable");

    private final String warehouseBlockStatus;
}
