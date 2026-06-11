package com.example.ECOMMERCE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.model.Categoria;
import com.example.ECOMMERCE.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    //LISTAR CATEGORIAS
    public List<Categoria> listarCategoria(){
        return categoriaRepository.findAll();
    }  

    //BUSCAR CATEGORIAS
    public Categoria buscarPorId(Integer idCategoria){
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    //GUARDAR CATEGORIAS
    public Categoria guardCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    //ACTUALIZAR CATEGORIA
    public Categoria actualizarCategoria(Integer idCategoria, Categoria categoriaActualizada){

        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        if(categoria != null){
            categoria.setNombre(categoriaActualizada.getNombre());
            categoria.setDescripcion(categoriaActualizada.getDescripcion()); 
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    //ELIMINAR CATEGORIAS
    public void eliminarCategoria(Integer idCategoria){
        categoriaRepository.deleteById(idCategoria);
    }
}   
