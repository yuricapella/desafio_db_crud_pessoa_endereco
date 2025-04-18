package br.com.db.desafio_crud_pessoa_endereco.endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AtualizarEnderecoRequestDTO {

    @NotBlank(message = "Rua não pode estar vazia.")
    @Size(min = 3, max = 100, message = "Rua deve conter entre 3 e 100 caracteres.")
    private String rua;

    @NotBlank(message = "Número não pode estar vazio.")
    @Size(min = 1, max = 10, message = "Número deve conter entre 1 e 10 caracteres.")
    @Pattern(regexp = "\\d+[A-Za-z]?", message = "Número deve conter apenas dígitos e, opcionalmente, uma letra (ex: 123 ou 123A).")
    private String numero;

    @NotBlank(message = "Bairro não pode estar vazio.")
    @Size(min = 3, max = 50, message = "Bairro deve conter entre 3 e 50 caracteres.")
    private String bairro;

    @NotBlank(message = "Cidade não pode estar vazia.")
    @Size(min = 3, max = 50, message = "Cidade deve conter entre 3 e 50 caracteres.")
    private String cidade;

    @NotBlank(message = "Estado não pode estar vazio.")
    @Pattern(regexp = "[A-Za-z]{2}", message = "Estado deve conter exatamente 2 letras.")
    private String estado;

    @NotBlank(message = "CEP não pode estar vazio.")
    @Pattern(regexp = "\\d{8}", message = "CEP deve conter exatamente 8 números, sem traços.")
    private String cep;

    @NotNull(message = "Endereço principal é obrigatório.")
    private Boolean enderecoPrincipal;

    public AtualizarEnderecoRequestDTO() {
    }

    public AtualizarEnderecoRequestDTO(String rua, String numero, String bairro, String cidade, String estado, String cep, Boolean enderecoPrincipal) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }
}
