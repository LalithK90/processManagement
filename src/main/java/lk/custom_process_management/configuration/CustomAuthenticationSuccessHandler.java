package lk.custom_process_management.configuration;


import lk.custom_process_management.asset.user_management.entity.enums.UserSessionLogStatus;
import lk.custom_process_management.asset.user_management.entity.User;
import lk.custom_process_management.asset.user_management.entity.UserSessionLog;
import lk.custom_process_management.asset.user_management.service.UserService;
import lk.custom_process_management.asset.user_management.service.UserSessionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component( "customAuthenticationSuccessHandler" )
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserSessionLogService userSessionLogService;
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //do some logic here if you want something to be done whenever
        User authUser = userService.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
//if user already have failure attempt clean before a save new session log

        //the user successfully logs in.
        UserSessionLog userSessionLog = new UserSessionLog();
        userSessionLog.setUser(authUser);
        userSessionLog.setUserSessionLogStatus(UserSessionLogStatus.LOGGED);
        userSessionLog.setCreatedAt(LocalDateTime.now());
        userSessionLogService.persist(userSessionLog);

        //set our response to OK status
        response.setStatus(HttpServletResponse.SC_OK);

        response.sendRedirect("/mainWindow");
    }
}
