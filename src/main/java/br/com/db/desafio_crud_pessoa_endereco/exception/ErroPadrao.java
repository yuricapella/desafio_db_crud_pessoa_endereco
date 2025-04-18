package br.com.db.desafio_crud_pessoa_endereco.exception;

import br.com.db.desafio_crud_pessoa_endereco.util.FormataData;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Map;

public class ErroPadrao {
    private String codigoErro;
    @JsonFormat(pattern = FormataData.PADRAO_DATA_HORA)
    private LocalDateTime dataHora;
    private String mensagem;
    private Map<String, String> errors;

    public String getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(String codigoErro) {
        this.codigoErro = codigoErro;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
