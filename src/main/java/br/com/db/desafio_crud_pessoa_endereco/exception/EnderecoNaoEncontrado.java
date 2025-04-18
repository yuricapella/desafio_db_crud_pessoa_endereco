package br.com.db.desafio_crud_pessoa_endereco.exception;

public class EnderecoNaoEncontrado extends RuntimeException {
    public EnderecoNaoEncontrado(String message) {
        super(message);
    }
}
