/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controlador;
import Logica.Fecha;
import Logica.IControlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

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
            throws ServletException, IOException, InterruptedException {
            IControlador controlador = new Controlador();
            PrintWriter out = response.getWriter();
            String nick = request.getParameter("userNick");
            String mail = request.getParameter("userMail");
            String fecha = request.getParameter("FechaDeNacimiento");
            
            //Casteo de fecha
            Matcher m = Pattern.compile("\\d+").matcher(fecha);
            List<Integer> numbers = new ArrayList<Integer>();
            while(m.find()) {
                numbers.add(Integer.parseInt(m.group()));
            }
            Fecha f = new Fecha(numbers.get(0), numbers.get(1), numbers.get(2));
            //
            
            String pass = request.getParameter("userPass");
            String nombre = request.getParameter("userNom");
            String apellido = request.getParameter("userApellido");
            String esArtista = request.getParameter("IsArtist");
            if(esArtista.equals("si")){
                String bio = request.getParameter("bio");
                String web_url = request.getParameter("web_url");
                controlador.registrarArtista(nick, pass, mail, nombre, apellido, f, "", bio, web_url);
                out.println("<html><body onload=\"alert('Artista Creado')\"></body></html>");
            }
            else{
                controlador.registrarCliente(nick, pass, mail, nombre, apellido, f, "");
                out.println("<html><body onload=\"alert('Cliente: "+ nick  +" creado')\"></body></html>");
            }
            response.setHeader("Refresh", "1; URL=http://localhost:8080/Lab/");
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
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (InterruptedException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
