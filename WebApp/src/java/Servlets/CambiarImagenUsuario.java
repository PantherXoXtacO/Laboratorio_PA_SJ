package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.Controlador;
import Logica.IControlador;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author Usuario
 */
@WebServlet(urlPatterns = {"/CambiarImagenUsuario"})
public class CambiarImagenUsuario extends HttpServlet {
    private String UPLOAD_DIRECTORY = "C:\\Users\\Usuario\\Desktop\\GitKraken\\Programacion de Aplicaciones\\PA LAB\\Laboratorio_PA_SJ\\WebApp\\web\\imagenes\\Usr_img";
    private String UserNick;

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
     //process only if its multipart content
        PrintWriter out = response.getWriter();
        if(ServletFileUpload.isMultipartContent(request)){
            try {
              // Map<String, List<FileItem>> = new ServletFileUpload(new DiskFileItemFactory()).parseParameterMap(request);
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String OldName = new File(item.getName()).getName();
                        int n = OldName.length();
                        UserNick = (String) request.getSession().getAttribute("UserNick");
                        String name = UserNick + OldName.substring(n-4);
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        IControlador controlador = new Controlador();
                        controlador.ActualizarImagenUsuario(UserNick, name);                        
                    }
                }
                
                response.sendRedirect("myPerfil");

                
           
               //File uploaded successfully
               //response.sendRedirect("");
            } catch (Exception ex) {
                out.println(ex);
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }    
        //request.getRequestDispatcher("/result.jsp").forward(request, response);
     
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
