package lk.custom_process_management.asset.ship_agent.service;

import lk.custom_process_management.asset.ship_agent.dao.ShipAgentDao;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipAgentService implements AbstractService< ShipAgent, Integer > {
private final ShipAgentDao shipAgentDao;

    public ShipAgentService(ShipAgentDao shipAgentDao) {
        this.shipAgentDao = shipAgentDao;
    }

    public List< ShipAgent > findAll() {
        return shipAgentDao.findAll();
    }

    public ShipAgent findById(Integer id) {
        return shipAgentDao.getOne(id);
    }

    public ShipAgent persist(ShipAgent shipAgent) {
        return shipAgentDao.save(shipAgent);
    }

    public boolean delete(Integer id) {
        return false;
    }

    public List< ShipAgent > search(ShipAgent shipAgent) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< ShipAgent > shipAgentExample = Example.of(shipAgent, matcher);
        return shipAgentDao.findAll(shipAgentExample);

    }

    public ShipAgent lastShipAgent() {
    return shipAgentDao.findFirstByOrderByIdDesc();
    }
}
