package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.OrderDao;
import lk.groceryShop.entity.Order;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(Order entity) {
        return false;
    }

    @Override
    public Order view(String id) {
        return null;
    }

    @Override
    public boolean delete(Order entity) {
        return false;
    }

    @Override
    public boolean update(Order entity) {
        return false;
    }
}
