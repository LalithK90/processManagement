package lk.customs.processManagement.asset.vezzal.service;


import lk.customs.processManagement.asset.vezzal.dao.VezzalDao;
import lk.customs.processManagement.asset.vezzal.entity.Vezzal;
import lk.customs.processManagement.util.interfaces.AbstractService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@CacheConfig( cacheNames = "vezzal" )
public class VezzalService implements AbstractService<Vezzal, Integer> {
private final VezzalDao vezzalDao;

    public VezzalService(VezzalDao vezzalDao) {
        this.vezzalDao = vezzalDao;
    }

    public List<Vezzal> findAll() {
        return vezzalDao.findAll();
    }

    public Vezzal findById(Integer id) {
        return vezzalDao.getOne(id);
    }

    public Vezzal persist(Vezzal vezzal) {
        return vezzalDao.save(vezzal);
    }

    public boolean delete(Integer id) {
        vezzalDao.deleteById(id);
        return false;
    }

    public List<Vezzal> search(Vezzal vezzal) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Vezzal> vezzalExample = Example.of(vezzal, matcher);
        return vezzalDao.findAll(vezzalExample);
    }

    public Vezzal lastCustomer(){
        return vezzalDao.findFirstByOrderByIdDesc();
    }
}