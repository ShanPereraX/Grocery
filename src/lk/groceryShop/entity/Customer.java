package lk.groceryShop.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;

    @CreationTimestamp
    private Date registeredDate;
    private double salary;

    public Customer(String id) {
        this.id = id;
    }
}
