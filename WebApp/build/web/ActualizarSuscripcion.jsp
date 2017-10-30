<%-- 
    Document   : ActualizarSuscripcion
    Created on : 30-oct-2017, 13:25:48
    Author     : Casca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ActualizarSuscripcion</title>
    </head>
    <body>
        <h1>Estado de suscripcion:</h1>
        <h1>Estado</h1>
        <h1>Nuevo estado:</h1>
        <h1 name="EstadoSiPendiente"> Deseo cancelar mi suscripcion  </h1>
        <input type="checkbox" name="Cancelar" value="ON" />
        <select name="EstadoSiVencida">
            <option>Cancelar</option>
            <option>Renovar</option>
        </select>
    </body>
</html>
