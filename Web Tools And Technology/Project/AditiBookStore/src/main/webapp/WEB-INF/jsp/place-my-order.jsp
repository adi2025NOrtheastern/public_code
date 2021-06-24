<%-- 
    Document   : place-my-order
    Created on : Apr 20, 2021, 11:56:57 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Not using!!</title>

<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(odd){background-color: grey;
color:black;}
tr:nth-child(even){background-color: lightgrey;
color:black;}

th {
    background-color: grey;
    color: black;
}

body{
color: white;
background-color: black; 
}

/* #toCenter{
          display: table;     
  		  margin-left:auto;
  		  margin-right:auto;
		} */



a{
color:blue;
}
</style>
</head>
<body style="margin-top: 100px">
<div id="toCenter">
<h2 align="center">View all your orders: </h2>
hi
<a href="report.pdf">See PDF document</a><br><br>
<p> <a href="redirect-buyer-home.htm">Return to home</a></p>
<table border="0">
            <tr>
                <th>Book Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Date Ordered</th>
            </tr>
            
            <c:forEach var="od" items="${od}">
            <c:if test="${od.customerId==sessionScope.userId}">
                <tr id="row"> 
                  
                	<td>${od.bookName}</td> 
                    <td>${od.bookAuthor}</td>
                    <td>${od.price}</td>
                    <td>${od.date}</td>
                    
                   
                </tr>
                </c:if>
             </c:forEach>
               
        </table>


</div>

</body>
</html>