package model.dao.impl;

import com.dto.Comentario;
import com.dto.Orden;
import com.dto.Producto;
import com.sql.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DaoProducto;

class DaoProductoImpl implements DaoProducto{

    @Override 
    public List<Producto> productoQry(Integer idUsuario) {
        List<Producto> listaProductos= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("nombre ");
        sb.append(",descripcion ");
        sb.append(",precio ");
        sb.append(",stock ");
        sb.append(",marca ");
        sb.append(",modelo ");
        sb.append("FROM Producto ");
        sb.append("WHERE estado<>'E' and idVendedor= ? ");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sb.toString());
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            
            listaProductos= new ArrayList<Producto>();
            while (rs.next())
            
            {
                Producto producto = new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setMarca(rs.getString("marca"));
                producto.setModelo(rs.getString("modelo"));
                listaProductos.add(producto);
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
    public String productoIns(Producto producto) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO Producto(");
        sb.append("idVendedor ");
        sb.append(",idSubcategoria ");
        sb.append(",nombre ");
        sb.append(",descripcion ");
        sb.append(",precio ");
        sb.append(",imagen ");
        sb.append(",stock ");
        sb.append(",vendidas ");
        sb.append(",marca ");
        sb.append(",modelo ");
        sb.append(",estado ");
        sb.append(") ");
        sb.append("values (?,?,?,?,?,?,?,?,?,?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setInt(1,producto.getIdVendedor());
            ps.setInt(2,producto.getIdSubcategoria());
            ps.setString(3,producto.getNombre());
            ps.setString(4,producto.getDescripcion());
            ps.setDouble(5,producto.getPrecio());
            ps.setString(6,producto.getImagen());
            ps.setInt(7,producto.getStock());
            ps.setInt(8,producto.getVendidas());
            ps.setString(9,producto.getMarca());
            ps.setString(10,producto.getModelo());
            ps.setString(11,producto.getEstado());

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
    public String productoDel(Integer idProducto) {
        String result= null;
        Connection cn = null;
        String sql = "UPDATE Producto set estado='E' WHERE idProducto= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idProducto);
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
    public Producto productoGet(Integer idProducto) {
        Producto oproducto =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("idProducto ");
        sql.append(",idVendedor ");
        sql.append(",idSubcategoria ");
        sql.append(",nombre ");
        sql.append(",descripcion ");
        sql.append(",precio ");
        sql.append(",imagen ");
        sql.append(",stock ");
        sql.append(",vendidas ");
        sql.append(",marca ");
        sql.append(",modelo ");
        sql.append(",estado ");
        sql.append("FROM Producto ");
        sql.append("WHERE idProducto= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                oproducto = new Producto();
                oproducto.setIdProducto(rs.getInt(1));
                oproducto.setIdVendedor(rs.getInt(2));
                oproducto.setIdSubcategoria(rs.getInt(3));
                oproducto.setNombre(rs.getString(4));
                oproducto.setDescripcion(rs.getString(5));
                oproducto.setPrecio(rs.getDouble(6));
                oproducto.setImagen(rs.getString(7));
                oproducto.setStock(rs.getInt(8));
                oproducto.setVendidas(rs.getInt(9));
                oproducto.setMarca(rs.getString(10));
                oproducto.setModelo(rs.getString(11));
                oproducto.setEstado(rs.getString(12));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return oproducto;
    }

    @Override
    public String productoUpd(Producto producto) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Producto SET ");
        sql.append("idVendedor = ? ");
        sql.append(",idSubcategoria = ? ");
        sql.append(",nombre = ? ");
        sql.append(",descripcion = ? ");
        sql.append(",precio = ? ");
        sql.append(",imagen = ? ");
        sql.append(",stock = ? ");
        sql.append(",vendidas = ? ");
        sql.append(",marca = ? ");
        sql.append(",modelo = ? ");
        sql.append(",estado = ? ");
        sql.append("WHERE idProducto = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,producto.getIdVendedor());
            ps.setInt(2,producto.getIdSubcategoria());
            ps.setString(3,producto.getNombre());
            ps.setString(4,producto.getDescripcion());
            ps.setDouble(5,producto.getPrecio());
            ps.setString(6,producto.getImagen());
            ps.setInt(7,producto.getStock());
            ps.setInt(8,producto.getVendidas());
            ps.setString(9,producto.getMarca());
            ps.setString(10,producto.getModelo());
            ps.setString(11,producto.getEstado());
            ps.setInt(12,producto.getIdProducto());
            
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
       public List<Producto> listarProductos(Integer idProducto,Integer idVendedor) {
        List<Producto> listaProductos = null;
        Producto producto = null;
        Connection cn = null;
        try {
            cn= ConnectionFactory.getInstance().getConnection();
            CallableStatement cs = cn.prepareCall("{call listarProductos(?,?)}");
            cs.setInt(1,idProducto);
            cs.setInt(2,idVendedor);
            
            ResultSet rs = cs.executeQuery();
            
            listaProductos = new ArrayList<Producto>();
            
            while(rs.next()) {
                producto = new Producto();
                
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setDescCategoria(rs.getString("categoria"));
                producto.setDesSubCategoria(rs.getString("subcategoria"));
                producto.setIdSubcategoria(rs.getInt("idSubcategoria"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setModelo(rs.getString("modelo"));
                producto.setImagen(rs.getString("imagen"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setVendidas(rs.getInt("vendidas"));
                producto.setStock(rs.getInt("stock"));

                
                listaProductos.add(producto);
            }
        }
        catch(Exception e) {
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    com.util.Logger.log(ex);
                    Logger.getLogger(DaoProductoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return listaProductos;
    }
    
    @Override
    public List<Comentario> comentarioQRY(Integer idProducto)
    {
        List<Comentario> listaComentarios= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT op.valoracion, op.comentarioCliente,op.fechaCreada, c.nombre, c.apellido ");
        sb.append("FROM OrdenxProducto op, orden o, usuario c ");
        sb.append("WHERE op.idOrden=o.idOrden and c.idUsuario=o.idCliente and ");
        sb.append(" (op.estado='4' or op.estado='N') and (op.comentarioCliente<>NULL or op.comentarioCliente<>'') and op.idProducto=? ");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sb.toString());
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            
            listaComentarios= new ArrayList<Comentario>();
            while (rs.next())
            
            {
                Comentario comentario = new Comentario();
                comentario.setValoracion(rs.getInt("valoracion"));
                comentario.setTexto(rs.getString("comentarioCliente"));
                comentario.setFecha(rs.getDate("fechaCreada").toString());
                comentario.setNombre(rs.getString("nombre")+" "+rs.getString("apellido"));
                listaComentarios.add(comentario);
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
         return listaComentarios;
    }
    
}
