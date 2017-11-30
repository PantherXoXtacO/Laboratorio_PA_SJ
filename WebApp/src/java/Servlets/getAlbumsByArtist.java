/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pkgWS.Album;
import pkgWS.ArrayList;
import pkgWS.Artista;
import pkgWS.Publicador;
import pkgWS.PublicadorService;

/**
 *
 * @author Casca
 */
@WebServlet("/getAlbumsByArtist")
public class getAlbumsByArtist extends HttpServlet {
    private static final long serialVersionUID = 1L;

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
            System.out.println("getalbumsbyartist.java");          
//            Fabrica fabrica = Fabrica.getInstance();
//            IControlador ICU = fabrica.getIControlador();
            PublicadorService service = new pkgWS.PublicadorService();
            Publicador ICU = service.getPublicadorPort();
            String artista = request.getParameter("dropdown1").trim(); 
            if(artista!=null){
                Artista art = ICU.consultarArtista(artista);
                List<Album> albumsDelArtista = art.getAlbums();
                if(albumsDelArtista.size()==0){
                    response.getWriter().write("");
                    System.out.println("Artista sin albums");
                }
                    
                String albums = ICU.albumListToString((ArrayList) albumsDelArtista);
                response.setContentType("text/plain");
                response.getWriter().write(albums);
            }             
	}

}