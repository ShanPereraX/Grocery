package lk.groceryShop;

import lk.groceryShop.dao.custom.impl.CustomerDaoImpl;
import lk.groceryShop.dao.custom.impl.ItemDaoImpl;
import lk.groceryShop.dao.custom.impl.OrderDaoImpl;
import lk.groceryShop.entity.Customer;
import lk.groceryShop.entity.Item;
import lk.groceryShop.entity.Orders;
import lk.groceryShop.util.FactoryConfiguration;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        CustomerDaoImpl customerDao = new CustomerDaoImpl(session);
//
//        Customer customer = new Customer();
//        customer.setId("C001");
//        customer.setName("Shan");
//
////////////////////////////////////////////////////////////////
//        System.out.println(customerDao.save(customer, session));
////////////////////////////////////////////////////////////////
//        Orders orders = new Orders();
//        orders.setOrderId("O001");
//        orders.setCustomerId("C001");
//
//        Item item = new Item();
//        item.setDescription("Samba");
//        item.setUnitPrice(10.0);
//        item.setItemId("I001");
//
//        ItemDaoImpl itemDao = new ItemDaoImpl(session);
//        itemDao.save(item,session);
//
//        Orders orders1 = new Orders();
//        orders1.setCustomerId("C001");
//        orders1.setOrderId("O001");
//
//        OrderDaoImpl orderDao = new OrderDaoImpl(session);
//        orderDao.save(orders1, session);
    }
}
