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

import com.example.ECOMMERCE.dto.ClienteDTO;
import com.example.ECOMMERCE.model.Cliente;
import com.example.ECOMMERCE.service.ClienteService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1")
public class ClienteController{

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<ClienteDTO> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente buscaPorId(@PathVariable Integer idCliente){
        return clienteService.buscarPorId(idCliente);
    }

    @PostMapping("/clientes")
    public Cliente guardarCliente(@Valid @RequestBody Cliente cliente){
        return clienteService.guardarCliente(cliente);
    }

    @PutMapping("/clientes/{idCliente}")
    public Cliente actualizarCliente(@PathVariable Integer idCliente, @Valid @RequestBody Cliente clienteActualizar){
        return clienteService.actualizarCliente(idCliente, clienteActualizar);
    }

    @DeleteMapping("/clientes/{idCliente}")
    public void eliminarCliente(@PathVariable Integer idCliente){
        clienteService.eliminarCliente(idCliente);
    }

}