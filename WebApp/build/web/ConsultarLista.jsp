<%@page import="pkgWS.DtListaPrticular"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="pkgWS.DtListaRepro"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    HashMap listas = (HashMap)request.getSession().getAttribute("ListasMap");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consltar Lista : <%//DTListaRepro x = (DTListaRepro) listas.get(0);
                                //out.println(x.getNombre());%>
        </title>
    </head>
    <body>
        <h1>Listas con el nombre : <%//out.println(x.getNombre());%></h1>
        <ul>
            <%
                Iterator itKey = listas.keySet().iterator();
                while(itKey.hasNext()){
                    int key = (int) itKey.next();
                    DtListaRepro L = (DtListaRepro) listas.get(key);
                    if(L instanceof DtListaPrticular){
                        DtListaPrticular lp = (DtListaPrticular) L;
                        out.println("<li><a href=\"Lab/VerListaInfo?id="+ key + "\">"+ lp.getNombre() + "(" + lp.getCliente() +")"+"</a></li>");
                    }
                    else{
                        out.println("<li><a href=\"Lab/VerListaInfo?id="+ key + "\">"+ L.getNombre() + "(Defecto)" + "</a></li>");
                    }
                }
            %>
        </ul>
    </body>
</html>
