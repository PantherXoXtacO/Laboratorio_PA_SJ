/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Album;
import Logica.Artista;
import Logica.Fabrica;
import Logica.Genero;
import Logica.IControlador;
import Logica.Tema;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "AltaAlbum", urlPatterns = {"/AltaAlbum"})
public class AltaAlbum extends HttpServlet {          

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Fabrica fabrica = Fabrica.getInstance();
        IControlador ICU = fabrica.getIControlador(); 
        HttpSession session = request.getSession();
        session.setAttribute("generosAgregados", null); 
        String artistname =(String) session.getAttribute("UserNick");
        Artista artist = ICU.consultarArtista(artistname);
         
        String nombreAlbum = request.getParameter("nombre_album");
        String año_album = request.getParameter("anio_album");
        String generos_album = request.getParameter("generos_album");        
        String imagen_album = request.getParameter("imagen_album");   
        
        System.out.println("NombreAlbum: " + nombreAlbum);
        System.out.println("Año Album: " + año_album);
        System.out.println("Generos_album: " + generos_album);
        System.out.println("imagen_album: " + imagen_album);
        
        if(nombreAlbum!=null && año_album!=null && año_album.matches("\\d+") && generos_album!=null){
            
            List<Genero> listgen = new ArrayList();
            listgen = ICU.GenerosFromString(generos_album);             
            
            //ICU.createTemporalAlbum(); ya deberia estar creado
            ICU.configTemporalAlbum(artist, nombreAlbum, listgen , Integer.parseInt(año_album), imagen_album);
            ICU.addTemporalAlbum();
            ICU.deleteTemporalAlbum();
            ICU.wipeTemporalGenres();


            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet AltaAlbum</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet AltaAlbum at " + request.getContextPath() + "</h1>");
                out.println("<h1>nombre: " + nombreAlbum + "</h1>");
                out.println("<h1>creacion: " + año_album+ "</h1>");
                out.println("<h1>generos: " + ICU.imprimirListaDeGeneros(listgen) + "</h1>");
                out.println("<h1>path a imagen del album: " + imagen_album + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        else
            response.sendRedirect("AltaAlbum.jsp");       
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
