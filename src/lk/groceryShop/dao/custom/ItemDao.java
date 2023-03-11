package lk.groceryShop.dao.custom;

import lk.groceryShop.dao.CrudDao;
import lk.groceryShop.entity.Item;

import java.util.List;

public interface ItemDao extends CrudDao<Item,String> {
    List<Item> loadItemList() ;
}
