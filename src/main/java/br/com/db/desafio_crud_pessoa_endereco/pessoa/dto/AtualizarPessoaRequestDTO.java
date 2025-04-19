package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "DTO para atualização de uma pessoa existente")
public class AtualizarPessoaRequestDTO {
    @Schema(description = "Nome da pessoa", example = "João Silva", required = true)
    @NotBlank(message = "Nome não pode estar vazio.")
    @Size(min = 3, message = "Nome deve conter no mínimo 3 letras.")
    private String nome;

    @Schema(description = "CPF da pessoa (apenas números)", example = "12345678901", required = true)
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos, sem pontos ou traços.")
    private String cpf;

    @Schema(description = "Data de nascimento no formato dd/MM/yyyy", example = "01/01/1990", required = true)
    @NotNull(message = "Data de nascimento é obrigatória.")
    @Past(message = "Data de nascimento deve ser anterior ao dia de hoje.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public AtualizarPessoaRequestDTO() {
    }

    public AtualizarPessoaRequestDTO(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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
