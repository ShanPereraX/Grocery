package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.CustomerDao;
import lk.groceryShop.entity.Customer;
import lk.groceryShop.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public boolean save(Customer entity, Session session) {
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
    public Customer view(String id,Session session) {
        return session.get(Customer.class, id);
    }

    @Override
    public boolean delete(String entity,Session session) {
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
    public boolean update(Customer entity,Session session) {
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
    public List<Customer> loadAllCustomers() {
        Session session = FactoryConfiguration.getInstance().getSession();
        String sql = "From Customer";
        Query query = session.createQuery(sql);
        List<Customer> list = query.list();
        return list;
    }
}
