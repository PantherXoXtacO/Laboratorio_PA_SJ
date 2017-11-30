<%-- 
    Document   : AltaTema
    Created on : 07-nov-2017, 17:33:01
    Author     : TISJ
--%>

<%@page import="pkgWS.ArrayList"%>
<%@page import="pkgWS.DtCliente"%>
<%@page import="pkgWS.PublicadorService"%>
<%@page import="pkgWS.Publicador"%>
<%@page import="pkgWS.DtUsuario"%>
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
       DtUsuario user= ICU.getUserData(usernick);
       if(user instanceof DtCliente){
           response.sendRedirect("index.jsp"); 
       }
    }
    //Fabrica fabrica = Fabrica.getInstance();
    //IControlador ICU = fabrica.getIControlador();    
    PublicadorService service = new pkgWS.PublicadorService();
    Publicador ICU = service.getPublicadorPort();
    ArrayList albums = ICU.getAlbumsListtoString();
    System.out.println(albums);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>            
        <h1>Agregar temas al album:</h1>
        <form action="/Lab/AltaTema" method="post">
            <input type="hidden" name="hiddenTemp1" id="hiddenTemp1" value="<%=albums%>">
           <p>Nombre: </p>
           <input type="text" name="nombre_tema" value="" />
           <p>Duracion: </p>
           <input type="text" name="duracion_tema" value="" />
           <p>Ubicacion en el album: </p>
           <input type="text" name="ubicacion_tema" value="" />   
           <p>Album: </p>
           <select id="albums" name="albums">
               <script type="text/javascript">                    
                    function myFunction(){
                        var generos = document.getElementById("hiddenTemp1").value;
                        var generos2 = generos.match(/\w+/g);
                        var arrayLength = generos2.length;
                        var x = document.getElementById("albums"); 
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
           <input type="submit" value="Agregar tema" />    
        </form>
    </body>
</html>
