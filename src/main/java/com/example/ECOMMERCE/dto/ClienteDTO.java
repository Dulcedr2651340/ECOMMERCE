package com.example.ECOMMERCE.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@JsonPropertyOrder({
    "idCliente",
    "nombre",
    "correo",
    "telefono",
})

public class ClienteDTO {
    
    @Column(name = "id_cliente")
    private Integer idCliente;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "Correo inválido")
    private String correo;

    @Size(min = 9, max = 9, message = "Tienen que ser 9 digitos")
    private String telefono;

    public ClienteDTO() {
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
