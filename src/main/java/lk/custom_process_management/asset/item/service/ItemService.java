package lk.custom_process_management.asset.item.service;


import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.item.dao.ItemDao;
import lk.custom_process_management.asset.item.entity.enums.ItemStatus;
import lk.custom_process_management.asset.item.entity.Item;
import lk.custom_process_management.util.interfaces.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@CacheConfig( cacheNames = "item" )
public class ItemService implements AbstractService< Item, Integer > {
  private final ItemDao itemDao;

  @Autowired
  public ItemService(ItemDao itemDao) {
    this.itemDao = itemDao;
  }

  public List< Item > findAll() {
    return itemDao.findAll().stream().filter(x->x.getLiveDead().equals(LiveDead.ACTIVE)).collect(Collectors.toList());
  }

  public Item findById(Integer id) {
    return itemDao.getOne(id);
  }

  private String makeItemCode(String lastNumber) {
    String newNumber = "";
    if ( lastNumber != null ) {
      int number = Integer.parseInt(lastNumber);

      if ( number < 10 ) {
        newNumber = "00" + (number + 1);
      }
      if ( 10 < number && number < 100 ) {
        newNumber = "0" + (number + 1);
      }
      if ( 100 < number ) {
        newNumber = String.valueOf(number + 1);
      }
      return newNumber;
    } else {
      return "0001";

    }
  }

  public Item persist(Item item) {
    if ( item.getId() == null ) {
      item.setLiveDead(LiveDead.ACTIVE);
      //need to create code to item
      String code = item.getCategory().getMainCategory()
          + item.getCategory().getName().trim().substring(0, 2)
          + item.getName().trim().substring(0, 2);
      //check last item on db
      Item itemDB = itemDao.findFirstByOrderByIdDesc();
      if ( itemDB != null ) {
        item.setCode(code + makeItemCode(itemDB.getCode().substring(6)));
      } else {
        item.setCode(code + makeItemCode(null));
      }
      item.setItemStatus(ItemStatus.NOT_AVAILABLE);
    }
    return itemDao.save(item);
  }

  public boolean delete(Integer id) {
  Item item = itemDao.getOne(id);
  item.setLiveDead(LiveDead.ACTIVE);
  itemDao.save(item);
    return false;
  }

  public List< Item > search(Item item) {
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example< Item > itemExample = Example.of(item, matcher);
    return itemDao.findAll(itemExample);
  }

  public Item lastItem() {
    return itemDao.findFirstByOrderByIdDesc();
  }
}
