<%-- 
    Document   : update-my-profile
    Created on : Apr 23, 2021, 8:15:07 PM
    Author     : aditi
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <title>Update Profile</title>
    </head>
    <body style="margin-top: 100px">
        
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
        
        
        <h5 style="color: red; margin: 10px">${error}</h5>
       
        <div class="d-flex justify-content-center" style="margin-top: 4%">

            <form method="POST" name="registerForm" action="update-user.htm">
                <h4 style="text-decoration: underline;margin-left: 35px">Update Form</h4>

                Role:
                ${sessionScope.role}
<br/>

                <div class="form-group">
                    <label for="firstname">First Name</label>
                    <input type="text" name="firstname" class="form-control" id="firstName" maxlength="50" minlength="3" placeholder="Enter First Name" value="${sessionScope.user.firstName}" required/>
                </div>

                <div class="form-group">
                    <label for="lastname">Last Name</label>
                    <input type="text" name="lastname" class="form-control" id="lastName" placeholder="Enter Last Name" maxlength="50" minlength="3" value="${sessionScope.user.lastName}" required/>
                </div>

                Gender:<br>${sessionScope.user.gender}
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="F" value="F"/>
                    <label class="form-check-label" for="F">Female</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="M" value="M"/>
                    <label class="form-check-label" for="M">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="O" value="O"/>
                    <label class="form-check-label" for="O">Other</label>
                </div>
                <br><br>

                <div class="form-group">
                    <label for="date">Enter Date of Birth</label>
                    <input class="form-control" max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())%>" type="date" id="date" name="dateofbirth" value="${sessionScope.user.date_of_birth}" required/>
                </div>

                

              
                
                
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" maxlength="30" id="email" placeholder="Enter Email" name="email" value="${sessionScope.user.emailID}" required/>
                </div>


                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="phone" class="form-control" id="phone" maxlength="20" placeholder="+888-888-8888" name="phone" value="${sessionScope.user.phone}" required/>
                </div>

                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" name="username" class="form-control" id="username" placeholder="Enter Username" value="${sessionScope.user.username}" minlength="5" maxlength="10" required/>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" id="password" placeholder="Enter Password" value="${sessionScope.user.password}" minlength="6" maxlength="10" required/>
                </div>
                
                
                  <div class="form-group">
                    <label for="address">Enter Address</label>
                    <textarea class="form-control" id="address" rows="5" cols="25" minlength="8" maxlength="100" name="address" value="${sessionScope.user.address}" required>${sessionScope.user.address}</textarea>
                </div>


                <input type="hidden" name="option" value="update"/>
                <input type="submit" value="Update" class="btn btn-primary mb-2"/>
            </form>
        </div>
    </body>
</html>