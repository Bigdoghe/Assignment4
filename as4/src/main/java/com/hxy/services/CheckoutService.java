package com.hxy.services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.hxy.utilities.OrderDao;
import com.hxy.model.Order;
import com.hxy.model.User;

 
public class CheckoutService {

    public void insertOrder(List<Order> list) {
    	Session session = OrderDao.openSession(); 
        
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin(); 
            Order ordernew = new Order();
            for (Order o : list) {
            	ordernew = new Order(o.getProductid(), o.getQuantity());
       	        session.save(ordernew);  
            }
              
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        } 
    }
	
	
	
	
	
	
	public int getNumofOrder(){
    	
    	Long count = 0L;
    	Session session = OrderDao.openSession();
        Transaction tx = null;
        Order order = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select count(*) from Order");
            count = (Long)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count.intValue();
    }
	
	
	
	public Order getOrderByOrderId(int orderid) {
        Session session = OrderDao.openSession();
        Transaction tx = null;
        Order order = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Order where id='"+orderid+"'");
            order = (Order)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return order;
    }
     
    public List<Order> getListOfOrders(){
        List<Order> list = new ArrayList<Order>();
        Session session = OrderDao.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Order").list();                       
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}