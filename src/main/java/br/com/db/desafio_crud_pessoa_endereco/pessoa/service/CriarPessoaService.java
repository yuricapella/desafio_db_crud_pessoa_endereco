package br.com.db.desafio_crud_pessoa_endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarPessoaService {
    public CriarPessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    private final PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }


}
