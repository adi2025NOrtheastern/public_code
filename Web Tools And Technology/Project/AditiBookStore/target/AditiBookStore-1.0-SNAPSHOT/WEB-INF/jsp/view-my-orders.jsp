<%-- 
    Document   : view-my-orders
    Created on : Apr 20, 2021, 11:16:45 AM
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
       
        <title>View All My Orders</title>
   
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
         <jsp:include page="buyer-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <div id="toCenter">
            <form>

                <p>
                  Table shows all your Orders:

                </p><p>
                <table>  
                    <th>
                    
                    <td>Order ID:</td>
                   
                    <td>Item Count:</td>
                   
                    <td>Order Date:</td>
                    <td>Order Total:</td>
                    </th>

                       

                    <c:forEach var="order" items="${requestScope.orderList}">
                        <tr> 

                            <td></td>
                            
                            <td> <c:out value = "${order.orderId}"/> </td>
                           
                            
                            <td> <c:out value = "${order.itemNumber}"/>
                                <a href="cancel-order.htm?username=${sessionScope.user.username}&orderId=${order.orderId}"  > Cancel Order </a>
                                <a  href="view-order-details.htm?username=${sessionScope.user.username}&orderId=${order.orderId}" >View this Order </a>
                             <td> <c:out value = "${order.orderDate}"/> </td>
                             <td> <c:out value = "${order.total}"/> </td>
                    </c:forEach> 

                    </tr> 
                </table> 
                </p>

           
                </form>
        </div>
        ${msgSuccess}
    </body>
</html>