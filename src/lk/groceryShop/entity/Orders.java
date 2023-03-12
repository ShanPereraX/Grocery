package lk.groceryShop.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Orders implements SuperEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int orderId;
    @CreationTimestamp
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Customer customer = new Customer();

    @ManyToMany(targetEntity = Item.class)
    List <Item> itemList = new ArrayList<>();


}
