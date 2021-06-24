/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Controller;

import com.aditicompany.DAO.SellerDao;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Admin;
import com.aditicompany.pojo.Genre;
import com.aditicompany.pojo.Seller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aditi
 */

@Controller
//@RequestMapping("approve-single-seller.htm")
public class ApproveCOntroller {
    
    
    @Autowired
    SellerDao sellerDao;   

    List<Seller> sell = null;
    
    //@ResponseBody//(value = "approve-single-seller.htm", method = RequestMethod.GET)
    @RequestMapping(value = "/approve-single-seller*.htm", method = RequestMethod.GET)
    public ModelAndView getApproveSellerForm(Model model,
            HttpServletRequest request, @RequestParam("username") String username) {

//        if(request.getSession()==null)
//        {
//            return new ModelAndView("login");
//        }
//        Admin by= (Admin)request.getSession().getAttribute("user");
//        if(by==null)
//        {
//            return new ModelAndView("login");
//        }
        
        Seller seller = null;
        String username1 = request.getParameter("username");
        System.out.println("username1: "+username1);
        System.out.println("username: "+username );
        //ModelAndView mv = null;
        try {
            seller = sellerDao.get(username);
        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Seller found, sedning seller: " + seller.getUsername());
        //request.setAttribute("genreList", gen);

        return new ModelAndView("approve-single-seller", "seller", seller);

//"add-genre";
    }
}
