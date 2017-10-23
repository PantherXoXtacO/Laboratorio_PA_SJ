<%-- 
    Document   : Welcome
    Created on : 20-oct-2017, 13:48:15
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          if(session.getAttribute("UserNick")==null){
              response.sendRedirect("index.html");
          }
        %>
        <h1>Ususario logueado : ${UserNick}</h1>
        
        <form action ="Logout" method="POST">
            <input type="submit" value="Logout"><br>            
        </form>
    </body>
</html>
