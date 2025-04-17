package br.com.db.desafio_crud_pessoa_endereco.endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.endereco.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public CriarEnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
