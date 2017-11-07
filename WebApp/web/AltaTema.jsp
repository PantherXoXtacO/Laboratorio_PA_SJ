<%-- 
    Document   : AltaTema
    Created on : 07-nov-2017, 17:33:01
    Author     : TISJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>            
        <h1>Agregar temas al album:</h1>
        <form action="/Lab/AltaTema" method="post">
           <p>Nombre: </p>
           <input type="text" name="nombre_tema" value="" />
           <p>Duracion: </p>
           <input type="text" name="duracion_tema" value="" />
           <p>Ubicacion en el album: </p>
           <input type="text" name="ubicacion_tema" value="" />            
           <input type="submit" value="Agregar tema" />    
           <input type="hidden" name="formSelect" values="tema"/>
        </form>
    </body>
</html>
