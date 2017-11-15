/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controlador;
import Logica.IControlador;
import DataType.DTCliente;
import Enums.TiposDeSuscripcion;
import Logica.Cliente;
import Logica.Fabrica;
import Logica.Suscripcion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Casca
 */
@WebServlet(name = "ContratarSuscripcion", urlPatterns = {"/ContratarSuscripcion"})
public class ContratarSuscripcion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Lab_Pro_AplPU" );
        EntityManager em = emfactory.createEntityManager();
        Fabrica fabrica = Fabrica.getInstance();
        IControlador ICU = fabrica.getIControlador();
        String TiposDeSuscripciones = request.getParameter("TiposDeSuscripciones"); 
        String usernick = (String) session.getAttribute("UserNick");        
        Cliente cliente = ICU.consultarCliente(usernick);
        Suscripcion s = null;
        if(TiposDeSuscripciones.equals("Anual"))
           s= new Suscripcion(cliente, TiposDeSuscripcion.Anual); 
        else if(TiposDeSuscripciones.equals("Mensual"))
            s= new Suscripcion(cliente, TiposDeSuscripcion.Mensual);
        else
            s= new Suscripcion(cliente, TiposDeSuscripcion.Semanal);       
        ICU.contratarSuscripcion(cliente, s.getTipo());
        
        
       
        
        response.setContentType("text/html;charset=UTF-8");        
        try (PrintWriter out = response.getWriter()) {
            TiposDeSuscripciones = s.getTipo().toString();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContratarSuscripcion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContratarSuscripcion at " + request.getContextPath() + "</h1>");
            out.println("<h1>"+ TiposDeSuscripciones + "</h1>");
            out.println("<h1>"+ "Nick:" + usernick + "</h1>");                          
            out.println("<h1>Thanks for the money m8</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
