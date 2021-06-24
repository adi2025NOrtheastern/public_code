<%-- 
    Document   : addedBookSuccess
    Created on : Apr 16, 2021, 10:47:44 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
       
<title>Added Book</title>
<style>

body{
color: blue;
background-color: white; 
text-align:center;
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
<h2 align="center">Books added successfully!</h2>
 <jsp:include page="seller-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
<a href="add-book.htm" >Add More Books</a><br>
<a href="redirect-seller-home.htm">Home</a><br>


<img src="/userimages/${requestScope.book.photoName}" style="width:50%;height:50%;"/>
</div>
</body>
</html>

<!--target="Contents"--><!--comment-  -->
