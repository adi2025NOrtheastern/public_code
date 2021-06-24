<%-- 
    Document   : edit-book
    Created on : Apr 22, 2021, 2:45:03 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>Edit Book Details</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }
            table, th, td {
                border: 1px solid black;
            }
            th, td {
                text-align: left;
                padding: 8px;
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
                color:black;
            }

            img {
                border: 5px solid #555;
            }
        </style>
    </head>
    <body style="margin-top: 100px">
        <jsp:include page="seller-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>

       <a href="redirect-delete-book.htm?bookId=${requestScope.book.bookId}">Delete Book</a>
         <hr/>

        <p>
            Photo :  <img height="150" width="150" src="/userimages/${requestScope.book.photoName}" />
            
            <br/>
            ID: ${requestScope.book.bookId}
        </p>
        <p>                ISBN : ${requestScope.book.isbn} </p>
        <p>                Title : ${requestScope.book.title}</p>
        <p>                Genre :
            <c:forEach var="genre" items="${sessionScope.genres}">
                <c:if test = "${requestScope.book.genreId==genre.genreId}"> 
                    <!--c:out value="${genre.genreName}"/-->
                    ${genre.genreName}
                </c:if>
            </c:forEach>
        </p>
        <p>                Author :${requestScope.book.author}</p>
        <p>                Price : ${requestScope.book.price}</p>
        <p>                Description : ${requestScope.book.description}</p>


        <form action="edit-book.htm" method="POST" >
            <h2 align="center">Please edit book details:</h2>
            <table>
                <tr>
                    <td style="color:white"> ISBN:</td>
                    <td> 
                        ${requestScope.book.isbn}
                    </td>
                </tr>

                <tr>
                    <td style="color:white"> Book Title:</td>
                    <td><input size="30" name="title" pattern='[a-zA-Z0-9 ]{3,}' title="No special characters allowed. Atleast 3 letters." value="${requestScope.book.title}" required/> 
                        <font color="red"></font></td>
                </tr>

                <tr>
                    <td style="color:white">Author:</td>
                    <td><input name="author" size="30" pattern='[a-zA-Z ]{3,}' title="No special characters allowed. Atleast 3 letters." value="${requestScope.book.author}" required/> 
                        <font color="red"></font></td>
                </tr>

            
                <tr>
                    <td style="color:white">Genre :</td>
                    <td>
                        <c:forEach var="genre" items="${sessionScope.genres}">
                            <c:if test = "${requestScope.book.genreId==genre.genreId}"> 
                                <!--c:out value="${genre.genreName}"/-->
                                ${genre.genreName}
                                <input type="hidden" name="genreId" value="${genre.genreId}"/>
                            </c:if>
                        </c:forEach>

                        Change?



                        <select name="genre_name">
                            <c:forEach var="genre" items="${sessionScope.genres}">
                                <option name="${genre.genreId}" value="${genre.genreName}">${genre.genreName}</option>

                            </c:forEach> 
                        </select>
                    </td>
                </tr>

                <tr>
                    <td style="color:white">Price(in USD):</td>
                    <td><input name="price" size="30" pattern="(?:\d*\.)?\d+" title="No special characters allowed. Decimal numbers only." value="${requestScope.book.price}" required/> 
                        <font color="red"></font></td>
                </tr>


                <tr>
                    <td style="color:white">Description:</td>
                    <td><input name="description" size="30" pattern='[a-zA-Z0-9 ]{3,}' title="No special characters allowed. Atleast longer than 3 letters." value="${requestScope.book.description}" required/> 
                        <font color="red"></font></td>
                </tr>





                <tr>
                    <td></td>
                    <td colspan="2" align="right"><input name="submit" type="submit" value="Edit Book" /></td>

                </tr>

            </table>
            <input type="hidden" name="oldId" value="${requestScope.book.bookId}" />

        </form>
            
            
            <p>
    ${requestScope.msg}

            </p>
    </body>
</html>

