package lk.groceryShop.dao;

import lk.groceryShop.entity.SuperEntity;

import java.io.Serializable;

public interface CrudDao<T extends SuperEntity, TM extends Serializable> extends SuperDao{
    boolean save(T entity);
    T view(TM id);
    boolean delete(T entity);
    boolean update(T entity);
}
