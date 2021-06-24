/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.PDFViewShow;

import com.aditicompany.DAO.GenreDao;
import com.aditicompany.DAO.OrdersDetailsDao;
import com.aditicompany.pojo.Buyer;
import com.aditicompany.pojo.Genre;
import com.aditicompany.pojo.OrderDetails;
import com.aditicompany.pojo.Seller;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import java.util.Arrays;

/**
 *
 * @author aditi
 */
public class PdfReportView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

//        Font font_helvetica_14_bold_blue = new Font(Font.HELVETICA, 14, Font.BOLD, Color.BLUE);
//        Font font_courier_16_italic_red = new Font(Font.COURIER, 16, Font.ITALIC, Color.RED);
//        Font font_courier_16_bold_black = new Font(Font.COURIER, 16, Font.BOLD, Color.BLACK);
        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            return;
        }

        List odList;
        String role = (String) session.getAttribute("role");
        if (role.equals("admin")) {
            
            Paragraph p1;
            p1 = new Paragraph("Aditi Online Bookstore - Admin Dashboard", FontFactory.getFont(FontFactory.TIMES_ROMAN, 40, Font.BOLD, new Color(0, 255, 0)));
            pdfdoc.add(p1);

            GenreDao genreDao = new GenreDao();
            
            List<Genre> gList = genreDao.listGenre();
             Paragraph prg1 = new Paragraph("Genre List " );
              pdfdoc.add(prg1);
              
              
               Table tablehead = new Table(4) {
                }; // 6 columns.

                tablehead.setAlignment(Element.ALIGN_LEFT);
                tablehead.setPadding(5);
                tablehead.addCell("Genre Id");
                tablehead.addCell("Genre Name");
                tablehead.addCell("List");
              //  tablehead.addCell("Price");

              
               pdfdoc.add(tablehead);
            for(Genre g: gList)
            {
               

               
                Table tablebody = new Table(4) {
                };
                tablehead.setPadding(5);
                tablebody.setAlignment(Element.ALIGN_LEFT);
                tablebody.addCell("Genre0000"+String.valueOf(g.getGenreId()));
                tablebody.addCell(g.getGenreName());
                tablebody.addCell(Arrays.toString(g.getBooks().toArray()));
               // tablebody.addCell(String.valueOf(order.getPrice()));

               
               // pdfdoc.add(tablehead);
                pdfdoc.add(tablebody);
            }
            
            
            
            

        } else {
            OrdersDetailsDao orDet = new OrdersDetailsDao();
            long userId = 0;
            String username = "";
            String emailId = "";
            String prefix = "ABC";
            if (role.equals("seller")) {

                Seller seller = (Seller) session.getAttribute("user");
                userId = seller.getSellerId();
                username = seller.getUsername();
                emailId = seller.getEmailID();
                odList = orDet.listDetailsSeller(userId);
                prefix = "ADBSUserSeller";
            } else {

                Buyer buyer = (Buyer) session.getAttribute("user");

                userId = buyer.getBuyerId();
                username = buyer.getUsername();
                emailId = buyer.getEmailID();
                odList = orDet.listDetails(userId);
                prefix = "ADBSUserBuyer";
            }

            Paragraph p1;
            p1 = new Paragraph("Aditi Online Bookstore - Your Order History", FontFactory.getFont(FontFactory.TIMES_ROMAN, 40, Font.BOLD, new Color(0, 255, 0)));
            pdfdoc.add(p1);

            Paragraph p2 = new Paragraph("Your User Id: " + prefix + String.valueOf(userId), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 40, Font.BOLD, new Color(0, 0, 255)));
            pdfdoc.add(p2);

            Paragraph p3 = new Paragraph(" User Name: " + username + "\n" + " Email ID: " + emailId);
            pdfdoc.add(p3);

            Iterator orderIterator = odList.iterator();
            while (orderIterator.hasNext()) {
                OrderDetails order = (OrderDetails) orderIterator.next();

                Paragraph prg1 = new Paragraph("Date of purchase: " + order.getDate());

                Table tablehead = new Table(4) {
                }; // 6 columns.

                tablehead.setAlignment(Element.ALIGN_LEFT);
                tablehead.setPadding(5);
                tablehead.addCell("Order Id");
                tablehead.addCell("Book Title");
                tablehead.addCell("Author");
                tablehead.addCell("Price");

                Table tablebody = new Table(4) {
                };
                tablehead.setPadding(5);
                tablebody.setAlignment(Element.ALIGN_LEFT);
                tablebody.addCell(String.valueOf(order.getOrderId()));
                tablebody.addCell(order.getBookName());
                tablebody.addCell(order.getBookAuthor());
                tablebody.addCell(String.valueOf(order.getPrice()));

                pdfdoc.add(prg1);
                pdfdoc.add(tablehead);
                pdfdoc.add(tablebody);

            }

            /*
        
        Paragraph para = new Paragraph("Personal Information",FontFactory.getFont(FontFactory.TIMES_ROMAN, 40, Font.BOLD, new Color(255, 0,0)));  
         para.setAlignment(1);
         doc.add(para);
         Table table = new Table(2);
         Image image = Image.getInstance("C:\\Users\\dedhi\\Docs\\Dimpi.jpeg");
         Cell cell1 = new Cell(image);
         cell1.setRowspan(4);
         table.addCell(cell1);
         Chunk name = new Chunk("Name: Dimpi Pankaj Dedhia", FontFactory.getFont(FontFactory.TIMES_ROMAN, 20));
         Chunk age = new Chunk("Age: 25 years",FontFactory.getFont(FontFactory.TIMES_ROMAN, 20));
         Chunk address = new Chunk("Address: Boston, MA, USA",FontFactory.getFont(FontFactory.TIMES_ROMAN, 20));
         Chunk contact = new Chunk("Contact no.: 866-890-1234",FontFactory.getFont(FontFactory.TIMES_ROMAN, 20));
         Cell cellname = new Cell(name);
         Cell cellage = new Cell(age);
         Cell celladdress = new Cell(address);
         Cell cellcontact = new Cell(contact);
         table.addCell(cellname);
         table.addCell(cellage);
         table.addCell(celladdress);
         table.addCell(cellcontact);
         table.setPadding(5);
         table.setAlignment(Element.ALIGN_LEFT);
         cell1.setBorderWidth(0);
         cellname.setBorderWidth(0);
         cellage.setBorderWidth(0);
         celladdress.setBorderWidth(0);
         cellcontact.setBorderWidth(0);
         cellname.setWidth(50);
         table.setBorderWidth(0);
         table.setWidth(100);
         doc.add(table);
             */
        }
    }

}
