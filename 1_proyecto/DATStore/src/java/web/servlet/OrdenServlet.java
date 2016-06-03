package web.servlet;

import com.dto.Orden;
import com.dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DaoOrden;
import model.dao.impl.DaoFactory;

@WebServlet(name = "OrdenServlet", urlPatterns = {"/Orden"})
public class OrdenServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String accion= request.getParameter("accion");
        String result = null;
        String target = null;
        
        DaoOrden daoOrden= DaoFactory.getInstancia().getDaoOrden();
        
        if (accion==null)
        {
            result= "solicitud no recibida";
        }
        else if (accion.equals("QRY"))
        {

            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            if(usuario != null){
                System.out.print("el idusuario es --->" + usuario.getIdUsuario());
                List<Orden> list= daoOrden.ordenxUsuario(usuario.getIdUsuario());
                request.getSession().setAttribute("list", list);
            }
        }
        else if(accion.equals("INS")){
            
            Orden oorden = new Orden();
            result=valida(oorden,request);
            if (result==null){
                result=daoOrden.ordenIns(oorden);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){out.print("OK");}
                else{out.println(result);}
            } finally {
                out.close();
            }
            return;
             
        }else if(accion.equals("DEL")){
            List<String> idOrdenes = Arrays.asList(request.getParameter("orden").split("\\s*,\\s*"));
            Iterator<String> it = idOrdenes.iterator();
            while (it.hasNext())
            {
                String resulttemp= daoOrden.ordenDel(Integer.parseInt(it.next()));
                if (resulttemp!=null)
                    if (result==null) result= resulttemp;
                else
                    result+="<br/>"+resulttemp;
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){out.print("OK");}
                else{out.println(result);}
            } finally {
                out.close();
            }
            return;
        }else if(accion.equals("GET")){
            try
            {
                Orden oorden = daoOrden.ordenGet(Integer.parseInt(request.getParameter("idOrden")));
                request.getSession().setAttribute("orden", oorden);
                target= "edit/orden/";
            }
            catch (Exception e)
            {
                com.util.Logger.log(e);
                result=e.getStackTrace().toString();
            }
            
        }else if(accion.equals("UPD")){
            Orden oorden = new Orden();
            result=valida(oorden,request);
            if (result==null){
                result=daoOrden.ordenUpd(oorden);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){out.print("OK");}
                else{out.println(result);}
            } finally {
                out.close();
            }
            return;
        }
        
        if (result != null){
            request.getSession().setAttribute("msg", result);
            target =  "view/mesage.jsp";
        }
        
        if (target != null){
            response.sendRedirect(target);
        }
        

    }

    
    private String valida(Orden oorden, HttpServletRequest request){
        String msg="";
        String idOrden= request.getParameter("idOrden");
        String idCliente= request.getParameter("idCliente");
        String fechaCreada= request.getParameter("fechaCreada");
        String estado= request.getParameter("estado");
        try{oorden.setIdOrden(Integer.valueOf(idOrden));}
        catch(Exception e){
            com.util.Logger.log(e);
            oorden.setIdOrden(null);
        }
        try{
            Integer oidCliente=Integer.valueOf(idCliente);
            if (oidCliente<=0) msg+="Ingrese idCliente mayor a cero<br/>";
            oorden.setIdCliente(oidCliente);
        }
        catch(Exception e){ 
            com.util.Logger.log(e);
            msg+="Ingrese idCliente valido<br/>"; 
        }
        msg += ((estado==null) || (estado.trim().isEmpty()))
                ? "Ingrese estado<br/>":"";
        oorden.setEstado(estado);
        if (msg.length()==0)
            return null;
        else
            return msg;
        
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
