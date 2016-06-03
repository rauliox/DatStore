package com.dto;

import java.util.ArrayList;
import java.util.List;


public class Categoria {
    private Integer idCategoria;
    private Integer idSubCategoria;
    private String descripcion;
    private String estado;
    private List<Subcategoria> subcategorias= new ArrayList<Subcategoria>();
    public Integer getIdCategoria(){
            return idCategoria;
    }
    public void setIdCategoria(Integer idCategoria){
            this.idCategoria=idCategoria;
    }
    public String getDescripcion(){
            return descripcion;
    }
    public void setDescripcion(String descripcion){
            this.descripcion=descripcion;
    }
    public String getEstado(){
            return estado;
    }
    public void setEstado(String estado){
            this.estado=estado;
    }

    public List<Subcategoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(List<Subcategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    /**
     * @return the idSubCategoria
     */
    public Integer getIdSubCategoria() {
        return idSubCategoria;
    }

    /**
     * @param idSubCategoria the idSubCategoria to set
     */
    public void setIdSubCategoria(Integer idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }
}
