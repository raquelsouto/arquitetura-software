package com.raquelwinkeler.entrega.dto;

import com.raquelwinkeler.entrega.model.Entrega;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntregaDTO {

    private Long pedidoId;
    private String enderecoDeOrigem;
    private String enderecoDestinatario;
    private String previsaoEntrega;

}
