package lk.groceryShop.dao;

import lk.groceryShop.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;

public interface CrudDao<T extends SuperEntity, TM extends Serializable> extends SuperDao{
    boolean save(T entity, Session session);
    T view(TM id,Session session);
    boolean delete(TM id, Session session);
    boolean update(T entity, Session session);
}
