package br.com.db.desafio_crud_pessoa_endereco.endereco.dto;

import jakarta.validation.constraints.*;

public class CriarEnderecoRequestDTO {

    @NotBlank(message = "Rua não pode estar vazia.")
    private String rua;

    @NotBlank(message = "Número não pode estar vazio.")
    private String numero;

    @NotBlank(message = "Bairro não pode estar vazio.")
    private String bairro;

    @NotBlank(message = "Cidade não pode estar vazia.")
    private String cidade;

    @NotBlank(message = "Estado não pode estar vazio.")
    private String estado;

    @NotBlank(message = "CEP não pode estar vazio.")
    @Pattern(regexp = "\\d{8}", message = "CEP deve conter apenas 8 dígitos")
    private String cep;

    @NotNull(message = "Endereço principal é obrigatório.")
    private Boolean enderecoPrincipal;

    @NotNull(message = "ID da pessoa é obrigatório.")
    private Long pessoaId;

    public CriarEnderecoRequestDTO(String rua, String numero, String bairro, String cidade, String estado, String cep, Boolean enderecoPrincipal, Long pessoaId) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.enderecoPrincipal = enderecoPrincipal;
        this.pessoaId = pessoaId;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
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
