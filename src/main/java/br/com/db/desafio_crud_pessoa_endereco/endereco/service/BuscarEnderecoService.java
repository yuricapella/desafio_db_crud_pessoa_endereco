package br.com.db.desafio_crud_pessoa_endereco.endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.EnderecoResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.EnderecoResponseMapper;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.endereco.repository.EnderecoRepository;
import br.com.db.desafio_crud_pessoa_endereco.exception.EnderecoNaoEncontrado;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.PessoaResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper.PessoaResponseMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BuscarEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public BuscarEnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Page<EnderecoResponseDTO> buscarTodosEnderecos(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));

        return enderecoRepository.findAll(pageable)
                .map(endereco -> EnderecoResponseMapper.toEnderecoDTO(endereco));
    }

    public Endereco buscarEnderecoPorId(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        return enderecoOptional
                .orElseThrow(() -> new EnderecoNaoEncontrado("Endereço com ID " + id + " não encontrado"));
    }
}
