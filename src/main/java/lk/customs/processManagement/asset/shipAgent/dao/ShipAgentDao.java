package lk.customs.processManagement.asset.shipAgent.dao;

import lk.customs.processManagement.asset.shipAgent.entity.ShipAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipAgentDao extends JpaRepository< ShipAgent, Integer > {
    ShipAgent findFirstByOrderByIdDesc();
}
