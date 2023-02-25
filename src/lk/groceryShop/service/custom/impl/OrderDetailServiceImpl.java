package lk.groceryShop.service.custom.impl;

import lk.groceryShop.entity.OrderDetail;
import lk.groceryShop.service.custom.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public boolean save(OrderDetail entity) {
        return false;
    }

    @Override
    public OrderDetail view(String id) {
        return null;
    }

    @Override
    public boolean delete(OrderDetail entity) {
        return false;
    }

    @Override
    public boolean update(OrderDetail entity) {
        return false;
    }
}
