
package controller.historico;

import back.dto.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import back.facade.HistoricoFacade;

@WebServlet(name = "HistoricoList", urlPatterns = {"/Historico/List"})
public class HistoricoList extends HttpServlet {

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
                
         String rta="";
         for (Historico historico: HistoricoFacade.listAll()) {
             rta="";
//             rta+="{
//         	    \"idhistorico\":\"+historico.getIdhistorico()+\",
//	    \"descripcionHistorico\":\"+historico.getDescripcionHistorico()+\",
//	    \"Miagroempresa_idmiAgroempresa\":\"+historico.getMiagroempresa().getIdmiAgroempresa()+\",
//	    \"valorHistorico\":\"+historico.getValorHistorico()+\"
//             },";
         }
         String msg="{\"msg\":\"exito\"}";
         if(rta!=""){
             rta = rta.substring(0, rta.length()-1);
         }else{
             msg="{\"msg\":\"MANEJO DE EXCEPCIONES AQUÃ�\"}";
             rta="{\"result\":\"No se encontraron registros.\"}";
         }
         try (PrintWriter out = response.getWriter()) {
         out.println("["+msg+","+rta+"]");
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