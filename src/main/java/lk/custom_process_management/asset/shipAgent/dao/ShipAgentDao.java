package lk.custom_process_management.asset.shipAgent.dao;

import lk.custom_process_management.asset.shipAgent.entity.ShipAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipAgentDao extends JpaRepository< ShipAgent, Integer > {
    ShipAgent findFirstByOrderByIdDesc();
}
