package lk.customs.processManagement.asset.chandlerLicense.entity.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LicenseStatus {
    VALID("Valid"),
    PROCEED("Proceeding"),
    INVALID("Invalid");

    private final String licenseStatus;
}
