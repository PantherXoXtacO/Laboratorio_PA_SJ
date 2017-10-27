<%-- 
    Document   : MiPerfil
    Created on : 25-oct-2017, 12:22:24
    Author     : Usuario
--%>

<%@page import="DataType.DTCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getSession()==null){
        response.sendRedirect("index.html");
    }
    
    DTCliente user = (DTCliente) request.getAttribute("userInfo");
%>
    
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi Perfil</title>
    </head>
    <body>
        
            <%
                out.println("<img src=\""+user.getImg().substring(14)+"\" height=\"200\" width=\"200\">");
                out.println("<form action=\"/Lab/CambiarImagenUsuario\" method=\"POST\" encType=\"multipart/form-data\">"
                        + "Cambiar imagen <br>"
                        + "<input type=\"file\" name=\"pic\" >" //multiple para varios archivos
                        + "<input type=\"submit\" value=\"Cambiar\">"
                        + "</form>");
                out.println("<p> Nick: "+ user.getNick() + "<br>"
                            + "Mail: " + user.getMail()+ "<br>"
                            + "Nombre: " + user.getNom() + "<br>"
                            + "Apellido: " + user.getAp() + "<br>");
            
            %>
            
            <form action ="Logout" method="POST">
            <input type="submit" value="Logout"><br>            
            </form>
    </body>