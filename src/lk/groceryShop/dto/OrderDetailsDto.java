package lk.groceryShop.dto;


import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetailsDto implements SuperDto{
    private String OrderId;
    private String itemId;
}
