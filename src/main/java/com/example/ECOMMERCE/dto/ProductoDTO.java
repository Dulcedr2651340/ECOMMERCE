package com.example.ECOMMERCE.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@JsonPropertyOrder({
    "id",
    "nombre",
    "marca",
    "precio",
    "garantia",
    "categoria"
})

public class ProductoDTO {

    private Integer id;

    @NotBlank(message="El nombre es obligatorio")
    private String nombre;

    @Positive(message="El precio debe ser mayor a 0")
    private Double precio;
    
    @NotBlank(message="La marca es obligatorio")
    private String marca;

    @Min(value = 1, message = "La garantía debe ser mayor o igual a 1")
    private Integer garantia;

    private String categoria;

    public ProductoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getGarantia() {
        return garantia;
    }

    public void setGarantia(Integer garantia) {
        this.garantia = garantia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    
}
