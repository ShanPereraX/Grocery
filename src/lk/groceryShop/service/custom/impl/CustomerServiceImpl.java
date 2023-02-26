package lk.groceryShop.service.custom.impl;

import lk.groceryShop.dao.DaoFactory;
import lk.groceryShop.dao.custom.CustomerDao;
import lk.groceryShop.dao.util.DaoTypes;
import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.entity.Customer;
import lk.groceryShop.entity.Item;
import lk.groceryShop.service.custom.CustomerService;
import lk.groceryShop.service.util.Converter;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;
Converter converter;
    public CustomerServiceImpl() {
        converter = Converter.getInstance();
        customerDao = DaoFactory.getInstance().getDao(DaoTypes.CUSTOMER);
    }

    @Override
    public boolean save(CustomerDto dto) {
        return customerDao.save(converter.toCustomerEntity(dto));
    }

    @Override
    public CustomerDto view(String id) {
        Customer entity = customerDao.view(id);
        return (entity != null) ? converter.toCustomerDto(entity) : null;
    }

    @Override
    public boolean delete(String id) {
        return customerDao.delete(id);
    }

    @Override
    public boolean update(CustomerDto dto) {
        return customerDao.update(converter.toCustomerEntity(dto));
    }
}
