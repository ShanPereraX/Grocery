package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.ItemDao;
import lk.groceryShop.entity.Item;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) {
        return false;
    }

    @Override
    public Item view(String id) {
        return null;
    }

    @Override
    public boolean delete(Item entity) {
        return false;
    }

    @Override
    public boolean update(Item entity) {
        return false;
    }
}
