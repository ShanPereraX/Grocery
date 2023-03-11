package lk.groceryShop.dao.custom;

import lk.groceryShop.dao.CrudDao;
import lk.groceryShop.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public interface CustomerDao extends CrudDao<Customer, String> {
    List<Customer> loadAllCustomers();
}
