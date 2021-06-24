/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.DAO;

import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Admin;
import org.hibernate.HibernateException;

/**
 *
 * @author aditi
 */
public class AdminDao extends DAO {

    public AdminDao() {
    }

    public Admin create(String firstName, String lastName, String emailID, String roleName,
            String username, String password, int adminAge, Admin admin)
            throws EbookstoreException {
        try {
            beginTransaction();
            System.out.println("inside admin DAO");

            //Admin admin = new Admin(adminAge);
            admin.setFirstName(firstName);
            admin.setLastName(lastName);
            admin.setEmailID(emailID);
            admin.setRoleName(roleName);
            admin.setUsername(username);
            admin.setPassword(password);

            getSession().save(admin);

            commit();
            return admin;

        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Exception while creating admin: " + e.getMessage());
        }
    }

    public void delete(Admin admin)
            throws EbookstoreException {
        try {
            beginTransaction();
            getSession().delete(admin);
            commit();
        } catch (HibernateException e) {
            rollbackTransaction();
            throw new EbookstoreException("Could not delete admin " + admin.getFirstName(), e);
        }
    }
    
}
