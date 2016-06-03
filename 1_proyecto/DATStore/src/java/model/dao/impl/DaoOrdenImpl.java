package model.dao.impl;

import com.dto.Estado;
import com.dto.Orden;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoEstado;
import model.dao.DaoOrden;

class DaoOrdenImpl implements DaoOrden{

    @Override
    public List<Orden> ordenQry() {
        List<Orden> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("a.idOrden ");
        sb.append(",a.idCliente ");
        sb.append(",a.fechaCreada ");
        sb.append(",c.descripcion ");
        sb.append("FROM Orden a inner join estado c on a.estado=c.estado ");
        sb.append("WHERE a.estado<>'E' ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sb.toString());
            list = new ArrayList<Orden>();
            
            while (rs.next())
            {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setIdCliente(rs.getInt("idCliente"));
                orden.setFechaCreada(rs.getDate("fechaCreada"));
                orden.setEstado(rs.getString("estado"));
                list.add(orden);
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

    @Override
    public String ordenIns(Orden orden) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO Orden(");
        sb.append("idCliente ");
        sb.append(",fechaCreada ");
        sb.append(",estado ");
        sb.append(") ");
        sb.append("values (?,?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setInt(1,orden.getIdCliente());
            ps.setDate(2,orden.getFechaCreada());
            ps.setString(3,orden.getEstado());

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
    public String ordenDel(Integer idOrden) {
        String result= null;
        Connection cn = null;
        String sql = "DELETE FROM Orden WHERE idOrden= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idOrden);
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
    public Orden ordenGet(Integer idOrden) {
        Orden oorden =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("idOrden ");
        sql.append(",idCliente ");
        sql.append(",fechaCreada ");
        sql.append(",estado ");
        sql.append("FROM Orden ");
        sql.append("WHERE idOrden= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idOrden);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                oorden = new Orden();
                oorden.setIdOrden(rs.getInt(1));
                oorden.setIdCliente(rs.getInt(2));
                oorden.setFechaCreada(rs.getDate(3));
                oorden.setEstado(rs.getString(4));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return oorden;
    }
    
    @Override
    public List<Orden> ordenxUsuario(Integer idUsuario) {
        
        List<Orden> listaOrdenes =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        
        sql.append("SELECT ");
        sql.append("a.idOrden ");
        sql.append(",a.idCliente ");
        sql.append(",a.fechaCreada ");
        sql.append(",c.descripcion ");
        sql.append("FROM Orden a inner join estado c on a.estado=c.estado ");
        sql.append("WHERE a.idCliente= ? ");
        sql.append("ORDER BY a.idOrden DESC ");
   
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            
            listaOrdenes= new ArrayList<Orden>();
            while (rs.next())
            {
                Orden objOrden= new Orden();
                
                DaoEstado Estado= new DaoEstadoImpl();
                //Cargando la lista de los estados, cargala en el formulario e imprimirla mediante etiquetas
                Estado.estadoQry();
                
                objOrden.setIdOrden(rs.getInt(1));
                objOrden.setIdCliente(rs.getInt(2));
                objOrden.setFechaCreada(rs.getDate(3));
                //Se enviara este id y se imprimira la descripcion en el formulario
                objOrden.setEstado(rs.getString(4));
                
                
                listaOrdenes.add(objOrden);
            }

        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return listaOrdenes;
        
    }

    @Override
    public String ordenUpd(Orden orden) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Orden SET ");
        sql.append("idCliente = ? ");
        sql.append(",fechaCreada = ? ");
        sql.append(",estado = ? ");
        sql.append("WHERE idOrden = ? ");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,orden.getIdCliente());
            ps.setDate(2,orden.getFechaCreada());
            ps.setString(3,orden.getEstado());
            ps.setInt(4,orden.getIdOrden());
            
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
}
