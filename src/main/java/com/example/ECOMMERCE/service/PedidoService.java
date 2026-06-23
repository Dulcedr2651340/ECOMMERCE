package com.example.ECOMMERCE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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

    dto.setIdPedido(
            pedido.getIdPedido()
    );

    dto.setFecha(
            pedido.getFecha()
    );


    dto.setTotal(
            pedido.getTotal()
    );


    dto.setCliente(

        pedido.getCliente()!=null

        ?

        pedido.getCliente().getNombre()

        :

        "Sin cliente"

    );


    pedidoDTOs.add(dto);

        }
        return pedidoDTOs;
   

    }
}