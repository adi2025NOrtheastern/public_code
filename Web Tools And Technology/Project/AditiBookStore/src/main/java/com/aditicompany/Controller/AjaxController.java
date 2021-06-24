/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Controller;

import com.aditicompany.DAO.BookDao;
import com.aditicompany.DAO.MessageDao;
import com.aditicompany.DAO.OrdersDao;
import com.aditicompany.DAO.OrdersDetailsDao;
import com.aditicompany.DAO.SellerDao;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.pojo.Book;
import com.aditicompany.pojo.Message;
import com.aditicompany.pojo.Seller;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;

/**
 *
 * @author aditi
 */
//RestContoller = ResponseBody + COntroller
@RestController
public class AjaxController {

    @Autowired
    MessageDao messageDao;

    @Autowired
    SellerDao sellerDao;

    @Autowired
    OrdersDao orderDao;
    
    @Autowired
    BookDao bookDao;

    @Autowired
    OrdersDetailsDao orderDetailsDao;

    //  message-seller.htm --> message-seller.htm
    @RequestMapping(value = "/message-seller.htm", method = RequestMethod.GET)
    protected String messageSeller(HttpServletRequest request, HttpServletResponse response)
            throws EbookstoreException {

//        if(request.getSession()==null || (request.getSession().getAttribute("user")==null))
//        {
//            return  ("Please login");
//        }
        
        HttpSession session = request.getSession();

        System.out.println("in ajax controller");
        long id = Long.parseLong(request.getParameter("id"));

        long sellerid = Long.parseLong(request.getParameter("sId"));

        long buyerid = Long.parseLong(request.getParameter("bId"));

        String msg = request.getParameter("msg");
        System.out.print("Message----> book id : " + id);
        System.out.print("Message----> seller id : " + sellerid);
        System.out.print("Message----> buyer id : " + buyerid);
        //BookDao bookDao=new BookDao();
        Message msgObj = messageDao.addMessage(id, sellerid, buyerid, msg);

        //Crete msg list
        List<Message> msgList = messageDao.getMessageList(id, buyerid);

        //return msgObj;
        String messages = "";

        for (Message msg1 : msgList) {
            messages += " Message ID: " + msg1.getMsgId() + " Book ID: " + msg1.getBookId()
                    + " Buyer ID: " + msg1.getBuyerId()
                    + " Seller ID: " + msg1.getSellerId()
                    + " Message : " + msg1.getMessage() + "<br/>";
        }
//        return " Message ID: "+ msgObj.getMsgId() + " Book ID: "+ msgObj.getBookId()+
//                " Buyer ID: "+ msgObj.getBuyerId() +
//                " Seller ID: "+ msgObj.getSellerId() +
//                " Message : "+ msgObj.getMessage();

        return messages;
    }

    //mark-order-seller.htm
    @RequestMapping(value = "/mark-order-seller.htm", method = RequestMethod.POST)
    public String markOrderDetailComplete(HttpServletRequest request) {

//        if(request.getSession()==null || (request.getSession().getAttribute("user")==null))
//        {
//            return  ("Please login");
//        }
        Seller seller = (Seller) request.getSession().getAttribute("user");
        
        
        String msg = "Not complete, error occured!";
        //String username = //request.getParameter("username");
        String odid = request.getParameter("odid");
        //ModelAndView mv = null;
        try {
            seller = sellerDao.get(seller.getUsername());

            //check if seller approval status is 
            if (seller.getApprove().equals("Yes")) {
                //approve it
                //msg = sellerDao.approveSeller(username);
                //update order detail status
                msg = orderDetailsDao.markComplete(odid);
                // msg = "Completed Mark successfully";
            }

        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        System.out.println("Seller found, seller: " + seller.getUsername());
        //request.setAttribute("genreList", gen);

        return msg;//new ModelAndView("approve-single-seller-success", "msg", msg);

    }
    
    
    //mark-cancel-order-seller.htm
     @RequestMapping(value = "/mark-cancel-order-seller.htm", method = RequestMethod.POST)
    public String markOrderDetailCancel(HttpServletRequest request) {

//        if(request.getSession()==null || (request.getSession().getAttribute("user")==null))
//        {
//            return  ("Please login");
//        }
        Seller seller = (Seller) request.getSession().getAttribute("user");
        
        
        String msg = "Not cancel, error occured!";
        //String username = //request.getParameter("username");
        String odid = request.getParameter("odid");
        //ModelAndView mv = null;
        try {
            seller = sellerDao.get(seller.getUsername());

            //check if seller approval status is 
            if (seller.getApprove().equals("Yes")) {
                //approve it
                //msg = sellerDao.approveSeller(username);
                //update order detail status
                msg = orderDetailsDao.markCancel(odid);
                // msg = "Completed Mark successfully";
            }

        } catch (EbookstoreException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        System.out.println("Seller found, seller: " + seller.getUsername());
        //request.setAttribute("genreList", gen);

        return msg;//new ModelAndView("approve-single-seller-success", "msg", msg);

    }
    
    
    

    @RequestMapping(value = "/message-buyer.htm", method = RequestMethod.GET)
    protected String messageBuyer(HttpServletRequest request, HttpServletResponse response)
            throws EbookstoreException {
//
//        if(request.getSession()==null || (request.getSession().getAttribute("user")==null))
//        {
//            return  ("Please login");
//        }
        HttpSession session = request.getSession();

        System.out.println("in ajax controller");
        long id = Long.parseLong(request.getParameter("id"));

        long sellerid = Long.parseLong(request.getParameter("sId"));

        long buyerid = Long.parseLong(request.getParameter("bId"));

        String msg = request.getParameter("msg");
        System.out.print("Message----> book id : " + id);
        System.out.print("Message----> seller id : " + sellerid);
        System.out.print("Message----> buyer id : " + buyerid);
        //BookDao bookDao=new BookDao();
        Message msgObj = messageDao.addMessage(id, sellerid, buyerid, msg);

        //Crete msg list
        List<Message> msgList = messageDao.getMessageList(id, buyerid);

        //return msgObj;
        String messages = null;

        messages = " Message ID: " + msgObj.getMsgId() + " Book ID: " + msgObj.getBookId()
                + " Buyer ID: " + msgObj.getBuyerId()
                + " Seller ID: " + msgObj.getSellerId()
                + " Message : " + msgObj.getMessage() + "<br/>";
        return messages;
    }

    
    //search book
    //returns matching book titles
    
    @RequestMapping(value="/search-book.htm", method=RequestMethod.POST)
	public String handleSearchRequest(HttpServletRequest request, HttpServletResponse hsr1) throws Exception {
    
//            if(request.getSession()==null || (request.getSession().getAttribute("user")==null))
//        {
//            return  ("Please login");
//        }
		
       String bookListName;
      
       String initial = request.getParameter("initial");
       String searchBy = request.getParameter("searchBy");
     
       
       if(searchBy.equals("genre"))
       {
           long genreId = Long.parseLong(request.getParameter("searchGenre"));
           bookListName = bookDao.searchBookByGenrID(initial, searchBy,genreId);
       }
       else{     
           bookListName = bookDao.searchBookByIntial(initial, searchBy);
       
       }
       
       System.out.println(bookListName);
    
      request.setAttribute("reqTitleList", bookListName);
     
      return bookListName;
	}
    
    
    
}
