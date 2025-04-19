package br.com.db.desafio_crud_pessoa_endereco.endereco.controller;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.AtualizarEnderecoRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.CriarEnderecoRequestDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.EnderecoResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.mapper.CriarEnderecoRequestMapper;
import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.AtualizarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.BuscarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.CriarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.endereco.service.DeletarEnderecoService;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.dto.PessoaResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.repository.PessoaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereço", description = "Operações relacionadas ao gerenciamento de endereços")
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
    @Operation(
            summary = "Buscar todos os endereços",
            description = "Recupera uma lista paginada de endereços. É possível definir a página, tamanho e ordenação.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Endereços encontrados com sucesso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Page<EnderecoResponseDTO>> buscarTodosEnderecos(
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sort", defaultValue = "cep") String sort) {

        Page<EnderecoResponseDTO> enderecos = buscarEnderecoService.buscarTodosEnderecos(page, size, sort);
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping(path = "/{id}")
    @Operation(
            summary = "Buscar endereço por ID",
            description = "Recupera um endereço específico pelo seu ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public Endereco buscarEnderecoPorId(@PathVariable(value = "id") Long id) {
        return buscarEnderecoService.buscarEnderecoPorId(id);
    }

    @PostMapping
    @Operation(
            summary = "Criar novo endereço",
            description = "Cria um novo endereço associado a uma pessoa existente.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Endereco> criarEndereco(@RequestBody @Valid CriarEnderecoRequestDTO endereco) {
        Pessoa pessoa = pessoaRepository.findById(endereco.getPessoaId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        Endereco enderecoEntity = CriarEnderecoRequestMapper.toEntity(endereco, pessoa);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(criarEnderecoService.criarEndereco(enderecoEntity));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar endereço",
            description = "Atualiza os dados de um endereço existente pelo seu ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos"),
                    @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Endereco> atualizarEnderecoPorId(@PathVariable(value = "id") Long id,
                                                           @RequestBody @Valid AtualizarEnderecoRequestDTO endereco) {
        atualizarEnderecoService.atualizarEnderecoPorId(endereco, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar endereço",
            description = "Remove um endereço pelo ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Endereço removido com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Endereço não encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    public ResponseEntity<Void> deletarEnderecoPorId(@PathVariable(value = "id") Long id) {
        deletarEnderecoService.deletarEnderecoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
