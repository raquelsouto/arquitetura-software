package com.raquelwinkeler.entrega.controller;

import com.raquelwinkeler.entrega.service.EntregaService;
import com.raquelwinkeler.entrega.dto.EntregaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/entrega")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @ApiOperation("Envia dados da entrega")
    @PostMapping
    public EntregaDTO cadastrar(@RequestBody EntregaDTO pedido) {
        return entregaService.cadastrar(pedido);
    }
}
