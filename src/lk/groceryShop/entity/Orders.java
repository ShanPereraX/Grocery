package lk.groceryShop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Orders implements SuperEntity{
    @Id private String orderId;
    private Date date;
    //private String customerId;
}
