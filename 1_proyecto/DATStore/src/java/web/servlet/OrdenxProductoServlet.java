package web.servlet;

import com.dto.OrdenxProducto;
import com.dto.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DaoOrdenxProducto;
import model.dao.impl.DaoFactory;

@WebServlet(name = "OrdenxProductoServlet", urlPatterns = {"/OrdenxProducto"})
public class OrdenxProductoServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion= request.getParameter("accion");
        String result = null;
        String target = null;
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        DaoOrdenxProducto daoOrdenxProducto= DaoFactory.getInstancia().getDaoOrdenxProducto();
        
        if (accion==null)
        {
            result= "solicitud no recibida";
        }
        else if (accion.equals("QRYVENDEDOR")){
            qryVendedor(request,response);
        }
        else if (accion.equals("UPDESTADO")){
            updEstado(request,response);
        }
        else if (accion.equals("QRY"))
        {
            String idOrden= request.getParameter("idOrden");
            //Orden orden= (Orden) request.getSession().getAttribute("orden");
            
            if(usuario != null){
                //System.out.print("el idorden es --->" + orden.getIdOrden());
                //List<OrdenxProducto> listaProductos= daoOrdenxProducto.ordenxProductoQry(orden.getIdOrden());
                List<OrdenxProducto> listaProductos= daoOrdenxProducto.ordenxProductoQry(Integer.parseInt(idOrden));
                //target= "cliente/ordenesxProductos.jsp";
                if (listaProductos != null){
                    request.getSession().setAttribute("listaProductos", listaProductos);
                }
                else{
                    result = "Problemas en consulta";
                }
            }   
        }else if (accion.equals("DEL")){
          
            String idOrdenxProducto= request.getParameter("idOrdenxProducto");
            String idOrden= request.getParameter("idOrden");

            if (usuario!=null){
                result=daoOrdenxProducto.ordenxProductoCancel(Integer.parseInt(idOrdenxProducto));
                System.out.print("INGRESASTE AL DEL");
                List<OrdenxProducto> listaProductos= daoOrdenxProducto.ordenxProductoQry(Integer.parseInt(idOrden));
                request.getSession().setAttribute("listaProductos", listaProductos);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){
//                request.getSession().setAttribute("idOrden", idOrden);
//                request.getSession().setAttribute("idOrdenxProducto", idOrdenxProducto);
//                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("cliente/ordenes.jsp");
                }
                //if(result==null){response.sendRedirect("cliente/ordenes.jsp");}
                else{out.println(result);}
            } 
            finally {
                out.close();
            }
            return;

        }else if(accion.equals("ENV")){
            
            String idOrden= request.getParameter("idOrden");
            String idOrdenxProducto= request.getParameter("idOrdenxProducto");
            
            if (usuario!=null){
                request.getSession().setAttribute("idOrden", idOrden);
                request.getSession().setAttribute("idOrdenxProducto", idOrdenxProducto);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){
                List<OrdenxProducto> listaProductos= daoOrdenxProducto.ordenxProductoQry(Integer.parseInt(idOrden));
                request.getSession().setAttribute("listaProductos", listaProductos);
                response.sendRedirect("cliente/comentario.jsp");
                }
                //if(result==null){response.sendRedirect("cliente/ordenes.jsp");}
                else{out.println(result);}
            } 
            finally {
                out.close();
            }
            return;
             
        }else if(accion.equals("INSC")){
            
            String idOrden= request.getParameter("idOrden");
            String idOrdenxProducto= request.getParameter("idOrdenxProducto");
            String comentario=request.getParameter("comentario");
            String valoracion=request.getParameter("valoracion");
 
            if (usuario!=null){
                result=daoOrdenxProducto.ordenxProductoInsComentario(Integer.parseInt(idOrdenxProducto), comentario, valoracion);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){
                List<OrdenxProducto> listaProductos= daoOrdenxProducto.ordenxProductoQry(Integer.parseInt(idOrden));
                request.getSession().setAttribute("listaProductos", listaProductos);
                response.sendRedirect("cliente/ordenes.jsp");
                }
                //if(result==null){response.sendRedirect("cliente/ordenes.jsp");}
                else{out.println(result);}
            } 
            finally {
                out.close();
            }
            return;
             
        }else if(accion.equals("NOREC")){
            
            String idOrdenxProducto= request.getParameter("idOrdenxProducto");
            String idOrden= request.getParameter("idOrden");
            String fechaEnviada= request.getParameter("fechaEnviada");

            if (usuario!=null){
                result=daoOrdenxProducto.ordenxProductoCancel(Integer.parseInt(idOrdenxProducto));
                System.out.print("INGRESASTE AL NOREC");
//              request.getSession().setAttribute("producto", objOrdenxProducto);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){
                request.getSession().setAttribute("idOrden", idOrden);
                request.getSession().setAttribute("idOrdenxProducto", idOrdenxProducto);
                request.getSession().setAttribute("usuario", usuario);
                response.sendRedirect("cliente/comentario.jsp");
                }
                //if(result==null){response.sendRedirect("cliente/ordenes.jsp");}
                else{out.println(result);}
            } 
            finally {
                out.close();
            }
            return;
             
        }else if(accion.equals("GET")){
            try
            {
                OrdenxProducto oordenxProducto = daoOrdenxProducto.ordenxProductoGet(Integer.parseInt(request.getParameter("idOrdenxProducto")));
                request.getSession().setAttribute("ordenxProducto", oordenxProducto);
                //target= "edit/ordenxProducto/";
            }
            catch (Exception e)
            {
                com.util.Logger.log(e);
                result=e.getStackTrace().toString();
            }
            
        }else if(accion.equals("UPD")){
            OrdenxProducto oordenxProducto = new OrdenxProducto();
            result=valida(oordenxProducto,request);
            if (result==null){
                result=daoOrdenxProducto.ordenxProductoUpd(oordenxProducto);
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
    
    
    private String valida(OrdenxProducto oordenxProducto, HttpServletRequest request){
        String msg="";
        String idOrdenxProducto= request.getParameter("idOrdenxProducto");
        String idOrden= request.getParameter("idOrden");
        String idProducto= request.getParameter("idProducto");
        String cantidad= request.getParameter("cantidad");
        String fechaCreada= request.getParameter("fechaCreada");
        String fechaEnviada= request.getParameter("fechaEnviada");
        String fechaEntregada= request.getParameter("fechaEntregada");
        String fechaCancelada= request.getParameter("fechaCancelada");
        String valoracion= request.getParameter("valoracion");
        String comentarioCliente= request.getParameter("comentarioCliente");
        String comentarioVendedor= request.getParameter("comentarioVendedor");
        String estado= request.getParameter("estado");
        try{oordenxProducto.setIdOrdenxProducto(Integer.valueOf(idOrdenxProducto));}
        catch(Exception e){
            com.util.Logger.log(e);
            oordenxProducto.setIdOrdenxProducto(null);
        }
        try{
            Integer oidOrden=Integer.valueOf(idOrden);
            if (oidOrden<=0) msg+="Ingrese idOrden mayor a cero<br/>";
            oordenxProducto.setIdOrden(oidOrden);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese idOrden valido<br/>"; }
        try{
            Integer oidProducto=Integer.valueOf(idProducto);
            if (oidProducto<=0) msg+="Ingrese idProducto mayor a cero<br/>";
            oordenxProducto.setIdProducto(oidProducto);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese idProducto valido<br/>"; }
        try{
            Integer ocantidad=Integer.valueOf(cantidad);
            if (ocantidad<=0) msg+="Ingrese cantidad mayor a cero<br/>";
            oordenxProducto.setCantidad(ocantidad);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese cantidad valido<br/>"; }
        try{
            Integer ovaloracion=Integer.valueOf(valoracion);
            if (ovaloracion<=0) msg+="Ingrese valoracion mayor a cero<br/>";
            oordenxProducto.setValoracion(ovaloracion);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese valoracion valido<br/>"; }
        msg += ((comentarioCliente==null) || (comentarioCliente.trim().isEmpty()))
                ? "Ingrese comentarioCliente<br/>":"";
        oordenxProducto.setComentarioCliente(comentarioCliente);
        msg += ((comentarioVendedor==null) || (comentarioVendedor.trim().isEmpty()))
                ? "Ingrese comentarioVendedor<br/>":"";
        oordenxProducto.setComentarioVendedor(comentarioVendedor);
        msg += ((estado==null) || (estado.trim().isEmpty()))
                ? "Ingrese estado<br/>":"";
        oordenxProducto.setEstado(estado);
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

    private void qryVendedor(HttpServletRequest request, HttpServletResponse response) {
        String idVendedor= request.getParameter("idVendedor");
        Integer iidVendedor= new Integer(0);
        try{iidVendedor=Integer.parseInt(idVendedor);}catch(Exception e){com.util.Logger.log(e);}
        List<OrdenxProducto> listaProductos= DaoFactory.getInstancia().getDaoOrdenxProducto().ordenxProductoQryVendedor(iidVendedor);
        request.getSession().setAttribute("listaProductos", listaProductos);
    }

    private void updEstado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idOrdenxProducto= request.getParameter("idOrdenxProducto");
        String estado= request.getParameter("estado");
        String valoracion =request.getParameter("valoracion");
        String comentario =request.getParameter("comentario");
        Usuario usuario= (Usuario)request.getSession().getAttribute("usuario");
        
        String result="";
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try {
            DaoOrdenxProducto daoOrdenxProducto=DaoFactory.getInstancia().getDaoOrdenxProducto();
            OrdenxProducto ordenxProducto= daoOrdenxProducto.ordenxProductoGet(Integer.parseInt(idOrdenxProducto));
            if (ordenxProducto==null){
                result+="no se encuentra la ordenxProducto<br/>";
            }
            if (estado == null){
                result+="Necesita especificar un estado<br/>";
            }
            else if ("2".equals(estado)) /*Aceptado*/
            {
                if (!usuario.getTipo().equals("vendedor")){
                    result+="Debe ser un vendedor para poder aceptar un producto<br/>";
                }else if (!ordenxProducto.getEstado().equals("1")){
                    result+="Solo se puede cambiar el estado Creado a Aceptado<br/>";
                } else{
                    ordenxProducto.setEstado("2");
                    String result1=daoOrdenxProducto.ordenxProductoUpdTrans(ordenxProducto,false);
                    if (result1!=null) result+=result1;                    
                }
            }
            else if ("3".equals(estado)){/*Enviado*/
                if (!usuario.getTipo().equals("vendedor")){
                    result+="Debe ser un vendedor para poder enviar un producto<br/>";
                }else if (!ordenxProducto.getEstado().equals("2")){
                    result+="Solo se puede cambiar el estado Aceptado a Enviado<br/>";
                } else{
                    ordenxProducto.setEstado("3");
                    ordenxProducto.setFechaEnviada(new Date(java.util.Calendar.getInstance().getTimeInMillis()));
                    String result1=daoOrdenxProducto.ordenxProductoUpdTrans(ordenxProducto,false);
                    if (result1!=null) result+=result1; 
                }
            }else if ("4".equals(estado)){/*Entregado*/
                if (usuario.getTipo().equals("cliente") && ordenxProducto.getEstado().equals("4")){
                    if (comentario==null || comentario.isEmpty()){
                        result+="Debe ingresar un comentario";
                    } else if (valoracion==null || valoracion.isEmpty() || Integer.parseInt(valoracion)<=0 || Integer.parseInt(valoracion)>5){
                        result+="Debe asignar una valoración";
                    }else {
                        ordenxProducto.setValoracion(Integer.parseInt(valoracion));
                        ordenxProducto.setComentarioCliente(comentario);
                        String result1=daoOrdenxProducto.ordenxProductoUpd(ordenxProducto);
                        if (result1!=null) result+=result1; 
                    }
                }else if (!usuario.getTipo().equals("vendedor")){
                    result+="Debe ser un vendedor para poder entregar un producto<br/>";
                }else if (!ordenxProducto.getEstado().equals("3")){
                    result+="Solo se puede cambiar el estado Enviado a Entregado<br/>";
                }else{
                    ordenxProducto.setEstado("4");
                    ordenxProducto.setFechaEntregada(new Date(java.util.Calendar.getInstance().getTimeInMillis()));
                    String result1=daoOrdenxProducto.ordenxProductoUpdTrans(ordenxProducto,false);
                    if (result1!=null) result+=result1; 
                }    
            }else if ("N".equals(estado)){/*No recibido*/
                if (!usuario.getTipo().equals("cliente")){
                    result+="Debe ser un cliente para poder marcar un producto como no entregado<br/>";
                }else if (!ordenxProducto.getEstado().equals("4")){
                    result+="Solo se puede cambiar el estado Entregado a No Entregado<br/>";
                } else{
                    ordenxProducto.setValoracion(Integer.parseInt(valoracion));
                    ordenxProducto.setComentarioCliente(comentario);
                    ordenxProducto.setEstado("N");
                    String result1=daoOrdenxProducto.ordenxProductoUpdTrans(ordenxProducto,true);
                    if (result1!=null) result+=result1; 
                }    
            }else if ("R".equals(estado)){/*Rechazado*/
                if (!usuario.getTipo().equals("vendedor")){
                    result+="Debe ser un vendedor para poder marcar un producto como rechazado<br/>";
                }else if (!ordenxProducto.getEstado().equals("1")){
                    result+="Solo se puede cambiar el estado Creado a Rechazado<br/>";
                } else if (comentario==null || comentario.isEmpty()){
                    result+="Para Rechazar un producto es necesario el comentario del vendedor";
                } else {
                    ordenxProducto.setComentarioVendedor(comentario);
                    ordenxProducto.setEstado("R");
                    String result1=daoOrdenxProducto.ordenxProductoUpdTrans(ordenxProducto,true);
                    if (result1!=null) result+=result1; 
                }    
            }else if ("X".equals(estado)){/*Anulado*/
                if (!usuario.getTipo().equals("cliente")){
                    result+="Debe ser un cliente para poder anular un producto<br/>";
                }else if (!ordenxProducto.getEstado().equals("1") && !ordenxProducto.getEstado().equals("2")){
                    result+="Solo se puede cambiar los estados Creado y Aceptado a Anulado<br/>";
                } else{
                    ordenxProducto.setEstado("X"); 
                    ordenxProducto.setFechaAnulada(new Date(java.util.Calendar.getInstance().getTimeInMillis()));
                    String result1=daoOrdenxProducto.ordenxProductoUpdTrans(ordenxProducto,true);
                    if (result1!=null) result+=result1; 
                }    
            }
            else {
                result+="no se puede cambiar el estado del producto a "+estado+"<br/>";
            }
            
            
            if (result.isEmpty())
                out.print("OK");
            else
                out.println(result);
        }catch(Exception e)
        {
            com.util.Logger.log(e);
            out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            out.close();
        }
        
    }

}
