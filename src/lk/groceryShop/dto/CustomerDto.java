package lk.groceryShop.dto;

import lombok.*;

import java.sql.Date;
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CustomerDto implements SuperDto{
    private String id;
    private String name;
    private String address;

    private Date registeredDate;
    private double salary;

    public CustomerDto(String id) {
        this.id = id;
    }

}
