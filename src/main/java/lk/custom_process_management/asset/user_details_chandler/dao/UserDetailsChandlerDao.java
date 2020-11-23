package lk.custom_process_management.asset.user_details_chandler.dao;

import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details_chandler.entity.UserDetailsChandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsChandlerDao extends JpaRepository< UserDetailsChandler,Integer> {
  UserDetailsChandler findFirstByOrderByIdDesc();

  UserDetailsChandler findByUserDetails(UserDetails userDetails);
}
