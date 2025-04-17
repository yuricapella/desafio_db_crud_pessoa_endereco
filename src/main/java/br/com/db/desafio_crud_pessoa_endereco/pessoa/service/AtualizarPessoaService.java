package br.com.db.desafio_crud_pessoa_endereco.pessoa.service;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.AtualizarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper.AtualizarPessoaRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPessoaService {
    private final PessoaRepository pessoaRepository;
    private final BuscarPessoaService buscarPessoaService;


    public AtualizarPessoaService(PessoaRepository pessoaRepository, BuscarPessoaService buscarPessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.buscarPessoaService = buscarPessoaService;
    }

    public void atualizarPessoaPorId(AtualizarPessoaRequestDTO pessoaAtualizada, Long id){
        Pessoa pessoaExistente = buscarPessoaService.buscarPessoaPorId(id);
        AtualizarPessoaRequestMapper.updateEntity(pessoaExistente, pessoaAtualizada);
        pessoaRepository.save(pessoaExistente);
    }
}

