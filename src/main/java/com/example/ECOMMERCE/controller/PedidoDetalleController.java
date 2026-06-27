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

import com.example.ECOMMERCE.dto.PedidoDetalleDTO;
import com.example.ECOMMERCE.model.PedidoDetalle;
import com.example.ECOMMERCE.service.PedidoDetalleService;

import jakarta.validation.Valid;

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

    @GetMapping("/pedidosDetalles/{idDetalle}")
    public PedidoDetalle buscarPedidoDetallePorId(
        @PathVariable Integer idDetalle){
    return pedidoDetalleService.buscarDetallePedidoPorId(idDetalle);

}

    @PostMapping("/pedidoDetalles")
    public PedidoDetalle guardarPedidoDetalle(@Valid @RequestBody PedidoDetalle pedidoDetalle){
        return pedidoDetalleService.guardarDetalle(pedidoDetalle);
    }

    @PutMapping("/pedidosDetalles/{idDetalle}")
    public PedidoDetalle actualizaDetalle(@PathVariable Integer idDetalle, @RequestBody PedidoDetalle detalleActualizar){
    return pedidoDetalleService.actualizaDetalle(
            idDetalle,
            detalleActualizar
    );
}

    @DeleteMapping("/pedidosDetalles/{idDetalle}")
public void eliminarDetalle(

        @PathVariable Integer idDetalle){

    pedidoDetalleService.eliminarDetalle(idDetalle);

}
}
