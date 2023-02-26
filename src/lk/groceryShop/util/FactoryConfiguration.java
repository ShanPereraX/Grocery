package lk.groceryShop.util;

import lk.groceryShop.entity.Customer;
import lk.groceryShop.entity.Item;
import lk.groceryShop.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Item.class);
        configuration.addAnnotatedClass(Orders.class);
        // configuration.addAnnotatedClass(OrderDetail.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? (factoryConfiguration = new FactoryConfiguration()) : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
