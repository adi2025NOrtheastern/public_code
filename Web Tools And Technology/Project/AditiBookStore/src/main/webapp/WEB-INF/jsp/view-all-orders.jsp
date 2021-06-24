<%-- 
    Document   : view-all-orders
    Created on : Apr 18, 2021, 9:43:50 PM
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
       
        <title>View All orders</title>
   
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
        
         <a href="report.pdf">View Report And Download</a>
        <div id="toCenter">
            <form>

                <p>
                  Table shows all Orders:

                  ${requestScope.msg}
                </p><p>
                <table>  
                    <tr>
                    <td>Seller ID:</td>
                    <td>Order ID:</td>
                    <td>Order Detail ID:</td>
                    <td>Price:</td>
                    <td>Book Id: </td>
                    <td>Book Name:  </td>
                    <td>Book Author:  </td>
                    <td>Order Status:</td>
                    
                    <td>Buyer ID:</td>
                    </tr>    
                    <c:forEach var="order" items="${requestScope.orderList}">
                        <tr> 

                            <td> <c:out value = "${order.sellerId}"/>  </td>
                            <td> <c:out value = "${order.orderId}"/> </td>
                            <td> <c:out value = "${order.orderDetailId}"/> </td>
                            <td> <c:out value = "${order.price}"/> </td>
                            <td> <c:out value = "${order.bookId}"/> </td>
                            <td> <c:out value = "${order.bookName}"/> </td>
                            <td> <c:out value = "${order.bookAuthor}"/> </td>
                            <td> <c:out value = "${order.status}"/>
                                
                             <a  href="view-seller-order-detail.htm?username=${seller.username}&orderId=${order.orderId}&orderDetailId=${order.orderDetailId}&bookid=${order.bookId}&buyId=${order.buyerId}" />View this Order
                            
                             <td><c:out value = "${order.buyerId}"/></td>
                    </c:forEach> 

                    </tr> 
                </table> 
                </p>

           
                </form>
        </div>
    </body>
</html>