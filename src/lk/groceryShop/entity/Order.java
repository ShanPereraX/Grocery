package lk.groceryShop.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order implements SuperEntity{
    @Id private String orderId;
    private Date date;
    private String customerId;
}
