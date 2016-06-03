package web.servlet;

import com.dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DaoUsuario;
import model.dao.impl.DaoFactory;

@WebServlet(name = "AutenticarServlet", urlPatterns = {"/Autenticar"})
public class AutenticarServlet extends HttpServlet {
    
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
        
        String accion= request.getParameter("accion");
        
        if (accion!=null)
        {
            if (accion.equals("login"))
            {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {
                    out.print(procesarLogin(request,response));
                } finally {
                    out.close();
                }
            }
            if (accion.equals("logout"))
            {
                procesarLogout(request,response);
                response.sendRedirect("index.jsp");
            }
            if (accion.equals("redirecthome"))
            {
                Integer totalart = (Integer)request.getSession().getAttribute("totalart");
                String urlLogin=(String)request.getSession().getAttribute("urlLogin");
                
                request.getSession().setAttribute("urlLogin", null);
                if (urlLogin!=null)
                    response.sendRedirect(urlLogin);
                else{
                    Usuario usuario=(Usuario)request.getSession().getAttribute("usuario");
                    if ( (usuario==null || usuario.getTipo().equals("cliente")))
                        if (totalart== null || totalart <= 0)
                            response.sendRedirect("index.jsp");
                        else
                            response.sendRedirect("carrito.jsp");
                    else {
                        response.sendRedirect("vendedor/index.jsp");}
                }
            }
        }
        
        
    }
    
    private String procesarLogin(HttpServletRequest request, HttpServletResponse response){
        DaoUsuario daoUsuario= DaoFactory.getInstancia().getDaoUsuario();
        Usuario usuario = daoUsuario.usuarioLogin(request.getParameter("correo"), request.getParameter("pass"));
        request.getSession().setAttribute("usuario", usuario);
        if (usuario!=null)
            return "OK";
        else
            return "Correo+password no encontrados<br/>";
    }
    
    private void procesarLogout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("usuario", null);
      
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
