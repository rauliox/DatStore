package web.servlet;

import com.dto.Orden;
import com.dto.Producto;
import com.dto.Categoria;
import com.dto.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
import model.dao.DaoProducto;
import model.dao.DaoCategoria;
import model.dao.impl.DaoFactory;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/Producto"})
public class ProductoServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            String accion= request.getParameter("accion");
        String result = null;
        String target = null;
        
        DaoProducto daoProducto= DaoFactory.getInstancia().getDaoProducto();
        DaoCategoria daoCategoria=DaoFactory.getInstancia().getDaoCategoria();
        
        if (accion==null)
        {
            result= "solicitud no recibida";
        }
        else if (accion.equals("QRY"))
        {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            if(usuario != null){
                System.out.print("el idusuario es --->" + usuario.getIdUsuario());
                List<Producto> list= daoProducto.productoQry(usuario.getIdUsuario());
                request.getSession().setAttribute("list", list);
            }
            
        }else if(accion.equals("INS")){
            
            Producto oproducto = new Producto();
            result=valida(oproducto,request);
            if (result==null){
                result=daoProducto.productoIns(oproducto);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){
                    
                out.print("OK");
                
                }
                else{out.println(result);}
            } finally {
                
                request.getSession().setAttribute("producto", new Producto());
                
                out.close();
            }
            return;
             
        }
        else if(accion.equals("DEL")){
            List<String> idProductos = Arrays.asList(request.getParameter("idProductos").split("\\s*,\\s*"));
            Iterator<String> it = idProductos.iterator();
            while (it.hasNext())
            {
                String resulttemp= daoProducto.productoDel(Integer.parseInt(it.next()));
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
                Producto oproducto = daoProducto.productoGet(Integer.parseInt(request.getParameter("idProducto")));
                request.getSession().setAttribute("producto", oproducto);
            }
            catch (Exception e)
            {
                com.util.Logger.log(e);
                result=e.getStackTrace().toString();
            }
            
        }else if(accion.equals("UPD")){
            Producto oproducto = new Producto();
            oproducto.setIdProducto(Integer.parseInt(request.getParameter("codigo")));
            result=valida(oproducto,request);
            
            
            
            if (result==null){
                result=daoProducto.productoUpd(oproducto);
            }
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                if(result==null){out.print("OK");}
                else{out.println(result);}
            } finally {
                out.close();
                request.getSession().setAttribute("producto", new Producto());
            }
            return;
        }
        else if (accion.equals("listarProductos"))
        {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            List<Producto> listaProd= daoProducto.listarProductos(Integer.parseInt(request.getParameter("idProducto")),usuario.getIdUsuario());
            
            if (listaProd!= null){
                request.getSession().setAttribute("listaProd", listaProd);
               // target= "view/producto/";
                response.sendRedirect("productos.jsp");
            }
            else{
                result = "Problemas en consulta";
            } 
        }
        else if (accion.equals("nuevoProducto"))
        {

            String mostrar= request.getParameter("mostrar");
            if(mostrar!=null){
                Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
                List<Producto> producto= daoProducto.listarProductos(Integer.parseInt(request.getParameter("idProducto")),usuario.getIdUsuario());
                
                request.getSession().setAttribute("producto",producto.get(0));
                
            }else
            {
                request.getSession().setAttribute("producto",null);
            }
            
           List<Categoria> listaCat=daoCategoria.listarCategoria(-1);
            if(listaCat!=null){
            request.getSession().setAttribute("listaCategoria", listaCat);
            target="vendedor/nuevoProducto.jsp";

            }
        }
        else if (accion.equals("eliminaProducto")){
            
              Integer idProducto=Integer.parseInt(request.getParameter("idProducto"));
              result =daoProducto.productoDel(idProducto);
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

    
    private String valida(Producto oproducto, HttpServletRequest request){
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        String msg="";
        //String idProducto= request.getParameter("idProducto");
        Integer idVendedor= usuario.getIdUsuario();
        oproducto.setIdVendedor(idVendedor);
        String idSubcategoria= request.getParameter("categoria");
        String nombre= request.getParameter("nombre");
        String descripcion= request.getParameter("descripcion");
        String precio= request.getParameter("precio");
        String imagen= request.getParameter("imagen");
        String stock= request.getParameter("stock");
        //String vendidas= request.getParameter("vendidas");
        String vendidas=request.getParameter("vendidas");;
        String marca= request.getParameter("marca");
        String modelo= request.getParameter("modelo");
        //String estado= request.getParameter("estado");
        String estado="A";
        
        /*try{oproducto.setIdProducto(Integer.valueOf(idProducto));}
        catch(Exception e){com.util.Logger.log(e);oproducto.setIdProducto(null);}
        try{
            Integer oidVendedor=Integer.valueOf(idVendedor);
            if (oidVendedor<=0) msg+="Ingrese idVendedor mayor a cero<br/>";
            oproducto.setIdVendedor(oidVendedor);
        }
        catch(Exception e){ msg+="Ingrese idVendedor valido<br/>"; }*/
        try{
            Integer oidSubcategoria=Integer.valueOf(idSubcategoria);
            if (oidSubcategoria<=0) msg+="Ingrese idSubcategoria mayor a cero<br/>";
            oproducto.setIdSubcategoria(oidSubcategoria);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese Categoría<br/>"; }
        msg += ((nombre==null) || (nombre.trim().isEmpty()))
                ? "Ingrese nombre<br/>":"";
        oproducto.setNombre(nombre);

        msg += ((descripcion==null) || (descripcion.trim().isEmpty()))
                ? "Ingrese descripcion<br/>":"";
        oproducto.setDescripcion(descripcion);
        try{
            Double oprecio=Double.valueOf(precio);
            if (oprecio<=0) msg+="Ingrese precio mayor a cero<br/>";
            oproducto.setPrecio(oprecio);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese precio valido<br/>"; }
        msg += ((imagen==null) || (imagen.trim().isEmpty()))
                ? "Ingrese URL imagen<br/>":"";
        
        URL url=null;
        try{
            url = new URL(imagen);
        }catch(MalformedURLException e){
            String base= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
            try{
                url= new URL(base+imagen);
            }catch (Exception ex){}
        }
        try
        {
            HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            String contentType = connection.getContentType();
            if (!contentType.substring(0,5).equals("image"))
                throw new Exception("el URL Imagen no es una imagen");
        }catch (Exception e)
        {
            com.util.Logger.log(e);
            msg+="el URL imagen ingresado no es una imagen.<br/>";
        }
        oproducto.setImagen(imagen);
        try{
            Integer ostock=Integer.valueOf(stock);
            if (ostock<=0) msg+="Ingrese stock mayor a cero<br/>";
            oproducto.setStock(ostock);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese stock valido<br/>"; }
        try{
            Integer ovendidas=Integer.valueOf(vendidas);
            if (ovendidas<0) msg+="Ingrese vendidas mayor a cero<br/>";
            oproducto.setVendidas(ovendidas);
        }
        catch(Exception e){com.util.Logger.log(e); msg+="Ingrese vendidas valido<br/>"; }
        msg += ((marca==null) || (marca.trim().isEmpty()))
                ? "Ingrese marca<br/>":"";
        oproducto.setMarca(marca);
        msg += ((modelo==null) || (modelo.trim().isEmpty()))
                ? "Ingrese modelo<br/>":"";
        oproducto.setModelo(modelo);
        msg += ((estado==null) || (estado.trim().isEmpty()))
                ? "Ingrese estado<br/>":"";
        oproducto.setEstado(estado);
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
