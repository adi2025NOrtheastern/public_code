/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Seller;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aditi
 */
public class SellerDao extends DAO {

    public SellerDao() {
    }

    public Seller get(String username)
            throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Seller where username= :username");
            q.setParameter("username", username);
            Seller customer = (Seller) q.uniqueResult();
            commit();
            return customer;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("No such user named" + username + "exists!", e);
        }
    }
    
    
    public Seller getSellerById(String username)
            throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Seller where sellerId= :sellerId");
            q.setParameter("sellerId", username);
            Seller customer = (Seller) q.uniqueResult();
            commit();
            return customer;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("No such user named" + username + "exists!", e);
        }
    }
    

//	HttpServletRequest request;
//	HttpSession session = request.getSession();
    public List<Seller> listUsername() throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from User");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the users", e);
        }
    }

    public List listSellers() throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Seller");
            // q.setCacheable(true);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the customers! Try again.", e);
        }
    }

    public Seller create(String firstName, String lastName, String emailID, String roleName,
            String username, String password, String address, String city, String zip, String state,
            String country, String phone, String gender)
            throws EbookstoreException {
        try {
            beginTransaction();
            System.out.println("inside DAO");

            Seller customer = new Seller(address, city, zip, state, country, phone, gender);
            //this is matching with the constructor in the customer pojo

            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setEmailID(emailID);
            customer.setRoleName("seller");
            customer.setUsername(username);
            customer.setPassword(password);

            getSession().save(customer);

            commit();
            return customer;

        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Exception while creating customer: " + e.getMessage());
        }
    }

    public void delete(Seller customer)
            throws EbookstoreException {
        try {
            beginTransaction();
            getSession().delete(customer);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not delete customer " + customer.getFirstName(), e);
        }
    }

    public List<Seller> listNewSellerApprove() throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Seller where approve=:approve");
            q.setParameter("approve", "No");
            List list = q.list();
            // q.setCacheable(true);
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the genres", e);
        }
    }

    public String approveSeller(String username) 
            throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("Update Seller set approve=:approve where username= :username");
            q.setParameter("approve", "Yes");
            q.setParameter("username", username);
             q.executeUpdate();
            //Seller customer = (Seller) q.uniqueResult();
            commit();
            return "Seller approved successfully";
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("No such user named" + username + "exists!", e);
        }
    } 

}
