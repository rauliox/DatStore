package com.dto;


public class Usuario {
	private Integer idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private String pass;
	private String tipo;
	private String estado;
	public Integer getIdUsuario(){
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario){
		this.idUsuario=idUsuario;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	public String getCorreo(){
		return correo;
	}
	public void setCorreo(String correo){
		this.correo=correo;
	}
	public String getPass(){
		return pass;
	}
	public void setPass(String pass){
		this.pass=pass;
	}
	public String getTipo(){
		return tipo;
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	public String getEstado(){
		return estado;
	}
	public void setEstado(String estado){
		this.estado=estado;
	}
}
