package web.filter;

import com.dto.Usuario;
import com.util.GlobalUtil;
import com.util.GlobalUtil.TipoUsuario;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUtil {
    public static void filtrarLogin(ServletRequest request, ServletResponse response, TipoUsuario tipo) throws IOException{
        HttpSession session = ((HttpServletRequest)request).getSession();
        HttpServletRequest _request = (HttpServletRequest)request;
        HttpServletResponse _response = (HttpServletResponse)response;
        
        String url = ((HttpServletRequest)request).getRequestURL().toString();
        String queryString = ((HttpServletRequest)request).getQueryString();
        if (queryString!=null) url=url+"?"+queryString;

        Usuario usuario = (Usuario)session.getAttribute("usuario");
        TipoUsuario tipoUsuario=(usuario!=null)?GlobalUtil.getTipoUsuario(usuario.getTipo()):TipoUsuario.CLIENTE;
        if(usuario == null) {
            session.setAttribute("msgLogin", "Debe estár logueado para acceder al contenido");         
        }else
        {
            if (tipo==TipoUsuario.CLIENTE && tipoUsuario!=TipoUsuario.CLIENTE){
                session.setAttribute("msgLogin", "Esta página requiere acceso como cliente");
            }
            if (tipo==TipoUsuario.VENDEDOR && tipoUsuario!=TipoUsuario.VENDEDOR){
                session.setAttribute("msgLogin", "Esta página requiere acceso como vendedor");
            }
        }
        if (usuario==null || (tipo==TipoUsuario.CLIENTE && tipoUsuario!=TipoUsuario.CLIENTE) || (tipo==TipoUsuario.VENDEDOR && tipoUsuario!=TipoUsuario.VENDEDOR)){
            session.setAttribute("urlLogin", url);
            _response.sendRedirect(_request.getContextPath() + "/login.jsp");
        }
    }
    
}
