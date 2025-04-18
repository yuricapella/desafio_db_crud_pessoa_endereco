package br.com.db.desafio_crud_pessoa_endereco.exception;

public class PessoaNaoEncontradaException extends RuntimeException {
    public PessoaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
