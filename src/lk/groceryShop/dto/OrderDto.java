package lk.groceryShop.dto;

import lk.groceryShop.entity.Customer;
import lk.groceryShop.entity.Item;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto implements SuperDto{
    private String orderId;
    private Date date;
    private Customer customer;
    private List<Item> itemList = new ArrayList<>();

}
