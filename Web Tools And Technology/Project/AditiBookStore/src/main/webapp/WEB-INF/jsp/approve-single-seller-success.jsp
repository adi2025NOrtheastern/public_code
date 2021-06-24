<%-- 
    Document   : approve-single-seller-success
    Created on : Apr 18, 2021, 6:15:17 PM
    Author     : aditi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>Success</title>
    </head>
    <body style="margin-top: 100px">
        <jsp:include page="admin-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <h1>${requestScope.msg}</h1>
        
        <a href="redirect-admin-home.htm">Home</a><br/>
    </body>
</html>
