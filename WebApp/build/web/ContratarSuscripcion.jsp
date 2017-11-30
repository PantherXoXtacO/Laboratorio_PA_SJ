<%-- 
    Document   : ContratarSuscripcion
    Created on : 29-oct-2017, 12:45:55
    Author     : Casca
--%>

<%@page import="pkgWS.Publicador"%>
<%@page import="pkgWS.PublicadorService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("UserNick")==null){
             response.sendRedirect("index.jsp");
    }
    else{
       String usernick = (String) session.getAttribute("UserNick");
       //Fabrica fabrica = Fabrica.getInstance();
       //IControlador ICU = fabrica.getIControlador();
       PublicadorService service = new pkgWS.PublicadorService();
       Publicador ICU = service.getPublicadorPort();
       DTUsuario user= ICU.getUserData(usernick);
       if(user instanceof DTArtista){
           response.sendRedirect("index.jsp"); 
       }
    }
%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ContratarSuscripcion</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Tipos de suscripcion</th>
                    <th>Precio</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Semanal</td>
                    <td>7</td>
                </tr>
                <tr>
                    <td>Mensual</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>Anual</td>
                    <td>300</td>
                </tr>
            </tbody>
        </table>
        
        <form action="/Lab/ContratarSuscripcion" method="POST">
            <select name="TiposDeSuscripciones">
            <option>Semanal</option>
            <option>Mensual</option>
            <option>Anual</option>
        </select>
            <input type="submit" value="submit">            
        </form>
    </body>
</html>
