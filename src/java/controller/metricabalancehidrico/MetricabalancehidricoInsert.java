
package controller.metricabalancehidrico;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import back.facade.MetricabalancehidricoFacade;
import back.dto.Balancehidrico;

@WebServlet(name = "MetricabalancehidricoInsert", urlPatterns = {"/Metricabalancehidrico/Insert"})
public class MetricabalancehidricoInsert extends HttpServlet {

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
                
       int idmetricaBalanceHidrico = Integer.parseInt(request.getParameter("idmetricaBalanceHidrico"));
       String descripcionMetricaBalanceHidrico = request.getParameter("descripcionMetricaBalanceHidrico");
       Balancehidrico balancehidrico = new Balancehidrico();
               balancehidrico.setIdbalanceHidrico(Integer.parseInt(request.getParameter("idbalanceHidrico")));

       MetricabalancehidricoFacade.insert(idmetricaBalanceHidrico, descripcionMetricaBalanceHidrico, balancehidrico);

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