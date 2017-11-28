/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Album;
import Logica.Fabrica;
import Logica.IControlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Casca
 */
@WebServlet(name = "ConsultarAlbumArtista", urlPatterns = {"/ConsultarAlbumArtista"})
public class ConsultarAlbumArtista extends HttpServlet {

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
        
        String artistaName = request.getParameter("dropdown1");  
        String albumName = request.getParameter("dropdown2");  
        
        if(artistaName==null || albumName==null){
            response.sendRedirect("index.jsp");
        }
        else{
            Fabrica fabrica = Fabrica.getInstance();
            IControlador ICU = fabrica.getIControlador();
            Album album = ICU.getAlbumByName(albumName);
            
            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConsultarAlbumGenero</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConsultarAlbumGenero at " + request.getContextPath() + "</h1>");
            out.println("<h1>Nombre del album: " + albumName + "</h1>");
            out.println("<h1>Artista: " + artistaName + "</h1>");
            out.println("<h1>Año de creacion: " + album.getAnio() + "</h1>");
            out.println("<h1>Generos: " + ICU.imprimirListaDeGeneros(album.getGeneros())+ "</h1>");
            out.println("<h1>IMAGEN"+ "</h1>");
            out.println("<h1>Lista de temas: <br>" + album.getListaDeTemasEnString() +  "</h1>");
            out.println("</body>");
            out.println("</html>");
        }  
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
