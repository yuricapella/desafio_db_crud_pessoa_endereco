package br.com.db.desafio_crud_pessoa_endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.dto.PessoaDTO;
import br.com.db.desafio_crud_pessoa_endereco.dto.mapper.PessoaMapper;
import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.repository.PessoaRepository;
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

    public List<PessoaDTO> buscarTodasPessoas() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> PessoaMapper.toPessoaDTO(pessoa))
                .collect(Collectors.toList());
    }

    public Pessoa buscarPessoaPorId(Long id) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        return pessoaOptional
                .orElseThrow(() -> new RuntimeException("Usuário com ID" + id + " não encontrado"));
    }
}
