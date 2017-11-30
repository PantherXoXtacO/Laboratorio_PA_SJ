/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Album;
import Logica.Artista;
import Logica.Controlador;
import Logica.Fabrica;
import Logica.IControlador;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
 * @author TISJ
 */
@WebServlet(urlPatterns = {"/CambiarImagenAlbum"})
public class CambiarImagenAlbum extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
     /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String UPLOAD_DIRECTORY = "C:\\Users\\TISJ\\Desktop\\Grupo Magico de atras\\Programacion de aplicaciones\\Laboratorio_PA_SJ\\WebApp\\web\\imagenes\\Album_img";
    private String AlbumNombre;

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
//        PrintWriter out = response.getWriter();
//        if(ServletFileUpload.isMultipartContent(request)){
//            try {
//              // Map<String, List<FileItem>> = new ServletFileUpload(new DiskFileItemFactory()).parseParameterMap(request);
//                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
//              
//                for(FileItem item : multiparts){
//                    if(!item.isFormField()){
//                        String OldName = new File(item.getName()).getName();
//                        int n = OldName.length();
//                        //UserNick = (String) request.getSession().getAttribute("UserNick");
//                        String name = AlbumNombre + OldName.substring(n-4);
//                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
//                        IControlador controlador = new Controlador();
//                        controlador.ActualizarImagenAlbum(AlbumNombre, OldName);                        
//                    }
//                }
//                
//                //response.sendRedirect("AltaAlbum");
//                
//               //File uploaded successfully
//               //response.sendRedirect("");
//            } catch (Exception ex) {
//                out.println(ex);
//               request.setAttribute("message", "File Upload Failed due to " + ex);
//            }          
//        }else{
//            request.setAttribute("message",
//                                 "Sorry this Servlet only handles file upload request");
//        }    
//        //request.getRequestDispatcher("/result.jsp").forward(request, response);
//    }
        System.out.println("se llama el servlet");
        response.setContentType("text/plain");
        response.getWriter().write("help");
            
     }    

    }          



    

  
        
    

   