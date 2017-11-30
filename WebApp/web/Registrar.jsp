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
        <title>Registro</title>
        <script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
        <script src="resources/js/CheckMailUse.js" type="text/javascript"></script>
    </head>
    
    <body>
        <form id="FormRegistro" name="FormRegistro" action ="/Lab/Registrar" method="POST">
            Nick*:
            <input id="userNick" type="Text" size="20" name="userNick"><z id="UsedNick"></z><br> 
            Mail*:
            <input id="userMail" type="email" size="20" name="userMail"><z id="UsedMail"></z><br> 
            Nombre:
            <input type="Text" size="20" name="userNom"><br>
            Apellido:
            <input type="Text" size="20" name="userApellido"><br>
            Fecha de Nacimiento:
            <input type="date" name="FechaDeNacimiento"><br>  
            Pass:
            <input id="contra" type="password" size="20" name="userPass" onkeyup="HabilitarBoton();"><br>
            Confirmar Pass:
            <input id="contra2" type="password" size="20" name="userPass2" onkeyup="HabilitarBoton();"><div id="passMatch"> </div> <br>
            ¿Eres artista?
            <input id="radioButtonEsArtista" type="radio" name="IsArtist" value="si" onchange="setArtInfoVisible();">Si
            <input id="radioButtonNoEsArtista" type="radio" name="IsArtist" value="no" onchange="setArtInfoVisible();" checked="checked">No<br>
            <div id="ArtistInfo" style="display: none;"> 
                Biografia:<br>
                <textarea form="FormRegistro" name="bio" cols="40" rows="4" ></textarea><br>
                Direccion web:
                <input type="Text" size="20" name="web_url">
            </div>
            <!--<br>Imagen:<br>
            <input id="pic" type="file" name="pic" accept="image/*"><br><br>-->
            <input id="botonRegistro" type="submit" value="Registar" disabled="true"><br>
        </form>
    </body>
    
    
    
    <script>function checkPasswordMatch() {
        var password = document.getElementById("contra").value;
        var confirmPassword  = document.getElementById("contra2").value;

        if (password !== confirmPassword){
            document.getElementById('passMatch').innerHTML = ' Las contraseñas no coinsiden';
            return false;
        }
        else{
            document.getElementById('passMatch').innerHTML = '';
            return true;
        }
    }
    </script>
    
    <script>function setArtInfoVisible(){
        var r = document.getElementById('radioButtonEsArtista');
        if(r.checked){
            document.getElementById('ArtistInfo').style.display = 'block';
        }
        else{
            document.getElementById('ArtistInfo').style.display = 'none';
        }
    }
    </script>
    
    <script>function HabilitarBoton(){
        if(checkPasswordMatch.call()){
            document.getElementById('botonRegistro').disabled = false;
        }
        else{
           document.getElementById('botonRegistro').disabled = true; 
        }
    }
    </script>
    
</html>



