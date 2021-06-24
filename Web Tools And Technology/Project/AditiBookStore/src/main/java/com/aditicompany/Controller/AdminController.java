/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Controller;

import com.aditicompany.DAO.BuyerDao;
import com.aditicompany.DAO.GenreDao;
import com.aditicompany.DAO.SellerDao;
import com.aditicompany.Helper.EmailClass;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.Validator.GenreValidator;
import com.aditicompany.pojo.Admin;
import com.aditicompany.pojo.Book;
import com.aditicompany.pojo.Genre;
import com.aditicompany.pojo.Seller;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aditi
 */
@Controller
//@RequestMapping("approve-single-seller")
public class AdminController {

//    @RequestMapping(value = "/add-genre.htm", method = RequestMethod.POST)
//    protected String addGenreSubmitAction(@ModelAttribute("genre") Genre genre, BindingResult result, SessionStatus status, HttpServletRequest request) throws Exception {
//
//    }
    @Autowired
    @Qualifier("genreValidator")
    GenreValidator genreValidator;

    @Autowired
    GenreDao genreDao;

    @Autowired
    SellerDao sellerDao;

    @Autowired
    BuyerDao buyerDao;

    List<Genre> gen = null;

    List<Seller> sell = null;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(genreValidator);
    }

    @RequestMapping(value = "/add-genre.htm", method = RequestMethod.POST)
    protected String addGenreSubmitAction(@ModelAttribute("genre") Genre genre, BindingResult result, HttpServletRequest request) throws Exception {

        
        genreValidator.validate(genre, result);
        if (result.hasErrors()) {
            request.setAttribute("genreList", gen);
            return "add-genre";
        }

        try {
            //GenreDao genreDao = new GenreDao();

            genreDao.create(genre.getGenreName());

        } catch (EbookstoreException e) {
            System.out.println(e.getMessage());
        }
        return "addGenreSuccess";
    }

    @RequestMapping(value = "/redirect-add-genre.htm", method = RequestMethod.GET)
    public ModelAndView initializeGenreForm(Model model, Genre genre, HttpServletRequest request) {

        
        //ModelAndView mv = null;
        try {
            gen = genreDao.listGenre();
        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("intitialize form add genre: " + genre);
        //request.setAttribute("genreList", gen);

        return new ModelAndView("add-genre", "genreList", gen);

//"add-genre";
    }

    @RequestMapping(value = "/redirect-approve-seller.htm", method = RequestMethod.GET)
    public ModelAndView getNewSellerListForm(Model model, HttpServletRequest request) {

        
        //ModelAndView mv = null;
        try {
            sell = sellerDao.listNewSellerApprove();
        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("sending seller list to approve");
        //request.setAttribute("genreList", gen);

        return new ModelAndView("approve-seller", "sellerList", sell);

//"add-genre";
    }

    //approve-single-seller-go.htm
    @RequestMapping(value = "/approve-single-seller-go.htm", method = RequestMethod.POST)
    public ModelAndView approveNewSellerRequest(HttpServletRequest request) {

        String msg = "Some error occured!";
        try {

            
            Seller seller = null;

            String username = request.getParameter("username");
            //ModelAndView mv = null;
            try {
                seller = sellerDao.get(username);

                //check if seller approval status is
                if (seller.getApprove().equals("No")) {
                    //approve it
                    msg = sellerDao.approveSeller(username);
                }

            } catch (EbookstoreException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Seller found, and approved seller: " + seller.getUsername());
            //request.setAttribute("genreList", gen);

            //send email approval
           
            String subject = "Aditi Book Store : Seller Approval";
            EmailClass.sendEmailMessage(seller.getEmailID(), "Congrats, you are approved as Seller!  :-)", subject);

        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        return new ModelAndView("approve-single-seller-success", "msg", msg);
    }

    //view-all-sellers.htm
    @RequestMapping(value = "/view-all-sellers.htm", method = RequestMethod.GET)
    public ModelAndView viewAllSellers(Model model,
            HttpServletRequest request) {

        
        //ModelAndView mv = null;
        try {
            sell = sellerDao.listSellers();
        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("sending all seller list");
        //request.setAttribute("genreList", gen);

        return new ModelAndView("view-all-sellers", "sellerList", sell);

//"add-genre";
    }

    //view-all-buyers.htm
    @RequestMapping(value = "/view-all-buyers.htm", method = RequestMethod.GET)
    public ModelAndView viewAllBuyers(Model model,
            HttpServletRequest request) {

        
        //ModelAndView mv = null;
        try {
            sell = buyerDao.listCustomers();
        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("sending all buyer list");
        //request.setAttribute("genreList", gen);

        return new ModelAndView("view-all-buyers", "buyerList", sell);

//"add-genre";
    }

    //view-dashboard.htm?option=view
    @RequestMapping(value = "/view-dashboard.htm", method = RequestMethod.GET)
    public ModelAndView viewDashboard(Model model,
            HttpServletRequest request) {

       
        //ModelAndView mv = null;

        //request.setAttribute("genreList", gen);
        return new ModelAndView("view-dashboard");

//"add-genre";
    }

    @GetMapping(value = "/redirect-update-genre.htm")
    protected ModelAndView getGenreUpdatePage(HttpServletRequest request, HttpServletResponse response) throws Exception {

       

        //ModelAndView mv = null;
        try {
            gen = genreDao.listGenre();
        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // System.out.println("intitialize form add genre: " + genre);
        //request.setAttribute("genreList", gen);

        return new ModelAndView("update-genre", "genreList", gen);
    }

    @PostMapping(value = "/update-genre.htm")
    protected ModelAndView updateGenre(HttpServletRequest request, HttpServletResponse response) throws Exception {

        

        long genreId = Long.parseLong(request.getParameter("genreSelected"));
        String newName = request.getParameter("genreName");
        Genre genre = genreDao.getById(genreId);
        List<Genre> genList = genreDao.listGenre();

        for (Genre g : genList) {
            if (g.getGenreName().equalsIgnoreCase(newName)) {

                request.setAttribute("genreList", genList);
                return new ModelAndView("update-genre", "msg", "This Genre already exists!");
            }
        }

       
        try {
            //GenreDao genreDao = new GenreDao();

            genre.setGenreName(newName);
            genreDao.update(genre);

        } catch (EbookstoreException e) {
            System.out.println(e.getMessage());
        }
        return new ModelAndView("addGenreSuccess","msg","success");
    }
}
