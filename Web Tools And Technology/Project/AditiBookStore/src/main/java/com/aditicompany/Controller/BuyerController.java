/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Controller;

import com.aditicompany.DAO.BookDao;
import com.aditicompany.DAO.GenreDao;
import com.aditicompany.DAO.MessageDao;
import com.aditicompany.DAO.OrdersDao;
import com.aditicompany.DAO.OrdersDetailsDao;
import com.aditicompany.DAO.SellerDao;
import com.aditicompany.Helper.EmailClass;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.PDFViewShow.PdfReportView;
import com.aditicompany.Validator.BookValidator;
import com.aditicompany.pojo.Admin;
import com.aditicompany.pojo.Book;
import com.aditicompany.pojo.Buyer;
import com.aditicompany.pojo.Genre;
import com.aditicompany.pojo.Message;
import com.aditicompany.pojo.OrderDetails;
import com.aditicompany.pojo.Orders;
import com.aditicompany.pojo.Seller;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.mail.*;
import org.springframework.web.servlet.View;

/**
 *
 * @author aditi
 */
@Controller
public class BuyerController {

    @Autowired
    //@Qualifier("bookValidator")
    BookValidator bookValidator;

    @Autowired
    GenreDao genreDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    SellerDao sellerDao;

    @Autowired
    OrdersDao orderDao;

    @Autowired
    OrdersDetailsDao orderDetailsDao;

    @Autowired
    MessageDao messageDao;

   
    //@RequestMapping(value = "/redirect-add-book*.htm", method = RequestMethod.GET)
    public String initializeForm(Model model, Book book, HttpServletRequest request) {
        try {
            //check if selller is approved or not
            String username = request.getParameter("username");
            Seller seller = sellerDao.get(username);

            if (seller.getApprove().equals("Yes")) {
                System.out.println("intitialize form book: " + book);
                return "add-book";
            } else {
                request.setAttribute("msg", "Sorry, Your approval request is pending, please wait as you can not add book till approvel");
                return "seller-home";
            }
        } catch (EbookstoreException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex: " + ex);
        }
        return null;
    }

    // @RequestMapping(value = "/redirect-view-cart.htm", method = RequestMethod.GET)
    public String initializeForm2(Model model) {
        //System.out.println("intitialize form book: " + book);
        return "display-cart";
    }

    //redirect-view-orders.htm -- to view all buyer order of specific buyer
    @RequestMapping(value = "/redirect-view-my-orders.htm", method = RequestMethod.GET)
    public String getViewOrderForm(Model model, HttpServletRequest request) {

        
        Buyer buyer = (Buyer) request.getSession().getAttribute("user");
        try {
            // System.out.println("intitialize form book: "+ book);
            //get list of orders

            List<Orders> orderList = orderDao.getOrderByBuyerId(buyer.getBuyerId());

            request.setAttribute("orderList", orderList);
            if (orderList == null || orderList.isEmpty()) {
                request.setAttribute("msg", "No order yet!");
            }
            return "view-my-orders";
        } catch (EbookstoreException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex: " + ex);
        }

        return null;
    }

    //redirect-buy-book.htm used when buyer clicks on buy a book
    @RequestMapping(value = "/redirect-buy-book.htm", method = RequestMethod.GET)
    public String getAllBooksToSell(Model model, HttpServletRequest request) {
        

        try {
            //Seller seller = (Seller) request.getSession().getAttribute("user");

            System.out.println("in redirect-buy-book");
            List<Book> bookList =null;
            if(request.getParameter("limit") != null && request.getParameter("offset") !=null)
            {
                System.out.println("inside limit and offset not null");
            int limit = Integer.parseInt(request.getParameter("limit"));
            int offset = Integer.parseInt(request.getParameter("offset"));
            bookList =  bookDao.getBooksToSellLimit(limit,offset);
            }
            else{
            bookList = bookDao.getBooksToSell();
            }
            //List<Genre> genreList = genreDao.listGenre();
            request.setAttribute("searchBookList", bookList);
            request.setAttribute("bookList", bookList);
            return "display-books";
        } catch (Exception ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex: " + ex);
        }

        return null;
    }

    //method to place order, create new order, add each book as order details from cart
    @RequestMapping(value = "/place-my-order.htm", method = RequestMethod.POST)
    protected ModelAndView doSubmitAction(@ModelAttribute("orders") Orders orders, HttpServletRequest request, OrderDetails od) throws Exception {
        

        HttpSession session = request.getSession();

        Buyer buyer = (Buyer) session.getAttribute("user");

        String total = request.getParameter("total");
        long userId = buyer.getBuyerId();
        ArrayList<Book> cart = (ArrayList<Book>) session.getAttribute("cart");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String orderDate = dateFormat.format(date);

        int count = 0;
        for (Book b : cart) {
            count++;
        }

        //OrdersDao ordersDao = new OrdersDao();
        orders.setOrderDate(orderDate);
        orders.setBuyerId(userId);
        orders.setTotal(total);
        //orders.setSellerId(sellerId);   //.setSellerId(sellerId);
        //because order can contain books from several sellers so save ion order details
        orders.setItemNumber(count);
        //orders.setStatus("New");
        orderDao.create(orders);

        for (Book b : cart) {
            //OrderDetails od = new OrderDetails();
            //OrderDetailsDao odDao = new OrderDetailsDao();

            b.setSold("Yes");
            bookDao.updateSold(b);
            od.setBookId(b.getBookId());
            od.setPrice(b.getPrice());
            od.setBookName(b.getTitle());
            od.setBookAuthor(b.getAuthor());
            od.setDate(orders.getOrderDate());
            od.setOrderId(orders.getOrderId());
            od.setBuyerId(orders.getBuyerId());
            od.setSellerId(b.getSellerId());
            od.setStatus("New");
            orderDetailsDao.create(od);
        }

        session.removeAttribute("cart");
        session.setAttribute("orderId", orders.getOrderId());
        
        session.removeAttribute("bookList");
        session.setAttribute("bookList", bookDao.getBooksToSell());


        String subject = "Aditi Book Store : Order Place";
        EmailClass.sendEmailMessage(buyer.getEmailID(), "Congrats, order place suuccess :-)", subject);

        ModelAndView mv = new ModelAndView("ordered-items");
        return mv;
    }

    //cart activities--->
    @RequestMapping(value = "/redirect-view-my-cart.htm", method = RequestMethod.GET)
    protected String doViewAction(HttpServletRequest request, HttpServletResponse response)
            throws EbookstoreException {
        

        HttpSession session = request.getSession();
        ArrayList<Book> cart;
        if (session != null && session.getAttribute("cart") != null) {
            cart = (ArrayList<Book>) session.getAttribute("cart");
            return "display-cart";
        } else {
            request.setAttribute("msg", "No items in cart yet!");
            return "display-cart";
        }

    }

    @RequestMapping(value = "/add-to-cart.htm", method = RequestMethod.GET)
    protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response)
            throws EbookstoreException {

       

        HttpSession session = request.getSession();

        ArrayList<Book> cart;
        if (session.getAttribute("cart") != null) {
            cart = (ArrayList<Book>) session.getAttribute("cart");
        } else {
            cart = new ArrayList<Book>();
        }
        long id = Long.parseLong(request.getParameter("id"));
        System.out.print("book to add id : " + id);
        //BookDao bookDao=new BookDao();
        Book book = bookDao.getBookById(id);
        cart.add(book);

        float total = 0;
        for (Book b : cart) {
            total = total + b.getPrice();
        }
        session.setAttribute("cart", cart);
        session.setAttribute("total", total);
        ModelAndView mv = new ModelAndView("display-cart", "cart", cart);
        request.setAttribute("msg", "Item added!");
        mv.addObject("total", total);
        //mv.setViewName("displayCart");
        return mv;
        //return "addedToCart";
    }

    @RequestMapping(value = "/remove-item.htm", method = RequestMethod.GET)
    protected ModelAndView doAction(@RequestParam("id") int id, HttpServletRequest request, HttpServletResponse response)
            throws EbookstoreException {
        

        HttpSession session = request.getSession();
        ArrayList<Book> value;

        String action = request.getParameter("removeitem");
        System.out.println("action:" + action);
        if (session.getAttribute("cart") != null) {
            value = (ArrayList<Book>) session.getAttribute("cart");
            System.out.println("Book to remove id: " + id);
            if(value.isEmpty())
            {
                 ModelAndView mv = new ModelAndView("display-cart");
                 return mv;
            }
            value.remove(id);

            float total = 0;
            for (Book b : value) {
                total = total + b.getPrice();
            }
            session.setAttribute("total", total);
            ModelAndView mv = new ModelAndView("display-cart");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("display-cart");
            return mv;
        }

    }

    //  view-book-details.htm
    @RequestMapping(value = "/view-book-details.htm", method = RequestMethod.GET)
    public String viewBookDetails(Model model, HttpServletRequest request) {
        
        try {

            //get book
            long bookId = (long) Long.parseLong(request.getParameter("id"));
            Book book = bookDao.getBookById(bookId);
            request.setAttribute("book", book);
            //getting msg list

            Buyer buyer = (Buyer) request.getSession().getAttribute("user");
            long buyerid = buyer.getBuyerId();
            //Crete msg list
            List<Message> msgList = messageDao.getMessageList(bookId, buyerid);

            //return msgObj;
            String messages = null;

            for (Message msg1 : msgList) {
                messages += " Message ID: " + msg1.getMsgId() + " Book ID: " + msg1.getBookId()
                        + " Buyer ID: " + msg1.getBuyerId()
                        + " Seller ID: " + msg1.getSellerId()
                        + " Message : " + msg1.getMessage() + "<br/>";
            }
            request.setAttribute("msgList", messages);

            return "view-book-details";
        } catch (Exception ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex: " + ex);
        }

        return null;
    }

    @RequestMapping(value = "/order-history.htm", method = RequestMethod.GET)
    protected ModelAndView viewOrderHistory(HttpServletRequest request) throws Exception {

        

        List odList = orderDetailsDao.listOrders();

        System.out.print("the od list says that :::: " + odList);

        ModelAndView mv = new ModelAndView("order-history", "od", odList);

        //pageContext.setAttribute("odList", odList);
        return mv;
    }

    //view-order-details.htm
    @RequestMapping(value = "/view-order-details.htm", method = RequestMethod.GET)
    protected ModelAndView viewOrderDetails(HttpServletRequest request) throws Exception {

       

        String username = request.getParameter("username");
        long orderId = Long.parseLong(request.getParameter("orderId"));

        List<OrderDetails> odList = orderDetailsDao.listOrderDetailsByOId(orderId);

        System.out.print("the od list : " + odList);

        ModelAndView mv = new ModelAndView("view-order-details", "odList", odList); //order-history 
        request.setAttribute("orderId", orderId);
        //String status = orderDao.getStatus(orderId);
        //request.setAttribute("status",status);

        //pageContext.setAttribute("odList", odList);
        return mv;
    }

    @RequestMapping(value = "/search.htm", method = RequestMethod.GET)
    public String getSearchOnlyBooks(Model model, HttpServletRequest request) {
        
        Buyer buyer = (Buyer) request.getSession().getAttribute("user");
        if (buyer == null) {
            return "login";
        }
        return "display-books";
    }

    //search.htm
    @RequestMapping(value = "/search.htm", method = RequestMethod.POST)
    public String getSearchBooks(Model model, HttpServletRequest request) {
        //check if selller is approved or not
        // String username = request.getParameter("username");

        System.out.println("in buyer contorller search.htm post");
        
        Buyer buyer = (Buyer) request.getSession().getAttribute("user");
        if (buyer == null) {
            return "login";
        }

        String searchBy = request.getParameter("search");

        String bookname = request.getParameter("bookName");

        String searchGenre = request.getParameter("searchGenre");

        System.out.println("searchGenre=" + searchGenre);

        System.out.println("bookname" + bookname);
        System.out.println("searchBy" + searchBy);
        //Buyer buyer = (Buyer) request.getSession().getAttribute("user");
        List<Book> bookList = null;
        try {
            if (searchBy.equals("genre")) {
                if (bookname == null || bookname.trim().equals("")) {
                    //if genre but no book name
                    System.out.println("inside genre and no book name");
                    bookList = bookDao.getByGenre(searchGenre);
                    request.setAttribute("searchBookList", bookList);
                    return "display-books";
                } else {
                    long id = Long.parseLong(searchGenre);
                    System.out.println("inside genre and book name");
                    bookList = bookDao.listBookByGenrID(bookname, searchBy, id);
                    request.setAttribute("searchBookList", bookList);
                    return "display-books";
                }
            }

            System.out.println("no genre");
            bookList = bookDao.getByParameter(searchBy, bookname);
        } catch (EbookstoreException ex) {
            Logger.getLogger(BuyerController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        request.setAttribute("searchBookList", bookList);
        return "display-books";

    }

    //view order pdf
    //@RequestMapping(value = "/report.pdf", method = RequestMethod.GET)
    @RequestMapping(value = "/report.pdf", method = RequestMethod.GET)
    protected View handleRequest() {
        View view = new PdfReportView();
        return view;
//        return new ModelAndView(view);
    }

    //redirect-buy-book.htm used when buyer clicks on buy a book
    @RequestMapping(value = "/redirect-admin-book.htm", method = RequestMethod.GET)
    public String getAllBooksAdmin(Model model, HttpServletRequest request) {
        
        Admin by = (Admin) request.getSession().getAttribute("user");
        if (by == null) {
            return ("login");
        }

        try {
            //Seller seller = (Seller) request.getSession().getAttribute("user");

            List<Book> bookList = bookDao.getBooksToSell();
            List<Genre> genreList = genreDao.listGenre();
            request.getSession().setAttribute("bookList", bookList);
            request.getSession().setAttribute("genreList", genreList);
            return "display-admin-books";
        } catch (Exception ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex: " + ex);
        }

        return null;
    }
    
    
    
    
    //cancel-order.htm

    
     @RequestMapping(value = "/cancel-order.htm", method = RequestMethod.GET)
    protected ModelAndView doCancelOrderAction(HttpServletRequest request) throws Exception {
        
        Buyer by = (Buyer) request.getSession().getAttribute("user");
        
        HttpSession session = request.getSession();

        Buyer buyer = (Buyer) session.getAttribute("user");

        long orderId = Long.parseLong(request.getParameter("orderId"));
        long userId = buyer.getBuyerId();
       
        //get orderd etails from orderdetails table and cancel the orderid

        List<OrderDetails> ordList = orderDetailsDao.listOrderDetailsByOId(orderId);

        for (OrderDetails od : ordList) {
            //OrderDetails od = new OrderDetails();
            //OrderDetailsDao odDao = new OrderDetailsDao();

            Book book1 = bookDao.getBookById(od.getBookId());
            book1.setSold("No");
            bookDao.update(book1);
           
            od.setDate(new Date().toString());
            
            od.setStatus("Cancelled");
            orderDetailsDao.update(od);
        }


        String subject = "Aditi Book Store : Order Cancel";
        EmailClass.sendEmailMessage(buyer.getEmailID(), "Congrats, order cancel suuccess :-)", subject);

        List<Orders> orderList = orderDao.getOrderByBuyerId(buyer.getBuyerId());

            request.setAttribute("orderList", orderList);
            if (orderList == null || orderList.isEmpty()) {
                request.setAttribute("msg", "No order yet!");
            }
           // return "view-my-orders";
           
        session.removeAttribute("bookList");
        session.setAttribute("bookList", bookDao.getBooksToSell());
         request.setAttribute("msgSuccess", "Cancel success");

        ModelAndView mv = new ModelAndView("view-my-orders");
        return mv;
    }

}


//session hhas all books, depending on criteria display books  -- no
