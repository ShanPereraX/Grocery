package lk.groceryShop.service.custom.impl;

import lk.groceryShop.dao.DaoFactory;
import lk.groceryShop.dao.custom.OrderDao;
import lk.groceryShop.dao.util.DaoTypes;
import lk.groceryShop.dto.OrderDto;
import lk.groceryShop.entity.Orders;
import lk.groceryShop.service.custom.OrderService;
import lk.groceryShop.service.util.Converter;
import lk.groceryShop.util.FactoryConfiguration;


public class OrderServiceImpl implements OrderService {
    OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = DaoFactory.getInstance().getDao(DaoTypes.ORDER);
    }

    @Override
    public boolean save(OrderDto dto) {
       return orderDao.save(Converter.getInstance().toOrderEntity(dto), FactoryConfiguration.getInstance().getSession());
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
