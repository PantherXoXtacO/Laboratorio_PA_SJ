<%-- 
    Document   : Registrar
    Created on : 21-oct-2017, 1:10:34
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action ="Registrar" method="POST">
            Nick:
            <input type="Text" size="20" name="userNick"><br>
            Mail:
            <input type="Text" size="20" name="userMail"><br>
            Nombre:
            <input type="Text" size="20" name="userNom"><br>
            Apellido:
            <input type="Text" size="20" name="userApellido"><br>
            Fecha de Nacimiento:
            <input type="date" name="FechaDeNacimiento"><br>  
            Pass:
            <input id="contra" type="password" size="20" name="userPass"><br>
            Confirmar Pass:
            <input id="contra2" type="password" size="20" name="userPass2" onkeyup="checkPasswordMatch();"><dib id="passMatch"> </dib> <br>          
            <input id="botonRegistro" type="submit" value="Registar" disabled="true"><br>
        </form>
    </body>
    
    
    
    <script>function checkPasswordMatch() {
        var password = document.getElementById("contra").value;
        var confirmPassword  = document.getElementById("contra2").value;

        if (password !== confirmPassword){
            document.getElementById('passMatch').innerHTML = ' Las contraseñas no coinsiden';
            document.getElementById('botonRegistro').disabled = true;
        }
        else{
            document.getElementById('passMatch').innerHTML = '';
            document.getElementById('botonRegistro').disabled = false;
        }
    }
    </script>
    
</html>



