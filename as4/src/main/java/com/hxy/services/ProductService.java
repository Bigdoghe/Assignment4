package com.hxy.services;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.hxy.utilities.HibernateUtil;
import com.hxy.utilities.ProductDao;
import com.hxy.model.Product;
import com.hxy.model.User;
 
public class ProductService {
	
	
	public boolean register(Product product){
	     Session session = ProductDao.openSession();
	     if(isProductExists(product)) return false;  
	     
	     Transaction tx = null;
	     try {
	         tx = session.getTransaction();
	         tx.begin();         
	         Product productnew = new Product(product.getProductname(), product.getPrice(),product.getDescription());
		     session.save(productnew);    
	         tx.commit();
	     } catch (Exception e) {
	         if (tx != null) {
	             tx.rollback();
	         }
	         e.printStackTrace();
	     } finally {
	         session.close();
	     } 
	     return true;
	}
	
	
	
	
	public boolean isProductExists(Product product){
	     Session session = ProductDao.openSession();
	     boolean result = false;
	     Transaction tx = null;
	     try{
	         tx = session.getTransaction();
	         tx.begin();
	         Query query = session.createQuery("from Product where productname='"+product.getProductname()+"'");
	         Product p = (Product)query.uniqueResult();
	         tx.commit();
	         if(p!=null) result = true;
	     }catch(Exception ex){
	         if(tx!=null){
	             tx.rollback();
	         }
	     }finally{
	         session.close();
	     }
	     return result;
	}
	
	
	
	
    public void deleteproduct(int productid) {
    	Session session = ProductDao.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            System.out.println("run");
            Query query = session.createQuery("delete from Product where id= :productid"); 
            query.setParameter("productid", productid);
            query.executeUpdate();
            System.out.println("run2");
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
	
    public void updateproduct(int productid,Product product) {
    	Session session = ProductDao.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            System.out.println("run");
            String productname = product.getProductname();
            double price = product.getPrice();
            String description = product.getDescription();
            Query query = session.createQuery("update from Product set productname='"+productname+"', price ='"+price+"', description ='"+description+"' where id='"+productid+"'"); 
            query.executeUpdate();
            System.out.println("run2");
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
	
	
	
	
	public int getProductNumber(){
    	
    	Long count = 0L;
    	Session session = ProductDao.openSession();
        Transaction tx = null;
        Product product = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("select count(*) from Product");
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
	
	public Product getProductByProductId(int productid) {
        Session session = ProductDao.openSession();
        Transaction tx = null;
        Product product = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Product where id='"+productid+"'");
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