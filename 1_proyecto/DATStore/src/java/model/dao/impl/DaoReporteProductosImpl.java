package model.dao.impl;

import model.dao.DaoReporteProductos;
import com.dto.ReporteProductos;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoReporteProductosImpl implements DaoReporteProductos {
    @Override
    public List<ReporteProductos> reporte(Integer idVendedor){
        List<ReporteProductos> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT p.imagen,p.nombre as producto,p.descripcion, p.stock, p.vendidas, p.precio, sum(op.precio) as monto, c.descripcion as categoria, s.descripcion as subcategoria ");
        sb.append("FROM producto p, OrdenxProducto op, categoria c, subcategoria s ");
        sb.append("WHERE p.idProducto=op.idProducto and s.idSubcategoria=p.idSubcategoria and c.idCategoria=s.idCategoria and op.estado='4' and p.idVendedor=? ");
        sb.append("GROUP BY p.imagen,p.nombre,p.descripcion, p.stock, p.vendidas, p.precio, c.descripcion, s.descripcion ");
        sb.append("ORDER BY p.vendidas desc ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            
            ps.setInt(1,idVendedor);
            
            ResultSet rs= ps.executeQuery();
            list = new ArrayList<ReporteProductos>();
            
            while (rs.next())
            {
                ReporteProductos reporteProductos = new ReporteProductos();
                reporteProductos.setImagen(rs.getString("imagen"));
                reporteProductos.setProducto(rs.getString("producto"));
                reporteProductos.setDescripcion(rs.getString("descripcion"));
                reporteProductos.setStock(rs.getInt("stock"));
                reporteProductos.setVendidos(rs.getInt("vendidas"));
                reporteProductos.setPrecio(rs.getDouble("precio"));
                reporteProductos.setMonto(rs.getDouble("monto"));
                reporteProductos.setCategoria(rs.getString("categoria")+"/"+rs.getString("subcategoria"));
                list.add(reporteProductos);
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
             }catch (SQLException e ){com.util.Logger.log(e);e.printStackTrace();}
         }
        return list;
    }
}
