<%-- 
    Document   : add-book
    Created on : Apr 16, 2021, 8:48:29 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

        <title>Add Book Form</title>
   
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
            background-color: graytext;
            padding: 8px;
        }

        th {
            background-color: grey;
            color: black;
        }

        #toCenter
        {
            display: table;     
            margin-left:auto;
            margin-right:auto;
        } 

        body{
            color: white;
            background-color: powderblue; 
        }

    </style>
</head>
<body style="margin-top: 100px">  
    <jsp:include page="seller-header.jsp" >
        <jsp:param name="home" value="active" />
    </jsp:include>
    <div id="toCenter">
        <form:form action="add-book.htm" method="Post" commandName="book" encType="multipart/form-data" >
            <h2 align="center">Please add new books to the collection</h2>
            <table>
                <tr>
                    <td style="color:white"> ISBN:</td>
                    <td><form:input path="isbn" size="30" pattern='[0-9]{10}' title="Please enter 10 digit ISBN number." /> 
                        <font color="red"><form:errors cssStyle="color:red" path="isbn"/></font></td>
                </tr>

                <tr>
                    <td style="color:white"> Book Title:</td>
                    <td><form:input path="title" size="30" pattern='[a-zA-Z0-9 ]{3,}' title="No special characters allowed. Atleast 3 letters." /> 
                        <font color="red"><form:errors cssStyle="color:red" path="title"/></font></td>
                </tr>

                <tr>
                    <td style="color:white">Author:</td>
                    <td><form:input path="author" size="30" pattern='[a-zA-Z ]{3,}' title="No special characters allowed. Atleast 3 letters." /> 
                        <font color="red"><form:errors cssStyle="color:red" path="author"/></font></td>
                </tr>

                <%-- <tr>
                    <td style="color:white">Genre/Category:</td>
                    <td><form:input path="genre" size="30" /> <font color="red"><form:errors path="genre"/></font></td>
                </tr> --%>

                <tr>
                    <td style="color:white">Genre :</td>
                    <td>
                        <form:select path="genre_name">
                            <c:forEach var="genre" items="${sessionScope.genres}">
                                <form:option value="${genre.genreName}"/>
                            </c:forEach> 
                        </form:select>
                    </td>
                </tr>

                <tr>
                    <td style="color:white">Price(in USD):</td>
                    <td><form:input path="price" size="30" pattern="(?:\d*\.)?\d+" title="No special characters allowed. Decimal numbers only."/> 
                        <font color="red"><form:errors cssStyle="color:red" path="price"/></font></td>
                </tr>


                <tr>
                    <td style="color:white">Description:</td>
                    <td><form:input path="description" size="30" pattern='[a-zA-Z0-9 ]{3,}' title="No special characters allowed. Atleast longer than 3 letters."/> 
                        <font color="red"><form:errors cssStyle="color:red" path="description"/></font></td>
                </tr>





                <tr>
                    <td></td>
                    <td colspan="2" align="right"><input type="submit" value="Add Book" /></td>

                </tr>

            </table>
                <br/>
                Upload Image : <input type="file" name ="photo"/>

        </form:form>
    </div>
</body>
</html>