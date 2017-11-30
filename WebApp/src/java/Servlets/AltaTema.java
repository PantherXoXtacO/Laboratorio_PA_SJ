/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgWS.Album;
import pkgWS.Genero;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

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
        
        //Fabrica fabrica = Fabrica.getInstance();
        //IControlador ICU = fabrica.getIControlador();
        PublicadorService service = new pkgWS.PublicadorService();
        Publicador ICU = service.getPublicadorPort();      
        String nombre = request.getParameter("nombre_tema");
        String duracion = request.getParameter("duracion_tema");
        String ubicacion = request.getParameter("ubicacion_tema");
        String albumname = request.getParameter("albums");
        
        if(nombre==null || duracion==null || ubicacion==null || albumname==null
                || !duracion.matches("\\d+") || !ubicacion.matches("\\d+")){            
             response.sendRedirect("AltaTema.jsp"); 
             System.out.println("Error en alguno de los campos");
        }
        else{
            Album album = ICU.getAlbumByName(albumname);                
            Tema tema = ICU.nuevoTema(nombre, Integer.parseInt(duracion), Integer.parseInt(ubicacion), album);
                    //new Tema(nombre, Integer.parseInt(duracion), Integer.parseInt(ubicacion), album);
            album.addTema(tema);
            ICU.addTemaToM(tema);
        
        String generosEnString = "";
        pkgWS.ArrayList generos = new pkgWS.ArrayList();
        //List<Genero> generos = album.getGeneros();
        Genero gen;
        Iterator it = generos.iterator();//ayayay
        while(it.hasNext()){
            gen = (Genero) it.next();
            generosEnString += "[" + gen.getNombre() + "] ";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AltaTema</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tema agregado con exito</h1>");
            out.println("<h1>Nombre: " + nombre + "</h1>");
            out.println("<h1>Duracion: " + duracion + "</h1>");
            out.println("<h1>Posicion: " + ubicacion + "</h1>");
            out.println("<h1>Album name: " + album.getNombre() + "</h1>");
            //out.println("<h1>Albun año de cracion: " + album.getAnio() + "</h1>");
            //out.println("<h1>Albun genero: " + generosEnString + "</h1>");
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
