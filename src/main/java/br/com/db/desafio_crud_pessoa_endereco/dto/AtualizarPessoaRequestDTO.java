package br.com.db.desafio_crud_pessoa_endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class AtualizarPessoaRequestDTO {
    @NotBlank(message = "Nome não pode estar vazio.")
    @Size(min = 3, message = "Nome deve conter no mínimo 3 letras.")
    private String nome;

    @CPF(message = "Cpf está fora do padrão (11 dígitos). Exemplo: 000.000.000-00")
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória.")
    @Past(message = "Data de nascimento deve ser anterior ao dia de hoje.")
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
