package com.raquelwinkeler.loja.service;

import com.raquelwinkeler.loja.dto.CompraDTO;
import com.raquelwinkeler.loja.model.Compra;
import com.raquelwinkeler.loja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    @Autowired
    CompraRepository compraRepository;

    public CompraDTO realizarCompra(CompraDTO compraDTO) {
        Compra compraSalva = new Compra();
        compraSalva.setEnderecoDestinatario(compraDTO.getEnderecoDestinatario());
        compraSalva.setId(compraDTO.getCompraId());
        compraSalva.setProduto(compraDTO.getProduto());
        compraSalva.setQuantidade(compraDTO.getQtd());
        compraSalva.setEnderecoOrigem(compraDTO.getEnderecoOrigem());
        compraSalva.setPrecoUnitario(compraDTO.getPrecoUnitario());
        compraSalva.setPedidoId(compraDTO.getPedidoId());
        compraRepository.save(compraSalva);

        CompraDTO compraResul = new CompraDTO();
        compraResul.setPedidoId(compraSalva.getPedidoId());
        compraResul.setProduto(compraSalva.getProduto());
        compraResul.setEnderecoOrigem(compraSalva.getEnderecoOrigem());
        compraResul.setEnderecoDestinatario(compraSalva.getEnderecoDestinatario());
        compraResul.setPrecoUnitario(compraSalva.getPrecoUnitario());
        compraResul.setQtd(compraSalva.getQuantidade());
        compraResul.setCompraId(compraSalva.getId());
        return compraResul;
    }
}
