package lk.groceryShop.service.custom;

import lk.groceryShop.dto.CustomerDto;
import lk.groceryShop.dto.ItemDto;
import lk.groceryShop.entity.Item;
import lk.groceryShop.service.SuperService;

import java.util.List;

public interface ItemService extends SuperService<ItemDto,String> {
    List<ItemDto> loadItemList()throws RuntimeException;
}
