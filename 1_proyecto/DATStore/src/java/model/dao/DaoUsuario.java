package model.dao;

import com.dto.Usuario;
import java.util.List;

public interface DaoUsuario {
    public List<Usuario> usuarioQry();
    public String usuarioIns(Usuario usuario);
    public String usuarioDel(Integer idUsuario);
    public Usuario usuarioGet(Integer idUsuario);
    public Usuario usuarioLogin(String correo, String pass);
    public String usuarioUpd(Usuario usuario);
}
