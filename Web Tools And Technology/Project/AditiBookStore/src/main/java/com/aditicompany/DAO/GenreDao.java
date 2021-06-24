/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Genre;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author aditi
 */
public class GenreDao extends DAO {

    public Genre get(String genreName) throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Genre where genreName= :genreName");
            q.setParameter("genreName", genreName);
            // q.setCacheable(true);
            Genre genre = (Genre) q.uniqueResult();
            commit();
            return genre;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not obtain the named genre " + genreName + " " + e.getMessage());
        }
    }

//    public List list() throws EbookstoreException {
//        try {
//            beginTransaction();
//            Query q = getSession().createQuery("from Genre");
//            List list = q.list();
//            //  q.setCacheable(true);
//            commit();
//            return list;
//        } catch (HibernateException e) {
//            rollbackTransaction();
//            throw new EbookstoreException("Could not list the genres", e);
//        }
//    }

    public List<Genre> listGenre() throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Genre");
            List list = q.list();
            // q.setCacheable(true);
            commit();
            return list;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not list the genres", e);
        }
    }

    public Genre create(String genreName) throws EbookstoreException {
        try {
            beginTransaction();
            Genre genre = new Genre(genreName);
            getSession().save(genre);
            commit();
            return null;
        } catch (HibernateException e) {
            rollbackTransaction();
            //throw new AdException("Could not create the category", e);
            throw new EbookstoreException("Exception while creating genre: " + e.getMessage());
        }
    }

    public void save(Genre genre) throws EbookstoreException {
        try {
            beginTransaction();
            getSession().update(genre);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not save the genre", e);
        }
    }

    public void delete(Genre genre) throws EbookstoreException {
        try {
            beginTransaction();
            getSession().delete(genre);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not delete the genre", e);
        }
    }
    
    
    
    public void update(Genre genre) throws EbookstoreException {
        try {
            beginTransaction();
            getSession().update(genre);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not delete the genre", e);
        }
    }
    
    
     public Genre getById(long genreId) throws EbookstoreException {
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Genre where genreId= :genreId");
            q.setParameter("genreId", genreId);
            // q.setCacheable(true);
            Genre genre = (Genre) q.uniqueResult();
            commit();
            return genre;
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not obtain the named genre genreId" + genreId + " " + e.getMessage());
        }
    }
}
