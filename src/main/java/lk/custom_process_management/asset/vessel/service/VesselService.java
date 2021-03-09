package lk.custom_process_management.asset.vessel.service;


import lk.custom_process_management.asset.vessel.dao.VesselDao;
import lk.custom_process_management.asset.vessel.entity.Vessel;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@CacheConfig( cacheNames = "vessel" )
public class VesselService implements AbstractService<Vessel, Integer> {
private final VesselDao vesselDao;

    public VesselService(VesselDao vesselDao) {
        this.vesselDao = vesselDao;
    }

    public List<Vessel> findAll() {
        return vesselDao.findAll();
    }

    public Vessel findById(Integer id) {
        return vesselDao.getOne(id);
    }

    public Vessel persist(Vessel vessel) {
        return vesselDao.save(vessel);
    }

    public boolean delete(Integer id) {
        vesselDao.deleteById(id);
        return false;
    }

    public List<Vessel> search(Vessel vessel) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Vessel> vesselExample = Example.of(vessel, matcher);
        return vesselDao.findAll(vesselExample);
    }

    public Vessel lastVessel(){
        return vesselDao.findFirstByOrderByIdDesc();
    }

}
