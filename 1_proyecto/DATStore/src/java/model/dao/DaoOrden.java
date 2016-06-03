package model.dao;

import com.dto.Orden;
import java.util.List;

public interface DaoOrden {
    public List<Orden> ordenQry();
    public String ordenIns(Orden orden);
    public String ordenDel(Integer idOrden);
    public Orden ordenGet(Integer idOrden);
    public String ordenUpd(Orden orden);
    
    //Ordenes por usuario
    public List<Orden> ordenxUsuario(Integer idUsuario);
}
