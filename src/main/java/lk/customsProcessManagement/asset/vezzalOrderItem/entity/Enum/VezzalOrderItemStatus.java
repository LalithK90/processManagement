package lk.customsProcessManagement.asset.vezzalOrderItem.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VezzalOrderItemStatus {

    AVAILABLE("Available"),
    PROCESSING("Processing"),
    FILL("Fill"),
    UNAVAILABLE("Unavailable");

    private final String vezzalOrderItemStatus;
}
