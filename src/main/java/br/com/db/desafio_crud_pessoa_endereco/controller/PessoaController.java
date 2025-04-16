package br.com.db.desafio_crud_pessoa_endereco.controller;

import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.service.BuscarPessoaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final BuscarPessoaService buscarPessoaService;

    public PessoaController(BuscarPessoaService buscarPessoaService) {
        this.buscarPessoaService = buscarPessoaService;
    }

    @GetMapping
    public List<Pessoa> buscarTodasPessoas(){
        return buscarPessoaService.buscarTodasPessoas();
    }

    @GetMapping(path = "/{id}")
    public Pessoa buscarPessoaPorId(@PathVariable(value = "id") Long id) {
        return buscarPessoaService.buscarPessoaPorId(id);
    }






}
