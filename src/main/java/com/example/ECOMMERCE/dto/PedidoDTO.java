package com.example.ECOMMERCE.dto;

import java.time.LocalDateTime;


public class PedidoDTO {
    
    private Integer idPedido;
    private String cliente;
    private LocalDateTime fecha;
    private Double total;

    public PedidoDTO() {
    }

    public PedidoDTO(Integer idPedido, String cliente, LocalDateTime fecha, Double total) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    
    
}
