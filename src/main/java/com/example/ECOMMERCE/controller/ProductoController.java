package com.example.ECOMMERCE.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECOMMERCE.model.Producto;
import com.example.ECOMMERCE.service.ProductoService;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @GetMapping("/productos/{id}")
    public Producto buscarPorId(@PathVariable Integer id){
        return productoService.buscarPorId(id);
    }
}
