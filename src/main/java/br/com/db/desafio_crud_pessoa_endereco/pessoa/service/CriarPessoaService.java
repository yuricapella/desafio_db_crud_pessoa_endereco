package br.com.db.desafio_crud_pessoa_endereco.pessoa.service;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.repository.PessoaRepository;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.validator.PessoaValidator;
import org.springframework.stereotype.Service;

@Service
public class CriarPessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaValidator pessoaValidator;

    public CriarPessoaService(PessoaRepository pessoaRepository, PessoaValidator pessoaValidator) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaValidator = pessoaValidator;
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        pessoaValidator.validarPessoa(pessoa, false);
        return pessoaRepository.save(pessoa);
    }
}
