package br.com.db.desafio_crud_pessoa_endereco.service;

import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletarPessoaService {
    private final PessoaRepository pessoaRepository;
    private final BuscarPessoaService buscarPessoaService;

    public DeletarPessoaService(PessoaRepository pessoaRepository, BuscarPessoaService buscarPessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.buscarPessoaService = buscarPessoaService;
    }

    public void deletarPessoaPorId(Long id){
        buscarPessoaService.buscarPessoaPorId(id);
        pessoaRepository.deleteById(id);
    }
}
