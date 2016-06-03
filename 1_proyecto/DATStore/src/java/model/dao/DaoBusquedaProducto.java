package model.dao;

import com.dto.BusquedaProducto;

public interface DaoBusquedaProducto {
    public void buscar(BusquedaProducto bp);
    public void inicializarBusqueda(BusquedaProducto bp);
}
