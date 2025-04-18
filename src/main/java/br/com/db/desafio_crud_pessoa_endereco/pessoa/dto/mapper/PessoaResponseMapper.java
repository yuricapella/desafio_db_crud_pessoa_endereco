package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.PessoaResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.EnderecoResponseMapper;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.util.FormataData;

import java.util.stream.Collectors;

public class PessoaResponseMapper {

    public static PessoaResponseDTO toPessoaDTO(Pessoa pessoa) {
        PessoaResponseDTO pessoaDTO = new PessoaResponseDTO();
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
        pessoaDTO.setIdade(FormataData.calcularIdade(pessoa.getDataNascimento()));
        pessoaDTO.setEnderecos(
                pessoa.getEnderecos().stream()
                        .map(EnderecoResponseMapper::toEnderecoDTO)
                        .collect(Collectors.toList())
        );
        return pessoaDTO;
    }

}
