package model.dao.impl;

import com.dto.Log;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoLog;

class DaoLogImpl implements DaoLog{

    @Override
    public List<Log> logQry() {
        List<Log> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("idlog ");
        sb.append(",tipo ");
        sb.append(",mensaje ");
        sb.append(",detalles ");
        sb.append("FROM Log ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sb.toString());
            list = new ArrayList<Log>();
            
            while (rs.next())
            {
                Log log = new Log();
                log.setIdlog(rs.getInt("idlog"));
                log.setTipo(rs.getString("tipo"));
                log.setMensaje(rs.getString("mensaje"));
                log.setDetalles(rs.getString("detalles"));
                list.add(log);
            }
         }
         catch (SQLException e){
             e.printStackTrace();
         }
         catch (Exception e){
             e.printStackTrace();
         }
         finally
         {
             try{
                 cn.close();
             }catch (SQLException e ){e.printStackTrace();}
         }
         return list;
    }

    @Override
    public String logIns(Log log) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO Log(");
        sb.append("tipo ");
        sb.append(",mensaje ");
        sb.append(",detalles ");
        sb.append(") ");
        sb.append("values (?,?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setString(1,log.getTipo());
            ps.setString(2,log.getMensaje());
            ps.setString(3,log.getDetalles().substring(0,999));

            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
            result= e.getMessage();
        }
        catch (Exception e){
            result= e.getMessage();
        }
        finally
        {
            try{
                cn.close();
            }catch (SQLException e ){result=e.getMessage();}
        }
        
        return result;
    }

    @Override
    public String logDel(Integer idlog) {
        String result= null;
        Connection cn = null;
        String sql = "DELETE FROM Log WHERE idlog= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idlog);
            int ctos = ps.executeUpdate();
            if(ctos==0){
                result="0 filas afectadas";
            }
        }
        catch(SQLException e)
        {
            result=e.getMessage();
        }
        finally{
            try{
                cn.close();
            }
            catch(SQLException e)
            {
                result = e.getMessage();
            }
        }
        
        return result;
    }

    @Override
    public Log logGet(Integer idlog) {
        Log olog =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("idlog ");
        sql.append(",tipo ");
        sql.append(",mensaje ");
        sql.append(",detalles ");
        sql.append("FROM Log ");
        sql.append("WHERE idlog= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idlog);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                olog = new Log();
                olog.setIdlog(rs.getInt(1));
                olog.setTipo(rs.getString(2));
                olog.setMensaje(rs.getString(3));
                olog.setDetalles(rs.getString(4));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){e.printStackTrace();}
        }
        return olog;
    }

    @Override
    public String logUpd(Log log) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Log SET ");
        sql.append("tipo = ? ");
        sql.append(",mensaje = ? ");
        sql.append(",detalles = ? ");
        sql.append("WHERE idlog = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1,log.getTipo());
            ps.setString(2,log.getMensaje());
            ps.setString(3,log.getDetalles());
            ps.setInt(4,log.getIdlog());
            
            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
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
            }catch (SQLException e ){result=e.getMessage();}
        }
        
        return result;
    }
}
