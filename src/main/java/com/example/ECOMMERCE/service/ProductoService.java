package com.example.ECOMMERCE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.model.Producto;
import com.example.ECOMMERCE.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

       public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //LISTAR PRODUCTOS
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    //BUSCAR PRODUCTOS
    public Producto buscarPorId(Integer id){
        return productoRepository.findById(id).orElse(null);
    }    
}
