package com.raquelwinkeler.loja.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompraDTO {

    @JsonIgnore
    private Long compraId;
    private Long pedidoId;
    private String produto;
    private String enderecoOrigem;
    private String enderecoDestinatario;
    private double precoUnitario;
    private int qtd;

    public CompraDTO(CompraDTO compraDTO) {
        this.compraId = compraDTO.getCompraId();
        this.produto = compraDTO.getProduto();
        this.enderecoDestinatario = compraDTO.getEnderecoDestinatario();
        this.precoUnitario = compraDTO.getPrecoUnitario();
        this.qtd = compraDTO.getQtd();
    }
}

