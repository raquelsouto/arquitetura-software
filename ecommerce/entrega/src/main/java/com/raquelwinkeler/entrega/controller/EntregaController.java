package com.raquelwinkeler.entrega.controller;

import com.raquelwinkeler.entrega.model.Entrega;
import com.raquelwinkeler.entrega.repository.EntregaRepository;
import com.raquelwinkeler.entrega.service.EntregaService;
import com.raquelwinkeler.entrega.dto.EntregaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @ApiOperation("Encontra as entregas de acordo com a id")
    @GetMapping("/{îd}")
    public Iterable<Entrega> findAll() {
        return entregaRepository.findAll();
    }


    @ApiOperation("Envia dados da entrega")
    @PostMapping
    public EntregaDTO cadastrar(@RequestBody EntregaDTO pedido) {
        return entregaService.cadastrar(pedido);
    }
}
