<%-- 
    Document   : cargarBD
    Created on : 29-nov-2017, 14:56:00
    Author     : Casca
--%>

<%@page import="pkgWS.Genero"%>
<%@page import="pkgWS.Publicador"%>
<%@page import="pkgWS.PublicadorService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%
    
        //Fabrica fabrica = Fabrica.getInstance();
        //IControlador ICU = fabrica.getIControlador(); 
        PublicadorService service = new pkgWS.PublicadorService();
        Publicador ICU = service.getPublicadorPort();
        ICU.AltaGenero("GeneroTest1", "General");
        ICU.AltaGenero("GeneroTest2", "General");
        //ICU.registrarArtista("asd", "asd", "asd@asd", "asdNombre", "asdApellido", new Fecha(29,11,2017), "none", "no", "no");
        //ICU.registrarArtista("asd2", "asd2", "asd2@asd2", "asd2Nombre", "asd2Apellido", new Fecha(29,11,2017), "none", "no", "no");
        //Artista artista = ICU.consultarArtista("asd");
        //List<Genero> genlist = new ArrayList();
        Genero gen1 = ICU.getGeneroPorNombre("GeneroTest1");
        //genlist.add(gen1);
        Genero gen2 = ICU.getGeneroPorNombre("GeneroTest2");
        //genlist.add(gen2);
        //ICU.createTemporalAlbum();
        //ICU.configTemporalAlbum(artista, "AlbumTest1", genlist, 2017, "no");
        //ICU.addTemporalAlbum();
        //ICU.deleteTemporalAlbum();
        
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
