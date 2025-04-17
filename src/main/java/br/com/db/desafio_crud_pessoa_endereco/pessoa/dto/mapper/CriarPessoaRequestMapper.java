package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.CriarEnderecoRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.CriarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;

import java.util.List;
import java.util.stream.Collectors;

public class CriarPessoaRequestMapper {
    public static Pessoa toEntity(CriarPessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaRequestDTO.getNome());
        pessoa.setCpf(pessoaRequestDTO.getCpf());
        pessoa.setDataNascimento(pessoaRequestDTO.getDataNascimento());

        List<Endereco> enderecos = pessoaRequestDTO.getEnderecos().stream()
                .map(enderecoDTO -> CriarEnderecoRequestMapper.toEntity(enderecoDTO, pessoa))
                .collect(Collectors.toList());

        pessoa.setEnderecos(enderecos);
        return pessoa;
    }
}
