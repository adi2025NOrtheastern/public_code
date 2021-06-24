<%-- 
    Document   : seller-header
    Created on : Apr 16, 2021, 8:33:04 PM
    Author     : aditi
--%>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Aditi Online Book Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link <%=request.getParameter("home")%>" href="redirect-seller-home.htm">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link <%=request.getParameter("add-book")%>" href="redirect-add-book.htm?username=${sessionScope.user.username}">Add Book to Sell</a>
      <a class="nav-item nav-link <%=request.getParameter("viewOrders")%>" href="redirect-view-orders.htm">View Orders</a>
      <a class="nav-item nav-link <%=request.getParameter("viewAllBooks")%>" href="redirect-view-all-books.htm">View All Books</a>
      <a class="nav-item nav-link <%=request.getParameter("myProfile")%>" href="redirect-my-profile.htm">My Profile</a>
      <a class="nav-item nav-link" href="redirect-my-messages.htm">Messages[0${sessionScope.msgCount}]</a>
      
    </div>
      <div class="nav navbar-nav ml-auto">
      <a class="nav-item nav-link" href="logout-user.htm?option=logout">
          <i class="fa fa-sign-out"></i> Logout ${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</a>
    </div>
  </div>
</nav>
