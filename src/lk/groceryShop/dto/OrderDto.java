package lk.groceryShop.dto;

import lombok.*;

import java.sql.Date;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto implements SuperDto{
    private String orderId;
    private Date date;
    private String customerId;


}
