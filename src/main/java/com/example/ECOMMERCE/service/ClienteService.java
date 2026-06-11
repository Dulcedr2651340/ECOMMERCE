package com.example.ECOMMERCE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.model.Cliente;
import com.example.ECOMMERCE.repository.ClienteRepository;

@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    //LISTAR CLIENTES
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    //BUSCAR PRODUCTOS
    public Cliente buscarPorId(Integer idCliente){
        return clienteRepository.findById(idCliente).orElse(null);
    }

    //GUARDAR CLIENTE
    public Cliente guardarCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    //ACTUALIZAR CLIENTE
    public Cliente actualizarCliente(Integer idCliente, Cliente clienteActualizar){

        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if(cliente != null){
            cliente.setNombre(clienteActualizar.getNombre());
            cliente.setCorreo(clienteActualizar.getCorreo());
            cliente.setTelefono(clienteActualizar.getTelefono());
        }
        return null;
    }

    //ELIMINAR CLIENTE
    public void eliminarCliente(Integer idCliente){
        clienteRepository.deleteById(idCliente);
    }
}
