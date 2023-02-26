package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.ItemDao;
import lk.groceryShop.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemDaoImpl implements ItemDao {
    Session session;

    public ItemDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Item entity) {
        Transaction transaction = session.beginTransaction();
        try {
            Integer integer = (Integer) session.save(entity);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Item view(String id) {
        return session.get(Item.class, id);
    }

    @Override
    public boolean delete(String id) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(new Item(id));
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Item entity) {
        Transaction transaction = session.beginTransaction();
        try {
            session.update(entity);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            transaction.rollback();
            return false;
        }
    }
}
