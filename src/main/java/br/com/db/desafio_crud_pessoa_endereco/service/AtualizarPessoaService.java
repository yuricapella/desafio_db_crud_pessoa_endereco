package br.com.db.desafio_crud_pessoa_endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AtualizarPessoaService {
    private final PessoaRepository pessoaRepository;
    private final BuscarPessoaService buscarPessoaService;


    public AtualizarPessoaService(PessoaRepository pessoaRepository, BuscarPessoaService buscarPessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.buscarPessoaService = buscarPessoaService;
    }

    public void atualizarPessoaPorId(Long id, Pessoa pessoaAtualizada){
        Pessoa pessoaExistente = buscarPessoaService.buscarPessoaPorId(id);
        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setCpf(pessoaAtualizada.getCpf());
        pessoaExistente.setDataNascimento(pessoaAtualizada.getDataNascimento());
        pessoaExistente.setDataAtualizacao(LocalDateTime.now());
        pessoaRepository.save(pessoaExistente);
    }
}

