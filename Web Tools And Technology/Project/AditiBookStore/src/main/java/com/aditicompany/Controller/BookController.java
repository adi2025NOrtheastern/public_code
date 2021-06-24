/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.Controller;

import com.aditicompany.DAO.BookDao;
import static com.aditicompany.DAO.DAO.getSession;
import com.aditicompany.DAO.GenreDao;
import com.aditicompany.DAO.MessageDao;
import com.aditicompany.DAO.OrdersDao;
import com.aditicompany.DAO.OrdersDetailsDao;
import com.aditicompany.DAO.SellerDao;
import com.aditicompany.MyException.EbookstoreException;
import com.aditicompany.Validator.BookValidator;
import com.aditicompany.pojo.Book;
import com.aditicompany.pojo.Genre;
import com.aditicompany.pojo.Message;
import com.aditicompany.pojo.OrderDetails;
import com.aditicompany.pojo.Orders;
import com.aditicompany.pojo.Seller;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static java.util.Objects.hash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author aditi
 */
//dedicated for Seeller
@Controller
public class BookController extends HttpServlet {

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
    MessageDao messageDao;

    @Autowired
    OrdersDao orderDao;

    @Autowired
    OrdersDetailsDao orderDetailsDao;

    /*@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(bookValidator);
    }*/
    @RequestMapping(value = "/add-book.htm", method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("book") Book book, BindingResult result, HttpServletRequest request) throws Exception {

//        if (request.getSession() == null) {
//            return "login";
//        }
        Seller seller = (Seller) request.getSession().getAttribute("user");
//        if (seller == null) {
//            return "login";
//        }
        //book.addAttribute("book", new Book());
        System.out.println("coming for validation book: " + book.getAuthor());
        bookValidator.validate(book, result);

        if (result.hasErrors()) {
            return "add-book";
        }

        String genreTitle = book.getGenre_name();
        String title = book.getTitle();
        //Seller seller;
        seller = (Seller) request.getSession().getAttribute("user");

        long sellerId = seller.getSellerId();
        try {

            System.out.println("inside DAO");

            //GenreDao genres = new GenreDao();
            //BookDao bookDao = new BookDao();
            Genre genre = genreDao.get(genreTitle);

            //File upload code starts:
            MultipartFile temp;// = book.getPhoto();
            String fileName = "sample";
            File file;
            if (book.getPhoto() != null) {
                temp = book.getPhoto();
                fileName = temp.getOriginalFilename() + hash(Math.random() + "123" + Math.random()) + ".png";

                file = new File("C:\\aditi\\uploads\\", fileName);
                temp.transferTo(file);
            } else {
                file = new File("C:\\aditi\\uploads\\sample.PNG");
                fileName = "sample" + hash(Math.random() + "123" + Math.random()) + ".png";

            }

            book.setPhotoName(fileName);

            //file upload code ends
            Book bk = bookDao.create(book.getIsbn(), title, book.getAuthor(), genre.getGenreName(), genre.getGenreId(), book.getPrice(), book.getDescription(), sellerId, book.getPhotoName());
            genre.addBook(bk);
            genreDao.save(genre);
            //GenreDao.close();

        } catch (EbookstoreException e) {
            System.out.println(e.getMessage());
        }
        request.setAttribute("book", book);
        return "addedBookSuccess";
    }

    @RequestMapping(value = "/redirect-add-book*.htm", method = RequestMethod.GET)
    public String initializeForm(@ModelAttribute Book book, Model model, HttpServletRequest request) {
        try {
            //check if selller is approved or not

            Seller seller = (Seller) request.getSession().getAttribute("user");

            String username = request.getParameter("username");
            //Seller seller = sellerDao.get(username);

            if (seller.getApprove().equals("Yes")) {
                System.out.println("intitialize form book: " + book);
                model.addAttribute("book", book);
                return "add-book";
            } else {
                request.setAttribute("msg", "Sorry, Your approval request is pending, please wait as you can not add book till approvel");
                return "seller-home";
            }
        } catch (Exception ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/add-book.htm", method = RequestMethod.GET)
    public String initializeForm2(Model model, Book book, HttpServletRequest request) {
        System.out.println("intitialize form book: " + book);

        Seller seller = (Seller) request.getSession().getAttribute("user");

        return "add-book";
    }

    @RequestMapping(value = "/edit-book.htm", method = RequestMethod.GET)
    public String initializeFormEditBk(HttpServletRequest request) {
        try {
            //, Book book

            Seller seller = (Seller) request.getSession().getAttribute("user");

            long bookId = Long.parseLong(request.getParameter("bookId"));
            Book book = bookDao.getBookById(bookId);
            System.out.println("intitialize form book: " + book);
            request.setAttribute("book", book);
            //model.addAttribute("book", book);
            return "edit-book";
        } catch (EbookstoreException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error occured in edit book initialize");
        }
        return "edit-book";
    }

    //redirect-view-orders.htm
    @RequestMapping(value = "/redirect-view-orders.htm", method = RequestMethod.GET)
    public String getViewOrderForm(Model model, HttpServletRequest request) {
        //check if selller is approved or not
        // String username = request.getParameter("username");

        Seller seller = (Seller) request.getSession().getAttribute("user");
        if (seller.getApprove().equals("Yes")) {
            try {
                // System.out.println("intitialize form book: "+ book);
                //get list of orders

                List<Orders> orderList = orderDao.getOrderBySellerId(seller.getSellerId());

                request.setAttribute("orderList", orderList);
                return "view-all-orders";
            } catch (EbookstoreException ex) {
                Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("msg", "Sorry, Your approval request is pending, please wait as you can not add book till approvel");
            return "seller-home";
        }
        return null;
    }

    //redirect-view-all-books.htm
    @RequestMapping(value = "/redirect-view-all-books.htm", method = RequestMethod.GET)
    public String getSellerBooks(Model model, HttpServletRequest request) {
        //check if selller is approved or not
        // String username = request.getParameter("username");

        Seller seller = (Seller) request.getSession().getAttribute("user");
        if (seller.getApprove().equals("Yes")) {
            try {
                // System.out.println("intitialize form book: "+ book);
                //get list of orders

                List<Book> bookList = bookDao.getSellerBooks(seller.getSellerId());

                request.setAttribute("bookList", bookList);
                return "view-all-books";
            } catch (EbookstoreException ex) {
                Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("msg", "Sorry, Your approval request is pending, please wait as you can not add book till approvel");
            return "seller-home";
        }
        return null;
    }

    //redirect-my-messages.htm
    @RequestMapping(value = "/redirect-my-messages.htm", method = RequestMethod.GET)
    public String getSellerMsgs(HttpServletRequest request) {
        //check if selller is approved or not
        // String username = request.getParameter("username");

        Seller seller = (Seller) request.getSession().getAttribute("user");

        if (seller.getApprove().equals("Yes")) {
            try {
                // System.out.println("intitialize form book: "+ book);
                //get list of orders

                List<Message> msgList = messageDao.getSellerMsgs(seller.getSellerId());

                request.setAttribute("msgList", msgList);
                return "view-my-messages";
            } catch (EbookstoreException ex) {
                Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("msg", "Sorry, Your approval request is pending, please wait as you can not add book till approvel");
            return "seller-home";
        }
        return null;
    }

    //view-seller-order-detail
    @RequestMapping(value = "/view-seller-order-detail.htm", method = RequestMethod.GET)
    protected ModelAndView viewOrderDetails(HttpServletRequest request) throws Exception {

        Seller seller = (Seller) request.getSession().getAttribute("user");

        String username = request.getParameter("username");
        long buyerId = Long.parseLong(request.getParameter("buyId"));
        long bookId = Long.parseLong(request.getParameter("bookid"));
        long orderId = Long.parseLong(request.getParameter("orderId"));
        long orderDetailId = Long.parseLong(request.getParameter("orderDetailId"));

        List<OrderDetails> odList = orderDetailsDao.listOrderDetailsByODetailId(orderId, orderDetailId);

        System.out.print("the od list : " + odList);

        List<Message> msgList = messageDao.getMessageList(bookId, buyerId);

        ModelAndView mv = new ModelAndView("view-seller-order-detail", "ordetails", odList);
        request.setAttribute("orderId", orderId);
        request.setAttribute("buyerId", buyerId);
        request.setAttribute("bookId", bookId);
        request.setAttribute("orderDetailId", orderDetailId);
        request.setAttribute("msgList", msgList);

        //String status = orderDao.getStatus(orderId);
        //request.setAttribute("status",status);
        //pageContext.setAttribute("odList", odList);
        return mv;
    }

    @RequestMapping(value = "/edit-book.htm", method = RequestMethod.POST)
    protected String doEditBkAction(HttpServletRequest request) throws Exception {

        Seller seller = (Seller) request.getSession().getAttribute("user");

        //System.out.println(request.getParameterMap().);
        Map map = request.getParameterMap();
        for (Object key : map.keySet()) {
            String keyStr = (String) key;
            String[] value = (String[]) map.get(keyStr);
            System.out.println("Key: " + (String) key + "   :   " + Arrays.toString(value));
        }
        System.out.println(" request.getParameter(\"bookId\") :" + request.getParameter("oldId"));
        Book oldBook = bookDao.getBookById(Long.parseLong((String) request.getParameter("oldId")));

        System.out.println("before setting old book: " + oldBook.getBookId() + oldBook.getAuthor() + oldBook.getDescription() + oldBook.getGenre_name() + oldBook.getIsbn() + oldBook.getSold() + oldBook.getTitle());

//        oldBook.setAuthor(book.getAuthor());
//
//        oldBook.setDescription(book.getDescription());
//        oldBook.setGenreId(book.getGenreId());
//        oldBook.setGenre_name(book.getGenre_name());
//        //oldBook.setPhoto(book.getPhoto());
//        
//        oldBook.setPrice(book.getPrice());
//        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(request.getParameter("author"));
//genre-id is of exisintg book
///henrename is of new book
        oldBook.setDescription(request.getParameter("description"));
        String newGeName = request.getParameter("genre_name");//-- exising genreid
        Genre newG = genreDao.get(newGeName);
        oldBook.setGenreId(newG.getGenreId());
        //Genre g = genreDao.getById(oldBook.getGenreId());
        oldBook.setGenre_name(newG.getGenreName());
        //oldBook.setPhoto(book.getPhoto());

        oldBook.setPrice(Float.parseFloat(request.getParameter("price")));
        oldBook.setTitle(request.getParameter("title"));

        //book.addAttribute("book", new Book());
        // System.out.println("New book: "+ book.getBookId()+book.getAuthor()+book.getDescription()+book.getGenre_name()+book.getIsbn()+book.getSold()+book.getTitle());
        System.out.println("after setting old book: " + oldBook.getBookId() + oldBook.getAuthor() + oldBook.getDescription() + oldBook.getGenre_name() + oldBook.getIsbn() + oldBook.getSold() + oldBook.getTitle());

        System.out.println("coming for validation ");

        //System.out.println("validation sucess");
        long oldGenreId = Long.parseLong(request.getParameter("genreId"));

        System.out.println("saving book");
        bookDao.updateDetails(oldBook);

        //getSession().update(oldBook);
        

        if (oldGenreId == oldBook.getGenreId()) {
            //good
        } else {
            System.out.println("genre is changed");
            Genre g1;
            g1 = genreDao.getById(oldGenreId);
            g1.removeBookById(oldGenreId);
            newG.addBook(oldBook);
        }

        request.setAttribute("msg", "Edit success");
        //return "edit-book";

        request.setAttribute("book", oldBook);
        return "edit-book";
    }

    //delete book
    @RequestMapping(value = "/redirect-delete-book.htm", method = RequestMethod.GET)
    public String deleteBok(Model model, HttpServletRequest request) {
        try {
            //check if selller is approved or not

            Seller seller = (Seller) request.getSession().getAttribute("user");

            String username = request.getParameter("username");
            //Seller seller = sellerDao.get(username);

            if (seller.getApprove().equals("Yes")) {
                long bookId = Long.parseLong(request.getParameter("bookId"));
                Book book = bookDao.getBookById(bookId);
                System.out.println("delete book: " + book);
                if (book != null) {
                    request.setAttribute("msg", "Delete successfully");
                    bookDao.delete(book);
                }
                else{
                    request.setAttribute("msg", "Book already deleted");
                    
                }
                List<Book> bookList = bookDao.getSellerBooks(seller.getSellerId());

                request.setAttribute("bookList", bookList);
            } else {
                request.setAttribute("msg", "Sorry, Your approval request is pending, please wait as you can not add book till approvel");
                return "seller-home";
            }
        } catch (EbookstoreException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "view-all-books";
    }

}
