package com.raquelwinkeler.loja.controller;

import com.raquelwinkeler.loja.dto.CompraDTO;
import com.raquelwinkeler.loja.model.Compra;
import com.raquelwinkeler.loja.repository.CompraRepository;
import com.raquelwinkeler.loja.service.CompraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraService compraService;

    @Autowired
    CompraRepository compraRepository;

    @ApiOperation("Devolve dados das compras de acordo com o id")
    @GetMapping("/{id}")
    public Compra findById(@PathVariable("id") Long id) throws Exception {
        return compraRepository.findById(id)
                .orElseThrow(() -> new Exception("Não foi possível encontrar a compra de id: " + id));
    }

    @ApiOperation("Envia dados da compra")
    @PostMapping
    public ResponseEntity<?> realizarCompra(@RequestBody CompraDTO compraDTO) {
        compraService.realizarCompra(compraDTO);

        return ResponseEntity.ok().body((new CompraDTO(compraDTO)));
    }

}
