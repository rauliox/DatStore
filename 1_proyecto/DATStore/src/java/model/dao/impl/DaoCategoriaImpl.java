package model.dao.impl;

import com.dto.Categoria;
import com.dto.Subcategoria;
import com.sql.ConnectionFactory;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.DaoCategoria;

class DaoCategoriaImpl implements DaoCategoria{

    @Override
    public List<Categoria> categoriaQry() {
        List<Categoria> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("idCategoria ");
        sb.append(",descripcion ");
        sb.append(",estado ");
        sb.append("FROM Categoria ");
        sb.append("WHERE estado<>'E' ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sb.toString());
            list = new ArrayList<Categoria>();
            
            while (rs.next())
            {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setDescripcion(rs.getString("descripcion"));
                categoria.setEstado(rs.getString("estado"));
                list.add(categoria);
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
             }catch (SQLException e ){ com.util.Logger.log(e); e.printStackTrace();}
         }
        
        DaoSubcategoriaImpl daoSubcategoria= new DaoSubcategoriaImpl();
        
        List<Subcategoria> subcategorias = daoSubcategoria.subcategoriaQry();
        
        Iterator<Categoria> itcat= list.iterator();
        while(itcat.hasNext()){
            Categoria cat=itcat.next();
            Iterator<Subcategoria> itsub= subcategorias.iterator();
            while(itsub.hasNext()){
                Subcategoria sub=itsub.next();
                if (cat.getIdCategoria()==sub.getIdCategoria()){
                    cat.getSubcategorias().add(sub);
                    itsub.remove();
                }
            }
        }
        
        return list;
    }

    @Override
    public String categoriaIns(Categoria categoria) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO Categoria(");
        sb.append("descripcion ");
        sb.append(",estado ");
        sb.append(") ");
        sb.append("values (?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setString(1,categoria.getDescripcion());
            ps.setString(2,categoria.getEstado());

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
            }catch (SQLException e ){com.util.Logger.log(e); result=e.getMessage();}
        }
        
        return result;
    }

    @Override
    public String categoriaDel(Integer idCategoria) {
        String result= null;
        Connection cn = null;
        String sql = "DELETE FROM Categoria WHERE idCategoria= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idCategoria);
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
    public Categoria categoriaGet(Integer idCategoria) {
        Categoria ocategoria =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("idCategoria ");
        sql.append(",descripcion ");
        sql.append(",estado ");
        sql.append("FROM Categoria ");
        sql.append("WHERE idCategoria= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idCategoria);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                ocategoria = new Categoria();
                ocategoria.setIdCategoria(rs.getInt(1));
                ocategoria.setDescripcion(rs.getString(2));
                ocategoria.setEstado(rs.getString(3));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return ocategoria;
    }

    @Override
    public String categoriaUpd(Categoria categoria) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Categoria SET ");
        sql.append("descripcion = ? ");
        sql.append(",estado = ? ");
        sql.append("WHERE idCategoria = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1,categoria.getDescripcion());
            ps.setString(2,categoria.getEstado());
            ps.setInt(3,categoria.getIdCategoria());
            
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
       public List<Categoria> listarCategoria(Integer idCategoria) {
        List<Categoria> listaCategoria = null;
        Categoria categoria = null;
        Connection cn = null;
        try {
            cn= ConnectionFactory.getInstance().getConnection();
            CallableStatement cs = cn.prepareCall("{call comboProducto(?)}");
            cs.setInt(1,idCategoria);
            
            ResultSet rs = cs.executeQuery();
            
            listaCategoria = new ArrayList<Categoria>();
            
            while(rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("idcategoria"));
                categoria.setIdSubCategoria(rs.getInt("idsubcategoria"));
                categoria.setDescripcion(rs.getString("producto"));

                
               
                listaCategoria.add(categoria);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DaoProductoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return listaCategoria;
    }
}
