/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.OrderDetails;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aditi
 */
public class OrdersDetailsDao extends DAO{
    
    public OrderDetails create(OrderDetails orderDetails) throws EbookstoreException {
		try{
			beginTransaction();	
			getSession().save(orderDetails);
			commit();
			return null;
		}
		catch(HibernateException e){
			rollbackTransaction();
			throw new EbookstoreException("Order Details table cannot be created", e);
		}
		
	}
	//List for pdfview:::
	
	  public List listDetails(long userId) throws EbookstoreException {
	        try {
	            beginTransaction();
	           // long userid = (Long)session.getAttribute("userId");
	            Query q = getSession().createQuery("from OrderDetails where buyerid= :userId and status in ('Complete','New')");
	            q.setParameter("userId", userId);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollbackTransaction();
	            throw new EbookstoreException("Could not list the genres", e);
	        }
	    }
	
            public List listDetailsSeller(long userId) throws EbookstoreException {
	        try {
	            beginTransaction();
	           // long userid = (Long)session.getAttribute("userId");
	            Query q = getSession().createQuery("from OrderDetails where sellerid= :userId");
	            q.setParameter("userId", userId);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollbackTransaction();
	            throw new EbookstoreException("Could not list the genres", e);
	        }
	    }
	
          
	  
	  public List listOrders() throws EbookstoreException {
	        try {
	            beginTransaction();
	            Query q = getSession().createQuery("from OrderDetails");
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollbackTransaction();
	            throw new EbookstoreException("Could not list the order details! Try again.", e);
	        }
	    }
          
           public List<OrderDetails> listOrderDetailsByOId(long orderId) throws EbookstoreException {
	        try {
	            beginTransaction();
	            Query q = getSession().createQuery("from OrderDetails where orderId=:oid");
                    q.setParameter("oid",orderId);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollbackTransaction();
	            throw new EbookstoreException("Could not list the order details! Try again.", e);
	        }
	    }

    public List<OrderDetails> listOrderDetailsByODetailId(long orderId, long orderDetailId) 
    throws EbookstoreException
    {
       try {
	            beginTransaction();
	            Query q = getSession().createQuery("from OrderDetails where orderId=:oid AND orderDetailId=:odid");
                    q.setParameter("oid",orderId);
                    q.setParameter("odid",orderDetailId);
	            List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollbackTransaction();
	            throw new EbookstoreException("Could not list the order details! Try again.", e);
	        }}

    public String markComplete(String odid)
        throws EbookstoreException
    {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            Query q = getSession().createQuery("Update OrderDetails set status=:approve where orderDetailId=:odid");
            q.setParameter("approve", "Complete");
            long id = Long.parseLong(odid);
            q.setParameter("odid", id);
             q.executeUpdate();
            //Seller customer = (Seller) q.uniqueResult();
            commit();
            return "Order updated successfully";
        } catch (HibernateException e) {
            rollbackTransaction();
            //throw new EbookstoreException("No such user named" + username + "exists!", e);
            System.out.println("markComplete exception");
        }
        return "Error occured in Mark COmplete";
    }

    public void update(OrderDetails od) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       getSession().update(od);
        System.out.println("order details updated");
    }

    public String markCancel(String odid) 
        throws EbookstoreException
    {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            Query q = getSession().createQuery("Update OrderDetails set status=:approve where orderDetailId=:odid");
            q.setParameter("approve", "Cancelled");
            long id = Long.parseLong(odid);
            q.setParameter("odid", id);
             q.executeUpdate();
            //Seller customer = (Seller) q.uniqueResult();
            commit();
            return "Order updated successfully";
        } catch (HibernateException e) {
            rollbackTransaction();
            //throw new EbookstoreException("No such user named" + username + "exists!", e);
            System.out.println("markCancel exception");
        }
        return "Error occured in Mark Cancel";
    }
}
