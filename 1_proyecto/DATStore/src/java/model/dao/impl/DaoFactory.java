package model.dao.impl;

import model.dao.*;

public class DaoFactory {
    private static DaoFactory factory = new DaoFactory();
    private DaoFactory(){
    }
    
    public static DaoFactory getInstancia(){
        return factory;
    }
    
    public DaoCategoria getDaoCategoria(){
        return new DaoCategoriaImpl();
    }
    
    public DaoEstado getDaoEstado(){
        return new DaoEstadoImpl();
    }
    
    public DaoLog getDaoLog(){
        return new DaoLogImpl();
    }
    
    public DaoOrden getDaoOrden(){
        return new DaoOrdenImpl();
    }
    
    public DaoOrdenxProducto getDaoOrdenxProducto(){
        return new DaoOrdenxProductoImpl();
    }
    
    public DaoProducto getDaoProducto(){
        return new DaoProductoImpl();
    }
    
    public DaoSubcategoria getDaoSubcategoria(){
        return new DaoSubcategoriaImpl();
    }
    
    public DaoUsuario getDaoUsuario(){
        return new DaoUsuarioImpl();
    }
    
    public DaoBusquedaProducto getDaoBusquedaProducto(){
        return new DaoBusquedaProductoImpl();
    }
    
    public DaoReporteClientes getDaoReporteClientes(){
        return new DaoReporteClientesImpl();
    }
    public DaoReporteProductos getDaoReporteProductos(){
        return new DaoReporteProductosImpl();
    }

    public DaoProcesarCompra getDaoProcesarCompra(){
    return new DaoProcesarCompraImpl();
    }
    
}
