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

import com.example.ECOMMERCE.model.Categoria;
import com.example.ECOMMERCE.service.CategoriaService;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {
    
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategoria();
    }

    @GetMapping("/categorias/{idCategoria}")
    public Categoria buscarPorId(@PathVariable Integer idCategoria){
        return categoriaService.buscarPorId(idCategoria);
    }

    @PostMapping("/categorias")
    public Categoria guardarCategoria(@RequestBody Categoria categoria){
        return categoriaService.guardCategoria(categoria);
    }

    @PutMapping("/categorias/{idCategoria}")
    public Categoria actualizarCategoria(@PathVariable Integer idCategoria, @RequestBody Categoria categoriaActualiar){
        return categoriaService.actualizarCategoria(idCategoria, categoriaActualiar);
    }
    
    @DeleteMapping("/categorias/{idCategoria}")
    public void eliminarCategoria(@PathVariable Integer idCategoria){
        categoriaService.eliminarCategoria(idCategoria);
    }
}
