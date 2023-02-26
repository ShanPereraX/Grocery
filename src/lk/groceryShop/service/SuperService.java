package lk.groceryShop.service;

import lk.groceryShop.dto.SuperDto;
import lk.groceryShop.entity.SuperEntity;

import java.io.Serializable;

public interface SuperService<T extends SuperDto, TM extends Serializable> {
    boolean save(T dto);
    T view(TM id);
    boolean delete(TM id);
    boolean update(T dto);
}
