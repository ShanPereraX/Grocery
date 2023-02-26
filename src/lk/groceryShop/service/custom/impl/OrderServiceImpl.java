package lk.groceryShop.service.custom.impl;

import lk.groceryShop.dto.OrderDto;
import lk.groceryShop.entity.Orders;
import lk.groceryShop.service.custom.OrderService;

public class OrderServiceImpl implements OrderService {


    @Override
    public boolean save(OrderDto dto) {
        return false;
    }

    @Override
    public OrderDto view(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(OrderDto dto) {
        return false;
    }
}
