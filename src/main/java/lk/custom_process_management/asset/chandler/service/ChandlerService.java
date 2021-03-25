package lk.custom_process_management.asset.chandler.service;


import lk.custom_process_management.asset.chandler.dao.ChandlerDao;
import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "supplier")
public class ChandlerService implements AbstractService< Chandler, Integer> {
    private final ChandlerDao chandlerDao;

    @Autowired
    public ChandlerService(ChandlerDao chandlerDao) {
        this.chandlerDao = chandlerDao;
    }

    public List< Chandler > findAll() {
        return chandlerDao.findAll().stream().filter(x->x.getLiveDead().equals(LiveDead.ACTIVE)).collect(Collectors.toList());
    }

    public Chandler findById(Integer id) {
        return chandlerDao.getOne(id);
    }

    public Chandler persist(Chandler chandler) {
/*        if (supplier.getId() == null) {
            supplier.setItemSupplierStatus(ItemSupplierStatus.CURRENTLY_BUYING);
        }*/
        if ( chandler.getId() ==null){
            chandler.setLiveDead(LiveDead.ACTIVE);
        }
        return chandlerDao.save(chandler);
    }

    public boolean delete(Integer id) {
        Chandler chandler = chandlerDao.getOne(id);
        chandler.setLiveDead(LiveDead.STOP);
        chandlerDao.save(chandler);
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
