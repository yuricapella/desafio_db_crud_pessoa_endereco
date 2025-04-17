package br.com.db.desafio_crud_pessoa_endereco.endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.endereco.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletarEnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final BuscarEnderecoService buscarEnderecoService;

    public DeletarEnderecoService(EnderecoRepository enderecoRepository, BuscarEnderecoService buscarEnderecoService) {
        this.enderecoRepository = enderecoRepository;
        this.buscarEnderecoService = buscarEnderecoService;
    }

    public void deletarEnderecoPorId(Long id) {
        buscarEnderecoService.buscarEnderecoPorId(id);
        enderecoRepository.deleteById(id);
    }
}
