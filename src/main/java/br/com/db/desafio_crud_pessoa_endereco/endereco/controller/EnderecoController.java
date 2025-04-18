package br.com.db.desafio_crud_pessoa_endereco.endereco.controller;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.AtualizarEnderecoRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.CriarEnderecoRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.EnderecoDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.CriarEnderecoRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.AtualizarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.BuscarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.CriarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.DeletarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final BuscarEnderecoService buscarEnderecoService;
    private final DeletarEnderecoService deletarEnderecoService;
    private final CriarEnderecoService criarEnderecoService;
    private final AtualizarEnderecoService atualizarEnderecoService;
    private final PessoaRepository pessoaRepository;

    public EnderecoController(BuscarEnderecoService buscarEnderecoService, DeletarEnderecoService deletarEnderecoService, CriarEnderecoService criarEnderecoService, AtualizarEnderecoService atualizarEnderecoService, PessoaRepository pessoaRepository) {
        this.buscarEnderecoService = buscarEnderecoService;
        this.deletarEnderecoService = deletarEnderecoService;
        this.criarEnderecoService = criarEnderecoService;
        this.atualizarEnderecoService = atualizarEnderecoService;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping
    public List<EnderecoDTO> buscarTodosEnderecos() {
        return buscarEnderecoService.buscarTodosEnderecos();
    }

    @GetMapping(path = "/{id}")
    public Endereco buscarEnderecoPorId(@PathVariable(value = "id") Long id) {
        return buscarEnderecoService.buscarEnderecoPorId(id);
    }

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody @Valid CriarEnderecoRequestDTO endereco) {
        Pessoa pessoa = pessoaRepository.findById(endereco.getPessoaId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        Endereco enderecoEntity = CriarEnderecoRequestMapper.toEntity(endereco, pessoa);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criarEnderecoService.criarEndereco(enderecoEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEnderecoPorId(@PathVariable(value = "id") Long id,
                                                           @RequestBody @Valid AtualizarEnderecoRequestDTO endereco) {
        atualizarEnderecoService.atualizarEnderecoPorId(endereco, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnderecoPorId(@PathVariable(value = "id") Long id) {
        deletarEnderecoService.deletarEnderecoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
