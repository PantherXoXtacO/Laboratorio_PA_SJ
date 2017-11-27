<%-- 
    Document   : AgregarGenerosAlAlbum
    Created on : 23-nov-2017, 18:32:32
    Author     : Casca
--%>

<%@page import="java.util.List"%>
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
    
    //Fabrica fabrica = Fabrica.getInstance();
    //IControlador ICU = fabrica.getIControlador(); 
    //Album album = ICU.getTemporalAlbum();
    //if(album==null){
    //    ICU.createTemporalAlbum();
    //    album = ICU.getTemporalAlbum();
    //}
    
    List<String> generos = ICU.getGenerosInString();   
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
        <title>Agregar Generos al Album</title>
    </head>
    <body>
        <form action="/Lab/AgregarGenerosAlAlbum" method="POST">
            <input type="hidden" name="hiddenTemp1" id="hiddenTemp1" value="<%=generos%>">
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
            <div> </div>
            <b>Generos Agregados: </b>
            <div>
                <input type="hidden" name="genreList" id="genreList">
                <b id="generosMostrados" value=""></b>
            </div>            
            <div> </div>
            <button type=button value="Agregar Genero" id="agregarAlbumBtn" onclick="myFunction2()">Agregar Genero</button>           
            <div> </div>
            <input type="submit" value="Next" id="NextBtn"/> 
        <script type="text/javascript">                    
                    function myFunction2(){
                        var genero = document.getElementById("mySelect").value; 
                        var genreList = document.getElementById("genreList");
                        var generosMostrados = document.getElementById("generosMostrados");
                        genreList.value += genero + " ";
                        generosMostrados.append(genero + " ");
                    }
        </script>
        </form>
            
         
        
    </body>
</html>
