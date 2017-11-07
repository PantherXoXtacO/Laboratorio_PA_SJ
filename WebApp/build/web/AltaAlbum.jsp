<%-- 
    Document   : AltaAlbum
    Created on : 04-nov-2017, 16:30:03
    Author     : Casca
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Genero"%>
<%@page import="Logica.Album"%>
<%@page import="DataType.DTCliente"%>
<%@page import="DataType.DTUsuario"%>
<%@page import="Logica.IControlador"%>
<%@page import="Logica.Fabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    //Scriptlet
    Object username = session.getAttribute("UserNick");
    if(username==null){
        response.sendRedirect("index.jsp"); 
    } 
     else{
       String usernick = (String) username;
       Fabrica fabrica = Fabrica.getInstance();
       IControlador ICU = fabrica.getIControlador();
       DTUsuario user= ICU.getUserData(usernick);
       if(user instanceof DTCliente){
           response.sendRedirect("index.jsp"); 
       }
    }
    Fabrica fabrica = Fabrica.getInstance();
    IControlador ICU = fabrica.getIControlador();    
    Album album = ICU.getTemporalAlbum();
    if(album==null){
        ICU.createTemporalAlbum();
        album = ICU.getTemporalAlbum();
    }
    
    List<String> generos = ICU.getGenerosInString();    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Album</title>
    </head>
    <body>
        <form action="/Lab/AltaAlbum" method="post">
            <input type="hidden" name="hiddenTemp1" id="hiddenTemp1" value="<%=generos%>">
            <p>Nombre: </p>
            <input type="text" name="nombre_album" value="" />
            <p>Año de creacion: </p>
            <input type="text" name="anio_album" value="" />
            <p>Genero: </p>
            <select name="dropdown3" id="mySelect">
                <script type="text/javascript">                    
                    function myFunction(){
                        var generos = document.getElementById("hiddenTemp1").value;
                        var generos2 = generos.match(/\w+/g);
                        var arrayLength = generos2.length;
                        var x = document.getElementById("mySelect"); 
                        var test2 = [];
                        for (var i = 0; i < arrayLength; i++) {
                            test2[i] = document.createElement("option");
                            test2[i].text = generos2[i];
                            x.add(test2[i]);
                        }                        
                    }
                    window.onload = myFunction;
                </script>
            </select>
            <h1>imagen </h1>
            <input type="submit" value="Crear Album" />
        </form>
        
        
        <%
        out.println("<h1>"+ "Temas agregados: " + album.getTemas().size() +"</h1>"); 
         %>
            
            
           
        
    </body>
</html>


    