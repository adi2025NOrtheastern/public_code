package com.aditicompany.Controller;

import com.aditicompany.DAO.BookDao;
import com.aditicompany.DAO.GenreDao;
import com.aditicompany.DAO.LoginDao;
import com.aditicompany.Helper.Validation;
import com.aditicompany.pojo.Admin;
import com.aditicompany.pojo.Book;
import com.aditicompany.pojo.Buyer;
import com.aditicompany.pojo.Seller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aditi
 */
@Controller
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @Autowired
    Validation validation;

    @Autowired
    BookDao bookDao;
    
    @Autowired
    GenreDao genreDao;

    @RequestMapping(value = "/login.htm", method = RequestMethod.POST)
    protected ModelAndView handleRequestInternalPOST(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = handleRequestInternal(request,
                response);

        return mv;
    }

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        //Validation validation = new Validation();
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        if (option == null || option == "") {
            mv = new ModelAndView("login");
            return mv;
        } else if (option.equals("login")) {
            String role = request.getParameter("role") == null ? "none" : request.getParameter("role");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //LoginDao loginDao = new LoginDao();
            if (role.equals("admin")) {
                ArrayList<Admin> admin = loginDao.getAdminLoginDetails(username, password);
                if (admin.size() > 0) {
                    request.getSession().setAttribute("user", admin.get(0));
                    request.getSession().setAttribute("role", "admin");

                    //com.aditicompany.DAO.GenreDao genreDao = new com.aditicompany.DAO.GenreDao();
                    java.util.List genreList = genreDao.listGenre(); //previously was genre.list()
                    request.getSession().setAttribute("genres", genreList);

                    mv = new ModelAndView("admin-home", "role", admin.get(0));
                    return mv;
                } else {
                    mv = new ModelAndView("login");
                    mv.addObject("error", "User or Password is Invalid. Kindly Register if you don't have an account!");
                    return mv;
                }
            } else if (role.equals("seller")) {
                ArrayList<Seller> seller = loginDao.getSellerLoginDetails(username, password);
                if (seller.size() > 0) {
                    request.getSession().setAttribute("user", seller.get(0));
                    request.getSession().setAttribute("userid", seller.get(0).getSellerId());
                    request.getSession().setAttribute("role", "seller");

                    //com.aditicompany.DAO.GenreDao genreDao = new com.aditicompany.DAO.GenreDao();
                    java.util.List genreList = genreDao.listGenre();
                    request.getSession().setAttribute("genres", genreList);
                    mv = new ModelAndView("seller-home", "role", seller.get(0));
                    return mv;
                } else {
                    mv = new ModelAndView("login");
                    mv.addObject("error", "User or Password is Invalid. Kindly Register if you don't have an account!");
                    return mv;
                }
            } else if (role.equals("buyer")) {
                ArrayList<Buyer> user = loginDao.getBuyerLoginDetails(username, password);
                if (user.size() > 0) {
                    request.getSession().setAttribute("user", user.get(0));
                    request.getSession().setAttribute("userid", user.get(0).getBuyerId());
                    request.getSession().setAttribute("role", "buyer");

                    List<Book> bookList = bookDao.getBooksToSell();
                    request.getSession().setAttribute("bookList", bookList);

                   // com.aditicompany.DAO.GenreDao genreDao = new com.aditicompany.DAO.GenreDao();
                    java.util.List genreList = genreDao.listGenre();
                    request.getSession().setAttribute("genreList", genreList);

                    mv = new ModelAndView("buyer-home", "role", user.get(0));
                    return mv;
                } else {
                    mv = new ModelAndView("login");
                    mv.addObject("error", "User or Password is Invalid. Kindly Register if you don't have an account!");
                    return mv;
                }

            } else {
                mv = new ModelAndView("login");
                mv.addObject("error", "Please specify a role!");
                return mv;
            }
        } else if (option.equals("logout")) {
            if (request.getSession().getAttribute("user") == null) {
                mv = new ModelAndView("login");
                return mv;
            }
            request.getSession().invalidate();
            mv = new ModelAndView("login");
            return mv;
        }

        return mv;
    }

    @RequestMapping(value = "/logout-user.htm", method = RequestMethod.GET)
    protected ModelAndView handleLogoutReq(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;

        String option = request.getParameter("option");
        if (option.equals("logout")) {
            //if no user was there
            if (request.getSession().getAttribute("user") == null) {
                mv = new ModelAndView("login");

                return mv;
            }
            request.getSession().invalidate();
            mv = new ModelAndView("login");
            return mv;
        }

        return mv;
    }

}
