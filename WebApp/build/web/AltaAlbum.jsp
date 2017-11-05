<%-- 
    Document   : AltaAlbum
    Created on : 04-nov-2017, 16:30:03
    Author     : Casca
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Genero"%>
<%@page import="Logica.Album"%>
<%@page import="DataType.DTCliente"%>
<%@page import="DataType.DTUsuario"%>
<%@page import="Logica.IControlador"%>
<%@page import="Logica.Fabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    Object username = session.getAttribute("UserNick");
    if(username==null){
        response.sendRedirect("index.html"); 
    } 
     else{
       String usernick = (String) username;
       Fabrica fabrica = Fabrica.getInstance();
       IControlador ICU = fabrica.getIControlador();
       DTUsuario user= ICU.getUserData(usernick);
       if(user instanceof DTCliente){
           response.sendRedirect("index.html"); 
       }
    }
    Fabrica fabrica = Fabrica.getInstance();
    IControlador ICU = fabrica.getIControlador();    
    Album album = ICU.getTemporalAlbum();
    if(album==null){
        ICU.createTemporalAlbum();
        album = ICU.getTemporalAlbum();
    }
    List<Genero> generos = ICU.getGeneroItem();
    System.out.println(generos);
%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Album</title>
    </head>
    <body>
        <form action="/Lab/AltaAlbum" method="post">
            <p>Nombre: </p>
            <input type="text" name="nombre_album" value="" />
            <p>Año de creacion: </p>
            <input type="text" name="año_album" value="" />
            <p>Genero: </p>
            <select name="Generos">
                <option></option>
                <option></option>
            </select>
            <h1>imagen </h1>
            <input type="submit" value="Crear Album" />
            <input type="hidden" name="formSelect" values="album"/>
        </form>
        
        <h1>Agregar temas al album:</h1>
        <form action="/Lab/AltaAlbum" method="post">
           <p>Nombre: </p>
           <input type="text" name="nombre_tema" value="" />
           <p>Duracion: </p>
           <input type="text" name="duracion_tema" value="" />
           <p>Ubicacion en el album: </p>
           <input type="text" name="ubicacion_tema" value="" />            
           <input type="submit" value="Agregar tema" />    
           <input type="hidden" name="formSelect" values="tema"/>
        </form>
        
        <%
        out.println("<h1>"+ "Temas agregados: " + album.getTemas().size() +"</h1>"); 
         %>
            
            
           
        
    </body>
</html>

<script>function addTema() {    
    var album = session.getAttribute("Album")
    var nombre_tema = document.getElementById('nombre_tema').value;
    var duracion_tema = document.getElementById('duracion_tema').value;
    var ubicacion_tema = document.getElementById('ubicacion_tema').value;
    var tema = {
        nombre_tema: nombre_tema,
        duracion_tema: duracion_tema,
        ubicacion_tema: ubicacion_tema
        
    };
    album.
    return tema;        
}</script>
    