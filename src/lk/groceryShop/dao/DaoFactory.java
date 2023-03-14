package lk.groceryShop.dao;

import lk.groceryShop.dao.custom.impl.*;
import lk.groceryShop.dao.util.DaoTypes;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public <T extends SuperDao> T getDao(DaoTypes types) {
        switch (types) {
            case ITEM:
                return (T) new ItemDaoImpl();
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case ORDER:
                return (T) new OrderDaoImpl();
            case QUERY:
                return (T) new QuaryDaoImpl();
        }
        return null;
    }
}
