package lk.groceryShop.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
    @CreationTimestamp
    private Date registeredDate;
}
