
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
    DTCliente user = (DTCliente) request.getAttribute("userInfo");
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
                out.println("<li>Tipo: Cliente </li>");
            %>
            </ul>
        </div>
        <h3>Listas de reproducción creadas por este usuario</h3>
        <div>
            <ul>
            <%  
                Iterator itListasRepro = user.getListasDeReproduccion().iterator();
                DTListaPrticular L;
                while(itListasRepro.hasNext()){
                    L = (DTListaPrticular) itListasRepro.next();
                    if(!L.isPrivacidad()){
                        out.println("<li>" + L.getNombre() + "</li>");
                    }
                }

            %>
            </ul>
        </div>
        <h2>Favoritos</h>
        <h3>Temas</h3>
        <div>
            <ul>
            <%
                Iterator itTemas = user.getTemasFav().iterator();
                DTTema tema;
                while(itTemas.hasNext()){
                    tema = (DTTema) itTemas.next();
                    out.println("<li>" + tema.getNombre() + "</li>");
                }
            %>
            </ul>
        </div>
        <h3>Albums</h3>
        <div>
            <ul>
                <%
                    Iterator itAlbum = user.getAlbumFav().iterator();
                    DTAlbum album;
                    while(itAlbum.hasNext()){
                        album = (DTAlbum) itAlbum.next();
                        out.println("<li>" + album.getNombre() + "</li>");
                    }
                %>
            </ul>
        </div>
        <h3>Listas</h3>
        <div>
            <ul>
                <%
                    Iterator itListasFav = user.getListasFav().iterator();
                    DTListaDefecto LD;
                    while(itListasFav.hasNext()){
                        LD = (DTListaDefecto) itListasFav.next();
                        out.println("<li>" + LD.getNombre() + "</li>");
                    }
                %>
            </ul>
        </div>
        
        <h2>Siguiendo</h2>            
        <div>
            <ul>
               <%
                   Iterator itSiguiendo = user.getSiguiendo().iterator();
                   DataSession user_siguiendo;
                   while(itSiguiendo.hasNext()){
                       user_siguiendo = (DataSession) itSiguiendo.next();
                       out.println("<li>" + user_siguiendo.getNick() + "</li>");
                   }
               %>
            </ul>    
        </div>
            
        <h2>Seguidores</h2>
        <div>
            <ul>
                <%
                    Iterator itSeguidores = user.getSeguidores().iterator();
                    DTUsuario user_seguidores;
                    while(itSeguidores.hasNext()){
                        user_seguidores = (DTUsuario) itSeguidores.next();
                        out.println("<li>" + user_seguidores.getNick() + "</li>");
                    }
                %>
            </ul>
        </div>
   <%
        if(request.getSession().getAttribute("UserNick")!=null){
            if((Boolean)request.getSession().getAttribute("EsArtista") == false){
                IControlador controlador = new Controlador();
                String seguidor = (String) request.getSession().getAttribute("UserNick");
                //String seguido = (String) request.getSession().getAttribute("userConsult");
                if(!user.yaSigue(seguidor)){
                    out.println("<form name=\"SeguirUser\" action=\"/Lab/SeguirUser\" method=\"POST\">");
                    if(user.getNick().equals(request.getSession().getAttribute("UserNick"))){
                        out.println("<input type=\"submit\" value=\"Seguir\" disabled=\"true\">");
                    }
                    else{
                        out.println("<input type=\"submit\" value=\"Seguir\" >");
                    }
                    out.println("</form>"); 
                }
                else{
                    out.println("<form name=\"DejarDeSeguirUser\" action=\"/Lab/DejarDeSeguirUser\" method=\"POST\">");
                    out.println("<input type=\"submit\" value=\"Dejar De Seguir\" >");
                    out.println("</form>");
                }
            }
        }
    %>
        
    </body>
</html>
