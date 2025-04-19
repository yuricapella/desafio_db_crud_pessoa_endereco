package br.com.db.desafio_crud_pessoa_endereco.endereco.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de resposta com dados de um endereço")
public class EnderecoResponseDTO {
    @Schema(description = "Nome da rua", example = "Rua das Flores")
    private String rua;

    @Schema(description = "Número do endereço", example = "123")
    private String numero;

    @Schema(description = "Nome do bairro", example = "Centro")
    private String bairro;

    @Schema(description = "Nome da cidade", example = "São Paulo")
    private String cidade;

    @Schema(description = "Sigla do estado", example = "SP")
    private String estado;

    @Schema(description = "CEP do endereço", example = "12345678")
    private String cep;

    @Schema(description = "Indica se é o endereço principal", example = "true")
    private boolean enderecoPrincipal;


    public EnderecoResponseDTO() {
    }

    public EnderecoResponseDTO(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
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
}
