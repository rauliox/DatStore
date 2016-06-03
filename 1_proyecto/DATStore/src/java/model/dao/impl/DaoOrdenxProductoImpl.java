package model.dao.impl;

import com.dto.OrdenxProducto;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoOrdenxProducto;

class DaoOrdenxProductoImpl implements DaoOrdenxProducto{

    @Override
    public List<OrdenxProducto> ordenxProductoQry(Integer idOrden) {
        List<OrdenxProducto> listaProductos= null;
        Connection cn=null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("a.idOrdenxProducto "); //1
        sql.append(",a.idOrden ");//2
        sql.append(",b.nombre ");//3
        sql.append(",a.cantidad ");//4
        sql.append(",a.precio ");//5
        sql.append(",a.fechaCreada ");//6
        sql.append(",c.descripcion ");//7
        sql.append(",a.fechaEnviada ");//8
        sql.append(",a.fechaEntregada ");//9
        sql.append(",a.comentarioCliente ");//10
        sql.append(",a.fechaAnulada ");//11
        sql.append(",a.valoracion ");//12
        sql.append(",a.comentarioVendedor ");//13
        sql.append(",a.estado ");//14

        sql.append("FROM OrdenxProducto a inner join producto b on a.idProducto=b.idProducto ");
        sql.append("inner join estado c on a.estado=c.estado ");
        sql.append("WHERE a.estado<>'E' and a.idOrden = ? ");
        
        try{
            
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idOrden);
            ResultSet rs = ps.executeQuery();
            
            listaProductos = new ArrayList<OrdenxProducto>();
            while (rs.next())
            {
                OrdenxProducto ordenxProducto = new OrdenxProducto();
                ordenxProducto.setIdOrdenxProducto(rs.getInt(1));
                ordenxProducto.setIdOrden(rs.getInt(2));
                ordenxProducto.setNombreProducto(rs.getString(3));
                ordenxProducto.setCantidad(rs.getInt(4));
                ordenxProducto.setPrecio(rs.getDouble(5));
                ordenxProducto.setFechaCreada(rs.getDate(6));
                //ordenxProducto.setFechaAnulada(rs.getDate("fechaAnulada"));
                //ordenxProducto.setValoracion(rs.getInt("valoracion"));
                
                //ordenxProducto.setComentarioVendedor(rs.getString("comentarioVendedor"));
                ordenxProducto.setDescEstado(rs.getString(7));
                ordenxProducto.setFechaEnviada(rs.getDate(8));
                ordenxProducto.setFechaEntregada(rs.getDate(9));
                ordenxProducto.setComentarioCliente(rs.getString(10));
                ordenxProducto.setEstado(rs.getString(14));
                listaProductos.add(ordenxProducto);
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
         return listaProductos;
    }

    @Override
    public String ordenxProductoIns(OrdenxProducto ordenxProducto) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO OrdenxProducto(");
        sb.append("idOrden ");
        sb.append(",idProducto ");
        sb.append(",cantidad ");
        sb.append(",fechaCreada ");
        sb.append(",fechaEnviada ");
        sb.append(",fechaEntregada ");
        sb.append(",fechaAnulada ");
        sb.append(",valoracion ");
        sb.append(",comentarioCliente ");
        sb.append(",comentarioVendedor ");
        sb.append(",estado ");
        sb.append(") ");
        sb.append("values (?,?,?,?,?,?,?,?,?,?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setInt(1,ordenxProducto.getIdOrden());
            ps.setInt(2,ordenxProducto.getIdProducto());
            ps.setInt(3,ordenxProducto.getCantidad());
            ps.setDate(4,ordenxProducto.getFechaCreada());
            ps.setDate(5,ordenxProducto.getFechaEnviada());
            ps.setDate(6,ordenxProducto.getFechaEntregada());
            ps.setDate(7,ordenxProducto.getFechaAnulada());
            ps.setInt(8,ordenxProducto.getValoracion());
            ps.setString(9,ordenxProducto.getComentarioCliente());
            ps.setString(10,ordenxProducto.getComentarioVendedor());
            ps.setString(11,ordenxProducto.getEstado());

            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        catch (Exception e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        finally
        {
            try{
                cn.close();
            }catch (SQLException e ){com.util.Logger.log(e);result=e.getMessage();}
        }
        
        return result;
    }

    @Override
    public String ordenxProductoDel(Integer idOrdenxProducto) {
        
        String result= null;
        Connection cn = null;
        String sql = "DELETE FROM OrdenxProducto WHERE idOrdenxProducto= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idOrdenxProducto);
            int ctos = ps.executeUpdate();
            if(ctos==0){
                result="0 filas afectadas";
            }
        }
        catch(SQLException e)
        {
            com.util.Logger.log(e);
            result=e.getMessage();
        }
        finally{
            try{
                cn.close();
            }
            catch(SQLException e)
            {
                com.util.Logger.log(e);
                result = e.getMessage();
            }
        }
        
        return result;
    }

    @Override
    public OrdenxProducto ordenxProductoGet(Integer idOrdenxProducto) {
        OrdenxProducto oordenxProducto =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("op.idOrdenxProducto ");
        sql.append(",op.idOrden ");
        sql.append(",op.idProducto ");
        sql.append(",op.cantidad ");
        sql.append(",op.precio ");
        sql.append(",op.fechaCreada ");
        sql.append(",op.fechaEnviada ");
        sql.append(",op.fechaEntregada ");
        sql.append(",op.fechaAnulada ");
        sql.append(",op.valoracion ");
        sql.append(",op.comentarioCliente ");
        sql.append(",op.comentarioVendedor ");
        sql.append(",op.estado ");
        sql.append(",c.Nombre ");
        sql.append(",c.Apellido ");
        sql.append(",p.nombre ");
        sql.append(",e.descripcion ");
        sql.append("FROM OrdenxProducto op, Orden o, Usuario c, Producto p , Estado e ");
        sql.append("WHERE op.idOrden=o.idOrden and o.idCliente=c.idUsuario and p.idProducto=op.idProducto and e.estado=op.estado ");
        sql.append(" and idOrdenxProducto= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idOrdenxProducto);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                oordenxProducto = new OrdenxProducto();
                oordenxProducto.setIdOrdenxProducto(rs.getInt(1));
                oordenxProducto.setIdOrden(rs.getInt(2));
                oordenxProducto.setIdProducto(rs.getInt(3));
                oordenxProducto.setCantidad(rs.getInt(4));
                oordenxProducto.setPrecio(rs.getDouble(5));
                oordenxProducto.setFechaCreada(rs.getDate(6));
                oordenxProducto.setFechaEnviada(rs.getDate(7));
                oordenxProducto.setFechaEntregada(rs.getDate(8));
                oordenxProducto.setFechaAnulada(rs.getDate(9));
                oordenxProducto.setValoracion(rs.getInt(10));
                oordenxProducto.setComentarioCliente(rs.getString(11));
                oordenxProducto.setComentarioVendedor(rs.getString(12));
                oordenxProducto.setEstado(rs.getString(13));
                oordenxProducto.setNombreCliente(rs.getString(14)+" "+rs.getString(15));
                oordenxProducto.setNombreProducto(rs.getString(16));
                oordenxProducto.setDescEstado(rs.getString(17));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return oordenxProducto;
    }

    @Override
    public String ordenxProductoUpd(OrdenxProducto ordenxProducto) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE OrdenxProducto SET ");
        sql.append("idOrden = ? ");
        sql.append(",idProducto = ? ");
        sql.append(",cantidad = ? ");
        sql.append(",precio = ? ");
        sql.append(",fechaCreada = ? ");
        sql.append(",fechaEnviada = ? ");
        sql.append(",fechaEntregada = ? ");
        sql.append(",fechaAnulada = ? ");
        sql.append(",valoracion = ? ");
        sql.append(",comentarioCliente = ? ");
        sql.append(",comentarioVendedor = ? ");
        sql.append(",estado = ? ");
        sql.append("WHERE idOrdenxProducto = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,ordenxProducto.getIdOrden());
            ps.setInt(2,ordenxProducto.getIdProducto());
            ps.setInt(3,ordenxProducto.getCantidad());
            ps.setDouble(4,ordenxProducto.getPrecio());
            ps.setDate(5,ordenxProducto.getFechaCreada());
            ps.setDate(6,ordenxProducto.getFechaEnviada());
            ps.setDate(7,ordenxProducto.getFechaEntregada());
            ps.setDate(8,ordenxProducto.getFechaAnulada());
            ps.setInt(9,ordenxProducto.getValoracion());
            ps.setString(10,ordenxProducto.getComentarioCliente());
            ps.setString(11,ordenxProducto.getComentarioVendedor());
            ps.setString(12,ordenxProducto.getEstado());
            ps.setInt(13,ordenxProducto.getIdOrdenxProducto());
            
            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        catch (Exception e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        finally
        {
            try{
                cn.close();
            }catch (SQLException e ){com.util.Logger.log(e);result=e.getMessage();}
        }
        
        return result;
    }

    @Override
    public String ordenxProductoCancel(Integer idOrdenxProducto) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE OrdenxProducto SET ");
        sql.append("fechaAnulada = CURDATE(), estado = 'X' ");
        sql.append("WHERE idOrdenxProducto = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idOrdenxProducto);
            
            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        catch (Exception e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        finally
        {
            try{
                cn.close();
            }catch (SQLException e ){com.util.Logger.log(e);result=e.getMessage();}
        }
        
        return result;
    }
    
    @Override
    public String ordenxProductoOrdenRecibida(Integer idOrdenxProducto) {
        
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE OrdenxProducto SET ");
        sql.append("fechaEntregada = CURDATE(), estado = '4' ");
        sql.append("WHERE idOrdenxProducto = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idOrdenxProducto);
            
            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        catch (Exception e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        finally
        {
            try{
                cn.close();
            }catch (SQLException e ){com.util.Logger.log(e);result=e.getMessage();}
        }
        
        return result;
    }

    @Override
    public String ordenxProductoInsComentario(Integer idOrdenxProducto, String comentario, String valoracion) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE OrdenxProducto SET ");
        sql.append("comentarioCliente = ? ,");
        sql.append("valoracion=? ");
        sql.append("WHERE idOrdenxProducto = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, comentario);
            ps.setString(2, valoracion);
            ps.setInt(3,idOrdenxProducto);
            
            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        catch (Exception e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        finally
        {
            try{
                cn.close();
            }catch (SQLException e ){com.util.Logger.log(e);result=e.getMessage();}
        }
        
        return result;
    }

    @Override
    public List<OrdenxProducto> ordenxProductoQryVendedor(Integer idVendedor){
        List<OrdenxProducto> listaProductos= null;
        Connection cn=null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("op.idOrdenxProducto ");
        sql.append(",op.idOrden ");
        sql.append(",op.idProducto ");
        sql.append(",op.cantidad ");
        sql.append(",op.precio ");
        sql.append(",op.fechaCreada ");
        sql.append(",op.fechaEnviada ");
        sql.append(",op.fechaEntregada ");
        sql.append(",op.fechaAnulada ");
        sql.append(",op.valoracion ");
        sql.append(",op.comentarioCliente ");
        sql.append(",op.comentarioVendedor ");
        sql.append(",op.estado ");
        sql.append(",c.Nombre ");
        sql.append(",c.Apellido ");
        sql.append(",p.nombre ");
        sql.append(",e.descripcion ");
        sql.append("FROM OrdenxProducto op, Orden o, Usuario c, Producto p, estado e ");
        sql.append("WHERE op.idOrden=o.idOrden and o.idCliente=c.idUsuario and p.idProducto=op.idProducto ");
        sql.append(" and op.estado<>'E' and e.estado=op.estado and idVendedor= ? ");
        sql.append("ORDER BY op.idOrdenxProducto DESC ");
        
        try{
            
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idVendedor);
            ResultSet rs = ps.executeQuery();
            
            listaProductos = new ArrayList<OrdenxProducto>();
            while (rs.next())
            {
                OrdenxProducto oordenxProducto = new OrdenxProducto();
                oordenxProducto.setIdOrdenxProducto(rs.getInt(1));
                oordenxProducto.setIdOrden(rs.getInt(2));
                oordenxProducto.setIdProducto(rs.getInt(3));
                oordenxProducto.setCantidad(rs.getInt(4));
                oordenxProducto.setPrecio(rs.getDouble(5));
                oordenxProducto.setFechaCreada(rs.getDate(6));
                oordenxProducto.setFechaEnviada(rs.getDate(7));
                oordenxProducto.setFechaEntregada(rs.getDate(8));
                oordenxProducto.setFechaAnulada(rs.getDate(9));
                oordenxProducto.setValoracion(rs.getInt(10));
                oordenxProducto.setComentarioCliente(rs.getString(11));
                oordenxProducto.setComentarioVendedor(rs.getString(12));
                oordenxProducto.setEstado(rs.getString(13));
                oordenxProducto.setNombreCliente(rs.getString(14)+" "+rs.getString(15));
                oordenxProducto.setNombreProducto(rs.getString(16));
                oordenxProducto.setDescEstado(rs.getString(17));
                listaProductos.add(oordenxProducto);
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
         return listaProductos;
    }
    
    @Override
    public String ordenxProductoUpdTrans(OrdenxProducto ordenxProducto, boolean devolverStock) {
        String result = null;
        Connection cn = null;
   
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            cn.setAutoCommit(false);
            
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE OrdenxProducto SET ");
            sql.append("idOrden = ? ");
            sql.append(",idProducto = ? ");
            sql.append(",cantidad = ? ");
            sql.append(",precio = ? ");
            sql.append(",fechaCreada = ? ");
            sql.append(",fechaEnviada = ? ");
            sql.append(",fechaEntregada = ? ");
            sql.append(",fechaAnulada = ? ");
            sql.append(",valoracion = ? ");
            sql.append(",comentarioCliente = ? ");
            sql.append(",comentarioVendedor = ? ");
            sql.append(",estado = ? ");
            sql.append("WHERE idOrdenxProducto = ? ");
        
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,ordenxProducto.getIdOrden());
            ps.setInt(2,ordenxProducto.getIdProducto());
            ps.setInt(3,ordenxProducto.getCantidad());
            ps.setDouble(4,ordenxProducto.getPrecio());
            ps.setDate(5,ordenxProducto.getFechaCreada());
            ps.setDate(6,ordenxProducto.getFechaEnviada());
            ps.setDate(7,ordenxProducto.getFechaEntregada());
            ps.setDate(8,ordenxProducto.getFechaAnulada());
            ps.setInt(9,ordenxProducto.getValoracion());
            ps.setString(10,ordenxProducto.getComentarioCliente());
            ps.setString(11,ordenxProducto.getComentarioVendedor());
            ps.setString(12,ordenxProducto.getEstado());
            ps.setInt(13,ordenxProducto.getIdOrdenxProducto());
            
            int ctos= ps.executeUpdate();

            if(ctos==0){
                throw new SQLException("no se encontró la ordenxProducto");
            }
            ps.close();
            
            if (devolverStock){
                sql = new StringBuilder();
                sql.append("UPDATE producto SET ");
                sql.append("stock = stock+? , ");
                sql.append("vendidas = vendidas-? ");
                sql.append("WHERE idProducto = ? ");
                
                ps=cn.prepareStatement(sql.toString());
                ps.setInt(1, ordenxProducto.getCantidad());
                ps.setInt(2, ordenxProducto.getCantidad());
                ps.setInt(3, ordenxProducto.getIdProducto());

                ctos= ps.executeUpdate();
                if(ctos==0){
                    throw new SQLException("no se encontró el Producto");
                }
                ps.close();
            }
        }
        catch (SQLException e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        catch (Exception e){
            com.util.Logger.log(e);
            result= e.getMessage();
        }
        finally
        {
            try{
                if (result!=null){
                    cn.rollback();
                }
                else{
                    cn.commit();
                }
            }catch (SQLException e ){
                com.util.Logger.log(e);
                if (result==null) result=e.getMessage();
                e.printStackTrace();
            }
        }
        
        return result;
    }
}
