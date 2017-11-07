<%-- 
    Document   : ActualizarSuscripcion
    Created on : 30-oct-2017, 13:25:48
    Author     : Casca
--%>

<%@page import="Enums.EstadosDeSuscripcion"%>
<%@page import="Logica.Suscripcion"%>
<%@page import="Logica.Fabrica"%>
<%@page import="Logica.Cliente"%>
<%@page import="Logica.IControlador"%>
<%@page import="DataType.DTArtista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String username = (String )request.getSession().getAttribute("UserNick");
    Fabrica fabrica = Fabrica.getInstance();
    IControlador ICU = fabrica.getIControlador();
    
    
    if(request.getSession().getAttribute("UserNick")==null ||
        ICU.consultarCliente(request.getSession().getAttribute("UserNick").toString()).getSuscripcion()==null ||
        ICU.consultarCliente(request.getSession().getAttribute("UserNick").toString()).getSuscripcion().getEstado()!=EstadosDeSuscripcion.Pendiente){
        response.sendRedirect("index.jsp");
        out.println("<html><body onload=\"alert('No hay cliente logeado o una suscripcion que actualizar')\"></body></html>");
    }
            
        String usernick = (String) session.getAttribute("UserNick");        
        Cliente cliente = ICU.consultarCliente(usernick);
        if(cliente!=null){
            Suscripcion s = cliente.getSuscripcion();
        }
            
    %>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ActualizarSuscripcion</title>
    </head>
    <body onload="tipoCheck()">
        
        <h1>Estado de suscripcion del usuario:</h1>
        <% 
            out.println("<h1>" + username + "</h1>");
            
            %>
        <h1>Estado:    </h1> 
        <% 
            if(cliente!=null){
                Suscripcion s = cliente.getSuscripcion();
                if(s!=null)
                    out.println("<h1>" + s.getEstado().toString() + " (" + s.getTipo().toString() + ")" + "</h1>");
                    
                }
            %>
            
          
           
            <form action="/Lab/ActualizarSuscripcion" method="POST">
                <div id="SiPendiente" >
                    <h1 name="Estado"> Deseo cancelar mi suscripcion <input type="checkbox" name="Cancelar" value="ON" />  </h1>
                </div>  
                
                <h1>Nuevo estado:
                <select name="EstadoSiVencida">
                    <option>Cancelar</option>
                    <option>Renovar</option>
                </select>
                </h1>
                <input type="submit" value="Actualizar" />
            </form>
    </body>
</html>

<script>
    function tipoCheck() {
        Fabrica fabrica = Fabrica.getInstance();
        IControlador ICU = fabrica.getIControlador();
        Cliente = ICU.consultarCliente(request.getSession().getAttribute("UserNick").toString());
        if(cliente!=null)
            s = cliente.getSuscripcion()
        if(s!=null){
            if (s.getEstado() === EstadosDeSuscripcion.Pendiente) {
                alert("check");
                document.getElementById("SiPendiente").style.display = "block";
            }     
        }
        
    }
</script>