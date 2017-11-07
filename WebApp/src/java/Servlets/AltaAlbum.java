/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Album;
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
        String hiddenParam=request.getParameter("formSelect");
        Fabrica fabrica = Fabrica.getInstance();
        IControlador ICU = fabrica.getIControlador();        
        String nombre = request.getParameter("nombre_tema");
        String duracion = request.getParameter("duracion_tema");
        String ubicacion = request.getParameter("ubicacion_tema");
        Album album;
        System.out.println("hidden: " + hiddenParam);
        
        
        if(hiddenParam!=null){
            if(nombre!=null && duracion!=null && ubicacion!=null 
            && duracion.matches("\\d+") && ubicacion.matches("\\d+")){
                album = ICU.getTemporalAlbum();
                Tema tema =new Tema(nombre, Integer.parseInt(duracion), Integer.parseInt(ubicacion), album);
                if (album != null) {
                    album.addTema(tema);
                    response.sendRedirect("AltaAlbum.jsp");
                }    
            }
            else
                response.sendRedirect("AltaAlbum.jsp"); 
        }
        else{
            processRequest(request, response);
        }
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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Fabrica fabrica = Fabrica.getInstance();
        IControlador ICU = fabrica.getIControlador();  
        Album tempAlbum = ICU.getTemporalAlbum();
        
        System.out.println("Anio valor: " + request.getParameterValues("anio_album"));
        System.out.println("Anio valor: " + request.getParameterValues("dropdown3"));
        String nombreAlbum = request.getParameter("nombre_album");
        System.out.println(nombreAlbum);
        String año_album = request.getParameter("anio_album");
        String genero = request.getParameter("dropdown3");
        System.out.println("nombre: " + nombreAlbum);
        System.out.println("creacion: " + año_album);
        System.out.println("genero: " + genero);
        List<Genero> listgen = new ArrayList();
        listgen.add(ICU.getGeneroPorNombre(genero));        
        ICU.configTemporalAlbum(null, nombreAlbum, listgen, Integer.parseInt(año_album), "");
        
        Album album = ICU.getTemporalAlbum();
        System.out.println("Nombre: " + album.getNombre());
        HttpSession session = request.getSession();
        session.setAttribute("albumTemporal", album);
        Album album2 = (Album) session.getAttribute("albumTemporal");
        System.out.println("Nombre: " + album2.getNombre());
        
        if(nombreAlbum!=null && !nombreAlbum.equalsIgnoreCase("")){
            String kek;
            System.out.println("entra al if");
        }
        else{
            System.out.println("No entra al if");
            //response.sendRedirect("AltaAlbum.jsp"); 
        }
             
        
        
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
            out.println("<h1>genero: " + genero + "</h1>");
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
