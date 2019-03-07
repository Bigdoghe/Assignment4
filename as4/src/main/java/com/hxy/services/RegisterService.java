package com.hxy.services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.hxy.utilities.HibernateUtil;
import com.hxy.model.User;
public class RegisterService {
     
public boolean register(User user){
     Session session = HibernateUtil.openSession();
     if(isUserExists(user)) return false;  
     
     Transaction tx = null;
     try {
         tx = session.getTransaction();
         tx.begin();         
         User usernew = new User(user.getUsername(), user.getPassword());
	     session.save(usernew);    
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
 
public boolean isUserExists(User user){
     Session session = HibernateUtil.openSession();
     boolean result = false;
     Transaction tx = null;
     try{
         tx = session.getTransaction();
         tx.begin();
         Query query = session.createQuery("from User where username='"+user.getUsername()+"'");
         User u = (User)query.uniqueResult();
         tx.commit();
         if(u!=null) result = true;
     }catch(Exception ex){
         if(tx!=null){
             tx.rollback();
         }
     }finally{
         session.close();
     }
     return result;
}
}