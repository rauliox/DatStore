package web.servlet;

import com.dto.Usuario;
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
import model.dao.DaoUsuario;
import model.dao.impl.DaoFactory;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String accion= request.getParameter("accion");
        String result = null;
        String target = null;
        
        DaoUsuario daoUsuario= DaoFactory.getInstancia().getDaoUsuario();
        
        if (accion==null)
        {
            result= "solicitud no recibida";
        }
        else if (accion.equals("QRY"))
        {
            List<Usuario> list= daoUsuario.usuarioQry();
            
            if (list != null){
                request.getSession().setAttribute("list", list);
                target= "view/usuario/";
            }
            else{
                result = "Problemas en consulta";
            }
            
        }else if(accion.equals("INS")){
            
            Usuario ousuario = new Usuario();
            result=valida(ousuario,request);
            if (result==null){
                result=daoUsuario.usuarioIns(ousuario);
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
            List<String> idUsuarios = Arrays.asList(request.getParameter("idUsuarios").split("\\s*,\\s*"));
            Iterator<String> it = idUsuarios.iterator();
            while (it.hasNext())
            {
                String resulttemp= daoUsuario.usuarioDel(Integer.parseInt(it.next()));
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
                Usuario ousuario = daoUsuario.usuarioGet(Integer.parseInt(request.getParameter("idUsuario")));
                request.getSession().setAttribute("usuario", ousuario);
                target= "edit/usuario/";
            }
            catch (Exception e)
            {
                com.util.Logger.log(e);
                result=e.getStackTrace().toString();
            }
            
        }else if(accion.equals("UPD")){
            Usuario ousuario = new Usuario();
            result=valida(ousuario,request);
            if (result==null){
                result=daoUsuario.usuarioUpd(ousuario);
                request.getSession().setAttribute("usuario", ousuario);
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

    
    private String valida(Usuario ousuario, HttpServletRequest request){
        String msg="";
        String idUsuario= request.getParameter("idUsuario");
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String correo= request.getParameter("correo");
        String pass= request.getParameter("pass");
        String pass2= request.getParameter("pass2");
        String tipo= request.getParameter("tipo");
        String estado= request.getParameter("estado");
        try{ousuario.setIdUsuario(Integer.valueOf(idUsuario));}
        catch(Exception e){com.util.Logger.log(e);ousuario.setIdUsuario(null);}
        msg += ((nombre==null) || (nombre.trim().isEmpty()))
                ? "Ingrese nombre<br/>":"";
        ousuario.setNombre(nombre);
        msg += ((apellido==null) || (apellido.trim().isEmpty()))
                ? "Ingrese apellido<br/>":"";
        ousuario.setApellido(apellido);
        msg += ((correo==null) || (correo.trim().isEmpty()))
                ? "Ingrese correo<br/>":"";
        ousuario.setCorreo(correo);
        msg += ((pass==null) || (pass.isEmpty()))
                ? "Ingrese pass<br/>":"";
        msg += ((pass2==null)|| (!pass2.equals(pass)))
                ? "Los 2 campos de password deben ser iguales <br/>":"";
        if (pass!=null)
            if(pass.length()<=6)
                msg += "password debe tener una longitud mayor a 6";
        ousuario.setPass(pass);
        msg += ((tipo==null) || (tipo.trim().isEmpty()))
                ? "Ingrese tipo<br/>":"";
        ousuario.setTipo(tipo);
        msg += ((estado==null) || (estado.trim().isEmpty()))
                ? "Ingrese estado<br/>":"";
        ousuario.setEstado(estado);
        
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
