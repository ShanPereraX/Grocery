package lk.groceryShop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Item")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Item implements SuperEntity {
    @Id
    private String itemId;

    private String description;
    private double unitPrice;
    private int qtyOnHand;

    public Item(String itemId) {
        this.itemId = itemId;
    }
}
