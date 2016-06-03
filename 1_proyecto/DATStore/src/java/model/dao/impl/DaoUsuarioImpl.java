package model.dao.impl;

import com.dto.Usuario;
import com.sql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.DaoUsuario;

class DaoUsuarioImpl implements DaoUsuario{

    @Override
    public List<Usuario> usuarioQry() {
        List<Usuario> list= null;
        Connection cn=null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("idUsuario ");
        sb.append(",nombre ");
        sb.append(",apellido ");
        sb.append(",correo ");
        sb.append(",pass ");
        sb.append(",tipo ");
        sb.append(",estado ");
        sb.append("FROM Usuario ");
        sb.append("WHERE estado<>'E' ");
        
        try{
            cn= ConnectionFactory.getInstance().getConnection();
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sb.toString());
            list = new ArrayList<Usuario>();
            
            while (rs.next())
            {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPass(rs.getString("pass"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setEstado(rs.getString("estado"));
                list.add(usuario);
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
    public String usuarioIns(Usuario usuario) {
        String result = null;
        Connection cn= null;
        StringBuilder sb= new StringBuilder();
        
        sb.append("INSERT INTO Usuario(");
        sb.append("nombre ");
        sb.append(",apellido ");
        sb.append(",correo ");
        sb.append(",pass ");
        sb.append(",tipo ");
        sb.append(",estado ");
        sb.append(") ");
        sb.append("values (?,?,?,MD5(?),?,?)");
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sb.toString());
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getApellido());
            ps.setString(3,usuario.getCorreo());
            ps.setString(4,usuario.getPass());
            ps.setString(5,usuario.getTipo());
            ps.setString(6,usuario.getEstado());

            int ctos= ps.executeUpdate();

            if(ctos==0)
            {
                result="0 filas afectadas";
            }
        }
        catch (SQLException e){
            com.util.Logger.log(e);
            if (e.getErrorCode()==1452 || e.getErrorCode()==1062)
                result="El correo ingresado ya está en uso";
            else
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
    public String usuarioDel(Integer idUsuario) {
        String result= null;
        Connection cn = null;
        String sql = "DELETE FROM Usuario WHERE idUsuario= ? ";
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1,idUsuario);
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
    public Usuario usuarioGet(Integer idUsuario) {
        Usuario ousuario =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("idUsuario ");
        sql.append(",nombre ");
        sql.append(",apellido ");
        sql.append(",correo ");
        sql.append(",pass ");
        sql.append(",tipo ");
        sql.append(",estado ");
        sql.append("FROM Usuario ");
        sql.append("WHERE idUsuario= ? ");

        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                ousuario = new Usuario();
                ousuario.setIdUsuario(rs.getInt(1));
                ousuario.setNombre(rs.getString(2));
                ousuario.setApellido(rs.getString(3));
                ousuario.setCorreo(rs.getString(4));
                ousuario.setPass(rs.getString(5));
                ousuario.setTipo(rs.getString(6));
                ousuario.setEstado(rs.getString(7));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return ousuario;
    }

    @Override
    public String usuarioUpd(Usuario usuario) {
        String result = null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE Usuario SET ");
        sql.append("nombre = ? ");
        sql.append(",apellido = ? ");
        sql.append(",correo = ? ");
        sql.append(",pass = md5(?) ");
        sql.append(",tipo = ? ");
        sql.append(",estado = ? ");
        sql.append("WHERE idUsuario = ? ");
        
        
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getApellido());
            ps.setString(3,usuario.getCorreo());
            ps.setString(4,usuario.getPass());
            ps.setString(5,usuario.getTipo());
            ps.setString(6,usuario.getEstado());
            ps.setInt(7,usuario.getIdUsuario());
            
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
    public Usuario usuarioLogin(String correo, String pass) {
        Usuario ousuario =null;
        Connection cn = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("idUsuario ");
        sql.append(",nombre ");
        sql.append(",apellido ");
        sql.append(",correo ");
        sql.append(",pass ");
        sql.append(",tipo ");
        sql.append(",estado ");
        sql.append("FROM Usuario ");
        sql.append("WHERE estado<>'E' and correo= ? and pass= MD5(?) ");

        if (correo!=null && pass!=null)
        try{
            cn=ConnectionFactory.getInstance().getConnection();
            PreparedStatement ps=cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                ousuario = new Usuario();
                ousuario.setIdUsuario(rs.getInt(1));
                ousuario.setNombre(rs.getString(2));
                ousuario.setApellido(rs.getString(3));
                ousuario.setCorreo(rs.getString(4));
                ousuario.setPass(rs.getString(5));
                ousuario.setTipo(rs.getString(6));
                ousuario.setEstado(rs.getString(7));
            }
        }
        catch(SQLException e){
            com.util.Logger.log(e);
            e.printStackTrace();
        }
        finally{
            try{cn.close();}catch (SQLException e){com.util.Logger.log(e);e.printStackTrace();}
        }
        return ousuario;
    }
}
