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
    List<String> albums = ICU.getAlbumsListtoString();
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="js/agregarGenero.js" type="text/javascript"></script>
        <title>Alta Album</title>
    </head>
    <body>
        <form action="/Lab/AltaAlbum" method="post">
            <input type="hidden" name="hiddenTemp1" id="hiddenTemp1" value="<%=generos%>">
            <p>Nombre: </p>
            <input type="text" name="nombre_album" value="" />
            <p>Año de creacion: </p>
            <input type="text" name="anio_album" value="" />
            <p id="p2">Genero: </p>
            <select name="mySelect" id="mySelect">
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
            <input type="submit" value="Crear Album" />
        </form>     
            
        <form>
            <input type="hidden" name="hiddenTemp2" id="hiddenTemp2">
            <input type="submit" value="Agregar Genero" id="agregarAlbumBtn" /> 
        </form>
           
            
        
        <input type="submit" value="Cambiar imagen" />
        <h1 id="keker" name="keker"> lel </h1>
        
        <script type="text/javascript">
            $(document).ready(function(){            
            //$("#p2").addClass("blue");
            //$("#p2").hide();
            var v = $("#mySelect option:selected").text();
            //window.alert(v);
            $("#keker").text("kek");
            });
        </script> 
        <style type="text/css">
            .blue { color: blue; }
        </style>
        
    </body>
</html>


    