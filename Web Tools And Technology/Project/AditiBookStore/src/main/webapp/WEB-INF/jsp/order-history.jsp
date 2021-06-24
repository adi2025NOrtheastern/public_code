<%-- 
    Document   : order-history
    Created on : Apr 19, 2021, 10:30:08 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
<title>not using</title>
</head>
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

tr:nth-child(odd){background-color: grey;
color:blue;}
tr:nth-child(even){background-color: lightgrey;
color:lightblue;}

th {
    background-color: grey;
    color: black;
}

body{
color: black;
background-color: white; 
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
<body style="margin-top: 100px">
<div id="toCenter">
<h2 align="center">View all your orders: </h2>

<a href="report.pdf">See PDF document</a><br><br>
<a href="redirect-buyer-home.htm">Home </a><br><br>
<table border="0">
            <tr>
                <th>Book Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Date Ordered</th>
            </tr>
            
            <c:forEach var="od" items="${od}">
            <c:if test="${od.buyerId==sessionScope.userId}">
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
