/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import DAO.AlumnoDAO;
import DAO.exceptions.RollbackFailureException;
import entities.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proceso.proceso;

/**
 *
 * @author Camilo
 */
public class controlador extends HttpServlet {

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
        
        String strnombre = request.getParameter("nombre").toString();
        String strid = request.getParameter("id").toString();
        String strapellido = request.getParameter("apellido").toString();
        String stredad = request.getParameter("edad").toString();
        String stremail = request.getParameter("email").toString();
        String strcurso = request.getParameter("curso").toString();
        
        
      //   proceso modelo = new proceso();
        
     //   String resultado = modelo.resultado(strnombre,strapellido,strcurso);
        
        Alumno alum = new Alumno();
        
        alum.setId(Integer.parseInt(strid));
        alum.setNombre (strnombre);
        alum.setApellido (strapellido);
        
        AlumnoDAO dao =new AlumnoDAO();
        
        try {
            dao.create(alum);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println("#### mensaje de error: " + ex.getMessage());
            
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        request.getRequestDispatcher("final.jsp").forward(request, response);
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
