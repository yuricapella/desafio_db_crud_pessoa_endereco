package br.com.db.desafio_crud_pessoa_endereco.dto;

import java.time.LocalDate;

public class PessoaDTO {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private int idade;

    public PessoaDTO(String nome, String cpf, LocalDate dataNascimento, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    public PessoaDTO() {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
