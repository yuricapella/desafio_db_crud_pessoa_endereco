package br.com.db.desafio_crud_pessoa_endereco.mapper.pessoa;

import br.com.db.desafio_crud_pessoa_endereco.dto.pessoa.PessoaDTO;
import br.com.db.desafio_crud_pessoa_endereco.mapper.endereco.EnderecoMapper;
import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.util.FormataData;

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
