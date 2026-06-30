package com.example.ECOMMERCE.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonPropertyOrder({
    "idPedido",
    "fecha",
    "total",
    "cliente"
})

public class PedidoDTO {
    
    @Column(name = "id_pedido")
    private Integer idPedido;

    @CreationTimestamp
    private LocalDateTime fecha;

    @Positive(message = "El total debe ser mayor a 0")
    private Double total;

    @JoinColumn(name = "id_cliente")
    @NotNull(message = "El cliente es obligatorio")
    private String cliente;

    public PedidoDTO() {
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
    
}
