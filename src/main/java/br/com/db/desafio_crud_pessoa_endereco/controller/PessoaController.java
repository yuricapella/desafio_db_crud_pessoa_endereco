package br.com.db.desafio_crud_pessoa_endereco.controller;

import br.com.db.desafio_crud_pessoa_endereco.dto.AtualizarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.dto.CriarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.dto.PessoaDTO;
import br.com.db.desafio_crud_pessoa_endereco.dto.mapper.CriarPessoaRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.service.AtualizarPessoaService;
import br.com.db.desafio_crud_pessoa_endereco.service.BuscarPessoaService;
import br.com.db.desafio_crud_pessoa_endereco.service.CriarPessoaService;
import br.com.db.desafio_crud_pessoa_endereco.service.DeletarPessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final BuscarPessoaService buscarPessoaService;
    private final DeletarPessoaService deletarPessoaService;
    private final CriarPessoaService criarPessoaService;
    private final AtualizarPessoaService atualizarPessoaService;

    public PessoaController(BuscarPessoaService buscarPessoaService, DeletarPessoaService deletarPessoaService, CriarPessoaService criarPessoaService, AtualizarPessoaService atualizarPessoaService) {
        this.buscarPessoaService = buscarPessoaService;
        this.deletarPessoaService = deletarPessoaService;
        this.criarPessoaService = criarPessoaService;
        this.atualizarPessoaService = atualizarPessoaService;
    }

    @GetMapping
    public List<PessoaDTO> buscarTodasPessoas(){
        return buscarPessoaService.buscarTodasPessoas();
    }

    @GetMapping(path = "/{id}")
    public Pessoa buscarPessoaPorId(@PathVariable(value = "id") Long id) {
        return buscarPessoaService.buscarPessoaPorId(id);
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody @Valid CriarPessoaRequestDTO pessoa){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criarPessoaService.criarPessoa(CriarPessoaRequestMapper.toEntity(pessoa)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoaPorId(@PathVariable(value = "id") Long id,
                                                       @RequestBody AtualizarPessoaRequestDTO pessoa){
        atualizarPessoaService.atualizarPessoaPorId(pessoa,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoaPorId(@PathVariable(value = "id") Long id) {
        deletarPessoaService.deletarPessoaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
