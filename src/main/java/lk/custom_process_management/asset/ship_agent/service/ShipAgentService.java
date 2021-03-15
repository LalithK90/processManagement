package lk.custom_process_management.asset.ship_agent.service;

import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.ship_agent.dao.ShipAgentDao;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipAgentService implements AbstractService< ShipAgent, Integer > {
private final ShipAgentDao shipAgentDao;

    public ShipAgentService(ShipAgentDao shipAgentDao) {
        this.shipAgentDao = shipAgentDao;
    }

    public List< ShipAgent > findAll() {
        return shipAgentDao.findAll().stream().filter(x->x.getLiveDead().equals(LiveDead.ACTIVE)).collect(Collectors.toList());
    }

    public ShipAgent findById(Integer id) {
        return shipAgentDao.getOne(id);
    }

    public ShipAgent persist(ShipAgent shipAgent) {
        if ( shipAgent.getId() == null ){
            shipAgent.setLiveDead(LiveDead.ACTIVE);
        }
        return shipAgentDao.save(shipAgent);
    }

    public boolean delete(Integer id) {
        ShipAgent shipAgent = shipAgentDao.getOne(id);
        shipAgent.setLiveDead(LiveDead.STOP);
        shipAgentDao.save(shipAgent);
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
