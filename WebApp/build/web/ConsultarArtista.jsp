<%@page import="DataType.*"%>
<%@page import="java.util.Iterator"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : ConsultarArtista
    Created on : 05-nov-2017, 19:17:05
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataType.DTCliente"%>
<%@page import="java.util.ArrayList"%>
<%
    DTArtista user = (DTArtista) request.getAttribute("userInfo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.println(user.getNick()); %></title>
    </head>
    <body>
        <img src="<%out.println(user.getImg().substring(14));%>" width="200" height="200" alt="Imagen de usuario"/>
        <h3>Datos</h3>
        <div>
            <ul>
            <%
                out.println("<li>Nick: " + user.getNick() + "</li>");
                out.println("<li>Mail: " + user.getMail() + "</li>");
                out.println("<li>Nombre: " + user.getNom() + "</li>");
                out.println("<li>Apellido: " + user.getAp() + "</li>");
                out.println("<li>WEB: " + user.getDir_web() + "</li>");
                out.println("<li>Tipo: Artista </li>");
            %>
            </ul>
        </div>
        <h3>BIO</h3>
        <div>
            <p><%out.println(user.getBiografia());%></p>
        </div>
        <h3>Albums</h3>
        <div>
            <%
                Iterator itAlbum = user.getAlbums().iterator();
                DTAlbum album;
                while(itAlbum.hasNext()){
                    album = (DTAlbum) itAlbum.next();
                    out.println("<li>" + album.getNombre() + "(" + album.getAnio() +")</li>");
                }            
            %>
        </div>
            
    </body>
</html>