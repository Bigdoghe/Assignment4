package com.hxy.services;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.hxy.utilities.AdminDao;
import com.hxy.model.AdminUser;
 
public class AdminLoginService {
 
    public boolean authenticateUser(String username, String password) {
        AdminUser user = getUserByUserName(username);
        System.out.println(username+password);
        if(user!=null && user.getUsername().equals(username) && user.getPassword().equals(password)){
        	return true;
        }else{
            return false;
        }
    }
 
    public AdminUser getUserByUserName(String username) {
        Session session = AdminDao.openSession();
        Transaction tx = null;
        AdminUser user = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from AdminUser where username='"+username+"'");
            user = (AdminUser)query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
     
    public List<AdminUser> getListOfUsers(){
        List<AdminUser> list = new ArrayList<AdminUser>();
        Session session = AdminDao.openSession();
        Transaction tx = null;       
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from AdminUser").list();                       
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