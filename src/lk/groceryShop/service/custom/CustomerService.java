package lk.groceryShop.service.custom;

import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.service.SuperService;

import java.util.List;

public interface CustomerService extends SuperService <CustomerDto,String>{
    List<CustomerDto> loadCustomers()throws RuntimeException;
}
