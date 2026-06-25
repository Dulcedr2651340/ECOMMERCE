package com.example.ECOMMERCE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ECOMMERCE.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
