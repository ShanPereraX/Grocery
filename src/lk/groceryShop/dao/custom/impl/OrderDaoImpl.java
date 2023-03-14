package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.OrderDao;
import lk.groceryShop.entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(Orders entity, Session session) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try{
             session.save(entity);
            transaction.commit();
            System.out.println("Order saved");
            return true;
        }catch (Exception e){
            transaction.rollback();
           return false;
        }finally {
            session.close();
        }
    }

    @Override
    public Orders view(String id, Session session) {

        return null;
    }

    @Override
    public boolean delete(String id, Session session) {
        return false;
    }

    @Override
    public boolean update(Orders entity, Session session) {
        return false;
    }
}
