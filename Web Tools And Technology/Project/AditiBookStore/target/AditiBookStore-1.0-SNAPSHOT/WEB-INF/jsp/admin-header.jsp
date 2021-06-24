<%-- 
    Document   : admin-header
    Created on : Apr 16, 2021, 8:30:47 PM
    Author     : aditi
--%>

<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Aditi Online Book Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link" href="redirect-admin-home.htm">Home <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="redirect-approve-seller.htm">Approve Seller</a>
      <a class="nav-item nav-link" href="redirect-add-genre.htm">Add New Category/Genre of Book</a>
      <a class="nav-item nav-link" href="redirect-update-genre.htm">Update Category/Genre of Book</a>
      <a class="nav-item nav-link" href="view-dashboard.htm?option=view">View Dashboards</a>
      <a class="nav-item nav-link" href="view-all-sellers.htm">View All Sellers</a>
      </div>
      <div class="nav navbar-nav ml-auto">
      <a class="nav-item nav-link" href="logout-user.htm?option=logout">
          <i class="fa fa-sign-out"></i> Logout ${sessionScope.user.getUsername()}</a>
    </div>
  </div>
</nav>