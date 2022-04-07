package com.raquelwinkeler.entrega.service;

import com.raquelwinkeler.entrega.dto.EntregaDTO;
import com.raquelwinkeler.entrega.model.Entrega;
import com.raquelwinkeler.entrega.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {

    @Autowired
    EntregaRepository entregaRepository;

    public EntregaDTO cadastrar(EntregaDTO entregaDTO) {
        Entrega entrega = new Entrega();
        entrega.setIdPedido(entregaDTO.getIdPedido());
        entrega.setEnderecoDeOrigem(entregaDTO.getEnderecoDeOrigem());
        entrega.setEnderecoDestinatario(entregaDTO.getEnderecoDestinatario());
        entrega.setPrevisaoDeEntrega(entregaDTO.getPrevisaoDeEntrega());
        entregaRepository.save(entrega);

        EntregaDTO entregaResult = new EntregaDTO();
        entregaResult.setIdPedido(entrega.getIdPedido());
        entregaResult.setEnderecoDeOrigem(entrega.getEnderecoDeOrigem());
        entregaResult.setEnderecoDestinatario(entrega.getEnderecoDestinatario());
        entregaResult.setPrevisaoDeEntrega(entrega.getPrevisaoDeEntrega());
        return entregaResult;
    }

}
