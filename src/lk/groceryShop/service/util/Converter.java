package lk.groceryShop.service.util;

import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.dto.ItemDto;
import lk.groceryShop.entity.Customer;
import lk.groceryShop.entity.Item;

public class Converter {
    private static Converter converter;

    private Converter() {
    }

    public static Converter getInstance() {
        return converter == null ? converter = new Converter() : converter;
    }

    public Customer toCustomerEntity(CustomerDto dto) {
        return new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getRegisteredDate(), dto.getSalary());
    }

    public Item toItemEntity(ItemDto dto) {
        return new Item(dto.getItemId(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    public ItemDto toItemDto(Item entity) {
        return new ItemDto(entity.getItemId(), entity.getDescription(), entity.getUnitPrice(),entity.getQtyOnHand());
    }

    public CustomerDto toCustomerDto(Customer entity) {
        return  new CustomerDto(entity.getId(), entity.getName(), entity.getAddress(), entity.getRegisteredDate(), entity.getSalary());
    }
}
