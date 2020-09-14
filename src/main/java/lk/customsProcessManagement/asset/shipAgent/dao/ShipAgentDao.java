package lk.customsProcessManagement.asset.shipAgent.dao;

import lk.customsProcessManagement.asset.shipAgent.entity.ShipAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipAgentDao extends JpaRepository< ShipAgent, Integer > {
    ShipAgent findFirstByOrderByIdDesc();
}
