package br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.EnderecoResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;

public class EnderecoResponseMapper {
    public static EnderecoResponseDTO toEnderecoDTO(Endereco endereco) {
        EnderecoResponseDTO enderecoDTO = new EnderecoResponseDTO();
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setBairro(endereco.getBairro());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setCep(endereco.getCep());
        return enderecoDTO;
    }
}
