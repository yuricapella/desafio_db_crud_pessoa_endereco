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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
@Tag(name = "Pessoa", description = "Operações relacionadas ao gerenciamento de pessoas")
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
    @Operation(
            summary = "Buscar todas as pessoas",
            description = "Recupera uma lista paginada de pessoas. É possível definir a página, tamanho e ordenação.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pessoas encontradas com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Page<PessoaResponseDTO>> buscarTodasPessoas(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "nome") String sort) {

        Page<PessoaResponseDTO> pessoas = buscarPessoaService.buscarTodasPessoas(page, size, sort);
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Buscar pessoa por ID",
            description = "Recupera uma pessoa específica pelo seu ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pessoa encontrada com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public Pessoa buscarPessoaPorId(@PathVariable(value = "id") Long id) {
        return buscarPessoaService.buscarPessoaPorId(id);
    }

    @PostMapping
    @Operation(
            summary = "Criar nova pessoa",
            description = "Cria uma nova pessoa com seus endereços associados.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Pessoa criada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody @Valid CriarPessoaRequestDTO pessoa){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criarPessoaService.criarPessoa(CriarPessoaRequestMapper.toEntity(pessoa)));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar pessoa",
            description = "Atualiza os dados de uma pessoa existente pelo seu ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Pessoa> atualizarPessoaPorId(@PathVariable(value = "id") Long id,
                                                       @RequestBody @Valid AtualizarPessoaRequestDTO pessoa){
        atualizarPessoaService.atualizarPessoaPorId(pessoa,id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar pessoa",
            description = "Remove uma pessoa e seus endereços associados pelo ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Pessoa removida com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Void> deletarPessoaPorId(@PathVariable(value = "id") Long id) {
        deletarPessoaService.deletarPessoaPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
