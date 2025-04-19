package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.CriarEnderecoRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "DTO para criação de uma nova pessoa")
public class CriarPessoaRequestDTO {
    @Schema(description = "Nome da pessoa", example = "João Silva", required = true)
    @NotBlank(message = "Nome não pode estar vazio.")
    @Size(min = 3, message = "Nome deve conter no mínimo 3 letras.")
    private String nome;

    @Schema(description = "CPF da pessoa (apenas números)", example = "12345678901", required = true)
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos, sem pontos ou traços.")
    private String cpf;

    @Schema(description = "Data de nascimento no formato dd/MM/yyyy", example = "01/01/1990", required = true)
    @NotNull(message = "Data de nascimento é obrigatória. Exemplo: 11/09/1999")
    @Past(message = "Data de nascimento deve ser anterior ao dia de hoje.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Schema(description = "Lista de endereços da pessoa", required = true)
    @NotEmpty(message = "Deve haver pelo menos um endereço.")
    private List<CriarEnderecoRequestDTO> enderecos;

    public CriarPessoaRequestDTO(String nome, String cpf, LocalDate dataNascimento, List<CriarEnderecoRequestDTO> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public List<CriarEnderecoRequestDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<CriarEnderecoRequestDTO> enderecos) {
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
