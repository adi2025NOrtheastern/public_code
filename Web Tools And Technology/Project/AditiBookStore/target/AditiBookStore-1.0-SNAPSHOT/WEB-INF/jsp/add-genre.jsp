<%-- 
    Document   : add-genre
    Created on : Apr 18, 2021, 3:44:15 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>Add Genre Form</title>
    </head>
   
    <style>

        table {
            border-collapse: collapse;
            width: 100%;
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
    <body style="margin-top: 100px">
        
           <jsp:include page="admin-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <div id="toCenter">
             <!--a href="redirect-admin-home.htm">Home</a><br/-->
            <form:form action="add-genre.htm" commandName="genre" method="post">

                <p>
                    Existing Genre:

                </p><p>
                <c:forEach var="genre" items="${requestScope.genreList}">
                   <c:out value = "${genre.genreName}"/> |
                </c:forEach> 
            </p>

            <h2 align="center" > Please provide the name of the Genre to add:</h2>
            <table>

                <tr align="center">
                    <td>Genre Name</td>
                    <td><form:input path="genreName" size="30" pattern='[a-zA-Z ]{2,}' title="No special characters allowed. Atleast longer than 2 letters." /> 
                        <font color="red"> 
                            <form:errors path="genreName"/> </font></td>
                </tr>

                <tr align="center">
                    <td></td>
                    <td colspan="2" align="center"><input type="submit" value="Add Genre" /></td>
                </tr>

            </table>
        </form:form>
    </div>
</body>
</html>