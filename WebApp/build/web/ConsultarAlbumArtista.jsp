<%-- 
    Document   : ConsultarAlbumArtista
    Created on : 06-nov-2017, 8:56:30
    Author     : Casca
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.IControlador"%>
<%@page import="Logica.Fabrica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
       Fabrica fabrica = Fabrica.getInstance();
       IControlador ICU = fabrica.getIControlador();
       List<String> artistas = ICU.getArtistas();
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Album</title>
    </head>
    <body>
        <form action="/Lab/ConsultarAlbumGenero" method="POST">
            <h1>Artistas: </h1>
            <input type="hidden" name="hiddenTemp1" id="hiddenTemp1" value="<%=artistas%>">
            <select id="dropdown1" name="dropdown1" onchange="myFunction2();" >
                <script type="text/javascript">                    
                    function myFunction(){
                        var generos = document.getElementById("hiddenTemp1").value;
                        var generos2 = generos.match(/\w+/g);
                        var arrayLength = generos2.length;
                        var x = document.getElementById("dropdown1"); 
                        var test2 = [];
                        for (var i = 0; i < arrayLength; i++) {
                            test2[i] = document.createElement("option");
                            test2[i].text = generos2[i];
                            x.add(test2[i]);
                        }                        
                    }
                    window.onload = myFunction;
                    document.write(fLen);
                </script>
            </select>
            <h1>Albums: </h1>
            <select id="dropdown2"  name="dropdown2">
                <script type="text/javascript">                    
                    function myFunction2(){
                        var array = document.getElementById("hiddenTemp1").value;
                        var array2 = array.match(/\w+/g);
                        var arrayLength = array2.length;
                        var x = document.getElementById("dropdown2"); 
                        var length = x.options.length;
                        for (i = 0; i < length; i++) {
                          select.x[i] = null;
                        }
                        var test2 = [];
                        for (var i = 0; i < arrayLength; i++) {
                            test2[i] = document.createElement("option");
                            test2[i].text = array2[i];
                            x.add(test2[i]);
                        }                        
                    }                    
                </script>                
            </select>
            <input type="submit" value="Consultar Album" />
        </form>
    </body>
</html>
