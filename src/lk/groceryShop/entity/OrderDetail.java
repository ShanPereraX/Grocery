package lk.groceryShop.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity(name ="OrderDetail")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderDetail implements SuperEntity{
    private String OrderId;
    private String itemId;

}
