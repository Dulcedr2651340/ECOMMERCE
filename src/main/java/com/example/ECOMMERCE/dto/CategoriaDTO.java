package com.example.ECOMMERCE.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

@JsonPropertyOrder({
    "idCategoria",
    "nombre",
    "descripcion"
})

public class CategoriaDTO {
    
    private Integer idCategoria;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable=false)
    private String nombre;

    @NotBlank(message = "La descripcion es obligatorio")
    @Column(nullable=false)
    private String descripcion;

    public CategoriaDTO() {
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
