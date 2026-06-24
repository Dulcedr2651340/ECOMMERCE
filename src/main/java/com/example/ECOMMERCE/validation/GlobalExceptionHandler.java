package com.example.ECOMMERCE.validation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ECOMMERCE.Exception.CategoriaNoEncontradoException;
import com.example.ECOMMERCE.Exception.ClienteNoEncontradoException;
import com.example.ECOMMERCE.Exception.PedidoNoEncontradoException;
import com.example.ECOMMERCE.Exception.ProductoNoEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse manejarValidacion(MethodArgumentNotValidException ex){

        Map<String, String> errores = new HashMap<>();
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errores.put(
                error.getField(),
                error.getDefaultMessage()
                
            );
        }

        ErrorResponse response = new ErrorResponse();
        
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMensaje("Error de validación");
        response.setFecha(LocalDateTime.now());
        response.setErrores(errores);

        return response;
    }

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ErrorResponse manejarProductoNoEncontrado(
        ProductoNoEncontradoException ex){

    ErrorResponse response = new ErrorResponse();

    response.setStatus(HttpStatus.NOT_FOUND.value());
    response.setMensaje(ex.getMessage());
    response.setFecha(LocalDateTime.now());
    response.setErrores(null);

    return response;
}

        @ExceptionHandler(CategoriaNoEncontradoException.class)
    public ErrorResponse manejarCategotiaNoEncontrado(
        CategoriaNoEncontradoException ex){

    ErrorResponse response = new ErrorResponse();

    response.setStatus(HttpStatus.NOT_FOUND.value());
    response.setMensaje(ex.getMessage());
    response.setFecha(LocalDateTime.now());
    response.setErrores(null);

    return response;
}

    @ExceptionHandler(ClienteNoEncontradoException.class)
    public ErrorResponse manejarClienteNoEncontrado(
        ClienteNoEncontradoException ex){

    ErrorResponse response = new ErrorResponse();

    response.setStatus(HttpStatus.NOT_FOUND.value());
    response.setMensaje(ex.getMessage());
    response.setFecha(LocalDateTime.now());
    response.setErrores(null);

    return response;
}

    @ExceptionHandler(PedidoNoEncontradoException.class)
    public ErrorResponse manejarClienteNoEncontrado(
        PedidoNoEncontradoException ex){

    ErrorResponse response = new ErrorResponse();

    response.setStatus(HttpStatus.NOT_FOUND.value());
    response.setMensaje(ex.getMessage());
    response.setFecha(LocalDateTime.now());
    response.setErrores(null);

    return response;
}   
}