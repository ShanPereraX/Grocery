package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.CustomerDao;
import lk.groceryShop.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerDaoImpl implements CustomerDao {
    Session session;

    public CustomerDaoImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Customer entity) {
        Transaction transaction = session.getTransaction();

        System.out.println(entity);
        try {
            transaction.begin();
            session.save(entity);
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
           e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    @Override
    public Customer view(String id) {
        return session.get(Customer.class, id);
    }

    @Override
    public boolean delete(String entity) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(new Customer(entity));
            transaction.commit();
            return true;
        } catch (RuntimeException e) {
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean update(Customer entity) {
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
