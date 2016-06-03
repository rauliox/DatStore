package model.dao;

import com.dto.Estado;
import java.util.ArrayList;
import java.util.List;

public interface DaoEstado {
    public List<Estado> estadoQry();
    public String estadoIns(Estado estado);
    public String estadoDel(String estado);
    public Estado estadoGet(String estado);
    public String estadoUpd(Estado estado);
    
    public List<Estado> listarEstado();
    
}
