<%-- 
    Document   : view-order-details
    Created on : Apr 21, 2021, 10:43:10 PM
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
       
<title>View Order Details</title>
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
    background-color: white;
    color: blue;
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
 <jsp:include page="buyer-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
    <h2 align="center">View the details of orders : Order ID ${requestScope.orderId}</h2>

    <br/>
    <a href="report.pdf">Download document</a><br/><br/>
     <br/>
<table>
  <tr>
  	
    <th>Order Id</th>
    <th>Buyer Id</th>
    <th>Seller Id</th>
    <th>Book Id</th>
    <th>Book Name</th>
    <th>Book Author</th>
    <th>Book Price</th>
    <th>Order Date</th>
    <th>Status</th>
    
  </tr>
  
    <c:forEach  var="o" items="${odList}">
    <tr>
    <td>${o.orderId}</td>
    <td>${o.buyerId}</td>
    <td>${o.sellerId}</td>
    <td>${o.bookId}</td>
    <td>${o.bookName}</td>
    <td>${o.bookAuthor}</td>
    <td>${o.price}</td>
    <td>${o.date}</td>
    <td>${o.status}</td>
   
    </tr>
    </c:forEach>
    

</table>
</html>