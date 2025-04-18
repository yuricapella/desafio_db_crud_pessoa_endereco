package br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.AtualizarEnderecoRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;

import java.time.LocalDateTime;

public class AtualizarEnderecoRequestMapper {
    public static Endereco updateEntity(Endereco enderecoExistente, AtualizarEnderecoRequestDTO enderecoAtualizado) {
        enderecoExistente.setRua(enderecoAtualizado.getRua());
        enderecoExistente.setNumero(enderecoAtualizado.getNumero());
        enderecoExistente.setBairro(enderecoAtualizado.getBairro());
        enderecoExistente.setCidade(enderecoAtualizado.getCidade());
        enderecoExistente.setEstado(enderecoAtualizado.getEstado());
        enderecoExistente.setCep(enderecoAtualizado.getCep());
        enderecoExistente.setEnderecoPrincipal(enderecoAtualizado.getEnderecoPrincipal());
        enderecoExistente.setDataAtualizacao(LocalDateTime.now());
        return enderecoExistente;
    }
}
