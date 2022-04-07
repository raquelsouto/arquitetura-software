package com.raquelwinkeler.entrega.controller;

import com.raquelwinkeler.entrega.model.Entrega;
import com.raquelwinkeler.entrega.repository.EntregaRepository;
import com.raquelwinkeler.entrega.service.EntregaService;
import com.raquelwinkeler.entrega.dto.EntregaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private EntregaService entregaService;

    @ApiOperation("Retorna todos os dados das entregas")
    @GetMapping
    public Iterable<Entrega> encontrarTodos() {
        return entregaRepository.findAll();
    }

    @ApiOperation("Retorna os dados da entrega de acordo com o id")
    @GetMapping("/{id}")
    public Entrega findById(@PathVariable("id") Long id) throws Exception {
        return entregaRepository.findById(id)
                .orElseThrow(() -> new Exception("Não foi possível encontrar a entrega de id: " + id));
    }

    @ApiOperation("Envia dados da entrega")
    @PostMapping
    public ResponseEntity<EntregaDTO> cadastrar(@RequestBody EntregaDTO pedido) {
        entregaService.cadastrar(pedido);

        return ResponseEntity.ok().body((new EntregaDTO(pedido)));
    }

}
