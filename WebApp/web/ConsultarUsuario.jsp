<%-- 
    Document   : ConsultarUsuario
    Created on : 06-nov-2017, 12:04:09
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Usuario</title>
    </head>
    <body>
        <h1>Consultar Usuario</h1>
        <form name="ConsultarUsuario" action="/Lab/VerInfoUser" method="GET">
            Nick o Mail del usuario:
            <input type="Text" size="20" name="dataname">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
