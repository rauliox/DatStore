package web.servlet;

import com.dto.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DaoCategoria;
import model.dao.impl.DaoFactory;

@WebServlet(name = "CategoriaServlet", urlPatterns = {"/Categoria"})
public class CategoriaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String accion= request.getParameter("accion");
        String result = null;
        String target = null;
        
        DaoCategoria daoCategoria= DaoFactory.getInstancia().getDaoCategoria();
        
        if (accion==null)
        {
            result= "solicitud no recibida";
        }
        else if (accion.equals("QRY"))
        {
            List<Categoria> list= daoCategoria.categoriaQry();
            
            if (list != null){
                request.getSession().setAttribute("list", list);
                target= "view/categoria/";
            }
            else{
                result = "Problemas en consulta";
            }
            
        }else if(accion.equals("INS")){
            
            Categoria ocategoria = new Categoria();
            result=valida(ocategoria,request);
            if (result==null){
                result=daoCategoria.categoriaIns(ocategoria);
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
            List<String> idCategorias = Arrays.asList(request.getParameter("idCategorias").split("\\s*,\\s*"));
            Iterator<String> it = idCategorias.iterator();
            while (it.hasNext())
            {
                String resulttemp= daoCategoria.categoriaDel(Integer.parseInt(it.next()));
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
                Categoria ocategoria = daoCategoria.categoriaGet(Integer.parseInt(request.getParameter("idCategoria")));
                request.getSession().setAttribute("categoria", ocategoria);
                target= "edit/categoria/";
            }
            catch (Exception e)
            {
                com.util.Logger.log(e);
                result=e.getStackTrace().toString();
            }
            
        }else if(accion.equals("UPD")){
            Categoria ocategoria = new Categoria();
            result=valida(ocategoria,request);
            if (result==null){
                result=daoCategoria.categoriaUpd(ocategoria);
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

    
    private String valida(Categoria ocategoria, HttpServletRequest request){
        String msg="";
        String idCategoria= request.getParameter("idCategoria");
        String descripcion= request.getParameter("descripcion");
        String estado= request.getParameter("estado");
        try{ocategoria.setIdCategoria(Integer.valueOf(idCategoria));}
        catch(Exception e){
            com.util.Logger.log(e);
            ocategoria.setIdCategoria(null);
        }
        msg += ((descripcion==null) || (descripcion.trim().isEmpty()))
                ? "Ingrese descripcion<br/>":"";
        ocategoria.setDescripcion(descripcion);
        msg += ((estado==null) || (estado.trim().isEmpty()))
                ? "Ingrese estado<br/>":"";
        ocategoria.setEstado(estado);
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
