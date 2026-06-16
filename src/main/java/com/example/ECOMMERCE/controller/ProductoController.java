package com.example.ECOMMERCE.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECOMMERCE.dto.ProductoDTO;
import com.example.ECOMMERCE.model.Producto;
import com.example.ECOMMERCE.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public List<ProductoDTO> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto buscarPorId(@PathVariable Integer id){
        return productoService.buscarPorId(id);
    }

    @PostMapping("/productos")
    public Producto guardarProducto(@Valid @RequestBody Producto producto){
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/productos/{id}")
    public Producto actualizarProducto(@PathVariable Integer id,  @Valid @RequestBody Producto productoActualizar){
        return productoService.actualizaProducto(id, productoActualizar);
    }

    @DeleteMapping("/productos/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        productoService.eliminarProducto(id);
    }

    @PostMapping("/validacion")
public String validar(@Valid @RequestBody Producto producto){
    return "VALIDO";
}
}
