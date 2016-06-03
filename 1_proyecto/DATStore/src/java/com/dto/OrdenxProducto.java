package com.dto;

import java.sql.Date;

public class OrdenxProducto {
	private Integer idOrdenxProducto;
	private Integer idOrden;
	private Integer idProducto;
	private Integer cantidad;
        private Double precio;
	private Date fechaCreada;
	private Date fechaEnviada;
	private Date fechaEntregada;
	private Date fechaAnulada;
	private Integer valoracion;
	private String comentarioCliente;
	private String comentarioVendedor;
	private String estado;
        
        
        /*opcionales (verificar que estén implementados en el metodo a utilizar)*/
        private String nombreProducto;
        private String nombreCliente;
        private String descEstado;
        
        
	public Integer getIdOrdenxProducto(){
		return idOrdenxProducto;
	}
	public void setIdOrdenxProducto(Integer idOrdenxProducto){
		this.idOrdenxProducto=idOrdenxProducto;
	}
	public Integer getIdOrden(){
		return idOrden;
	}
	public void setIdOrden(Integer idOrden){
		this.idOrden=idOrden;
	}
	public Integer getIdProducto(){
		return idProducto;
	}
	public void setIdProducto(Integer idProducto){
		this.idProducto=idProducto;
	}
	public Integer getCantidad(){
		return cantidad;
	}
	public void setCantidad(Integer cantidad){
		this.cantidad=cantidad;
	}
	public Date getFechaCreada(){
		return fechaCreada;
	}
	public void setFechaCreada(Date fechaCreada){
		this.fechaCreada=fechaCreada;
	}
	public Date getFechaEnviada(){
		return fechaEnviada;
	}
	public void setFechaEnviada(Date fechaEnviada){
		this.fechaEnviada=fechaEnviada;
	}
	public Date getFechaEntregada(){
		return fechaEntregada;
	}
	public void setFechaEntregada(Date fechaEntregada){
		this.fechaEntregada=fechaEntregada;
	}
	public Date getFechaAnulada(){
		return fechaAnulada;
	}
	public void setFechaAnulada(Date fechaAnulada){
		this.fechaAnulada=fechaAnulada;
	}
	public Integer getValoracion(){
		return valoracion;
	}
	public void setValoracion(Integer valoracion){
		this.valoracion=valoracion;
	}
	public String getComentarioCliente(){
		return comentarioCliente;
	}
	public void setComentarioCliente(String comentarioCliente){
		this.comentarioCliente=comentarioCliente;
	}
	public String getComentarioVendedor(){
		return comentarioVendedor;
	}
	public void setComentarioVendedor(String comentarioVendedor){
		this.comentarioVendedor=comentarioVendedor;
	}
	public String getEstado(){
		return estado;
	}
	public void setEstado(String estado){
		this.estado=estado;
	}

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the NombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param NombreProducto the NombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the descEstado
     */
    public String getDescEstado() {
        return descEstado;
    }

    /**
     * @param descEstado the descEstado to set
     */
    public void setDescEstado(String descEstado) {
        this.descEstado = descEstado;
    }
    
    public String getComentario(){
        if (comentarioCliente==null || comentarioCliente.isEmpty())
            return comentarioVendedor;
        else
            return comentarioCliente;
    }
}
