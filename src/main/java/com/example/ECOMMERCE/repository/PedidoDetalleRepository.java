package com.example.ECOMMERCE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ECOMMERCE.model.PedidoDetalle;


@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Integer>{
    
}
