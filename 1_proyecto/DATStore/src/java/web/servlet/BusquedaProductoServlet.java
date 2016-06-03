package web.servlet;

import com.dto.BusquedaProducto;
import com.dto.Producto;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.impl.DaoFactory;

@WebServlet(name = "BusquedaProductoServlet", urlPatterns = {"/BusquedaProducto"})
public class BusquedaProductoServlet extends HttpServlet {

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
        if ("iniciarbusqueda".equals(accion)){
            iniciarBusqueda(request,response);
        }
        if ("buscar".equals(accion)){
            listado(request,response);
        }

    }
    
    private void iniciarBusqueda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        BusquedaProducto bp = new BusquedaProducto();
        bp.setAsc(Boolean.FALSE);
        bp.setOrden("idProducto");
        bp.setPagina(1);
        
        getParameters(request, response, bp);
        
        DaoFactory.getInstancia().getDaoBusquedaProducto().inicializarBusqueda(bp);
        
        /*************** TEST ***************************************/
        /*bp.getCriterioPrecio().put("100/200", "S/.100 - S/.200");
        bp.getCriterioPrecio().put("200/300", "S/.200 - S/.300");
        bp.getCriterioPrecio().put("300/500", "S/.300 - S/.500");
        bp.getCriterioPrecio().put("500/2000", "S/.500 - S/.2000");
        bp.getCriterioPrecio().put("2000/5000", "S/.2000 - S/.5000");
        bp.getCriterioPrecio().put("5000/7000", "S/.5000 - S/.7000");
        
        bp.getCriterioMarca().add("LG");
        bp.getCriterioMarca().add("Apple");
        bp.getCriterioMarca().add("Sampsung");
        bp.getCriterioMarca().add("Nokia");
        
        bp.getCriterioModelo().add("S1");
        bp.getCriterioModelo().add("One");
        bp.getCriterioModelo().add("Iphone 4");
        bp.getCriterioModelo().add("test");
        
        bp.setNroPaginas(10);
        for (int i=1; i<16; i++)
            bp.getProductos().add(new Producto(i, i, i, "Televisor "+Integer.toString(i), "Descripción del televisor "+Integer.toString(i), 
                    100d, "images/pic"+Integer.toString(((i-1)%6)+1)+".jpg", 10, 1, "LG", "1045TV3D", "A"));*/
        /************************************************************/
        
        
        request.getSession().setAttribute("busquedaProducto", bp);
    }
    
    private void listado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BusquedaProducto bp=(BusquedaProducto)request.getSession().getAttribute("busquedaProducto");
        if (bp!=null)
        {
            getParameters(request,response,bp);

            DaoFactory.getInstancia().getDaoBusquedaProducto().buscar(bp);
            
            response.sendRedirect("producto/busquedaproducto.jsp");
        }
        
    }
    
    private static void getParameters(HttpServletRequest request, HttpServletResponse response, BusquedaProducto bp){
        String orden = request.getParameter("orden");
        String asc= request.getParameter("asc");
        String pagina= request.getParameter("pagina");
        String busqueda= request.getParameter("busqueda");
        String idCategoria= request.getParameter("idCategoria");
        String idSubcategoria= request.getParameter("idSubcategoria");
        String[] precios = request.getParameterValues("precio");
        String[] marcas = request.getParameterValues("marca");
        String[] modelos = request.getParameterValues("modelo");
        
        if ("precio".equals(orden) || "nombre".equals(orden))
            bp.setOrden(orden);
        if ("posicion".equals(orden))
            bp.setOrden("idProducto");

        if ("true".equals(asc) || "1".equals(asc))
            bp.setAsc(Boolean.TRUE);
        else if("false".equals(asc) || "0".equals(asc))
            bp.setAsc(Boolean.FALSE);
        
        bp.setPagina(1);
        if (pagina!=null)
            try{
                int pg=Integer.parseInt(pagina);
                bp.setPagina(pg);
            }catch (Exception e){com.util.Logger.log(e);}
        
        if (busqueda != null){
            bp.setBusqueda(busqueda);
        }
        
        if (idCategoria != null)
            try{
                int id=Integer.parseInt(idCategoria);
                bp.setIdCategoria(id);
                bp.setCategoria(DaoFactory.getInstancia().getDaoCategoria().categoriaGet(id).getDescripcion());
            }catch (Exception e){com.util.Logger.log(e);}
        
        if (idSubcategoria != null)
            try{
                int id=Integer.parseInt(idSubcategoria);
                bp.setIdSubcategoria(id);
                bp.setSubcategoria(DaoFactory.getInstancia().getDaoSubcategoria().subcategoriaGet(id).getDescripcion());
            }catch (Exception e){com.util.Logger.log(e);}
        
        bp.getCriterioPrecioAplicado().clear();
        if (precios!= null && precios.length!=0)
            bp.getCriterioPrecioAplicado().addAll(Arrays.asList(precios));
        
        bp.getCriterioMarcaAplicado().clear();
        if (marcas!= null && marcas.length!=0)
            bp.getCriterioMarcaAplicado().addAll(Arrays.asList(marcas));
        
        bp.getCriterioModeloAplicado().clear();
        if (modelos!= null && modelos.length!=0)
            bp.getCriterioModeloAplicado().addAll(Arrays.asList(modelos));
            
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
