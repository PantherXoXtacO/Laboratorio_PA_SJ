/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Album;
import Logica.Fabrica;
import Logica.IControlador;
import Logica.Tema;
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
 * @author TISJ
 */
@WebServlet(name = "AltaTema", urlPatterns = {"/AltaTema"})
public class AltaTema extends HttpServlet {

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
        
        Fabrica fabrica = Fabrica.getInstance();
        IControlador ICU = fabrica.getIControlador();        
        String nombre = request.getParameter("nombre_tema");
        String duracion = request.getParameter("duracion_tema");
        String ubicacion = request.getParameter("ubicacion_tema");
        
        
        HttpSession session = request.getSession();
        Album album = (Album) session.getAttribute("albumTemporal");        
        Tema tema = new Tema(nombre, Integer.parseInt(duracion), Integer.parseInt(ubicacion), album);
        album.addTema(tema);
        session.setAttribute("albumTemporal", album);
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaTema</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AltaTema at " + request.getContextPath() + "</h1>");
            out.println("<h1>Albun name: " + album.getNombre() + "</h1>");
            out.println("<h1>Albun año de cracion: " + album.getAnio() + "</h1>");
            out.println("<h1>Albun genero: " + album.getGeneros() + "</h1>");
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
