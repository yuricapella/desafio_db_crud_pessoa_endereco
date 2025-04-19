package br.com.db.desafio_crud_pessoa_endereco.pessoa.dto;

import br.com.db.desafio_crud_pessoa_endereco.endereco.dto.EnderecoResponseDTO;
import br.com.db.desafio_crud_pessoa_endereco.util.FormataCPF;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "DTO de resposta com dados de uma pessoa")
public class PessoaResponseDTO {
    @Schema(description = "Nome da pessoa", example = "João Silva")
    private String nome;

    @Schema(description = "CPF da pessoa formatado", example = "123.456.789-01")
    private String cpf;

    @Schema(description = "Data de nascimento", example = "01/01/1990")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @Schema(description = "Idade calculada da pessoa", example = "33")
    private int idade;

    @Schema(description = "Lista de endereços da pessoa")
    private List<EnderecoResponseDTO> enderecos;

    public PessoaResponseDTO(String nome, String cpf, LocalDate dataNascimento, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
    }

    public PessoaResponseDTO() {
    }


    public List<EnderecoResponseDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoResponseDTO> enderecos) {
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return FormataCPF.formatar(this.cpf);
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
