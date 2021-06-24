<%-- 
    Document   : display-admin-books
    Created on : Apr 23, 2021, 11:50:57 PM
    Author     : aditi
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- shows books to buyer-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>Display Books</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
                border: 1px solid black;
            }

            th, td {
                text-align: left;
                padding: 8px;
                border: 1px solid black;
            }

            tr:nth-child(odd){background-color: bisque;
                              color:black;}
            tr:nth-child(even){background-color: lightblue;
                               color:black;}

            th {
                background-color: grey;
                color: black;
            }

            body{
                color: blue;
                background-color: white; 
            }

            a{
                color:blue;
            }
        </style>
        

    </head>
    <body style="margin-top: 100px">
        <jsp:include page="admin-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <!--h4> Click on the button to display search form: 
     <button onclick="searchFormDisplay()">Show Form</button></h4--> 


        
        
        
          
        <table>
            <tr>
                <td><b>Photo</b></td>
                <td><b>ISBN</b></td>
                <td><b>Title</b></td>
                <td><b>Genre</b></td>
                <td><b>Author</b></td>
                <td><b>Price</b></td>
                <td><b>Description</b></td>
                <td><b>Sold?</b></td>

                

            </tr>
            <!--test if searchBookList is null == means display all obooks -->
            
            <c:if test="${requestScope.searchBookList==null}">
                <c:forEach var="book" items="${sessionScope.bookList}">
               
                    <tr>
                        <td><img height="150" width="150" src="/userimages/${book.photoName}" /></td> 
                        <td>${book.isbn}</td>
                        <td>${book.title}</td>

                        <c:forEach var="genre" items="${sessionScope.genreList}">
                            <c:if test = "${book.genreId==genre.genreId}"> 
                                <td>${genre.genreName}</td>
                            </c:if>
                        </c:forEach>

                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.description}</td>
                        <td>${book.sold}</td>

                    </tr>
               
            </c:forEach>
                
                
            </c:if>
                    
                    
                    <c:if test="${requestScope.searchBookList!=null}">
                <c:forEach var="book" items="${requestScope.searchBookList}">
                <c:if test = "${book.sold=='No'}"> 
                    <tr>
                        <td><img height="150" width="150" src="${book.photoName}" /></td> 
                        <td>${book.isbn}</td>
                        <td>${book.title}</td>

                        <c:forEach var="genre" items="${sessionScope.genreList}">
                            <c:if test = "${book.genreId==genre.genreId}"> 
                                <td>${genre.genreName}</td>
                            </c:if>
                        </c:forEach>

                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.description}</td>
                        <td>
    <!--a href="add-to-cart.htm?id=${book.bookId}&action=addtocart">Add To Cart</a-->

    <!--a href="message-seller.htm?id=${book.bookId}&action=msgSeller">Message Seller</a-->

                            
                        </td>

                    </tr>
                </c:if>
            </c:forEach>
                
                
            </c:if>
            
            
            
        </table>
        <br/><br/>



    </body>
</html>
