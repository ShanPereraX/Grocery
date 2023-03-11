package lk.groceryShop.service.custom.impl;

import lk.groceryShop.dao.DaoFactory;
import lk.groceryShop.dao.custom.CustomerDao;
import lk.groceryShop.dao.util.DaoTypes;
import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.entity.Customer;
import lk.groceryShop.service.custom.CustomerService;
import lk.groceryShop.service.util.Converter;
import lk.groceryShop.util.FactoryConfiguration;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
Converter converter;
    public CustomerServiceImpl() {
        converter = Converter.getInstance();
        customerDao = DaoFactory.getInstance().getDao(DaoTypes.CUSTOMER);
    }

    @Override
    public boolean save(CustomerDto dto) {
        return customerDao.save(converter.toCustomerEntity(dto), FactoryConfiguration.getInstance().getSession());
    }

    @Override
    public CustomerDto view(String id) {
        Customer entity = customerDao.view(id,FactoryConfiguration.getInstance().getSession());
        return (entity != null) ? converter.toCustomerDto(entity) : null;
    }

    @Override
    public boolean delete(String id) {
        return customerDao.delete(id,FactoryConfiguration.getInstance().getSession());
    }

    @Override
    public boolean update(CustomerDto dto) {
        return customerDao.update(converter.toCustomerEntity(dto),FactoryConfiguration.getInstance().getSession());
    }

    @Override
    public List<CustomerDto> loadCustomers() throws RuntimeException {
        List<Customer> customers = customerDao.loadAllCustomers();
        if (customers.size()>0){
            return customers.stream().map(customer -> converter.toCustomerDto(customer)).collect(Collectors.toList());
        }
        throw new RuntimeException("Empty Customer List ! ");
    }
}
