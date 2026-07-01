package com.example.ECOMMERCE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.Exception.PedidoDetalleNoEncontradoException;
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


    //LISTAR PEDIDO DETALLE
    public List<PedidoDetalleDTO> listarPedidoDetalles(){

        List<PedidoDetalleDTO> pedidoDetalleDTO = new ArrayList<>();
        List<PedidoDetalle> detalles = pedidoDetalleRepository.findAll();
        
        for(PedidoDetalle detalle : detalles){

            PedidoDetalleDTO dto = new PedidoDetalleDTO();

                dto.setIdDetalle(detalle.getIdDetalle());
                dto.setCantidad(detalle.getCantidad());
                dto.setSubtotal(detalle.getSubTotal());

                dto.setProducto(detalle.getProducto() != null ?
                                detalle.getProducto().getNombre() :
                "Sin producto"
        );

        dto.setIdPedido(detalle.getPedido() != null ?
                        detalle.getPedido().getIdPedido() : null
        );

        dto.setCliente(detalle.getPedido() != null
                        && detalle.getPedido().getCliente() != null ?
                           detalle.getPedido()
                                  .getCliente()
                                  .getNombre() :
                "Sin cliente"

        );


        pedidoDetalleDTO.add(dto);

                }

                return pedidoDetalleDTO;
        }


    //BUSCAR PEDIDO DETALLE
    public PedidoDetalle buscarDetallePedidoPorId(Integer idDetalle){
        return pedidoDetalleRepository.findById(idDetalle)
                .orElseThrow(
                        () -> new PedidoDetalleNoEncontradoException(
                                "Detalle con id" + idDetalle + " no encontrado")
                );
        }

   //GUARDAR PEDIDO DETALLE     
   public PedidoDetalle guardarDetalle(PedidoDetalle detalle){
        return pedidoDetalleRepository.save(detalle);
   }     

   //ACTUALIZAR PEDIDO DETALLE
   public PedidoDetalle actualizaDetalle(Integer idDetalle, PedidoDetalle detalleActualizar){
        PedidoDetalle detalle = buscarDetallePedidoPorId(idDetalle);
        detalle.setCantidad(
                detalleActualizar.getCantidad()
        );

        detalle.setSubTotal(
                detalleActualizar.getSubTotal()
        );

        detalle.setProducto(
                detalleActualizar.getProducto()
        );

        detalle.setPedido(
                detalleActualizar.getPedido()
        );

        return pedidoDetalleRepository.save(detalle);
   }

   //ELIMINAR PEDIDO DETALLE
   public void eliminarDetalle(Integer idDetalle){
        buscarDetallePedidoPorId(idDetalle);
        pedidoDetalleRepository.deleteById(idDetalle);
   }

   

}