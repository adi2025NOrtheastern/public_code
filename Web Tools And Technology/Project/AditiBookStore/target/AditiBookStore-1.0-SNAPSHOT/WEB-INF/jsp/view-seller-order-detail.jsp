<%-- 
    Document   : view-seller-order-detail
    Created on : Apr 21, 2021, 11:24:56 PM
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
              <script type="text/javascript">
            function ajaxFunction() {
                var xmlHttp;
                try { //firefox, opera
                    xmlHttp = new XMLHttpRequest();
                } catch (e) {
                    try { //IE
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        try {
                            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e)
                        {
                            alert("AJAX not suppported!");
                            return false;
                        }
                    }
                }

                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4)
                    {
                        document.getElementById("content").innerHTML = xmlHttp.responseText;
                    }
                }


                alert("sending message");
                var myMsg = document.getElementById("msg").value;
                 xmlHttp.open("GET", "message-buyer.htm?id=${requestScope.bookId}&sId=${sessionScope.user.sellerId}&bId=${requestScope.buyerId}&msg=" + myMsg, true);


                xmlHttp.send();

            }



            //  ajaxMarkComplete
            function ajaxMarkComplete(odid) {
                var xmlHttp;
                try { //firefox, opera
                    xmlHttp = new XMLHttpRequest();
                } catch (e) {
                    try { //IE
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        try {
                            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e)
                        {
                            alert("AJAX not suppported!");
                            return false;
                        }
                    }
                }

                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4)
                    {
                        document.getElementById("content1").innerHTML = xmlHttp.responseText;
                    }
                }


                alert("Marking Complete");
                // var myMsg = document.getElementById("msg").value;
                  xmlHttp.open("POST", "mark-order-seller.htm?id=${requestScope.bookId}&sId=${sessionScope.user.sellerId}&odid=" + odid, true);


                xmlHttp.send();

            }
            
            
            
            function ajaxMarkCancel(odid) {
                var xmlHttp;
                try { //firefox, opera
                    xmlHttp = new XMLHttpRequest();
                } catch (e) {
                    try { //IE
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        try {
                            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e)
                        {
                            alert("AJAX not suppported!");
                            return false;
                        }
                    }
                }

                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4)
                    {
                        document.getElementById("content1").innerHTML = xmlHttp.responseText;
                    }
                }


                alert("Marking Cancel");
                // var myMsg = document.getElementById("msg").value;
                  xmlHttp.open("POST", "mark-cancel-order-seller.htm?id=${requestScope.bookId}&sId=${sessionScope.user.sellerId}&odid=" + odid, true);


                xmlHttp.send();

            }
        </script>

    </head>
    <body style="margin-top: 100px">

  

         <jsp:include page="seller-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <h2 align="center">View the details of orders : Order ID ${requestScope.orderId}</h2>

        <br/>

        <br/>
        <table>
            <tr>

                <th>Order Id</th>
                <th>Order Detail Id</th>
                <th>Buyer Id</th>
                <th>Seller Id</th>
                <th>Book Id</th>
                <th>Book Name</th>
                <th>Book Author</th>
                <th>Book Price</th>
                <th>Order Date</th>
                <th>Status</th>

            </tr>

            <c:forEach  var="o" items="${ordetails}">
                <tr>
                    <td>${o.orderId}</td>
                    <td>${o.orderDetailId}</td>
                    <td>${o.buyerId}</td>
                    <td>${o.sellerId}</td>
                    <td>${o.bookId}</td>
                    <td>${o.bookName}</td>
                    <td>${o.bookAuthor}</td>
                    <td>${o.price}</td>
                    <td>${o.date}</td>
                    <td>




                        <span id="content1">

                            <c:if test="${o.status == 'Complete'}">
                                ${o.status}
                                Mark Cancel?
                                <button value="Cancel" onClick="ajaxMarkCancel(${o.orderDetailId});"> Cancel</button>
                            </c:if>
                            
                            <c:if test="${o.status == 'Cancelled'}">
                                ${o.status}
                            </c:if>

                            <c:if test="${o.status == 'New'}">
                                ${o.status}
                                Mark Complete?
                                <button value="Complete" onClick="ajaxMarkComplete(${o.orderDetailId});"> Complete</button>
                            </c:if>
                        </span>
                    </td>


                </tr>
            </c:forEach>


        </table>

        <br/>



        Add New Message: <br/>
        <input type="text" id="msg" name="msg"/>


        <br/>
        <button value="Send Message" onClick="ajaxFunction();"> Click to send Message</button>
        <br/> <br/>
        Previous Messages:
        <br/>
        <c:forEach var="msg11" items="${requestScope.msgList}" >
            < Id:  ${msg11.msgId} >

            < Seller Id:  ${msg11.sellerId} >

            < Buyer Id:  ${msg11.buyerId} >

            < Message: ${msg11.message} >
            <br/>
        </c:forEach>

            
            
            new:
        <span id="content">
            <c:forEach var="msg11" items="${requestScope.msgList}" >
                < Id:  ${msg11.msgId} >

                < Seller Id:  ${msg11.sellerId} >

                < Buyer Id:  ${msg11.buyerId} >

                < Message: ${msg11.message} >
                <br/>
            </c:forEach>
        </span>

</html>
