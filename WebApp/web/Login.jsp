<%-- 
    Document   : Login
    Created on : 26-oct-2017, 20:19:06
    Author     : TISJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="/Lab/Login" method="POST">
            <input type="text" name="name" size="20">
            <input type="password" name="pass" size="20">
            <input type="submit" value="Ingresar">            
        </form>
    </body>
</html>
