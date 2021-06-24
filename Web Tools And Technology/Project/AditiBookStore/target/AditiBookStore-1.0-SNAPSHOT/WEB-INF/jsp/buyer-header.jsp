<%-- 
    Document   : buyer-header
    Created on : Apr 16, 2021, 8:33:12 PM
    Author     : aditi
--%>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Aditi Online Book Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link <%=request.getParameter("home")%>" href="redirect-buyer-home.htm">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link <%=request.getParameter("display-book")%>" href="redirect-buy-book.htm?limit=3&offset=0">Buy Book</a>
      <a class="nav-item nav-link <%=request.getParameter("view order")%>" href="redirect-view-my-orders.htm">View Orders</a>
      <a class="nav-item nav-link <%=request.getParameter("view-cart")%>" href="redirect-view-my-cart.htm">View Cart</a>

      <a class="nav-item nav-link <%=request.getParameter("myProfile")%>" href="redirect-my-profile.htm">My Profile</a>
      </div>
      <div class="nav navbar-nav ml-auto">
      <a class="nav-item nav-link" href="logout-user.htm?option=logout">
          <i class="fa fa-sign-out"></i> Logout ${sessionScope.user.getFirstName()} ${sessionScope.user.getLastName()}</a>
    </div>
  </div>
</nav>
   