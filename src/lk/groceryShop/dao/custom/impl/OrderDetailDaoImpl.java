package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.OrderDetailDao;
import lk.groceryShop.entity.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao {
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
