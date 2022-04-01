package com.raquelwinkeler.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    public ClienteDTO(ClienteDTO cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
    }

}
