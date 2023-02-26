package lk.groceryShop.dto;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ItemDto  implements SuperDto{
    private String itemId;

    private String description;
    private double unitPrice;
    private int qtyOnHand;

    public ItemDto(String itemId) {
        this.itemId = itemId;
    }

}
