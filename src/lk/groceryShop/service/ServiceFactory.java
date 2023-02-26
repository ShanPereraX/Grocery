package lk.groceryShop.service;

import lk.groceryShop.dao.custom.impl.*;
import lk.groceryShop.service.custom.impl.CustomerServiceImpl;
import lk.groceryShop.service.custom.impl.ItemServiceImpl;
import lk.groceryShop.service.custom.impl.OrderDetailServiceImpl;
import lk.groceryShop.service.custom.impl.OrderServiceImpl;
import lk.groceryShop.service.util.ServiceType;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return serviceFactory == null ? serviceFactory = new ServiceFactory() : serviceFactory;
    }
    public <T extends SuperService> T getService(ServiceType type){
        switch (type) {
            case ITEM:
                return (T) new ItemServiceImpl();
            case CUSTOMER:
                return (T) new CustomerServiceImpl();
            case ORDER:
                return (T) new OrderServiceImpl();
            case ORDER_DETAIL:
                return (T) new OrderDetailServiceImpl();
            default: throw new RuntimeException("Not Implemented");
        }

    }
}
