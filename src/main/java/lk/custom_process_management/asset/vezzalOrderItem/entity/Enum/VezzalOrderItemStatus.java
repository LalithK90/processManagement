package lk.custom_process_management.asset.vezzalOrderItem.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VezzalOrderItemStatus {

    PROCESSING("Processing"),
    AVAILABLE("Available"),
    FILL("Fill"),
    UNAVAILABLE("Unavailable");

    private final String vezzalOrderItemStatus;
}
