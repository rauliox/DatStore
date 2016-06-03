package model.dao.impl;

import com.dto.Categoria;
import com.dto.Subcategoria;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoSubcategoria;

class DaoSubcategoriaImpl implements DaoSubcategoria{

    @Override
    public List<Subcategoria> subcategoriaQry() {
        List<Subcategoria> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("idSubcategoria ");
        sb.append(",idCategoria ");
        sb.append(",descripcion ");
        sb.append(",estado ");
        sb.append("FROM Subcategoria ");
        sb.append("WHERE estado<>'E' ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sb.toString());
            list = new ArrayList<Subcategoria>();
            
            while (rs.next())
            {
                Subcategoria subcategoria = new Subcategoria();
                subcategoria.setIdSubcategoria(rs.getInt("idSubcategoria"));
                subcategoria.setIdCategoria(rs.getInt("idCategoria"));
                subcategoria.setDescripcion(rs.getString("descripcion"));
                subcategoria.setEstado(rs.getString("estado"));
                list.add(subcategoria);
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
    public String subcategoriaIns(Subcategoria subcategoria) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO Subcategoria(");
        sb.append("idCategoria ");
        sb.append(",descripcion ");
        sb.append(",estado ");
        sb.append(") ");
        sb.append("values (?,?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setInt(1,subcategoria.getIdCategoria());
            ps.setString(2,subcategoria.getDescripcion());
            ps.setString(3,subcategoria.getEstado());

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
    public String subcategoriaDel(Integer idSubcategoria) {
        String result= null;
        Connection cn = null;
        String sql = "DELETE FROM Subcategoria WHERE idSubcategoria= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idSubcategoria);
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
    public Subcategoria subcategoriaGet(Integer idSubcategoria) {
        Subcategoria osubcategoria =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("idSubcategoria ");
        sql.append(",idCategoria ");
        sql.append(",descripcion ");
        sql.append(",estado ");
        sql.append("FROM Subcategoria ");
        sql.append("WHERE idSubcategoria= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idSubcategoria);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                osubcategoria = new Subcategoria();
                osubcategoria.setIdSubcategoria(rs.getInt(1));
                osubcategoria.setIdCategoria(rs.getInt(2));
                osubcategoria.setDescripcion(rs.getString(3));
                osubcategoria.setEstado(rs.getString(4));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return osubcategoria;
    }

    @Override
    public String subcategoriaUpd(Subcategoria subcategoria) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Subcategoria SET ");
        sql.append("idCategoria = ? ");
        sql.append(",descripcion = ? ");
        sql.append(",estado = ? ");
        sql.append("WHERE idSubcategoria = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,subcategoria.getIdCategoria());
            ps.setString(2,subcategoria.getDescripcion());
            ps.setString(3,subcategoria.getEstado());
            ps.setInt(4,subcategoria.getIdSubcategoria());
            
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
