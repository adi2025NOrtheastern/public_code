<%-- 
    Document   : ordered-items
    Created on : Apr 19, 2021, 10:31:04 PM
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
       
        <title>Order Success</title>

        <style>

            #toCenter{
                display: table;     
                margin-left:auto;
                margin-right:auto;
            }
            body{
                color: black;
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
        <div id="toCenter">
            <h2 align="center">Congrats, Order placed successfully! </h2>

            <a href="report.pdf">See PDF document</a><br/><br/>

            <h2>Items have been successfully ordered!</h2>

            You paid $${sessionScope.total}.
            <br/><br/>
            Your Order id generated is ${sessionScope.orderId}.
            <br/><br/>

            <!-- <a href="report.htm">Generate pdf</a> -->

            Email sent!
            <br/>
            
            <a href="redirect-view-my-orders.htm">View Order History</a>
            <a href="redirect-buyer-home.htm">Home </a><br/><br/>
        </div>


    </body>
</html>