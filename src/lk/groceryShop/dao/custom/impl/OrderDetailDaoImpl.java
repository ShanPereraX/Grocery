package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.OrderDetailDao;
import lk.groceryShop.entity.OrderDetail;
import org.hibernate.Session;

public class OrderDetailDaoImpl implements OrderDetailDao {
    Session session;

    public OrderDetailDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(OrderDetail entity) {
        return false;
    }

    @Override
    public OrderDetail view(String id) {
        return null;
    }

    @Override
    public boolean delete(String entity) {
        return false;
    }

    @Override
    public boolean update(OrderDetail entity) {
        return false;
    }
}
