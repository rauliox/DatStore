package model.dao;

import com.dto.OrdenxProducto;
import java.util.List;

public interface DaoOrdenxProducto {
    public List<OrdenxProducto> ordenxProductoQry(Integer idOrden);
    public String ordenxProductoIns(OrdenxProducto ordenxProducto);
    public String ordenxProductoDel(Integer idOrdenxProducto);
    public OrdenxProducto ordenxProductoGet(Integer idOrdenxProducto);
    public String ordenxProductoUpd(OrdenxProducto ordenxProducto);
    public String ordenxProductoCancel(Integer idOrdenxProducto);
    public String ordenxProductoInsComentario(Integer idOrdenxProducto, String comentario, String Valoracion);
    public String ordenxProductoOrdenRecibida(Integer idOrdenxProducto);
    public List<OrdenxProducto> ordenxProductoQryVendedor(Integer idVendedor);
    public String ordenxProductoUpdTrans(OrdenxProducto ordenxProducto, boolean devolverStock);
}
