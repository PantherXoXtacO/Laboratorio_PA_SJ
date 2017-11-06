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
    
    List<String> generos = ICU.getGenerosInString();    
    //List<Genero> generos = ICU.getGeneroItem();
    //List<String> generos = ICU.getGenerosInString();    
    //List<String> generos_string = ICU.GenerosToString(generos);
    //System.out.println(generos_string);
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
            <input type="text" name="año_album" value="" />
            <p>Genero: </p>
            <select id="mySelect">
                <script type="text/javascript">                    
                    function myFunction(){
                        var generos = document.getElementById("hiddenTemp1").value;
                        var arrayLength = generos.length;
                        var x = document.getElementById("mySelect"); 
                        
                       
                        
                        var test =["Rock", "Nacional", "Pop"];
                        
                        var test2 = [];
                        for (var i = 0; i < 3; i++) {
                            test2[i] = document.createElement("option");
                            test2[i].text = test[i];
                            x.add(test2[i]);
                        }
                        
                        
                    }
                    window.onload = myFunction;
                    document.write(fLen);  
                </script>
            </select>
            <h1>imagen </h1>
            <input type="submit" value="Crear Album" />
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


    