<%-- 
    Document   : view-my-messages
    Created on : Apr 21, 2021, 8:56:08 PM
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
       
        <title>View All Messages</title>
   
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
     <script type="text/javascript">
            function ajaxFunction(buyerid,bookid,msgid) {
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
                var senderM = "sendermsg"+msgid;
                var myMsg = document.getElementById(senderM).value;
                xmlHttp.open("GET", "message-seller.htm?id="+bookid+"&sId=${sessionScope.user.sellerId}&bId=" + buyerid+"&msg=" + myMsg, true);


                xmlHttp.send();

            }
        </script>
    </head>
    <body style="margin-top: 100px">
       
        <jsp:include page="seller-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <div id="toCenter">
            <!--form-->

                <p>
                  Table shows all Messages:

                </p><p>
                <table>  
                    <tr>
                    <td>Seller ID:</td>
                    <td>Buyer ID:</td>
                    <td>Book ID:</td>
                    <td>Message ID:</td>
                    <td>Message: </td>
                    

                    </tr>    

                    <c:forEach var="msg" items="${requestScope.msgList}">
                        <tr> 

                            <td> <c:out value = "${msg.sellerId}"/>  </td>
                            <td> <c:out value = "${msg.buyerId}"/> </td>
                            <td> <c:out value = "${msg.bookId}"/> </td>
                            <td> <c:out value = "${msg.msgId}"/> </td>
                            <td> <c:out value = "${msg.message}"/> </td>
                            <td>
                                 Add New Message:
             <input type="text" id="sendermsg${msg.msgId}" name="sendermsg"/>
            <button value="Send Message" onClick="ajaxFunction(${msg.buyerId},${msg.bookId},${msg.msgId});"> Click</button>
                                
                                
                            </td>
                        
                        </c:forEach> 

                    </tr> 
                </table>
                
                
                </p>

          
                <!--/form-->
            
        <br/>
        New Message added here:
        <span id="content">
            New Message
        </span>
        </div>
    </body>
</html>