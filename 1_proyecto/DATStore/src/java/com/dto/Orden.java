package com.dto;

import java.sql.Date;

public class Orden {
	private Integer idOrden;
	private Integer idCliente;
	private Date fechaCreada;
	private String estado;
        
	public Integer getIdOrden(){
		return idOrden;
	}
	public void setIdOrden(Integer idOrden){
		this.idOrden=idOrden;
	}
	public Integer getIdCliente(){
		return idCliente;
	}
	public void setIdCliente(Integer idCliente){
		this.idCliente=idCliente;
	}
	public Date getFechaCreada(){
		return fechaCreada;
	}
	public void setFechaCreada(Date fechaCreada){
		this.fechaCreada=fechaCreada;
	}
	public String getEstado(){
		return estado;
	}
	public void setEstado(String estado){
		this.estado=estado;
	}

}
