package lk.groceryShop.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Customer implements SuperEntity {
    @OneToMany(targetEntity = Orders.class, mappedBy = "customer")
    @ToString.Exclude
    List<Orders> ordersList = new ArrayList<>();
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


    public Customer(String id, String name, String address, Date registeredDate, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.registeredDate = registeredDate;
        this.salary = salary;
    }
}
