package lk.custom_process_management.asset.userManagement.dao;

import lk.custom_process_management.asset.userManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Integer > {
    Role findByRoleName(String roleName);
}
