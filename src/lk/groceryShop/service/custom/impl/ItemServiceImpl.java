package lk.groceryShop.service.custom.impl;

import javafx.collections.FXCollections;
import lk.groceryShop.dao.DaoFactory;
import lk.groceryShop.dao.custom.ItemDao;
import lk.groceryShop.dao.util.DaoTypes;
import lk.groceryShop.dto.ItemDto;
import lk.groceryShop.entity.Item;
import lk.groceryShop.service.custom.ItemService;
import lk.groceryShop.service.util.Converter;
import lk.groceryShop.util.FactoryConfiguration;

import java.util.List;
import java.util.stream.Collectors;

public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDao;
    private final Converter converter;

    public ItemServiceImpl() {
        itemDao = DaoFactory.getInstance().getDao(DaoTypes.ITEM);
        converter = Converter.getInstance();
    }

    @Override
    public boolean save(ItemDto dto) {
        return itemDao.save(converter.toItemEntity(dto), FactoryConfiguration.getInstance().getSession());
    }

    @Override
    public ItemDto view(String id) {
        Item entity = itemDao.view(id, FactoryConfiguration.getInstance().getSession());
        return (entity != null) ? converter.toItemDto(entity) : null;
    }

    @Override
    public boolean delete(String id) {
        return itemDao.delete(id, FactoryConfiguration.getInstance().getSession());
    }

    @Override
    public boolean update(ItemDto dto) {
        System.out.print("Update: ");
        return itemDao.update(converter.toItemEntity(dto), FactoryConfiguration.getInstance().getSession());
    }

    @Override
    public List<ItemDto> loadItemList() throws RuntimeException {
        List<Item> itemList = itemDao.loadItemList();
        List<ItemDto> collect = itemList.stream().map(converter::toItemDto).collect(Collectors.toList());
        if (collect.size() != 0) return collect;
        throw new RuntimeException("Empty Item list!");
    }
}
