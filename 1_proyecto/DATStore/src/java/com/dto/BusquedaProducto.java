package com.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BusquedaProducto {
    public static final int PRODUCTOSXPAGINA=15;
    public static final int MAXITEMSCRITERIOS=15;
    public static final int MAXPRECIOS=7;
    
    /*** ENTRADAS ***/
    private String orden;
    private Boolean asc;
    private Integer pagina;
    private String busqueda;//opcional
    private Integer idCategoria;//opcional
    private String categoria; // opcional
    private Integer idSubcategoria;//opcional
    private String subcategoria; //opcional
    private List<String> criterioPrecioAplicado=new ArrayList<String>();
    private List<String> criterioMarcaAplicado = new ArrayList<String>();
    private List<String> criterioModeloAplicado = new ArrayList<String>();
    
    /*** SALIDAS ***/
    private Map<String,String> criterioPrecio=new LinkedHashMap<String,String>();
    private List<String> criterioMarca = new ArrayList<String>();
    private List<String> criterioModelo = new ArrayList<String>();
    
    private List<Producto> productos = new ArrayList<Producto>();
    private Integer nroPaginas;
    

    /**
     * @return the orden
     */
    public String getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(String orden) {
        this.orden = orden;
    }

    /**
     * @return the asc
     */
    public Boolean getAsc() {
        return asc;
    }

    /**
     * @param asc the asc to set
     */
    public void setAsc(Boolean asc) {
        this.asc = asc;
    }

    /**
     * @return the idCategoria
     */
    public Integer getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the idSubcategoria
     */
    public Integer getIdSubcategoria() {
        return idSubcategoria;
    }

    /**
     * @param idSubcategoria the idSubcategoria to set
     */
    public void setIdSubcategoria(Integer idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    /**
     * @return the criterioPrecio
     */
    public Map<String,String> getCriterioPrecio() {
        return criterioPrecio;
    }

    /**
     * @param criterioPrecio the criterioPrecio to set
     */
    public void setCriterioPrecio(Map<String,String> criterioPrecio) {
        this.criterioPrecio = criterioPrecio;
    }

    /**
     * @return the criterioMarca
     */
    public List<String> getCriterioMarca() {
        return criterioMarca;
    }

    /**
     * @param criterioMarca the criterioMarca to set
     */
    public void setCriterioMarca(List<String> criterioMarca) {
        this.criterioMarca = criterioMarca;
    }

    /**
     * @return the criterioModelo
     */
    public List<String> getCriterioModelo() {
        return criterioModelo;
    }

    /**
     * @param criterioModelo the criterioModelo to set
     */
    public void setCriterioModelo(List<String> criterioModelo) {
        this.criterioModelo = criterioModelo;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the nroPaginas
     */
    public Integer getNroPaginas() {
        return nroPaginas;
    }

    /**
     * @param nroPaginas the nroPaginas to set
     */
    public void setNroPaginas(Integer nroPaginas) {
        this.nroPaginas = nroPaginas;
    }

    /**
     * @return the criterioPrecioAplicado
     */
    public List<String> getCriterioPrecioAplicado() {
        return criterioPrecioAplicado;
    }

    /**
     * @param criterioPrecioAplicado the criterioPrecioAplicado to set
     */
    public void setCriterioPrecioAplicado(List<String> criterioPrecioAplicado) {
        this.criterioPrecioAplicado = criterioPrecioAplicado;
    }

    /**
     * @return the criterioMarcaAplicado
     */
    public List<String> getCriterioMarcaAplicado() {
        return criterioMarcaAplicado;
    }

    /**
     * @param criterioMarcaAplicado the criterioMarcaAplicado to set
     */
    public void setCriterioMarcaAplicado(List<String> criterioMarcaAplicado) {
        this.criterioMarcaAplicado = criterioMarcaAplicado;
    }

    /**
     * @return the criterioModeloAplicado
     */
    public List<String> getCriterioModeloAplicado() {
        return criterioModeloAplicado;
    }

    /**
     * @param criterioModeloAplicado the criterioModeloAplicado to set
     */
    public void setCriterioModeloAplicado(List<String> criterioModeloAplicado) {
        this.criterioModeloAplicado = criterioModeloAplicado;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the subcategoria
     */
    public String getSubcategoria() {
        return subcategoria;
    }

    /**
     * @param subcategoria the subcategoria to set
     */
    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    /**
     * @return the pagina
     */
    public Integer getPagina() {
        return pagina;
    }

    /**
     * @param pagina the pagina to set
     */
    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    /**
     * @return the busqueda
     */
    public String getBusqueda() {
        return busqueda;
    }

    /**
     * @param busqueda the busqueda to set
     */
    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }
    
    
}
