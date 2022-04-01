package com.raquelwinkeler.sistema.service;

import com.raquelwinkeler.sistema.dto.ClienteDTO;
import com.raquelwinkeler.sistema.model.Cliente;
import com.raquelwinkeler.sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteDTO cadastrar(ClienteDTO novoCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(novoCliente.getId());
        cliente.setNome(novoCliente.getNome());
        cliente.setCpf(novoCliente.getCpf());
        cliente.setEndereco(novoCliente.getEndereco());
        cliente.setTelefone(novoCliente.getTelefone());
        clienteRepository.save(cliente);

        ClienteDTO clienteResult = new ClienteDTO();
        clienteResult.setId(cliente.getId());
        clienteResult.setNome(cliente.getNome());
        clienteResult.setTelefone(cliente.getTelefone());
        return clienteResult;
    }

    public ClienteDTO atualizar(ClienteDTO novoCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(novoCliente.getId());
        cliente.setNome(novoCliente.getNome());
        cliente.setCpf(novoCliente.getCpf());
        cliente.setEndereco(novoCliente.getEndereco());
        cliente.setTelefone(novoCliente.getTelefone());
        clienteRepository.save(cliente);

        ClienteDTO clienteResult = new ClienteDTO();
        clienteResult.setId(cliente.getId());
        clienteResult.setNome(cliente.getNome());
        clienteResult.setCpf(cliente.getCpf());
        clienteResult.setEndereco(cliente.getEndereco());
        clienteResult.setTelefone(cliente.getTelefone());
        return clienteResult;
    }

}
