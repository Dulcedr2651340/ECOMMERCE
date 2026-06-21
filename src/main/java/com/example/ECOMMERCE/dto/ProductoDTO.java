package com.example.ECOMMERCE.dto;

public class ProductoDTO {

    private String nombre;
    private Double precio;
    private String categoria;

    public ProductoDTO() {
    }

    
    public String getNombre() {
        return nombre;
    }
    public Double getPrecio() {
        return precio;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
