package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.ItemDao;
import lk.groceryShop.entity.Customer;
import lk.groceryShop.entity.Item;
import lk.groceryShop.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean save(Item entity, Session session) {
        Transaction transaction = session.beginTransaction();
        try {
            transaction.begin();
            Integer integer = (Integer) session.save(entity);
            transaction.commit();
            System.out.println("item saved");
            return true;
        } catch (RuntimeException e) {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Item view(String id, Session session) {
        return session.get(Item.class, id);
    }

    @Override
    public boolean delete(String id, Session session) {
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
    public boolean update(Item entity, Session session) {
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

    @Override
    public List<Item> loadItemList() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String sql = "From Item";
        Query query = session.createQuery(sql);
        List<Item> list = query.list();
        return list;
    }
}
