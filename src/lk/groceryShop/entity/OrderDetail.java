package lk.groceryShop.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class OrderDetail implements SuperEntity{
    private String OrderId;
    private String itemId;

}
