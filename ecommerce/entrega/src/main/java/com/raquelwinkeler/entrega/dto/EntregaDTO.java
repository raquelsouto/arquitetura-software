package com.raquelwinkeler.entrega.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EntregaDTO {

    private Long idPedido;
    private String enderecoDeOrigem;
    private String enderecoDestinatario;
    private String previsaoDeEntrega;

    public EntregaDTO(EntregaDTO entrega) {
        this.idPedido = entrega.getIdPedido();
        this.enderecoDeOrigem = entrega.getEnderecoDeOrigem();
        this.enderecoDestinatario = entrega.getEnderecoDestinatario();
        this.previsaoDeEntrega = entrega.getPrevisaoDeEntrega();
    }

}
