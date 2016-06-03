package model.dao;

import com.dto.Comentario;
import com.dto.Producto;
import java.util.List;

public interface DaoProducto {
    public List<Producto> productoQry(Integer idUsuario);
    public List<Producto>listarProductos(Integer idProducto, Integer idVendedor);
    public String productoIns(Producto producto);
    public String productoDel(Integer idProducto);
    public Producto productoGet(Integer idProducto);
    public String productoUpd(Producto producto);
    public List<Comentario> comentarioQRY(Integer idProducto);
}
