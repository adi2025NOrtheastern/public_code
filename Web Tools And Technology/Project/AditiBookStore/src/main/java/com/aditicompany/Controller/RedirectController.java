/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Controller;

import com.aditicompany.pojo.Book;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aditi
 */
@Controller
public class RedirectController {
       
     
    @RequestMapping(value = "/redirect-admin-home.htm")
    protected ModelAndView getAdminHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        ModelAndView mv = null;
        if(request.getSession().getAttribute("user") == null){
            mv = new ModelAndView("login");
            return mv;
        }
        mv = new ModelAndView("admin-home");
        return mv;
    }
    
    @RequestMapping(value = "/redirect-seller-home.htm")
    protected ModelAndView getSellerHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = null;
        if(request.getSession().getAttribute("user") == null){
            mv = new ModelAndView("login");
            return mv;
        }
        mv = new ModelAndView("seller-home");
        return mv;
    }
    
    @RequestMapping(value = "/redirect-buyer-home.htm")
    protected ModelAndView getBuyerHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = null;
        if(request.getSession().getAttribute("user") == null){
            mv = new ModelAndView("login");
            return mv;
        }
        mv = new ModelAndView("buyer-home");
        return mv;
    }
    
    
    
//    @RequestMapping(value = "/redirect-add-genre.htm")
//    protected ModelAndView addGenrePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
//        ModelAndView mv = null;
//        if(request.getSession().getAttribute("user") == null){
//            mv = new ModelAndView("login");
//            return mv;
//        }
//        mv = new ModelAndView("add-genre");
//        return mv;
//    }
//    
    
    
//    //redirect-add-book.htm
//    @RequestMapping(value = "/redirect-add-book.htm")
//    protected ModelAndView getSellerAddBookPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
//        ModelAndView mv = null;
//        if(request.getSession().getAttribute("user") == null){
//            mv = new ModelAndView("login");
//            return mv;
//        }
//        
//        
//      //  mv.addAttribute("book", new Book());
//        mv = new ModelAndView("add-book");
//        return mv;
//    }
    
    
    
    //redirect-my-profile.htm
    
    @RequestMapping(value = "/redirect-my-profile.htm")
    protected ModelAndView getProfilePage(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = null;
        if(request.getSession().getAttribute("user") == null){
            mv = new ModelAndView("login");
            return mv;
        }
        mv = new ModelAndView("update-my-profile");
        return mv;
    }
    
    
 
    
    
}
