<%-- 
    Document   : success-page
    Created on : Apr 23, 2021, 11:09:23 PM
    Author     : aditi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
        <title>Success Page</title>
    </head>
    <body style="margin-top: 100px">
      role:  ${sessionScope.role }
      
     
      
       
    
    <c:choose>
            <c:when test="${sessionScope.role == 'seller'}">
                <jsp:include page="seller-header.jsp" >
                    <jsp:param name="myProfile" value="active" />
                </jsp:include>
            </c:when>
            <c:when test="${sessionScope.role == 'buyer'}">
                <jsp:include page="buyer-header.jsp" >
                    <jsp:param name="myProfile" value="active" />
                </jsp:include>
            </c:when>
        </c:choose>
    
    
        <h1>Message: 
            ${requestScope.msg}
        </h1>
    </body>
</html>
