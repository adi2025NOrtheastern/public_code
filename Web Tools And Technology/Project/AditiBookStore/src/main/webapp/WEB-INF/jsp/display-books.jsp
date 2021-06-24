<%-- 
    Document   : display-books
    Created on : Apr 19, 2021, 10:28:34 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- shows books to buyer-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <title>Display Books</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
                border: 1px solid black;
            }

            th, td {
                text-align: left;
                padding: 8px;
                border: 1px solid black;
            }

            tr:nth-child(odd){background-color: bisque;
                              color:black;}
            tr:nth-child(even){background-color: lightblue;
                               color:black;}

            th {
                background-color: grey;
                color: black;
            }

            body{
                color: blue;
                background-color: white; 
            }

            a{
                color:blue;
            }
        </style>
        <script type="text/javascript">
          


            //  ajaxbook tiles by initials suggested are retuning
            function ajaxBookName() {
                var xmlHttp;
                try { //firefox, opera
                    xmlHttp = new XMLHttpRequest();
                } catch (e) {
                    try { //IE
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e) {
                        try {
                            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                        } catch (e)
                        {
                            alert("AJAX not suppported!");
                            return false;
                        }
                    }
                }


//= $("input[type='radio'][name='search']:checked").val();
var searchBy = document.querySelector('input[name = "search"]:checked').value;

//alert(a);

                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4)
                    {
                        document.getElementById("bookTitle").innerHTML = "Suggested by "+searchBy + ":- " + xmlHttp.responseText;
                    }
                }
                // searching by book prefix- to give suggestions and then user clicks on submit to get results(diaplyed by refreshing page)

                var name = document.getElementById("bookname").value;
                //var genreId = document.querySelector('input[name = "searchGenre"]:selected').value;//document.getElementById("searchGenre").value;

                 var e = document.getElementById("genreselect");
                var genreId = e.value;
                //alert(genreId);
                //alert("Marking Complete");
                // var myMsg = document.getElementById("msg").value;

                if(searchBy == 'genre')
                {
                     xmlHttp.open("POST", "search-book.htm?initial="+name+"&searchBy="+searchBy+"&searchGenre="+genreId, true);
                }
                else{
                xmlHttp.open("POST", "search-book.htm?initial=" + name+"&searchBy="+searchBy, true);
            }


                xmlHttp.send();
                
                

            }

            // searcj book
            function searchFormDisplay() {
                if (document.getElementById("searchForm").style.display === "none") {
                    document.getElementById("searchForm").style.display = "block";
                    document.getElementById("search").reset();
                    document.getElementById("results").innerHTML = "";
                    //document.getElementById("registrationForm").style.display = "none";
                } else {
                    document.getElementById("searchForm").style.display = "none";
                }
            }
//AJAX

            function GetXmlHttpObject()
            {
                var xmlHttp = null;
                try
                {
                    // Firefox, Opera 8.0+, Safari
                    xmlHttp = new XMLHttpRequest();
                } catch (e)
                {
                    // Internet Explorer
                    try
                    {
                        xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                    } catch (e)
                    {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                }
                return xmlHttp;
            }


            var xmlHttp;
            xmlHttp = GetXmlHttpObject();

           



        </script>

    </head>
    <body style="margin-top: 100px">
        <jsp:include page="buyer-header.jsp" >
            <jsp:param name="home" value="active" />
        </jsp:include>
        <!--h4> Click on the button to display search form: 
     <button onclick="searchFormDisplay()">Show Form</button></h4--> 
        <a href="redirect-buy-book.htm?limit=3&offset=0"> 1 Page </a>
        <a href="redirect-buy-book.htm?limit=3&offset=3"> 2 Page </a>
        <a href="redirect-buy-book.htm?limit=3&offset=6"> 3 Page </a>

        <a href="redirect-buy-book.htm"> All Pages </a>
        <div id="searchForm" align="center">
            <h3 align="center">Search Form</h3>
            <form  id="search" action="search.htm" method="POST">
                
                  <label>Search By:</label> <br/>
                  
                 
                <input type="text" id="bookname" name="bookName" pattern='[a-zA-Z0-9 ]{0,}' title="Please enter book title." onKeyUp="ajaxBookName();"/> <br/><br/>

                 <span id="bookTitle" STYLE="color: green; font-size: 15pt">

        </span>
                <br/>

              
                <input type="radio" name="search" value="title" checked="checked"/> Title <br/>
                <input type="radio" name="search" value="author"/> Author <br/>

                <input type="radio" name="search" value="isbn"/> ISBN <br/>

                <input type="radio" name="search" value="genre"> Genre 
                <select name="searchGenre" id="genreselect">
                    <!--option value="volvo">Volvo</option-->

                    <c:forEach var="msg" items="${sessionScope.genreList}">
                        <option id="${msg.genreId}" value="${msg.genreId}">${msg.genreName}</option>

                    </c:forEach>
                </select>
                <input type="submit" value= "Search" name="Search Book"/><br/>
            </form>


            
            <div id="results">
            </div>
        </div>
        <!-- <form action="addtocart.htm" method="post"> -->
       
        <br/>
        
        
        
          
        <table>
            <tr>
                <td><b>Photo</b></td>
                <td><b>ISBN</b></td>
                <td><b>Title</b></td>
                <td><b>Genre</b></td>
                <td><b>Author</b></td>
                <td><b>Price</b></td>
                <td><b>Description</b></td>

                <td><b>Select Item</b></td>

            </tr>
            <!--test if searchBookList is null == means display all obooks -->
            
            <c:if test="${requestScope.searchBookList==null}">
                <c:forEach var="book" items="${sessionScope.bookList}">
                <c:if test = "${book.sold=='No'}"> 
                    <tr>
                        <td><img height="150" width="150" src="/userimages/${book.photoName}" /></td> 
                        <td>${book.isbn}</td>
                        <td>${book.title}</td>

                        <c:forEach var="genre" items="${sessionScope.genreList}">
                            <c:if test = "${book.genreId==genre.genreId}"> 
                                <td>${genre.genreName}</td>
                            </c:if>
                        </c:forEach>

                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.description}</td>
                        <td>
    <!--a href="add-to-cart.htm?id=${book.bookId}&action=addtocart">Add To Cart</a-->

    <!--a href="message-seller.htm?id=${book.bookId}&action=msgSeller">Message Seller</a-->

                            <a href="view-book-details.htm?id=${book.bookId}&action=viewBookDetails">View Book Details</a>

                        </td>

                    </tr>
                </c:if>
            </c:forEach>
                
                
            </c:if>
                    
                    
                    <c:if test="${requestScope.searchBookList!=null}">
                <c:forEach var="book" items="${requestScope.searchBookList}">
                <c:if test = "${book.sold=='No'}"> 
                    <tr>
                        <td><img height="150" width="150" src="/userimages/${book.photoName}" /></td> 
                        <td>${book.isbn}</td>
                        <td>${book.title}</td>

                        <c:forEach var="genre" items="${sessionScope.genreList}">
                            <c:if test = "${book.genreId==genre.genreId}"> 
                                <td>${genre.genreName}</td>
                            </c:if>
                        </c:forEach>

                        <td>${book.author}</td>
                        <td>${book.price}</td>
                        <td>${book.description}</td>
                        <td>
    <!--a href="add-to-cart.htm?id=${book.bookId}&action=addtocart">Add To Cart</a-->

    <!--a href="message-seller.htm?id=${book.bookId}&action=msgSeller">Message Seller</a-->

                            <a href="view-book-details.htm?id=${book.bookId}&action=viewBookDetails">View Book Details</a>

                        </td>

                    </tr>
                </c:if>
            </c:forEach>
                
                
            </c:if>
            
            
            
        </table>
        <br/><br/>



    </body>
</html>
