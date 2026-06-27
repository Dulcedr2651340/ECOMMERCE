package com.example.ECOMMERCE.dto;

public class PedidoDetalleDTO {
    
private Integer idDetalle;

private Integer idPedido;

private String cliente;

private String producto;

private Integer cantidad;

private Double subtotal;
    
    public PedidoDetalleDTO() {
    }

    

    public PedidoDetalleDTO(Integer idDetalle, Integer idPedido, String cliente, String producto, Integer cantidad,
            Double subtotal) {
        this.idDetalle = idDetalle;
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }



    public Integer getIdDetalle() {
        return idDetalle;
    }



    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }



    public Integer getIdPedido() {
        return idPedido;
    }



    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }



    public String getCliente() {
        return cliente;
    }



    public void setCliente(String cliente) {
        this.cliente = cliente;
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



    public Double getSubtotal() {
        return subtotal;
    }



    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }



    

    
}
