package br.com.db.desafio_crud_pessoa_endereco.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.dto.CriarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;

public class CriarPessoaRequestMapper {
    public static Pessoa toEntity(CriarPessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaRequestDTO.getNome());
        pessoa.setCpf(pessoaRequestDTO.getCpf());
        pessoa.setDataNascimento(pessoaRequestDTO.getDataNascimento());
        return pessoa;
    }
}
