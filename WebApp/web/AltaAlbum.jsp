<%-- 
    Document   : AltaAlbum
    Created on : 04-nov-2017, 16:30:03
    Author     : Casca
--%>



<%@page import="pkgWS.ArrayList"%>
<%@page import="pkgWS.Album"%>
<%@page import="pkgWS.Publicador"%>
<%@page import="pkgWS.PublicadorService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    //Scriptlet
    Object username = session.getAttribute("UserNick");
    if(username==null){
        response.sendRedirect("index.jsp"); 
    } 
     else{
       String usernick = (String) username;
       //Fabrica fabrica = Fabrica.getInstance();
       //IControlador ICU = fabrica.getIControlador();
       PublicadorService service = new pkgWS.PublicadorService();
       Publicador ICU = service.getPublicadorPort();
       DTUsuario user= ICU.getUserData(usernick);
       if(user instanceof DTCliente){
           response.sendRedirect("index.jsp"); 
       }
    }
    //Fabrica fabrica = Fabrica.getInstance();
    //IControlador ICU = fabrica.getIControlador(); 
    PublicadorService service = new pkgWS.PublicadorService();
    Publicador ICU = service.getPublicadorPort();
    String listaDeGeneros = (String) session.getAttribute("generosAgregados");    
    Album album = ICU.getTemporalAlbum();
    if(album==null){
        ICU.createTemporalAlbum();
        album = ICU.getTemporalAlbum();
    }
    
    ArrayList generosTemp = ICU.getTemporalGenres();
    if(generosTemp==null){
        ICU.createTemporalGenres();
        generosTemp = ICU.getTemporalGenres();
    }
    //ICU.AltaGenero("GeneroTest3", "General");
    //ICU.AltaGenero("GeneroTest2", "General");
    %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
        <title>Alta Album</title>
    </head>
    <body>
        <form action="/Lab/AltaAlbum" method="post">
            <input type="hidden" name="generos_album" value="<%=listaDeGeneros%>"> 
            <p>* Nombre: </p>
            <input type="text" name="nombre_album"/>
            <p>* Año de creacion: </p>
            <input type="text" name="anio_album"/>    
            <p>Ruta de la imagen: </p>
            <div> 
            <input name="imagen_album">
            <input type="button" name="imagen_album" value="Cambiar imagen" />
            </div>
            <input type="submit" value="Crear Album" />   
            <p>Los campos necesarios estan marcados con *</p>
        </form>     
    </body>
</html>


    