/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pkgWS.Album;
import pkgWS.ArrayList;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

/**
 *
 * @author Casca
 */
@WebServlet("/getAlbumsByGenre")
public class getAlbumsByGenre extends HttpServlet {
    private static final long serialVersionUID = 1L;

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
                      
//            Fabrica fabrica = Fabrica.getInstance();
//            IControlador ICU = fabrica.getIControlador();
            PublicadorService service = new pkgWS.PublicadorService();
            Publicador ICU = service.getPublicadorPort();
            String genero = request.getParameter("dropdown1").trim(); 
            if(genero!=null){
                Genero gen = ICU.getGeneroPorNombre(genero);                
                List<Album> albumsDelGenero = gen.getAlbums();
                if(albumsDelGenero.size()==0)
                    response.getWriter().write("");
                String albums = ICU.albumListToString((ArrayList) albumsDelGenero);
                response.setContentType("text/plain");
                response.getWriter().write(albums);
            }             
	}

}