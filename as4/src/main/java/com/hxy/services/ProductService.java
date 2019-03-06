package com.hxy.services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.hxy.utilities.ProductDao;
import com.hxy.model.Product;
 
public class ProductService {

    public int getProductNumber(){
    	int num = 0;
        Session session = ProductDao.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("selcet Count(*) from product"); 
            while(query!=null) {
            	num++;
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
        return num;
    }
	
	
	
	public Product getProductByProductName(String productname) {
        Session session = ProductDao.openSession();
        Transaction tx = null;
        Product product = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Product where productname='"+productname+"'");
            product = (Product)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }
     
    public List<Product> getListOfProducts(){
        List<Product> list = new ArrayList<Product>();
        Session session = ProductDao.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Product").list();                       
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