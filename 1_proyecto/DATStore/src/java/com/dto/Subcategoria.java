package com.dto;


public class Subcategoria {
	private Integer idSubcategoria;
	private Integer idCategoria;
	private String descripcion;
	private String estado;
	public Integer getIdSubcategoria(){
		return idSubcategoria;
	}
	public void setIdSubcategoria(Integer idSubcategoria){
		this.idSubcategoria=idSubcategoria;
	}
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
}
