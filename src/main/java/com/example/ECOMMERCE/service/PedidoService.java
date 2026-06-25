package com.example.ECOMMERCE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.Exception.PedidoNoEncontradoException;
import com.example.ECOMMERCE.dto.PedidoDTO;
import com.example.ECOMMERCE.model.Pedido;
import com.example.ECOMMERCE.repository.PedidoRepository;


@Service
public class PedidoService {
    
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //LISTAR PEDIDOS
    public List<PedidoDTO> listarPedidos(){

        List<PedidoDTO> pedidoDTOs = new ArrayList<>();
        List<Pedido> pedidos = pedidoRepository.findAll();

        for(Pedido pedido : pedidos){

    PedidoDTO dto = new PedidoDTO();

    dto.setIdPedido(pedido.getIdPedido());
    dto.setFecha(pedido.getFecha());
    dto.setTotal(pedido.getTotal());
    dto.setCliente(pedido.getCliente()!=null?
        pedido.getCliente().getNombre() : "Sin cliente" );

    pedidoDTOs.add(dto); 
        
    }
        return pedidoDTOs;
   

    }

    //GUARDAR PEDIDO
    public Pedido guardarPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    //BUSCAR PEDIDO
    public Pedido buscarPorId(Integer idPedido){
        return pedidoRepository.findById(idPedido)
                .orElseThrow(
                        () -> new PedidoNoEncontradoException(
                            "Pedido con id" + idPedido + " no encontrado"
                        )
                    );    
                
    }

    //ACTUALIZAR PEDIDO
    public Pedido actualizarPedido(Integer idPedido, Pedido pedidoActualizar){
        Pedido pedido = buscarPorId(idPedido);
        
        pedido.setCliente(pedidoActualizar.getCliente());
        pedido.setTotal(pedidoActualizar.getTotal());

        return pedidoRepository.save(pedido);
    }

    //ELIMINAR PEDIDO
    public void eliminarPedido(Integer idPedido){
        buscarPorId(idPedido);
        pedidoRepository.deleteById(idPedido);
    }
}