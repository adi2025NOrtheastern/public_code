/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.aditicompany.pojo.Admin;
import com.aditicompany.pojo.Buyer;
import com.aditicompany.pojo.Seller;
import com.aditicompany.pojo.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author aditi
 */
public class LoginDao extends DAO{
  //  private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
  //  private Session session = null;

//    private Session getSession() {
//        if (session == null || !session.isOpen()) {
//            session = sf.openSession();
//        }
//        return session;
//    }
//
//    private void beginTransaction() {
//        getSession().beginTransaction();
//    }
//
//    private void commit() {
//        getSession().getTransaction().commit();;
//    }
//
//    private void close() {
//        getSession().close();
//    }
//
//    private void rollbackTransaction() {
//        getSession().getTransaction().rollback();
//    }

    public ArrayList<Admin> getAdminLoginDetails(String username, String password) {
        ArrayList<Admin> role = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Admin where username = :username and password = :password");
            q.setParameter("username", username);
            q.setParameter("password", password);
            role = (ArrayList<Admin>) q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return role;
    }
    
    public ArrayList<Seller> getSellerLoginDetails(String username, String password) {
        ArrayList<Seller> role = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Seller where username = :username and password = :password");
            q.setParameter("username", username);
            q.setParameter("password", password);
            role = (ArrayList<Seller>) q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return role;
    }
    
    public ArrayList<Buyer> getBuyerLoginDetails(String username, String password) {
        ArrayList<Buyer> role = null;
        try {
            beginTransaction();
            //Query q = getSession().createQuery("from Message where userName= :username");
            Query q = getSession().createQuery("from Buyer where username = :username and password = :password");
            q.setParameter("username", username);
            q.setParameter("password", password);
            role = (ArrayList<Buyer>) q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return role;
    }
    //registerUser
    public int registerBuyer(String firstname, String lastname, String gender, Date date, String address, String email, String phone, String username, String password){
        int result = 0;
        try{
            beginTransaction();
            Buyer user = new Buyer();//address,  city,  zip,  state,  country,  phone,  gender);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setGender(gender);
            user.setDate_of_birth(date);
            user.setAddress(address);
            user.setEmailID(email);                           
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setRoleName("buyer");
            getSession().save(user);
            commit();
            result = 1;
        }catch(HibernateException e){
            e.printStackTrace();
            rollbackTransaction();
            result = 0;
        }finally {
            close();
        }
        return result;
    }
    
    public int addSeller(String firstname, String lastname, String gender, Date date, String address, String email, String phone, String username, String password){
        int result = 0;
        try{
            beginTransaction();
            Seller user = new Seller();
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setGender(gender);
            user.setDate_of_birth(date);
            user.setAddress(address);
            user.setEmailID(email);                           
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setRoleName("seller");
            user.setApprove("No");
            getSession().save(user);
            commit();
            result = 1;
        }catch(HibernateException e){
            e.printStackTrace();
            rollbackTransaction();
            result = 0;
        }finally {
            close();
        }
        return result;
    }
    
    public int checkUser(String email, String username){
        int result = 0;
        try{
            beginTransaction();
            Criteria criteria = getSession().createCriteria(User.class);
            Criterion critEmail = Restrictions.eq("email",email);
            Criterion crtiUsername = Restrictions.eq("username", username); 
            criteria.add(Restrictions.or(critEmail,crtiUsername));
            List users = criteria.list();
            if (users.size() > 0) {
                result = 1;
            }else{
                result = 2;
            }
            
        }catch(HibernateException e){
            e.printStackTrace();
            rollbackTransaction();
            result = 0;
        }finally {
            close();
        }
        return result;
    }
    
    
    
    public int updateSeller(String firstname, String lastname, String gender, Date date, String address, String email, String phone, String username, String password,Seller sell){
        int result = 0;
        try{
            beginTransaction();
            Seller user = sell;
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setGender(gender);
            user.setDate_of_birth(date);
            user.setAddress(address);
            user.setEmailID(email);                           
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setRoleName("seller");
            getSession().update(user);
            commit();
            result = 1;
        }catch(HibernateException e){
            e.printStackTrace();
            rollbackTransaction();
            result = 0;
        }finally {
            close();
        }
        return result;
    }
    
    
    
     public int UpdateBuyer(String firstname, String lastname, String gender, Date date, String address, String email, String phone, String username, String password, Buyer buy){
        int result = 0;
        try{
            beginTransaction();
            Buyer user = buy;//address,  city,  zip,  state,  country,  phone,  gender);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setGender(gender);
            user.setDate_of_birth(date);
            user.setAddress(address);
            user.setEmailID(email);                           
            user.setPhone(phone);
            user.setUsername(username);
            user.setPassword(password);
            user.setRoleName("buyer");
            getSession().update(user);
            commit();
            result = 1;
        }catch(HibernateException e){
            e.printStackTrace();
            rollbackTransaction();
            result = 0;
        }finally {
            close();
        }
        return result;
    }
    
}

