package lk.groceryShop.to;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ItemTO {
    private String itemId;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private double total;


}
