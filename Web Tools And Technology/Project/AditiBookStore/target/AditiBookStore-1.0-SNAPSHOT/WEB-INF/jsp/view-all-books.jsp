<%-- 
    Document   : view-all-books
    Created on : Apr 18, 2021, 10:11:40 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>View All Books</title>
   
  
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

        tr:nth-child(odd){
            background-color: buttonface;
            padding: 8px;
        }

        th {
            background-color: grey;
            color: black;
        }

        body{
            color: blue;
            background-color: white; 
        }

        #toCenter
        {
            display: table;     
            margin-left:auto;
            margin-right:auto;
        } 


        a{color:blue;}

    </style>
    </head>
    <body style="margin-top: 100px">
         <jsp:include page="seller-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <div id="toCenter">
            <form>

                ${requestScope.msg}
                <p>
                    Table shows all books added by me : ${sessionScope.user.username}

                </p><p>
                <table>  
                    <tr>
                    <th>Seller ID:</th>
                    <th>Photo</th>
                    <th>Book ID:</th>
                    <th>Book Title:</th>
                    <th>ISBN:</th>
                    <th>Author Name: </th>
                    <th>Description ID:  </th>
                    <th>Price:</th>
                    <th>Sold:</th>

                    </tr>    

                    <c:forEach var="book" items="${requestScope.bookList}">
                        <tr> 

                            <td> <c:out value = "${book.sellerId}"/>  </td>
                            <td> <img height="150" width="150" src="/userimages/${book.photoName}" />
                            </td>
                            <td> <c:out value = "${book.bookId}"/> </td>
                            <td> <c:out value = "${book.title}"/> </td>
                            <td> <c:out value = "${book.isbn}"/> </td>
                            <td> <c:out value = "${book.author}"/> </td>
                            <td> <c:out value = "${book.description}"/> </td>
                            <td> <c:out value = "${book.price}"/>

                                <a  href="edit-book.htm?bookId=${book.bookId}&genre=${book.genreId}" />Edit
                            <td> <c:out value = "${book.sold}"/> </td>
                        </c:forEach> 

                    </tr> 
                </table> 
                </p>


            </form>
        </div>
    </body>
</html>