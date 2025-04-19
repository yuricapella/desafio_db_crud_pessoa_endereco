package br.com.db.desafio_crud_pessoa_endereco.pessoa.controller;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.AtualizarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.CriarPessoaRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.PessoaResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.mapper.CriarPessoaRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.service.AtualizarPessoaService;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.service.BuscarPessoaService;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.service.CriarPessoaService;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.service.DeletarPessoaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<Page<PessoaResponseDTO>> buscarTodasPessoas(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "nome") String sort) {

        Page<PessoaResponseDTO> pessoas = buscarPessoaService.buscarTodasPessoas(page, size, sort);
        return ResponseEntity.ok(pessoas);
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
                                                       @RequestBody @Valid AtualizarPessoaRequestDTO pessoa){
        atualizarPessoaService.atualizarPessoaPorId(pessoa,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoaPorId(@PathVariable(value = "id") Long id) {
        deletarPessoaService.deletarPessoaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
