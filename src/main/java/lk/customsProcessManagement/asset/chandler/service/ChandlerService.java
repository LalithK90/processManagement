package lk.customsProcessManagement.asset.chandler.service;


import lk.customsProcessManagement.asset.chandler.dao.ChandlerDao;
import lk.customsProcessManagement.asset.chandler.entity.Chandler;
import lk.customsProcessManagement.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "supplier")
public class ChandlerService implements AbstractService< Chandler, Integer> {
    private final ChandlerDao chandlerDao;

    @Autowired
    public ChandlerService(ChandlerDao chandlerDao) {
        this.chandlerDao = chandlerDao;
    }

    public List< Chandler > findAll() {
        return chandlerDao.findAll();
    }

    public Chandler findById(Integer id) {
        return chandlerDao.getOne(id);
    }

    public Chandler persist(Chandler chandler) {
/*        if (supplier.getId() == null) {
            supplier.setItemSupplierStatus(ItemSupplierStatus.CURRENTLY_BUYING);
        }*/
        return chandlerDao.save(chandler);
    }

    public boolean delete(Integer id) {
        chandlerDao.deleteById(id);
        return false;
    }

    public List< Chandler > search(Chandler chandler) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example< Chandler > supplierExample = Example.of(chandler, matcher);
        return chandlerDao.findAll(supplierExample);
    }

    public Chandler lastSupplier() {
        return chandlerDao.findFirstByOrderByIdDesc();
    }

/*    public Supplier findByIdAndItemSupplierStatus(Integer supplierId, ItemSupplierStatus itemSupplierStatus) {
    return supplierDao.findByIdAndItemSupplierStatus(supplierId,itemSupplierStatus);
    }*/
}