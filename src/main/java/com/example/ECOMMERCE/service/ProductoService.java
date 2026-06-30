package com.example.ECOMMERCE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.Exception.ProductoNoEncontradoException;
import com.example.ECOMMERCE.dto.ProductoDTO;
import com.example.ECOMMERCE.model.Producto;
import com.example.ECOMMERCE.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

       public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //LISTAR PRODUCTOS
    public List<ProductoDTO> listarProductos() {

        List<Producto> productos = productoRepository.findAll();
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for(Producto producto : productos){

            ProductoDTO dto = new ProductoDTO();
            dto.setId(producto.getId());
            dto.setNombre(producto.getNombre());
            dto.setPrecio(producto.getPrecio());
            dto.setMarca(producto.getMarca());
            dto.setGarantia(producto.getGarantia());

            dto.setCategoria(
                producto.getCategoria() != null
                ? producto.getCategoria().getNombre()
                : "Sin categoría"
            );

            productosDTO.add(dto);
        }

        return productosDTO;
    }
    

    //BUSCAR PRODUCTOS
    public Producto buscarPorId(Integer id){
        return productoRepository.findById(id)
        .orElseThrow(
            () -> new ProductoNoEncontradoException(
                "Producto con id " + id + " no encontrado"
            )
        );
    }    

    //GUARDAR PRODUCTO
    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    //ACTUALIZAR PRODUCTO
    public Producto actualizaProducto(Integer id, Producto productoActualizar){

        Producto producto = productoRepository.findById(id).orElse(null);
        if(producto != null){
            producto.setNombre(productoActualizar.getNombre());
            producto.setPrecio(productoActualizar.getPrecio());
            producto.setMarca(productoActualizar.getMarca());
            producto.setGarantia(productoActualizar.getGarantia());
            return productoRepository.save(producto);
        }
        return null;
    }

    //ELIMINAR PRODUCTO
    public void eliminarProducto(Integer id){
        productoRepository.deleteById(id);
    }
}
