package com.dto;

public class ReporteClientes {
    private String cliente;
    private Double productos;
    private Double monto;

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the productos
     */
    public Double getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Double productos) {
        this.productos = productos;
    }

    /**
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
