package model.dao.impl;

import model.dao.DaoReporteClientes;
import com.dto.ReporteClientes;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DaoReporteClientesImpl implements DaoReporteClientes {
    @Override
    public List<ReporteClientes> reporte(Integer idVendedor){
        List<ReporteClientes> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT concat(cli.Nombre,\" \",cli.Apellido) cliente, sum(op.cantidad) productos, sum(op.precio) monto ");
        sb.append("FROM OrdenxProducto op, Orden o, Usuario cli, Producto p ");
        sb.append("WHERE o.idOrden=op.idOrden and cli.idUsuario=o.idCliente and p.idProducto=op.idProducto and op.estado='4' and p.idVendedor=? ");
        sb.append("GROUP BY Cliente ");
        sb.append("ORDER BY Productos DESC ,Monto DESC ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            
            ps.setInt(1,idVendedor);
            
            ResultSet rs= ps.executeQuery();
            list = new ArrayList<ReporteClientes>();
            
            while (rs.next())
            {
                ReporteClientes reporteClientes = new ReporteClientes();
                reporteClientes.setCliente(rs.getString("cliente"));
                reporteClientes.setProductos(rs.getDouble("productos"));
                reporteClientes.setMonto(rs.getDouble("monto"));
                list.add(reporteClientes);
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
