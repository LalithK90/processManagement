package lk.custom_process_management.asset.user_management.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PasswordChange {

    private String username;

    @Size( min = 4, message = "password should include four characters or symbols" )
    private String oldPassword;

    @Size( min = 4, message = "password should include four characters or symbols" )
    private String newPassword;

    @Size( min = 4, message = "password should include four characters or symbols" )
    private String newPasswordConform;

}