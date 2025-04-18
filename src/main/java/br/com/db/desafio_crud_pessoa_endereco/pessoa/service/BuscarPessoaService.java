package br.com.db.desafio_crud_pessoa_endereco.pessoa.service;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.PessoaResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper.PessoaResponseMapper;
import br.com.db.desafio_crud_pessoa_endereco.exception.PessoaNaoEncontradaException;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuscarPessoaService {

    private final PessoaRepository pessoaRepository;

    public BuscarPessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<PessoaResponseDTO> buscarTodasPessoas() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> PessoaResponseMapper.toPessoaDTO(pessoa))
                .collect(Collectors.toList());
    }

    public Pessoa buscarPessoaPorId(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        return pessoaOptional
                .orElseThrow(() -> new PessoaNaoEncontradaException ("Pessoa com ID " + id + " não encontrada"));
    }
}
