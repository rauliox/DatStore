package com.dto;


public class Producto {
	private Integer idProducto;
	private Integer idVendedor;
	private Integer idSubcategoria;
	private String nombre;
	private String descripcion;
	private Double precio;
	private String imagen;
	private Integer stock;
	private Integer vendidas;
	private String marca;
	private String modelo;
	private String estado;
        private String descCategoria;
        private String desSubCategoria;
        
	public Integer getIdProducto(){
		return idProducto;
	}
        
	public void setIdProducto(Integer idProducto){
		this.idProducto=idProducto;
	}
	public Integer getIdVendedor(){
		return idVendedor;
	}
	public void setIdVendedor(Integer idVendedor){
		this.idVendedor=idVendedor;
	}
	public Integer getIdSubcategoria(){
		return idSubcategoria;
	}
	public void setIdSubcategoria(Integer idSubcategoria){
		this.idSubcategoria=idSubcategoria;
	}
	public String getNombre(){
		return nombre;
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	public Double getPrecio(){
		return precio;
	}
	public void setPrecio(Double precio){
		this.precio=precio;
	}
	public String getImagen(){
		return imagen;
	}
	public void setImagen(String imagen){
		this.imagen=imagen;
	}
	public Integer getStock(){
		return stock;
	}
	public void setStock(Integer stock){
		this.stock=stock;
	}
	public Integer getVendidas(){
		return vendidas;
	}
	public void setVendidas(Integer vendidas){
		this.vendidas=vendidas;
	}
	public String getMarca(){
		return marca;
	}
	public void setMarca(String marca){
		this.marca=marca;
	}
	public String getModelo(){
		return modelo;
	}
	public void setModelo(String modelo){
		this.modelo=modelo;
	}
	public String getEstado(){
		return estado;
	}
	public void setEstado(String estado){
		this.estado=estado;
	}

    /**
     * @return the descCategoria
     */
    public String getDescCategoria() {
        return descCategoria;
    }

    /**
     * @param descCategoria the descCategoria to set
     */
    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    /**
     * @return the desSubCategoria
     */
    public String getDesSubCategoria() {
        return desSubCategoria;
    }

    /**
     * @param desSubCategoria the desSubCategoria to set
     */
    public void setDesSubCategoria(String desSubCategoria) {
        this.desSubCategoria = desSubCategoria;
    }
        
    public Producto(Integer idProducto, Integer idVendedor, Integer idSubcategoria, String nombre, String descripcion, Double precio, String imagen, Integer stock, Integer vendidas, String marca, String modelo, String estado) {
        this.idProducto = idProducto;
        this.idVendedor = idVendedor;
        this.idSubcategoria = idSubcategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.stock = stock;
        this.vendidas = vendidas;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
    }

    public Producto() {
    }
        
}
