package br.com.db.desafio_crud_pessoa_endereco.endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.EnderecoDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.EnderecoMapper;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.endereco.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuscarEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public BuscarEnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<EnderecoDTO> buscarTodosEnderecos() {
        return enderecoRepository.findAll()
                .stream()
                .map(EnderecoMapper::toEnderecoDTO)
                .collect(Collectors.toList());
    }

    public Endereco buscarEnderecoPorId(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        return enderecoOptional
                .orElseThrow(() -> new RuntimeException("Endereço com ID " + id + " não encontrado"));
    }
}
