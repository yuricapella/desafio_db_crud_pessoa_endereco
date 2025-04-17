package br.com.db.desafio_crud_pessoa_endereco.endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.AtualizarEnderecoRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.AtualizarEnderecoRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.endereco.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class AtualizarEnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final BuscarEnderecoService buscarEnderecoService;

    public AtualizarEnderecoService(EnderecoRepository enderecoRepository, BuscarEnderecoService buscarEnderecoService) {
        this.enderecoRepository = enderecoRepository;
        this.buscarEnderecoService = buscarEnderecoService;
    }

    public void atualizarEnderecoPorId(AtualizarEnderecoRequestDTO enderecoAtualizado, Long id) {
        Endereco enderecoExistente = buscarEnderecoService.buscarEnderecoPorId(id);
        AtualizarEnderecoRequestMapper.updateEntity(enderecoExistente, enderecoAtualizado);
        enderecoRepository.save(enderecoExistente);
    }
}
