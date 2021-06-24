<%-- 
    Document   : approve-single-seller
    Created on : Apr 18, 2021, 5:46:30 PM
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
       
        <title>Approve Seller Form</title>
    
  
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
        <div id="toCenter">
            <jsp:include page="admin-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
            <form action="approve-single-seller-go.htm" method="post">

                <p>
                   Please verify and approve: New Seller Approval Request for : ${requestScope.seller.username}

                </p>
                <table>  
                    <tr>
                    <td>Seller ID:</td>
                    <td>Username:</td>
                    <td>First Name:</td>
                    <td>Last Name: </td>
                    <td>Email ID:  </td>
                    <td>Approval Status:</td>

                    </tr>    

                    
                        <tr> 

                            <td> ${requestScope.seller.sellerId}  </td>
                            <td> ${requestScope.seller.username} </td>
                            <td> ${requestScope.seller.firstName} </td>
                            <td> ${requestScope.seller.lastName} </td>
                            <td> ${requestScope.seller.emailID}</td>
                            <td> ${requestScope.seller.approve} </td>

                    </tr> 
                    
                </table> 
               
                 <input type="hidden" name = "username" value="${requestScope.seller.username}"/>
                   
                  <input type="submit" value="Approve this"/>
           
                </form>
        </div>
    </body>
</html>