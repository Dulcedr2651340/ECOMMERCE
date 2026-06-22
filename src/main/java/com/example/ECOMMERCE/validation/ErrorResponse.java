package com.example.ECOMMERCE.validation;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    
    private Integer status;
    private String mensaje;
    private LocalDateTime fecha;
    private Map<String, String> errores;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer status, String mensaje, LocalDateTime fecha, Map<String, String> errores) {
        this.status = status;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.errores = errores;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }

    

    
}
