/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import static com.aditicompany.DAO.DAO.getSession;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Genre;
import com.aditicompany.pojo.Orders;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aditi
 */
public class OrdersDao extends DAO {

    public List<Orders> getOrderBySellerId(long sellerId) throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from OrderDetails where sellerId= :id");
            long id = sellerId;//Long.parseLong(sellerId);
            q.setParameter("id", id);
            // q.setCacheable(true);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not obtain the list for seller id= " + sellerId + " " + e.getMessage());
        }
    }

    public List<Orders> getOrderByBuyerId(long buyerId) throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Orders where buyerId= :id");
            long id = buyerId;//Long.parseLong(sellerId);
            q.setParameter("id", id);
            // q.setCacheable(true);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not obtain the list for seller id= " + buyerId + " " + e.getMessage());
        }
    }

    public Orders create(Orders orders) throws EbookstoreException {
        try {
            beginTransaction();
            //Orders orders = new Orders(customerId);	
            getSession().save(orders);
            commit();
            return null;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Orders table cannot be created", e);
        }

    }

    public String getStatus(long orderId) throws EbookstoreException  {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            //Orders orders = new Orders(customerId);	
            //getSession().save(orders);
            Query q = getSession().createQuery("Select status from Orders where orderId= :id");
            //long id = buyerId;//Long.parseLong(sellerId);
            q.setParameter("id", orderId);
            // q.setCacheable(true);
              String status = (String) q.uniqueResult();
            
           
            commit();
            return status;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Orders table cannot be created", e);
        }
    }
}
