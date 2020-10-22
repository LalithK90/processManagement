package lk.custom_process_management.asset.userDetails.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WorkingPlaceChangeReason {
    IMPORTANCEOFSERVICE("Importance of Service"),
    EMLOYEEREQUEST("Employee Request"),
    DISIPILINARYACTION("Disciplinary Action"),
    ANNURALTRANSFER("Annual Transfer");

    private final String workingPlaceChangeReason;

}
