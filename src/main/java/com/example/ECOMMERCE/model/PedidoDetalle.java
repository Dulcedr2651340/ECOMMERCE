package com.example.ECOMMERCE.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="detalle_pedido")
public class DetallePedido {

    private Integer idDetalle;
    private Integer cantidad;
    private Double  subTotal;
    
    private Pedido pedido;

    private Producto producto;

    public DetallePedido() {
    }

    

    public DetallePedido(Integer idDetalle, Integer cantidad, Double subTotal) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }



    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
}
