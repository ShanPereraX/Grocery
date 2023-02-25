package lk.groceryShop.service.custom.impl;

import lk.groceryShop.entity.Order;
import lk.groceryShop.service.custom.OrderService;

public class OrderServiceImpl implements OrderService {
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
