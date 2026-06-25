package com.example.ECOMMERCE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.dto.PedidoDetalleDTO;
import com.example.ECOMMERCE.model.PedidoDetalle;
import com.example.ECOMMERCE.repository.PedidoDetalleRepository;

@Service
public class PedidoDetalleService {


    private final PedidoDetalleRepository pedidoDetalleRepository;



    public PedidoDetalleService(

            PedidoDetalleRepository pedidoDetalleRepository){

        this.pedidoDetalleRepository =
                pedidoDetalleRepository;

    }



    public List<PedidoDetalleDTO> listarPedidoDetalles(){


        List<PedidoDetalle> detalles =
                pedidoDetalleRepository.findAll();



        List<PedidoDetalleDTO> dtos =
                new ArrayList<>();



        for(PedidoDetalle detalle : detalles){


            PedidoDetalleDTO dto =
                    new PedidoDetalleDTO();



            dto.setProducto(

                    detalle.getProducto()!=null

                    ?

                    detalle.getProducto().getNombre()

                    :

                    "Sin producto"

            );


            dto.setCantidad(

                    detalle.getCantidad()

            );


            dto.setSubTotal(

                    detalle.getSubTotal()

            );


            dtos.add(dto);

        }



        return dtos;

    }


}