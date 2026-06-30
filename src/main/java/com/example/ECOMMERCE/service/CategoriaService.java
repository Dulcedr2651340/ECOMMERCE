package com.example.ECOMMERCE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.Exception.CategoriaNoEncontradoException;
import com.example.ECOMMERCE.dto.CategoriaDTO;
import com.example.ECOMMERCE.model.Categoria;
import com.example.ECOMMERCE.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    //LISTAR CATEGORIAS
    public List<CategoriaDTO> listarCategoria(){

        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaDTO> categoriaDTO = new ArrayList<>();

        for(Categoria categoria : categorias){

            CategoriaDTO dto = new CategoriaDTO();

            dto.setIdCategoria(categoria.getIdCategoria());
            dto.setNombre(categoria.getNombre());
            dto.setDescripcion(categoria.getDescripcion());

            categoriaDTO.add(dto);
        }
        return categoriaDTO;
    }  

    //BUSCAR CATEGORIAS
    public Categoria buscarPorId(Integer idCategoria){
        return categoriaRepository.findById(idCategoria)
                    .orElseThrow(
                        () -> new CategoriaNoEncontradoException(
                            "Producto con id " + idCategoria + " no encontrado"
                        )
                    )
                    ;
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
