package lk.custom_process_management.asset.user_management.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserSessionLogStatus {
    LOGGED("User Logged"),
    LOGOUT("User Logout"),
    FAILURE("Failure");

    private final String userSessionLogStatus;
}
