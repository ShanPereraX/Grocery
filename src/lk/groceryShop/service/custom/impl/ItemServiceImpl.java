package lk.groceryShop.service.custom.impl;

import lk.groceryShop.entity.Item;
import lk.groceryShop.service.custom.ItemService;

public class ItemServiceImpl implements ItemService {
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
