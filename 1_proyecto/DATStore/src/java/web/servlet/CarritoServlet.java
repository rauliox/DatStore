/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web.servlet;

import com.dto.Carrito;
import com.dto.Comentario;
import com.dto.Producto;
import com.dto.Usuario;
import com.util.OperacionesCarrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.DaoProcesarCompra;
import model.dao.impl.DaoFactory;

/**
 *
 * @author hogar1
 */
@WebServlet(name = "CarritoServlet", urlPatterns = {"/Carrito"})
public class CarritoServlet extends HttpServlet {

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
    String accion = request.getParameter("accion");
        
     if(accion.equals("cargar")){
         CargarProductos(request, response);
     }   
     
     else if(accion.equals("Alcarrito")){
         AgregarCarrito(request, response);
     } 
     else if(accion.equals("limpiar")){
         LimpiarCarrito(request, response);
     } 
     else if(accion.equals("eliminar")){
         EliminarProducto(request, response);
     } 
       else if(accion.equals("cambiarcant")){
         CambiarCantidad(request, response);
     } 
     else if(accion.equals("singleprod")){
         SingleProd(request, response);
     } 
      else if(accion.equals("procesarcompra")){
         ProcesarCompra(request, response);
     } 
     
    }
    

     private void CargarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         OperacionesCarrito op = new OperacionesCarrito();
       //  List<Productosenbd> lista = op.ListaProductos();
         HttpSession session= request.getSession();
        // session.setAttribute("lista", lista);
         session.setAttribute("listacarrito", op.ListarCarrito());
         session.setAttribute("dato", "");
         session.setAttribute("totalart", "");
         response.sendRedirect("index.jsp");
         
    }
     
  private void SingleProd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto producto = DaoFactory.getInstancia().getDaoProducto().productoGet(idProducto);
        List<Comentario> comentarios=DaoFactory.getInstancia().getDaoProducto().comentarioQRY(idProducto);
        /*OperacionesCarrito operaciones = new OperacionesCarrito();*/
        
         HttpSession session= request.getSession();
         session.setAttribute("producto", producto);
         session.setAttribute("comentarios", comentarios);
         /*session.setAttribute("totalart", "");
         session.setAttribute("listacarrito", operaciones.ListarCarrito());*/
         
         
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

  private void AgregarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         OperacionesCarrito operaciones = new OperacionesCarrito();
         
         String idProducto = request.getParameter("idProducto");
         int cantidad =Integer.parseInt(request.getParameter("cantidad")) ;
         int idProd=0;
         try{
             idProd=Integer.parseInt(idProducto);
         }
         catch(Exception e){
             com.util.Logger.log(e);
         }
         Producto prod= DaoFactory.getInstancia().getDaoProducto().productoGet(idProd);
         /*String descripcion = request.getParameter("descripcion");
         String precio = request.getParameter("precio");
          */
         Double precio = cantidad*prod.getPrecio();
         
         Carrito micarrito = new Carrito(idProd,prod.getNombre(),prod.getDescripcion(),cantidad,precio,prod.getStock(),prod.getImagen());
         
        
        operaciones.AgregarProducto(micarrito);
         
        request.getSession().setAttribute("totalart", operaciones.TotalProductos());
        request.getSession().setAttribute("listacarrito", operaciones.ListarCarrito());
     
      
    }

   private void LimpiarCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         OperacionesCarrito operaciones = new OperacionesCarrito();
       
         operaciones.LimpiarCarrito();
         
         request.getSession().setAttribute("totalart", operaciones.ListarCarrito().size());
         request.getSession().setAttribute("listacarrito", operaciones.ListarCarrito());
   
   
    }

    private void EliminarProducto(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {     
        OperacionesCarrito operaciones = new OperacionesCarrito();
        operaciones.EliminarProducto(Integer.parseInt(request.getParameter("idProducto")));
        
            request.getSession().setAttribute("totalart", operaciones.TotalProductos());
          
    }
    
     private void CambiarCantidad(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {   
         
      int idProducto = Integer.parseInt(request.getParameter("idProducto"));
      int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
      OperacionesCarrito operaciones = new OperacionesCarrito();
      Carrito carro = operaciones.BuscarProducto(idProducto);
      double valor = (carro.getPrecio()/carro.getCantidad());
      carro.setCantidad(cantidad);
      carro.setPrecio(cantidad*valor);
      
      operaciones.ActualizaDatos(carro);
      
      request.getSession().setAttribute("totalart", operaciones.TotalProductos());
      request.getSession().setAttribute("listacarrito", operaciones.ListarCarrito());
      
      
      /********prueba*///////////
      
      /*PrintWriter out = response.getWriter();
        // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
        out.print("{ \"subtotal\": "+String.valueOf(cantidad*valor)+", \"totalcarrito\": "+String.valueOf(500)+"}");
        out.flush();
      */
      response.sendRedirect("carrito.jsp");
     
    }
     
     
      private void ProcesarCompra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         
          DaoProcesarCompra daoProcesar = DaoFactory.getInstancia().getDaoProcesarCompra();
          List<Carrito> lista = (List<Carrito>) request.getSession().getAttribute("listacarrito");
          Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
          String result = daoProcesar.Procesar(lista, usuario);
                      
          request.getSession().setAttribute("resultado", result);
          LimpiarCarrito(request,response);
          response.sendRedirect("cliente/redirect.jsp");
         
    }
     
    
}
