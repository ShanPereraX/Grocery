package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.CustomerDao;
import lk.groceryShop.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer entity) {
        return false;
    }

    @Override
    public Customer view(String id) {
        return null;
    }

    @Override
    public boolean delete(Customer entity) {
        return false;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }
}
