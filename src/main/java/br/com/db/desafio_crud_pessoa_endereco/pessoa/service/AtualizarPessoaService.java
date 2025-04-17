package br.com.db.desafio_crud_pessoa_endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.dto.pessoa.AtualizarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.mapper.pessoa.AtualizarPessoaRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.repository.PessoaRepository;
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

