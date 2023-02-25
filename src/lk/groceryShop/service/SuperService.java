package lk.groceryShop.service;

import lk.groceryShop.entity.SuperEntity;

import java.io.Serializable;

public interface SuperService<T extends SuperEntity, TM extends Serializable> {
    boolean save(T entity);
    T view(TM id);
    boolean delete(T entity);
    boolean update(T entity);
}
