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
            session.save(entity);
            transaction.commit();
            System.out.println("item saved");
            return true;
        } catch (RuntimeException e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            System.out.println("item not saved");
            return false;
        } finally {
            session.close();
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
        } finally {
            session.close();
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
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> loadItemList() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String sql = "From Item";
        Query query = session.createQuery(sql);
        List<Item> list = query.list();
        session.close();
        return list;
    }
}
