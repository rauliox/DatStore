package com.dto;


public class Log {
	private Integer idlog;
	private String tipo;
	private String mensaje;
	private String detalles;
	public Integer getIdlog(){
		return idlog;
	}
	public void setIdlog(Integer idlog){
		this.idlog=idlog;
	}
	public String getTipo(){
		return tipo;
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	public String getMensaje(){
		return mensaje;
	}
	public void setMensaje(String mensaje){
		this.mensaje=mensaje;
	}
	public String getDetalles(){
		return detalles;
	}
	public void setDetalles(String detalles){
		this.detalles=detalles;
	}
}
