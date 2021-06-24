/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Buyer;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aditi
 */
public class BuyerDao extends DAO {

	public BuyerDao(){	
	}
	
	public Buyer get(String username)
		throws EbookstoreException{
		try{
			beginTransaction();
			Query q = getSession().createQuery("from Buyer where username= :username");
			q.setParameter("username", username);
			Buyer customer = (Buyer) q.uniqueResult();
			commit();
			return customer;
		}
		catch(HibernateException e){
			rollbackTransaction();
			throw new EbookstoreException("No such user named"+username+"exists!",e );
		}
	}
	
//	HttpServletRequest request;
//	HttpSession session = request.getSession();
	
	
	
	 public List<Buyer> listUsername() throws EbookstoreException {
	        try {
	            beginTransaction();
	            Query q = getSession().createQuery("from Buyer");
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollbackTransaction();
	            throw new EbookstoreException("Could not list the users", e);
	        }
	    }
	
	 
	   public List listCustomers() throws EbookstoreException {
	        try {
	            beginTransaction();
	            Query q = getSession().createQuery("from Buyer");
	           // q.setCacheable(true);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollbackTransaction();
	            throw new EbookstoreException("Could not list the buyers! Try again.", e);
	        }
	    }
	 
	 
	  public Buyer create(String firstName, String lastName,String emailID, String roleName, 
			  String username, String password, String address, String city, String zip, String state,
			  String country, String phone,String gender)
	            throws EbookstoreException {
	        try {
	            beginTransaction();
	            System.out.println("inside DAO");
	           
	            Buyer customer=new Buyer(address, city, zip, state, country, phone, gender);
	            //this is matching with the constructor in the customer pojo
	            
	            customer.setFirstName(firstName);
	            customer.setLastName(lastName);
	            customer.setEmailID(emailID);
	            customer.setRoleName(roleName);
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
	  
	  public void delete(Buyer customer)
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
	
	
	
}

