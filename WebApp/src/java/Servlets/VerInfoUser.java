/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataType.DTCliente;
import DataType.DTUsuario;
import Logica.Controlador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.IControlador;

/**
 *
 * @author Usuario
 */
public class VerInfoUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String nick = request.getParameter("dataname");
        IControlador controlador = new Controlador();
        DTUsuario u = controlador.getUserData(nick);
        if(u!=null){
            request.getSession().setAttribute("userConsult", u.getNick());
            request.setAttribute("userInfo", u);
            if(u instanceof DTCliente){
                getServletConfig().getServletContext().getRequestDispatcher("/ConsultarCliente.jsp").forward(request,response);
            }
            else{
                getServletConfig().getServletContext().getRequestDispatcher("/ConsultarArtista.jsp").forward(request,response);
            } 
        }
        else{
            out.println("<html><body onload=\"alert('Usuario no encontrado')\"></body></html>");
            response.setHeader("Refresh", "0; URL=/Lab/");
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
