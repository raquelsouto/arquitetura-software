package com.raquelwinkeler.loja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private String enderecoDestinatario;
    private String enderecoOrigem;
    private String produto;
    private double precoUnitario;
    private int quantidade;

}
