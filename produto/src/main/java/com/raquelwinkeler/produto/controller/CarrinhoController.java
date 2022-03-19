package com.raquelwinkeler.produto.controller;

import com.raquelwinkeler.produto.model.Carrinho;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class CarrinhoController {

    @GetMapping
    public List<Carrinho> buscarTodos() {
        return new ArrayList<Carrinho>();
    }
}

