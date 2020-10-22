package lk.custom_process_management.asset.userManagement.dao;

import lk.custom_process_management.asset.userManagement.entity.Enum.UserSessionLogStatus;
import lk.custom_process_management.asset.userManagement.entity.User;
import lk.custom_process_management.asset.userManagement.entity.UserSessionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionLogDao extends JpaRepository<UserSessionLog, Integer > {
    UserSessionLog findByUserAndUserSessionLogStatus(User user, UserSessionLogStatus userSessionLogStatus);
}
