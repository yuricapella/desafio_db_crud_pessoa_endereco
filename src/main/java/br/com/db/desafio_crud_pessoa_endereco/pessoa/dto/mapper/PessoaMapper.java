package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.PessoaDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.EnderecoMapper;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.util.FormataData;

import java.util.stream.Collectors;

public class PessoaMapper {

    public static PessoaDTO toPessoaDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
        pessoaDTO.setIdade(FormataData.calcularIdade(pessoa.getDataNascimento()));
        pessoaDTO.setEnderecos(
                pessoa.getEnderecos().stream()
                        .map(EnderecoMapper::toEnderecoDTO)
                        .collect(Collectors.toList())
        );
        return pessoaDTO;
    }

}
