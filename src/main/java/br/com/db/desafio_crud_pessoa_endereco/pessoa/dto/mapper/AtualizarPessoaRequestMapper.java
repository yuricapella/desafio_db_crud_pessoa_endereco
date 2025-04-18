package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.AtualizarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;

import java.time.LocalDateTime;

public class AtualizarPessoaRequestMapper {
    public static Pessoa updateEntity(Pessoa pessoaExistente, AtualizarPessoaRequestDTO pessoaAtualizada) {
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setCpf(pessoaAtualizada.getCpf());
        pessoaExistente.setDataNascimento(pessoaAtualizada.getDataNascimento());
        pessoaExistente.setDataAtualizacao(LocalDateTime.now());
        return pessoaExistente;
    }
}
