/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Book;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aditi
 */
public class BookDao extends DAO {

    public Book create(String isbn, String title, String author, String genre_name, long genreID, float price, String description, long sellerId, String photoName)
            throws EbookstoreException {
        try {
            beginTransaction();
            Book book = new Book(isbn, title, author, genre_name, genreID, price, description, sellerId);
            book.setPhotoName(photoName);
            getSession().save(book);
            commit();
            close();
            return book;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Exception while creating book: " + e.getMessage());
        }
    }

    public String edit(String isbn, String title, String author, String genre_name, long genreID, float price, String description, long sellerId, long bookId)
            throws EbookstoreException {
        try {
            beginTransaction();
            Query qry = getSession().createQuery("Update table Book b set  b.title=:title, b.author=:author, b.genreId=:genreId, b.price=: price, b.description=: description where b.bookId= :value");
            // qry.setCacheable(true);
            //qry.setParameter("isbn", isbn);
            qry.setParameter("title", title);
            qry.setParameter("author", author);
            qry.setParameter("genreID", genreID);
            qry.setParameter("price", price);
            qry.setParameter("description", description);
            //qry.setParameter("value", bookId);

            qry.setParameter("value", bookId);

            qry.executeUpdate();

            System.out.println("successfully updated bookid: " + bookId);
            commit();
            close();
            return "successfully updated";
        } catch (Exception e) {
            rollbackTransaction();
            //throw new EbookstoreException("Exception while editing book: " + e.getMessage());
            System.out.println(e);
            //return "error";
        }
        return "error";
    }

    public void delete(Book book)
            throws EbookstoreException {
        try {
            beginTransaction();
            getSession().delete(book);
            commit();
            close();
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
            close();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books", e);
        }
    }

    public List<Book> searchBook(String key, String flag) throws EbookstoreException {
        try {
            beginTransaction();

            Query qry = getSession().createQuery("From Book b where b." + flag + "= :value");
            // qry.setCacheable(true);
            qry.setParameter("value", key);
            List<Book> list = new ArrayList<Book>();
            list = qry.list();
            commit();
            close();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books", e);
        }
    }

    public List<Book> listBook() throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Book");
            //q.setCacheable(true);
            List list = q.list();

            System.out.println("in listBook() bookDao class");

            commit();
            close();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            System.out.println(e);
            throw new EbookstoreException("Could not list the books", e);

        }
    }

    public List<Book> getBooksToSell() throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Book where sold=:option");
            //q.setCacheable(true);
            q.setParameter("option", "No");
            List list = q.list();

            commit();
            close();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books", e);
        }
    }

    public List<Book> getSellerBooks(long id) throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Book where sellerId=:id");
            //q.setCacheable(true);
            q.setParameter("id", id);
            List list = q.list();

            commit();
            close();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not find the list of books of seller", e);
        }
    }

    public Book getBookById(long id) throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Book where bookID= :id");
            q.setParameter("id", id);
            Book book = (Book) q.uniqueResult();
            // getSession().save(book);
            commit();
            close();
            return book;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not get book!", e);
        }

    }

    public String searchBookByIntial(String initial, String searchBy)
            throws EbookstoreException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            //if genre
            Query q;
            if (searchBy.equals("genre")) {
                q = getSession().createQuery("Select distinct title from Book");

                //name of genre like mathss, english
                // q.setParameter("id", genreId);
            } else {
                q = getSession().createQuery("Select distinct " + searchBy + " from Book where " + searchBy + " like :id");
                q.setParameter("id", "%" + initial + "%");
            }
            //q.setCacheable(true);
            // q.setParameter("searchBy", searchBy);
            System.out.println("id=" + initial);
            //q.setParameter("id", "%" + initial + "%");
            List list = q.list();

            commit();
            close();
            System.out.println("tiles:- " + list);
            return list.toString();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books titles", e);
        }

    }

    //searchBookByGenrID
    public String searchBookByGenrID(String initial, String searchBy, long genreId)
            throws EbookstoreException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            //if genre
            Query q = null;
            if (searchBy.equals("genre") && initial.trim().equals("")) {
                q = getSession().createQuery("Select distinct title from Book where genreId like :id");

                //name of genre like mathss, english
                q.setParameter("id", genreId);
            } else if (searchBy.equals("genre") && !initial.trim().equals("")) {
                q = getSession().createQuery("Select distinct title from Book where genreId like :id and title like :name");
                q.setParameter("name", "%" + initial + "%");
                q.setParameter("id", genreId);

            }
            //q.setCacheable(true);
            // q.setParameter("searchBy", searchBy);
            System.out.println("id=" + initial);
            System.out.println("searchBy" + searchBy);
            System.out.println("genreID" + genreId);
            //q.setParameter("id", "%" + initial + "%");
            List list = q.list();

            commit();
            close();
            System.out.println("tiles:- " + list);
            return list.toString();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books titles", e);
        }

    }

    public List<Book> getByParameter(String searchBy, String name) throws EbookstoreException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            Query q = getSession().createQuery(" from Book where " + searchBy + "= :name");
            //q.setCacheable(true);
            // q.setParameter("searchBy", searchBy);
            q.setParameter("name", name);

            System.out.println("searchBy" + searchBy);
            System.out.println("name" + name);
            System.out.println("in getByParameter");
            List list = q.list();

            commit();
            close();
            //     System.out.println("tiles:- "+ list);
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            //throw new EbookstoreException("Could not list the books titles", e);
            System.out.println("ex" + e);
        }
        //return null;
        return null;

    }

    public List<Book> getByGenre(String searchBy) throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery(" from Book where genreId= :id");
            //q.setCacheable(true);
            // q.setParameter("searchBy", searchBy);
            q.setParameter("id", Long.parseLong(searchBy));
            List list = q.list();

            commit();
            close();
            //     System.out.println("tiles:- "+ list);
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            //throw new EbookstoreException("Could not list the books titles", e);
            System.out.println("ex" + e);
        }
        //return null;
        return null;
    }

    //on submit
    public List<Book> listBookByGenrID(String initial, String searchBy, long genreId)
            throws EbookstoreException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            beginTransaction();
            //if genre
            Query q = null;
            if (searchBy.equals("genre") && initial.trim().equals("")) {
                q = getSession().createQuery("from Book where genreId like :id");

                //name of genre like mathss, english
                q.setParameter("id", genreId);
            } else if (searchBy.equals("genre") && !initial.trim().equals("")) {
                q = getSession().createQuery("from Book where genreId like :id and title like :name");
                q.setParameter("name", "%" + initial + "%");
                q.setParameter("id", genreId);

            }
            //q.setCacheable(true);
            // q.setParameter("searchBy", searchBy);
            System.out.println("id=" + initial);
            System.out.println("searchBy" + searchBy);
            System.out.println("genreID" + genreId);
            //q.setParameter("id", "%" + initial + "%");
            List list = q.list();

            commit();
            close();
            //System.out.println("tiles:- " + list);
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books titles", e);
        }

    }

    public List<Book> getBooksToSellLimit(int limit, int offset) throws EbookstoreException {

        try {
            beginTransaction();
            Query q = getSession().createQuery("from Book where sold=:option");
            //q.setCacheable(true);
            q.setParameter("option", "No");
            q.setMaxResults(limit);
            q.setFirstResult(offset);
            List list = q.list();

            System.out.println("list"+ list);
            System.out.println("sending book by limit and offset"+limit+","+offset);
            commit();
            close();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the books", e);
        }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(Book book1)  throws EbookstoreException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            beginTransaction();
            Query q = getSession().createQuery("Update Book set sold=:option where bookId=:id");
            //q.setCacheable(true);
            q.setParameter("option", "No");
            q.setParameter("id", book1.getBookId());
           
            int res = q.executeUpdate();

            commit();
            close();
            return res;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not update the books", e);
        }
    }
    
    
    public int updateSold(Book book1)  throws EbookstoreException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            beginTransaction();
            Query q = getSession().createQuery("Update Book set sold=:option where bookId=:id");
            //q.setCacheable(true);
            q.setParameter("option", "Yes");
            q.setParameter("id", book1.getBookId());
           
            int res = q.executeUpdate();

            commit();
            close();
            return res;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not update the books", e);
        }
    }

    public void updateDetails(Book oldBook) throws EbookstoreException{
       
        try{
            beginTransaction();
            Query q = getSession().createQuery("Update Book set author=:author, description=:desc, genreId=:gId, price=:price,title=:title where bookId=:id");
            //q.setCacheable(true);
            q.setParameter("author", oldBook.getAuthor());
            q.setParameter("desc", oldBook.getDescription());
            q.setParameter("gId", oldBook.getGenreId());
             q.setParameter("title", oldBook.getTitle());
             q.setParameter("price", oldBook.getPrice());
            q.setParameter("id", oldBook.getBookId());
           
            int res = q.executeUpdate();

            commit();
            close();
            //return res;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not update the books", e);
        }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
