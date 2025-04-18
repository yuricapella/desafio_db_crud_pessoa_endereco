package br.com.db.desafio_crud_pessoa_endereco.pessoa.service;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.AtualizarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper.AtualizarPessoaRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.repository.PessoaRepository;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.validator.PessoaValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AtualizarPessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaValidator pessoaValidator;
    private final BuscarPessoaService buscarPessoaService;

    public AtualizarPessoaService(PessoaRepository pessoaRepository, PessoaValidator pessoaValidator, BuscarPessoaService buscarPessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaValidator = pessoaValidator;
        this.buscarPessoaService = buscarPessoaService;
    }

    public void atualizarPessoaPorId(AtualizarPessoaRequestDTO pessoaAtualizada, Long id) {
        Pessoa pessoaExistente = buscarPessoaService.buscarPessoaPorId(id);
        AtualizarPessoaRequestMapper.updateEntity(pessoaExistente, pessoaAtualizada);
        pessoaValidator.validarPessoa(pessoaExistente, true);
        pessoaRepository.save(pessoaExistente);
    }
}

