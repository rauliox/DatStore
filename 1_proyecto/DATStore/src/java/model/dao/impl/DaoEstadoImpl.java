package model.dao.impl;

import com.dto.Estado;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoEstado;

class DaoEstadoImpl implements DaoEstado{

    @Override
    public List<Estado> estadoQry() {
        List<Estado> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("estado ");
        sb.append(",descripcion ");
        sb.append("FROM Estado ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sb.toString());
            list = new ArrayList<Estado>();
            
            while (rs.next())
            {
                Estado estado = new Estado();
                estado.setEstado(rs.getString("estado"));
                estado.setDescripcion(rs.getString("descripcion"));
                list.add(estado);
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
    public String estadoIns(Estado estado) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO Estado(");
        sb.append("estado ");
        sb.append(",descripcion ");
        sb.append(") ");
        sb.append("values (?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setString(1,estado.getEstado());
            ps.setString(2,estado.getDescripcion());

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
    public String estadoDel(String estado) {
        String result= null;
        Connection cn = null;
        String sql = "DELETE FROM Estado WHERE estado= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1,estado);
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
    public Estado estadoGet(String estado) {
        Estado oestado =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("estado ");
        sql.append(",descripcion ");
        sql.append("FROM Estado ");
        sql.append("WHERE estado= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setString(1, estado);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                oestado = new Estado();
                oestado.setEstado(rs.getString(1));
                oestado.setDescripcion(rs.getString(2));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return oestado;
    }

    @Override
    public String estadoUpd(Estado estado) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Estado SET ");
        sql.append("descripcion = ? ");
        sql.append("WHERE estado = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1,estado.getDescripcion());
            ps.setString(2,estado.getEstado());
            
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
    public List<Estado> listarEstado() {
        List<Estado> listaEstados = new ArrayList<Estado>();
//        listaEstados.add(new Estado("Java", "Java"));
//        listaEstados.add(new Estado("Net", "Net"));
//        listaEstados.add(new Estado("PHP", "PHP"));
//        listaEstados.add(new Estado("Delphi", "Delphi"));
//        
        return listaEstados;
    }
}
