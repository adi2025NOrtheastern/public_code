<%-- 
    Document   : display-cart
    Created on : Apr 19, 2021, 10:29:41 PM
    Author     : aditi
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>My Cart</title>

        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }
            table, th, td {
                border: 1px solid black;
            }
            table, th, td {
                border: 1px solid black;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: grey; color:black;}
            tr:nth-child(odd){background-color: yellow; color:black;}
            th {
                background-color: coral;
                color: blue;
            }


            #toCenter{
                display: table;     
                margin-left:auto;
                margin-right:auto;
            }
            body{
                color: blue;
                background-color: white; 
            }

            a{color:blue;}	

        </style>


    </head>
    <body  style="margin-top: 100px">
        <jsp:include page="buyer-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <div id="toCenter">
            Message: ${requestScope.msg}

            <br/>
            <form:form action="place-my-order.htm" modelAttribute="orders" method="post">
                <c:choose>
                    <c:when test = "${!empty sessionScope.cart}">
                        <h3> Your cart contents</h3>
                        <table>
                            <tr>
                                <th>PIC</th>
                                <th>ISBN</th>
                                <th>Title</th>
                                <th>Author</th>
                                <th>Price</th>
                                <th>Seller Id</th>
                                <th>Remove?</th>
                            </tr>

                            <c:forEach var="b" items="${cart}" varStatus="status">
                                <tr id="row${status.index}"> 

                                    <td> <img height="150" width="150" src="/userimages/${b.photoName}" /> </td>
                                    <td>${b.isbn}</td>
                                    <td>${b.title}</td>
                                    <td>${b.author}</td>
                                    <td>${b.price}</td>
                                    <td>${b.sellerId}</td>

                                    <td><a href="remove-item.htm?id=${status.index}&action=removeitem">Remove</a></td>


                                </tr>
                            </c:forEach>
                            <tr></tr>
                            <tr>
                                <td></td>
                                <td>Total</td>
                                <td>${sessionScope.total}</td>
                                <td></td>

                            </tr>
                        </table>
                        <br/><br/>
                        
                        <input type="hidden" name="total" value="${sessionScope.total}" />
                        <a href="redirect-buy-book.htm"> Continue Shopping </a>


                        <input type="submit" value="Checkout">
                    </c:when>

                    <c:otherwise>
                        <h2> Your shopping cart is empty </h2>

                    </c:otherwise>

                </c:choose> 
                <p> <a href="redirect-buyer-home.htm">Return to home</a></p>

            </form:form>



        </div>
    </body>
</html>
