package lk.groceryShop.service.custom.impl;

import lk.groceryShop.entity.Customer;
import lk.groceryShop.service.custom.CustomerService;

public class CustomerServiceImpl implements CustomerService {
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
