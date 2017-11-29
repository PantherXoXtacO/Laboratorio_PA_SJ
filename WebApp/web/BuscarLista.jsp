<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consltar Lista</title>
    </head>
    <body>
        <h1>Consultar Lista</h1>
        <form name="ConsultarLista" action="/Lab/ConsultarLista" method="GET">
            Nombre de la lista:
            <input type="Text" size="20" name="nombreLista">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
