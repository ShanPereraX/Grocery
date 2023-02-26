package lk.groceryShop.dao;

import lk.groceryShop.dao.custom.impl.*;
import lk.groceryShop.dao.util.DaoTypes;
import lk.groceryShop.util.FactoryConfiguration;
import org.hibernate.Session;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private final Session session;

    private DaoFactory() {
        session = FactoryConfiguration.getInstance().getSession();
    }

    public static DaoFactory getInstance() {
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public <T extends SuperDao> T getDao(DaoTypes types) {
        switch (types) {
            case ITEM:
                return (T) new ItemDaoImpl(session);
            case CUSTOMER:
                return (T) new CustomerDaoImpl(session);
            case ORDER:
                return (T) new OrderDaoImpl(session);
            case ORDER_DETAIL:
                return (T) new OrderDetailDaoImpl(session);
            case QUARY:
                return (T) new QuaryDaoImpl(session);
        }
        return null;
    }
}
