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

import com.example.ECOMMERCE.dto.PedidoDTO;
import com.example.ECOMMERCE.model.Pedido;
import com.example.ECOMMERCE.service.PedidoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PedidoController {
    
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedidos")
    public List<PedidoDTO> listarPedido() {
        return pedidoService.listarPedidos();
    }

    @PostMapping("/pedidos")
    public Pedido guardarPedido(@Valid @RequestBody Pedido pedido){
        return pedidoService.guardarPedido(pedido);
    }

    @GetMapping("/pedidos/{idPedido}")
    public Pedido buscarIdPedido(@PathVariable Integer idPedido){
    return pedidoService.buscarPorId(idPedido);
    }

    @PutMapping("/pedidos/{idPedido}")
    public Pedido actualizarPedido(@PathVariable Integer idPedido, @RequestBody Pedido pedido){
        return pedidoService.actualizarPedido(idPedido, pedido);
    }

    @DeleteMapping("/pedidos/{idPedido}")
    public void eliminarPedido(@PathVariable Integer idPedido){
        pedidoService.eliminarPedido(idPedido);
    }
}
