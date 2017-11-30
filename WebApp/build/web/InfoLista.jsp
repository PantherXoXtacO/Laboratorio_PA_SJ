<%@page import="pkgWS.DtTema"%>
<%@page import="java.util.Iterator"%>
<%@page import="pkgWS.DtListaPrticular"%>
<%@page import="pkgWS.DtListaRepro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            DtListaRepro L = (DtListaRepro) request.getAttribute("Lista");
        %>
        <title><%out.println(L.getNombre());%></title>
    </head>
    <body>
        <h1><%out.println(L.getNombre());%></h1>
        <img src="<%out.println(L.getImagen());%>" alt="IMAGEN">
        <div>
        <%
            if(L instanceof DtListaPrticular){
                DtListaPrticular aux = (DtListaPrticular) L;
                out.println("Dueño" + aux.getCliente());
            }
            else{
                out.println("Lista por defecto");
            }
        %>
        </div>

        <h2>Temas:</h2>
        <div>
            <ul>
                <%
                    Iterator it = L.getTemas().iterator();
                    DtTema tema;
                    while(it.hasNext()){
                        tema = (DtTema) it.next();
                        out.println("<li>" + tema.getNombre() + "</li>");
                    }                
                %>
            </ul>
        </div>
    </body>
</html>
