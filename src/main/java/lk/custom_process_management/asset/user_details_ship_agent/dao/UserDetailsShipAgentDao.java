package lk.custom_process_management.asset.user_details_ship_agent.dao;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details_ship_agent.entity.UserDetailsShipAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsShipAgentDao extends JpaRepository< UserDetailsShipAgent,Integer> {
  UserDetailsShipAgent findFirstByOrderByIdDesc();

  UserDetailsShipAgent findByUserDetails(UserDetails userDetails);
}
