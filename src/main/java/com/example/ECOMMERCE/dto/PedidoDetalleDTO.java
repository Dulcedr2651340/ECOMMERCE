package com.example.ECOMMERCE.dto;

public class PedidoDetalle {
    
    private String producto;
    private Integer cantidad;
    private Double subTotal;
    
    public PedidoDetalle() {
    }

    public PedidoDetalle(String producto, Integer cantidad, Double subTotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    
}
