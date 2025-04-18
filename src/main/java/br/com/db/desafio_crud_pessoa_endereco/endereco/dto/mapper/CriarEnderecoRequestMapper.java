package br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.CriarEnderecoRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;

public class CriarEnderecoRequestMapper {
    public static Endereco toEntity(CriarEnderecoRequestDTO enderecoRequestDTO, Pessoa pessoa) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoRequestDTO.getRua());
        endereco.setNumero(enderecoRequestDTO.getNumero());
        endereco.setBairro(enderecoRequestDTO.getBairro());
        endereco.setCidade(enderecoRequestDTO.getCidade());
        endereco.setEstado(enderecoRequestDTO.getEstado());
        endereco.setCep(enderecoRequestDTO.getCep());
        endereco.setEnderecoPrincipal(enderecoRequestDTO.getEnderecoPrincipal());
        endereco.setPessoa(pessoa);
        return endereco;
    }
}
