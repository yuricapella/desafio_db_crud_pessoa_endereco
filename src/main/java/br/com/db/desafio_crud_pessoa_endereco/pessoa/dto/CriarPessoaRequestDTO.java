package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.CriarEnderecoRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

public class CriarPessoaRequestDTO {
    @NotBlank(message = "Nome não pode estar vazio.")
    @Size(min = 3, message = "Nome deve conter no mínimo 3 letras.")
    private String nome;

    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos, sem pontos ou traços.")
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória.")
    @Past(message = "Data de nascimento deve ser anterior ao dia de hoje.")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

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
