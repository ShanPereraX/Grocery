package lk.groceryShop.service.custom.impl;

import lk.groceryShop.dto.OrderDetailsDto;
import lk.groceryShop.entity.OrderDetail;
import lk.groceryShop.service.custom.OrderDetailService;

public class OrderDetailServiceImpl implements OrderDetailService {

    @Override
    public boolean save(OrderDetailsDto dto) {
        return false;
    }

    @Override
    public OrderDetailsDto view(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(OrderDetailsDto dto) {
        return false;
    }
}
