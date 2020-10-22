package lk.custom_process_management.asset.warehouseBlock.service;


import lk.custom_process_management.asset.warehouseBlock.dao.WarehouseBlockDao;
import lk.custom_process_management.asset.warehouseBlock.entity.WarehouseBlock;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig( cacheNames = "warehouseBlock" )
public class WarehouseBlockService implements AbstractService< WarehouseBlock, Integer> {
    private final WarehouseBlockDao warehouseBlockDao;

    @Autowired
    public WarehouseBlockService(WarehouseBlockDao warehouseBlockDao) {
        this.warehouseBlockDao = warehouseBlockDao;
    }

    public List< WarehouseBlock > findAll() {
        return warehouseBlockDao.findAll();
    }

    public WarehouseBlock findById(Integer id) {
        return warehouseBlockDao.getOne(id);
    }

    public WarehouseBlock persist(WarehouseBlock warehouseBlock) {
        return warehouseBlockDao.save(warehouseBlock);
    }

    public boolean delete(Integer id) {
        warehouseBlockDao.deleteById(id);
        return false;
    }

    public List< WarehouseBlock > search(WarehouseBlock warehouseBlock) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< WarehouseBlock > warehouseBlockExample = Example.of(warehouseBlock, matcher);
        return warehouseBlockDao.findAll(warehouseBlockExample);
    }
}

