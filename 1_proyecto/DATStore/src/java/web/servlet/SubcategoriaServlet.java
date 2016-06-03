package web.servlet;

import com.dto.Subcategoria;
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
import model.dao.DaoSubcategoria;
import model.dao.impl.DaoFactory;

@WebServlet(name = "SubcategoriaServlet", urlPatterns = {"/Subcategoria"})
public class SubcategoriaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String accion= request.getParameter("accion");
        String result = null;
        String target = null;
        
        DaoSubcategoria daoSubcategoria= DaoFactory.getInstancia().getDaoSubcategoria();
        
        if (accion==null)
        {
            result= "solicitud no recibida";
        }
        else if (accion.equals("QRY"))
        {
            List<Subcategoria> list= daoSubcategoria.subcategoriaQry();
            
            if (list != null){
                request.getSession().setAttribute("list", list);
                target= "view/subcategoria/";
            }
            else{
                result = "Problemas en consulta";
            }
            
        }else if(accion.equals("INS")){
            
            Subcategoria osubcategoria = new Subcategoria();
            result=valida(osubcategoria,request);
            if (result==null){
                result=daoSubcategoria.subcategoriaUpd(osubcategoria);
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
            List<String> idSubcategorias = Arrays.asList(request.getParameter("idSubcategorias").split("\\s*,\\s*"));
            Iterator<String> it = idSubcategorias.iterator();
            while (it.hasNext())
            {
                String resulttemp= daoSubcategoria.subcategoriaDel(Integer.parseInt(it.next()));
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
                Subcategoria osubcategoria = daoSubcategoria.subcategoriaGet(Integer.parseInt(request.getParameter("idSubcategoria")));
                request.getSession().setAttribute("subcategoria", osubcategoria);
                target= "edit/subcategoria/";
            }
            catch (Exception e)
            {
                com.util.Logger.log(e);
                result=e.getStackTrace().toString();
            }
            
        }else if(accion.equals("UPD")){
            Subcategoria osubcategoria = new Subcategoria();
            result=valida(osubcategoria,request);
            if (result==null){
                result=daoSubcategoria.subcategoriaIns(osubcategoria);
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

    
    private String valida(Subcategoria osubcategoria, HttpServletRequest request){
        String msg="";
        String idSubcategoria= request.getParameter("idSubcategoria");
        String idCategoria= request.getParameter("idCategoria");
        String descripcion= request.getParameter("descripcion");
        String estado= request.getParameter("estado");
        try{osubcategoria.setIdSubcategoria(Integer.valueOf(idSubcategoria));}
        catch(Exception e){com.util.Logger.log(e);osubcategoria.setIdSubcategoria(null);}
        try{
            Integer oidCategoria=Integer.valueOf(idCategoria);
            if (oidCategoria<=0) msg+="Ingrese idCategoria mayor a cero<br/>";
            osubcategoria.setIdCategoria(oidCategoria);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese idCategoria valido<br/>"; }
        msg += ((descripcion==null) || (descripcion.trim().isEmpty()))
                ? "Ingrese descripcion<br/>":"";
        osubcategoria.setDescripcion(descripcion);
        msg += ((estado==null) || (estado.trim().isEmpty()))
                ? "Ingrese estado<br/>":"";
        osubcategoria.setEstado(estado);
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
