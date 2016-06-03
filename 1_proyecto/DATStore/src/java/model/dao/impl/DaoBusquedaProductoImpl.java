package model.dao.impl;

import com.dto.BusquedaProducto;
import com.dto.Producto;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.dao.DaoBusquedaProducto;

class DaoBusquedaProductoImpl implements DaoBusquedaProducto{
    
    @Override
    public void buscar(BusquedaProducto bp)
    {
        inicializarWhere(bp);
        listado(bp);
    }
    
    @Override
    public void inicializarBusqueda(BusquedaProducto bp)
    {
        inicializarWhere(bp);
        inicializarCriterios(bp);
        listado(bp);
    }
    
    private StringBuilder sbwhere;
    private List parametros;
    
    private void inicializarWhere(BusquedaProducto bp){
        parametros= new ArrayList();
        sbwhere=new StringBuilder();
        sbwhere.append("WHERE s.idSubcategoria=p.idSubcategoria and p.estado<>'E' and p.stock>0 ");
        
        if(bp.getBusqueda()!=null)
        {
            sbwhere.append(" and p.nombre like ? ");
            parametros.add("%"+bp.getBusqueda()+"%");
        }
        if (bp.getIdCategoria()!=null){
            sbwhere.append(" and s.idCategoria=? ");
            parametros.add(bp.getIdCategoria());
        }
        if (bp.getIdSubcategoria()!=null){
            sbwhere.append(" and p.idSubcategoria=? ");
            parametros.add( bp.getIdSubcategoria());
        }
        List<String> criterioPrecio=bp.getCriterioPrecioAplicado();
        if (criterioPrecio!=null && !criterioPrecio.isEmpty())
        {
            sbwhere.append(" and (false ");
            Iterator<String> it=criterioPrecio.iterator();
            while (it.hasNext()){
                sbwhere.append(" or (p.precio>= ? and p.precio<= ?) ");
                String[] rango = it.next().split("/");
                Double precio1=new Double(0);
                Double precio2=new Double(0);
                try{
                    precio1= Double.parseDouble(rango[0]);
                    precio2= Double.parseDouble(rango[1]);
                }
                catch (Exception e){
                    com.util.Logger.log(e);
                }
                parametros.add( precio1);
                parametros.add( precio2);
            }
            sbwhere.append(") ");
        }
        
        List<String> criterioMarca=bp.getCriterioMarcaAplicado();
        if (criterioMarca!=null && !criterioMarca.isEmpty())
        {
            sbwhere.append(" and (false ");
            Iterator<String> it=criterioMarca.iterator();
            while (it.hasNext()){
                sbwhere.append(" or p.marca = ? ");
                parametros.add( it.next());
            }
            sbwhere.append(") ");
        }
                
        List<String> criterioModelo=bp.getCriterioModeloAplicado();
        if (criterioModelo!=null && !criterioModelo.isEmpty())
        {
            sbwhere.append(" and (false ");
            Iterator<String> it=criterioModelo.iterator();
            while (it.hasNext()){
                sbwhere.append(" or p.modelo = ? ");
                parametros.add( it.next());
            }
            sbwhere.append(") ");
        }
        
    }
    
    
    public void listado(BusquedaProducto bp) {
        Connection cn=null;
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            StringBuilder sbcount = new StringBuilder();
            sbcount.append("SELECT count(p.idProducto) cuenta ");
            sbcount.append("FROM Producto p, Subcategoria s ");
            sbcount.append(sbwhere.toString());
            
            PreparedStatement pscount = cn.prepareStatement(sbcount.toString());
            com.util.GlobalUtil.mapParams(pscount, parametros);
            ResultSet rscount= pscount.executeQuery();
            if (rscount.next()){
                bp.setNroPaginas((int)Math.ceil(((double)rscount.getInt("cuenta"))/BusquedaProducto.PRODUCTOSXPAGINA));
            }
            
            
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ");
            sb.append("p.idProducto ");
            sb.append(",p.idVendedor ");
            sb.append(",p.idSubcategoria ");
            sb.append(",p.nombre ");
            sb.append(",p.descripcion ");
            sb.append(",p.precio ");
            sb.append(",p.imagen ");
            sb.append(",p.stock ");
            sb.append(",p.vendidas ");
            sb.append(",p.marca ");
            sb.append(",p.modelo ");
            sb.append(",p.estado ");
            sb.append("FROM Producto p, Subcategoria s ");
            sb.append(sbwhere.toString());

            sb.append("ORDER BY ").append(bp.getOrden());
            if(bp.getAsc())
                sb.append(" ASC ");
            else
                sb.append(" DESC ");

            sb.append(" LIMIT ");
            sb.append((bp.getPagina()-1)*BusquedaProducto.PRODUCTOSXPAGINA);
            sb.append(",");
            sb.append(BusquedaProducto.PRODUCTOSXPAGINA);

            PreparedStatement ps = cn.prepareStatement(sb.toString());
            
            com.util.GlobalUtil.mapParams(ps, parametros);
            
            ResultSet rs= ps.executeQuery();
            bp.getProductos().clear();
            
            while (rs.next())
            {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setIdVendedor(rs.getInt("idVendedor"));
                producto.setIdSubcategoria(rs.getInt("idSubcategoria"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setImagen(rs.getString("imagen"));
                producto.setStock(rs.getInt("stock"));
                producto.setVendidas(rs.getInt("vendidas"));
                producto.setMarca(rs.getString("marca"));
                producto.setModelo(rs.getString("modelo"));
                producto.setEstado(rs.getString("estado"));
                bp.getProductos().add(producto);
            }
         }
         catch (SQLException e){
             com.util.Logger.log(e);
             e.printStackTrace();
         }
         catch (Exception e){
             com.util.Logger.log(e);
             e.printStackTrace();
         }
         finally
         {
             try{
                 cn.close();
             }catch (SQLException ex ){
                 com.util.Logger.log(ex);
                 ex.printStackTrace();
             }
         }
    }
    
    public void inicializarCriterios(BusquedaProducto bp){
        
        Connection cn=null;
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            
            StringBuilder sbprecio = new StringBuilder();
            sbprecio.append("SELECT DISTINCT ");
            sbprecio.append(" p.precio ");
            sbprecio.append(" FROM Producto p, Subcategoria s ");
            sbprecio.append(sbwhere.toString());
            sbprecio.append(" ORDER BY precio ASC ");
            PreparedStatement psprecio = cn.prepareStatement(sbprecio.toString());
            
            com.util.GlobalUtil.mapParams(psprecio, parametros);
            
            ResultSet rsprecio= psprecio.executeQuery();
            ArrayList<Double> precios=new ArrayList<Double>();            
            while (rsprecio.next()){
                precios.add(rsprecio.getDouble("precio"));
            }
            bp.getCriterioPrecio().clear();
            int preciosEnCriterio= (int)Math.ceil(((double)precios.size() )/BusquedaProducto.MAXPRECIOS);
            String iniPrecio=""; String finPrecio="";
            for(int i=0; i<precios.size();i++){
                if (i%preciosEnCriterio==0)
                    iniPrecio=precios.get(i).toString();
                if ((i+1)%preciosEnCriterio==0 || i==precios.size()-1)                {
                    finPrecio=precios.get(i).toString();
                    if (iniPrecio.equals(finPrecio))
                        bp.getCriterioPrecio().put(iniPrecio+"/"+finPrecio,"S/."+iniPrecio);
                    else
                        bp.getCriterioPrecio().put(iniPrecio+"/"+finPrecio,"S/."+iniPrecio+" - "+"S/."+finPrecio );
                }
            }
            
            StringBuilder sbmarca = new StringBuilder();
            sbmarca.append("SELECT DISTINCT ");
            sbmarca.append(" p.marca ");
            sbmarca.append(" FROM Producto p, subcategoria s ");
            sbmarca.append(sbwhere.toString());
            sbmarca.append(" LIMIT 0,");
            sbmarca.append(BusquedaProducto.MAXITEMSCRITERIOS);
            
            PreparedStatement psmarca = cn.prepareStatement(sbmarca.toString());
            
            com.util.GlobalUtil.mapParams(psmarca, parametros);
            
            ResultSet rsmarca= psmarca.executeQuery();
            bp.getCriterioMarca().clear();
            
            while (rsmarca.next())
            {
                bp.getCriterioMarca().add(rsmarca.getString("marca"));
            }
            
            StringBuilder sbmodelo = new StringBuilder();
            sbmodelo.append("SELECT DISTINCT ");
            sbmodelo.append(" p.modelo ");
            sbmodelo.append(" FROM Producto p, Subcategoria s ");
            sbmodelo.append(sbwhere.toString());
            sbmodelo.append(" LIMIT 0,");
            sbmodelo.append(BusquedaProducto.MAXITEMSCRITERIOS);
            PreparedStatement psmodelo = cn.prepareStatement(sbmodelo.toString());
            
            com.util.GlobalUtil.mapParams(psmodelo, parametros);
            
            ResultSet rsmodelo= psmodelo.executeQuery();
            bp.getCriterioModelo().clear();
            
            while (rsmodelo.next())
            {
                bp.getCriterioModelo().add(rsmodelo.getString("modelo"));
            }
         }
         catch (SQLException e){
             com.util.Logger.log(e);
             e.printStackTrace();
         }
         catch (Exception e){
             com.util.Logger.log(e);
             e.printStackTrace();
         }
         finally
         {
             try{
                 cn.close();
             }catch (SQLException ex ){
                 com.util.Logger.log(ex);
                 ex.printStackTrace();
             }
         }
    }
}
