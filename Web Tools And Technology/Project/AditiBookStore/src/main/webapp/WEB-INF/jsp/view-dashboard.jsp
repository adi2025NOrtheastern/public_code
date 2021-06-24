<%-- 
    Document   : view-dashboard
    Created on : Apr 23, 2021, 11:34:02 PM
    Author     : aditi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>Dashboard
        </title>
    </head>
    <body style="margin-top: 100px">
         <jsp:include page="admin-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <h1>Hello Admin!</h1>
        
        <h2><a href="report.pdf?role=admin" />Download Report </a></h2>
        
       <iframe src="view-all-sellers.htm" width="500" height="500" title="View Sellers"></iframe>
        <br/>
        <iframe src="view-all-buyers.htm" width="500" height="500" title="View Buyers"></iframe>
        <br/>
        <iframe src="redirect-admin-book.htm" width="500" height="500" title="All books"></iframe>
    </body>
</html>
