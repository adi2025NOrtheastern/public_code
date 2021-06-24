<%-- 
    Document   : search-book
    Created on : Apr 19, 2021, 10:31:49 PM
    Author     : aditi
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Not using</title>


 <style>
        table{
            border:3px solid white;
            align:center;
        }
        a{
            text-decoration: underline;
            cursor: pointer;
            color: white;
        }
        span{
            color: red;
        }
        
        body{
        background-color:black;
        color:white;
        
        }
        #toCenter{
          display: table;     
  		  margin-left:auto;
  		  margin-right:auto;
		}
		
		#results{
		background-color:grey;
		color:white;
		padding:2px;
		align:center;
		}
		
		#search{
		background-color:white;
		color:black;
		padding:8px;
		}
        
    </style>
    
       <script>

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

function getResults() {
    if (xmlHttp == null)
    {
        alert("Your browser does not support AJAX!");
        return;
    }
    var key = document.getElementById("name").value;
    var flag = document.querySelector('input[name = "search"]:checked').value;
    var query = "action=search&key=" + key.trim() + "&flag=" + flag.trim();
    xmlHttp.onreadystatechange = function stateChanged()
    {
        if (xmlHttp.readyState == 4)
        {
            document.getElementById("results").innerHTML = "";
           // var json = json.books[0];
            var json = JSON.parse(xmlHttp.responseText);

            if (json.books.length > 0) {
                var x = document.createElement("TABLE");
                x.setAttribute("id", "myTable");
                document.getElementById("results").appendChild(x);
                var y = document.createElement("TR");
                y.setAttribute("id", "myTr");
                document.getElementById("myTable").appendChild(y);

                var z = document.createElement("TH");
                var t = document.createTextNode("ISBN");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);
                
                var z = document.createElement("TH");
                var t = document.createTextNode("Title");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                var z = document.createElement("TH");
                var t = document.createTextNode("Author");
                z.appendChild(t);
                document.getElementById("myTr").appendChild(z);

                for (var count = 0; count < json.books.length; count++) {
                    var y = document.createElement("TR");
                    y.setAttribute("id", "myTr" + count);
                    document.getElementById("myTable").appendChild(y);
                    
                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.books[count].isbn);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.books[count].title);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                    var z = document.createElement("TD");
                    var t = document.createTextNode(json.books[count].author);
                    z.appendChild(t);
                    document.getElementById("myTr" + count).appendChild(z);

                }
            } else {
                document.getElementById("results").innerHTML="Nothing Found";
            }
        }
    };
    xmlHttp.open("POST", "search.htm", true);
    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttp.send(query);
    return false;
}  
 
</script>
</head>

<body>
 
<div id="toCenter">
<h4> Click on the button to display search form: 
 <button onclick="searchFormDisplay()">Show Form</button></h4>
 
   <div id="searchForm" style="display: none;">
            <h3 align="center">Search Form</h3>
            <form id="search" onsubmit="return getResults();">
                Search Book <br><br> <input type="text" id="name" name="book" pattern='[a-zA-Z0-9 ]{0,}' title="Please enter valid input." /> <br><br>
                <label>Search By:</label> <br><br>
                <input type="radio" name="search" value="title" checked="checked"/> Title <br><br>
                <input type="radio" name="search" value="author"/> Author <br><br>
               <!--  <input type="radio" name="search" value="genre"/> Genre -->
                <input type="radio" name="search" value="isbn"/> ISBN <br><br>
                <input type="submit" name="Search Book"/><br><br>
            </form>
            <h4>Your result will be displayed here:</h4>
            <div id="results">
            </div>
   </div>   
</div>
</body>
</html>