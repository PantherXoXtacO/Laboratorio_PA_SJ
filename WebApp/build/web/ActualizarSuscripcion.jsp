<%-- 
    Document   : ActualizarSuscripcion
    Created on : 30-oct-2017, 13:25:48
    Author     : Casca
--%>

<%@page import="DataType.DTArtista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if(request.getSession()==null){
        response.sendRedirect("index.html");
    }
    
    DTArtista user = (DTArtista) request.getAttribute("userInfo");
    String username = "userNotFound";
    if(user!=null){
         username = user.getNick();
    }
        
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ActualizarSuscripcion</title>
    </head>
    <body>
        <h1>Estado de suscripcion del usuario:</h1>
        <% System.out.println(username);
            %>
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
