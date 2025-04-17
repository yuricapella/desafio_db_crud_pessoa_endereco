package br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.EnderecoDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;

public class EnderecoMapper {
    public static EnderecoDTO toEnderecoDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setCep(endereco.getCep());
        return enderecoDTO;
    }
}
