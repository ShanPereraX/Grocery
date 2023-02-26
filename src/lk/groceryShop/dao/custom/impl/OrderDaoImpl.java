package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.OrderDao;
import lk.groceryShop.entity.Orders;
import org.hibernate.Session;

public class OrderDaoImpl implements OrderDao {
    Session session;

    public OrderDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Orders entity) {
        return false;
    }

    @Override
    public Orders view(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Orders entity) {
        return false;
    }
}
