package com.example.ECOMMERCE.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECOMMERCE.dto.PedidoDetalleDTO;
import com.example.ECOMMERCE.service.PedidoDetalleService;

@RestController
@RequestMapping("/api/v1")
public class PedidoDetalleController {
    
    private final PedidoDetalleService pedidoDetalleService;

    public PedidoDetalleController(PedidoDetalleService pedidoDetalleService) {
        this.pedidoDetalleService = pedidoDetalleService;
    }

    @GetMapping("/pedidosDetalles")
    public List<PedidoDetalleDTO> listarPedidoDetallaes(){
        return pedidoDetalleService.listarPedidoDetalles();
    }
}
