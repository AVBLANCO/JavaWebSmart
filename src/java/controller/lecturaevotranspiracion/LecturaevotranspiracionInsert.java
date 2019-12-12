/*
              -------Creado por-------
             \(x.x )/ Anarchy \( x.x)/
              ------------------------
 */

//    Ella existió sólo en un sueño. Él es un poema que el poeta nunca escribió.  \\
package back.controller.lecturaevotranspiracion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import back.facade.LecturaevotranspiracionFacade;
import back.dto.Metricaevotranspiracion;

@WebServlet(name = "LecturaevotranspiracionInsert", urlPatterns = {"/Lecturaevotranspiracion/Insert"})
public class LecturaevotranspiracionInsert extends HttpServlet {

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
                
       int idlecturaEvotranspiracion = Integer.parseInt(request.getParameter("idlecturaEvotranspiracion"));
       String fechaLecturaEvotranspiracion = request.getParameter("fechaLecturaEvotranspiracion");
       double valorLecturaEvotranspiracion = Double.parseDouble(request.getParameter("valorLecturaEvotranspiracion"));
       Metricaevotranspiracion metricaevotranspiracion = new Metricaevotranspiracion();
               metricaevotranspiracion.setIdmetricaEvotranspiracion(Integer.parseInt(request.getParameter("idmetricaEvotranspiracion")));

       LecturaevotranspiracionFacade.insert(idlecturaEvotranspiracion, fechaLecturaEvotranspiracion, valorLecturaEvotranspiracion, metricaevotranspiracion);

       try (PrintWriter out = response.getWriter()) {
         out.print("true");
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
//That`s all folks!