package com.example.ECOMMERCE.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import com.example.ECOMMERCE.Exception.ClienteNoEncontradoException;
import com.example.ECOMMERCE.dto.ClienteDTO;
import com.example.ECOMMERCE.model.Cliente;
import com.example.ECOMMERCE.repository.ClienteRepository;


@Service
public class ClienteService {
    
    private final ClienteRepository clienteRepository;
    private static final Logger log = LoggerFactory.getLogger(ClienteService.class);

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    //LISTAR CLIENTES
    public List<ClienteDTO> listarClientes(){

        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clienteDTO= new ArrayList<>();

        for(Cliente cliente : clientes){

            ClienteDTO dto = new ClienteDTO();
            dto.setIdCliente(cliente.getIdCliente());
            dto.setNombre(cliente.getNombre());
            dto.setCorreo(cliente.getCorreo());
            dto.setTelefono(cliente.getTelefono());

            clienteDTO.add(dto);
        }

        return clienteDTO;
    }

    //BUSCAR PRODUCTOS
    public Cliente buscarPorId(Integer idCliente){
        return clienteRepository.findById(idCliente)
                .orElseThrow(
                    () -> new ClienteNoEncontradoException(
                        "Producto con id " + idCliente + " no encontrado"
                    )
                );
    }

    //GUARDAR CLIENTE
    public Cliente guardarCliente(Cliente cliente){

        MDC.put("operacion", "guardarCliente");
        log.info("Guardando cliente {}", cliente.getNombre());
        Cliente resultado = clienteRepository.save(cliente);
        MDC.clear();
        return resultado;
        //return clienteRepository.save(cliente);
    }

    //ACTUALIZAR CLIENTE
    public Cliente actualizarCliente(Integer idCliente, Cliente clienteActualizar){

        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if(cliente != null){
            cliente.setNombre(clienteActualizar.getNombre());
            cliente.setCorreo(clienteActualizar.getCorreo());
            cliente.setTelefono(clienteActualizar.getTelefono());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    //ELIMINAR CLIENTE
    public void eliminarCliente(Integer idCliente){
        clienteRepository.deleteById(idCliente);
    }
}
