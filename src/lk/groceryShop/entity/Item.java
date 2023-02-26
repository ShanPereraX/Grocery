package lk.groceryShop.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item implements SuperEntity {
    @Id
    private String itemId;

    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
