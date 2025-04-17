package br.com.db.desafio_crud_pessoa_endereco.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.dto.PessoaDTO;
import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.util.FormataData;

public class PessoaMapper {

    public static PessoaDTO toPessoaDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
        pessoaDTO.setIdade(FormataData.calcularIdade(pessoa.getDataNascimento()));
        return pessoaDTO;
    }

}
