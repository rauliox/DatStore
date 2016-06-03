package web.servlet;

import com.dto.ReporteClientes;
import com.dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.impl.DaoFactory;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@WebServlet(name = "ReporteClientesServlet", urlPatterns = {"/ReporteClientes"})
public class ReporteClientesServlet extends HttpServlet {

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
        try {
            
            String fpath = request.getServletContext().getRealPath("")
                    + "\\WEB-INF\\reportes\\reporteClientes.jrxml";

            JasperDesign jasperDesign = JRXmlLoader.load(fpath);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            Integer idVendedor=((Usuario)request.getSession().getAttribute("usuario")).getIdUsuario();
            
            List<ReporteClientes> reporte = DaoFactory.getInstancia().getDaoReporteClientes().reporte(idVendedor);
            JRDataSource dataSource = new JRBeanArrayDataSource(reporte.toArray());
            
            byte[] bytes = JasperRunManager.runReportToPdf(jasperReport,null,dataSource);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream out = response.getOutputStream();
            
            out.write(bytes, 0, bytes.length);
            out.flush();
            out.close();
            
        }
        catch(Exception e) {
            com.util.Logger.log(e);
           e.printStackTrace();
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
