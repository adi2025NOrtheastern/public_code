/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import static com.aditicompany.DAO.DAO.getSession;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Book;
import com.aditicompany.pojo.Message;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aditi
 */
public class MessageDao extends DAO {

    public Message addMessage(long bookId, long sellerId, long buyerId, String message)
            throws EbookstoreException {
        Message msg;
        try {
            beginTransaction();
            msg = new Message();
            msg.setBookId(bookId);
            msg.setBuyerId(buyerId);
            msg.setSellerId(sellerId);
            msg.setMessage(message);
            getSession().save(msg);
            commit();
            //return book;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Exception while creating msg: " + e.getMessage());
        }
        return msg;
    }

    public void delete(Book book)
            throws EbookstoreException {
        try {
            beginTransaction();
            getSession().delete(book);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not delete book", e);
        }
    }

    public List list() throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Book");
            //  q.setCacheable(true);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books", e);
        }
    }

    public List<Message> getMessageList(long id, long buyerid)
            throws EbookstoreException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Message where buyerId=:buyerId and bookId=:bookId order by bookId,buyerId");
            //  q.setCacheable(true);
            q.setParameter("buyerId", buyerid);
            q.setParameter("bookId", id);

            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books", e);
        }
    }

    public List<Message> getSellerMsgs(Long sellerId)  throws EbookstoreException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Message where sellerId=:sellerId order by bookId");
            //  q.setCacheable(true);
            q.setParameter("sellerId", sellerId);
            //q.setParameter("bookId", id);

            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books", e);
        }
    }

}
