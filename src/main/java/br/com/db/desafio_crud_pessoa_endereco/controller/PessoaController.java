package br.com.db.desafio_crud_pessoa_endereco.controller;

import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.service.BuscarPessoaService;
import br.com.db.desafio_crud_pessoa_endereco.service.DeletarPessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final BuscarPessoaService buscarPessoaService;
    private final DeletarPessoaService deletarPessoaService;

    public PessoaController(BuscarPessoaService buscarPessoaService, DeletarPessoaService deletarPessoaService) {
        this.buscarPessoaService = buscarPessoaService;
        this.deletarPessoaService = deletarPessoaService;
    }

    @GetMapping
    public List<Pessoa> buscarTodasPessoas(){
        return buscarPessoaService.buscarTodasPessoas();
    }

    @GetMapping(path = "/{id}")
    public Pessoa buscarPessoaPorId(@PathVariable(value = "id") Long id) {
        return buscarPessoaService.buscarPessoaPorId(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoaPorId(@PathVariable(value = "id") Long id) {
        deletarPessoaService.deletarPessoaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }







}
