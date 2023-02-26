package lk.groceryShop.service.custom.impl;

import lk.groceryShop.dao.DaoFactory;
import lk.groceryShop.dao.custom.ItemDao;
import lk.groceryShop.dao.util.DaoTypes;
import lk.groceryShop.dto.ItemDto;
import lk.groceryShop.entity.Item;
import lk.groceryShop.service.custom.ItemService;
import lk.groceryShop.service.util.Converter;

public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDao;
    private final Converter converter;

    public ItemServiceImpl() {
        itemDao = DaoFactory.getInstance().getDao(DaoTypes.ITEM);
        converter = Converter.getInstance();
    }

    @Override
    public boolean save(ItemDto dto) {
        return itemDao.save(converter.toItemEntity(dto));
    }

    @Override
    public ItemDto view(String id) {
        Item entity = itemDao.view(id);
        return (entity != null) ? converter.toItemDto(entity) : null;
    }

    @Override
    public boolean delete(String id) {
        return itemDao.delete(id);
    }

    @Override
    public boolean update(ItemDto dto) {
        return itemDao.update(converter.toItemEntity(dto));
    }
}
