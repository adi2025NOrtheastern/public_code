/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author aditi
 */


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class NewClass extends HttpServlet {
	
	private boolean isMultipart;
   private String filePath;
   private int maxFileSize = 500 * 1024;
   private int maxMemSize = 4 * 1024;
   private File file ;

   public void init( ){
    
      filePath = getServletContext().getInitParameter("file-upload"); 
   }
   	
 public void doPost(HttpServletRequest request,  HttpServletResponse response)  
				throws ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 String email = request.getParameter("email");
 String password = request.getParameter("password");
 String cpassword = request.getParameter("cpassword");
 String filename1 = request.getParameter("filename");
 String gender = request.getParameter("gender");
 String country = request.getParameter("countries");
 String cricket = request.getParameter("cricket");
  String football = request.getParameter("football");
 String address = request.getParameter("address");
 String title = "Servlet Form Submission1 MAp";
 String fileName=null;
  isMultipart = ServletFileUpload.isMultipartContent(request);
  DiskFileItemFactory factory = new DiskFileItemFactory();
   
      
      factory.setSizeThreshold(maxMemSize);
   
      
      factory.setRepository(new File("c:\\temp"));

    
      ServletFileUpload upload = new ServletFileUpload(factory);
   
    
      upload.setSizeMax( maxFileSize );

      try { 
       
         List fileItems = upload.parseRequest(request);
	
        
         Iterator i = fileItems.iterator();
		  while ( i.hasNext () ) {
            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
              
               String fieldName = fi.getFieldName();
               fileName = fi.getName();
               String contentType = fi.getContentType();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
              
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;
			}
		  }
		 
 String docType =
 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
 "Transitional//EN\">\n";
 out.println(docType +
 "<HTML>\n" +
 "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
 "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" );
 out.println(email +" " +password+" "+cpassword+ " " +fileName+ " " +
 gender + " " +country+ " Cricket" +cricket + " football" + football + " "+address);
 out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
 "<TR BGCOLOR=\"#FFAD00\">\n" +
 "<TH>Parameter Name<TH>User Value");
 
 out.println("<TR><TD> Email:" + "<TD>" +email);
  out.println("<TR><TD> Password:" + "<TD>" +password);
   out.println("<TR><TD> Confirm Password:" + "<TD>" +cpassword);
    out.println("<TR><TD> Picture:" + "<TD>" +fileName);
	 out.println("<TR><TD> Gender:" + "<TD>" +gender);
	  out.println("<TR><TD> Country:" + "<TD>" +country);
	  	  out.println("<TR><TD> Hobby: " + "<TD> Cricket: " + cricket + " Football:" + football);
		  	  out.println("<TR><TD> Address:" + "<TD>" +address);
 
 out.println("</TABLE>\n");
 
 out.println("<br> <label>Email:</label>" + email);
 out.println("<br> <label>Password:</label>" + password);
 out.println("<br> <label>Confirm Password:</label>" + cpassword);
 out.println("<br> <label>Picture:</label>" + fileName);
 out.println("<br> <label>Gender:</label>" + gender);
 out.println("<br> <label>Country:</label>" + country);
 out.println("<br> <label>Hobby:</label>" );

  out.println(" <label> Cricket</label> "+ cricket);
 
  out.println(" <label> Football</label> " + football);

 out.println("<br> <label>Address:</label>" + address);
 
 Map m=request.getParameterMap();
        Set s = m.entrySet();
        Iterator it = s.iterator();

            while(it.hasNext()){

                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

                String key             = entry.getKey();
                String[] value         = entry.getValue();

                out.println("Key is "+key+"<br>");

                    if(value.length>1){    
                        for (int i1 = 0; i1 < value.length; i1++) {
                            out.println("<li>" + value[i1].toString() + "</li><br>");
                        }
                    }else
                            out.println("Value is "+value[0].toString()+"<br>");

                    out.println("-------------------<br>");
            }
 
 
 
 
 out.println("</BODY></HTML>");
 }
 
  catch(Exception ex) {
            System.out.println(ex);
         }
		 
				}
 
 public void doGet(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
 doGet(request, response);
 }
}