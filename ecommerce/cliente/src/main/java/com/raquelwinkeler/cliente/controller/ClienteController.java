package com.raquelwinkeler.cliente.controller;

import com.raquelwinkeler.cliente.dto.ClienteDTO;
import com.raquelwinkeler.cliente.model.Cliente;
import com.raquelwinkeler.cliente.repository.ClienteRepository;
import com.raquelwinkeler.cliente.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteService clienteService;

    @ApiOperation("Retorna todos os clientes")
    @GetMapping
    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @ApiOperation("Retorna o cliente de acordo com o id")
    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Long id) throws Exception {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new Exception("Não foi possível encontrar o cliente de id: " + id));
    }

    @ApiOperation("Cadastra um cliente no sistema")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClienteDTO cliente) {
        clienteService.cadastrar(cliente);

        return ResponseEntity.ok().body((new ClienteDTO(cliente)));
    }

    @ApiOperation("Atualiza os dados do cliente de acordo com o id")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id,
                                    @RequestBody ClienteDTO clienteDTO) {
        Optional encontrou = clienteRepository.findById(id);
        if(encontrou.isPresent()) {
            clienteService.atualizar(clienteDTO);
            return ResponseEntity.ok().body((new ClienteDTO(clienteDTO)));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation("Deleta um cliente de acordo com o id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Long id) {
        Optional<Cliente> encontrou = clienteRepository.findById(id);

        if(encontrou.isPresent()) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
