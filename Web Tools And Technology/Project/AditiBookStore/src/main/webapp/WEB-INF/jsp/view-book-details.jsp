<%-- 
    Document   : view-book-details
    Created on : Apr 20, 2021, 5:17:41 PM
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
       
        <title>View Book Details</title>
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
         <jsp:include page="buyer-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <a href="redirect-view-my-cart.htm">View Cart</a>
         <hr/>

        <a href="add-to-cart.htm?id=${requestScope.book.bookId}&action=addtocart">Add To Cart</a>

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


                alert("sending message to seller");
                var myMsg = document.getElementById("msg").value;
                xmlHttp.open("GET", "message-seller.htm?id=${requestScope.book.bookId}&sId=${requestScope.book.sellerId}&bId=${sessionScope.user.buyerId}&msg=" + myMsg, true);


                xmlHttp.send();

            }
        </script>




        <!-- <form action="addtocart.htm" method="post"> -->



        <p>
            Photo :  <img height="150" width="150" src="/userimages/${requestScope.book.photoName}" />
            
        </p>
        <p>                ISBN : ${requestScope.book.isbn} </p>
        <p>                Title : ${requestScope.book.title}</p>
        <p>                Genre :
            <c:forEach var="genre" items="${sessionScope.genreList}">
                <c:if test = "${requestScope.book.genreId==genre.genreId}"> 
                    <!--c:out value="${genre.genreName}"/-->
                    ${genre.genreName}
                </c:if>
            </c:forEach>





        </p>
        <p>                Author :${requestScope.book.author}</p>
        <p>                Price : ${requestScope.book.price}</p>
        <p>                Description : ${requestScope.book.description}</p>

<hr/>
        <form name="messageForm"> 
<!--action="message-seller.htm?id=${requestScope.book.bookId}&action=msgSeller" commandName="message" method="post"-->
            <input type="text" id ="msg" size="100" pattern='[a-zA-Z ]{2,}' title="Enter your message. Atleast longer than 2 letters." /> 
            <font color="red"> 
                <!--form:errors path="message"/--> 
            </font>

            <input type="hidden" name="sellerId" value="${requestScope.book.sellerId}"/>
            <input type="hidden" name="buyerId" value="${sessionScope.user.buyerId}"/>

            <input type="hidden" name="id" value="${requestScope.book.bookId}"/>

            <!--input type="submit" value="Send Message" onClick()="ajaxFunction();" /-->

        </form>

        <button value="Send Message" onClick="ajaxFunction();"> CLick</button>
        <br/>
        Messages:
        <c:forEach var="msg11" items="${requestScope.msgList}">
          Id:  {msg11.msgId} 
          <br/>
          Message: {msg11.message} 
<br/>
        </c:forEach>

  New Message added here:
        <span id="content">
          ...
        </span>


    </body>
</html>

