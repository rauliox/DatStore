package web.servlet;

import com.dto.Log;
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
import model.dao.DaoLog;
import model.dao.impl.DaoFactory;

@WebServlet(name = "LogServlet", urlPatterns = {"/Log"})
public class LogServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        String accion= request.getParameter("accion");
        String result = null;
        String target = null;
        
        DaoLog daoLog= DaoFactory.getInstancia().getDaoLog();
        
        if (accion==null)
        {
            result= "solicitud no recibida";
        }
        else if (accion.equals("QRY"))
        {
            List<Log> list= daoLog.logQry();
            
            if (list != null){
                request.getSession().setAttribute("list", list);
                target= "view/log/";
            }
            else{
                result = "Problemas en consulta";
            }
            
        }else if(accion.equals("INS")){
            
            Log olog = new Log();
            result=valida(olog,request);
            if (result==null){
                result=daoLog.logIns(olog);
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
            List<String> idloges = Arrays.asList(request.getParameter("idloges").split("\\s*,\\s*"));
            Iterator<String> it = idloges.iterator();
            while (it.hasNext())
            {
                String resulttemp= daoLog.logDel(Integer.parseInt(it.next()));
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
                Log olog = daoLog.logGet(Integer.parseInt(request.getParameter("idlog")));
                request.getSession().setAttribute("log", olog);
                target= "edit/log/";
            }
            catch (Exception e)
            {
                com.util.Logger.log(e);
                result=e.getStackTrace().toString();
            }
            
        }else if(accion.equals("UPD")){
            Log olog = new Log();
            result=valida(olog,request);
            if (result==null){
                result=daoLog.logUpd(olog);
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

    
    private String valida(Log olog, HttpServletRequest request){
        String msg="";
        String idlog= request.getParameter("idlog");
        String tipo= request.getParameter("tipo");
        String mensaje= request.getParameter("mensaje");
        String detalles= request.getParameter("detalles");
        try{olog.setIdlog(Integer.valueOf(idlog));}
        catch(Exception e){
            com.util.Logger.log(e);
            olog.setIdlog(null);
        }
        msg += ((tipo==null) || (tipo.trim().isEmpty()))
                ? "Ingrese tipo<br/>":"";
        olog.setTipo(tipo);
        msg += ((mensaje==null) || (mensaje.trim().isEmpty()))
                ? "Ingrese mensaje<br/>":"";
        olog.setMensaje(mensaje);
        msg += ((detalles==null) || (detalles.trim().isEmpty()))
                ? "Ingrese detalles<br/>":"";
        olog.setDetalles(detalles);
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
