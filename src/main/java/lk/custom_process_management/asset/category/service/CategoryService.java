package lk.custom_process_management.asset.category.service;



import lk.custom_process_management.asset.category.dao.CategoryDao;
import lk.custom_process_management.asset.category.entity.Category;
import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@CacheConfig(cacheNames = "category")
public class CategoryService implements AbstractService< Category, Integer> {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    public List<Category> findAll() {
        return categoryDao.findAll().stream().filter(x->x.getLiveDead().equals(LiveDead.ACTIVE)).collect(Collectors.toList());
    }

    public Category findById(Integer id) {
        return categoryDao.getOne(id);
    }

    public Category persist(Category category) {
        if  (category.getId() ==null){
            category.setLiveDead(LiveDead.ACTIVE);
        }
        category.setName(category.getName().toUpperCase());
        return categoryDao.save(category);
    }

    public boolean delete(Integer id) {
        Category category = categoryDao.getOne(id);
        category.setLiveDead(LiveDead.STOP);
        categoryDao.save(category);
        return false;
    }


    public List<Category> search(Category category) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Category> categoryExample = Example.of(category, matcher);
        return categoryDao.findAll(categoryExample);
    }
}
