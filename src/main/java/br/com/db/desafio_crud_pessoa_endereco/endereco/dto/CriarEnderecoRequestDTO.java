package br.com.db.desafio_crud_pessoa_endereco.endereco.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "DTO para criação de um novo endereço")
public class CriarEnderecoRequestDTO {

    @Schema(description = "Nome da rua", example = "Rua das Flores", required = true)
    @NotBlank(message = "Rua não pode estar vazia.")
    @Size(min = 3, max = 100, message = "Rua deve conter entre 3 e 100 caracteres.")
    private String rua;

    @Schema(description = "Número do endereço", example = "123", required = true)
    @NotBlank(message = "Número não pode estar vazio.")
    @Size(min = 1, max = 10, message = "Número deve conter entre 1 e 10 caracteres.")
    @Pattern(regexp = "\\d+[A-Za-z]?", message = "Número deve conter apenas dígitos e, opcionalmente, uma letra (ex: 123 ou 123A).")
    private String numero;

    @Schema(description = "Nome do bairro", example = "Centro", required = true)
    @NotBlank(message = "Bairro não pode estar vazio.")
    @Size(min = 3, max = 50, message = "Bairro deve conter entre 3 e 50 caracteres.")
    private String bairro;

    @Schema(description = "Nome da cidade", example = "São Paulo", required = true)
    @NotBlank(message = "Cidade não pode estar vazia.")
    @Size(min = 3, max = 50, message = "Cidade deve conter entre 3 e 50 caracteres.")
    private String cidade;

    @Schema(description = "Sigla do estado com 2 letras", example = "SP", required = true)
    @NotBlank(message = "Estado não pode estar vazio.")
    @Pattern(regexp = "[A-Za-z]{2}", message = "Estado deve conter exatamente 2 letras.")
    private String estado;

    @Schema(description = "CEP sem traços (apenas números)", example = "12345678", required = true)
    @NotBlank(message = "CEP não pode estar vazio.")
    @Pattern(regexp = "\\d{8}", message = "CEP deve conter exatamente 8 números, sem traços.")
    private String cep;

    @Schema(description = "Indica se este é o endereço principal", example = "true", required = true)
    @NotNull(message = "Endereço principal é obrigatório.")
    private Boolean enderecoPrincipal;

    @Schema(description = "ID da pessoa associada ao endereço", example = "1", required = true)
    @NotNull(message = "ID da pessoa é obrigatório.")
    @Positive(message = "ID da pessoa deve ser um número positivo.")
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
