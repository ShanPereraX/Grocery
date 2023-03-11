package lk.groceryShop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(mappedBy = "itemList",targetEntity = Orders.class)
    List<Orders> ordersList = new ArrayList<>();

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public Item(String itemId, String description, double unitPrice, int qtyOnHand) {
        this.itemId = itemId;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }
}
