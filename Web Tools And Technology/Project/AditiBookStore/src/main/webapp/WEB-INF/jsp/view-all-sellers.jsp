<%-- 
    Document   : view-all-sellers
    Created on : Apr 18, 2021, 8:58:09 PM
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
       
        <title>View All Sellers</title>
   
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
         <jsp:include page="admin-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <a href="redirect-admin-home.htm">Home </a>
        <div id="toCenter">
            <form>

                <p>
                  Table shows all Sellers:

                </p><p>
                <table>  
                    <th>
                    <td>Seller ID:</td>
                    <td>Username:</td>
                    <td>First Name:</td>
                    <td>Last Name: </td>
                    <td>Email ID:  </td>
                    <td>Approval Status:</td>

                    </th>    

                    <c:forEach var="seller" items="${requestScope.sellerList}">
                        <tr> 

                            <td></td>
                            <td> <c:out value = "${seller.sellerId}"/>  </td>
                            <td> <c:out value = "${seller.username}"/> </td>
                            <td> <c:out value = "${seller.firstName}"/> </td>
                            <td> <c:out value = "${seller.lastName}"/> </td>
                            <td> <c:out value = "${seller.emailID}"/> </td>
                            <td> <c:out value = "${seller.approve}"/> 
                           
                        </c:forEach> 

                    </tr> 
                </table> 
                </p>

           
                </form>
            
        </div>
    </body>
</html>