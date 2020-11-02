package lk.custom_process_management.asset.ship_agent.dao;

import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipAgentDao extends JpaRepository< ShipAgent, Integer > {
    ShipAgent findFirstByOrderByIdDesc();
}
