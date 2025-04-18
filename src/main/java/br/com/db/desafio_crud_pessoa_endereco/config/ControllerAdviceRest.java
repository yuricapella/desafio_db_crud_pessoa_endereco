package br.com.db.desafio_crud_pessoa_endereco.config;

import br.com.db.desafio_crud_pessoa_endereco.exception.EnderecoNaoEncontrado;
import br.com.db.desafio_crud_pessoa_endereco.exception.ErroCodigo;
import br.com.db.desafio_crud_pessoa_endereco.exception.ErroPadrao;
import br.com.db.desafio_crud_pessoa_endereco.exception.PessoaNaoEncontradaException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdviceRest {

    @ExceptionHandler({PessoaNaoEncontradaException.class})
    public ResponseEntity<ErroPadrao> handlerPessoaNaoEncontradaException(PessoaNaoEncontradaException ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setCodigoErro(ErroCodigo.PESSOA_NAO_ENCONTRADA.name());
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erroPadrao);
    }

    @ExceptionHandler({EnderecoNaoEncontrado.class})
    public ResponseEntity<ErroPadrao> handlerEnderecoNaoEncontradoException(EnderecoNaoEncontrado ex){
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setCodigoErro(ErroCodigo.ENDERECO_NAO_ENCONTRADO.name());
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(erroPadrao);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroPadrao> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setCodigoErro(ErroCodigo.CPF_DUPLICADO.name());
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem("CPF já cadastrado no sistema.");

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(erroPadrao);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErroPadrao> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setCodigoErro(ErroCodigo.CAMPO_INVALIDO.name());
        erroPadrao.setDataHora(LocalDateTime.now());
        erroPadrao.setMensagem(ex.getBody().getDetail());

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(erro -> {
            String campo = ((FieldError) erro).getField();
            String mensagemErroCampo = erro.getDefaultMessage();
            errors.put(campo, mensagemErroCampo);
        });
        erroPadrao.setErrors(errors);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erroPadrao);
    }



    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroPadrao> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        Throwable rootCause = ex.getCause();
        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setDataHora(LocalDateTime.now());

        if (rootCause instanceof InvalidFormatException invalidEx
                && LocalDate.class.equals(invalidEx.getTargetType())) {

            erroPadrao.setCodigoErro(ErroCodigo.DATA_INVALIDA.name());
            erroPadrao.setMensagem("Formato de data inválido. Utilize o padrão: 11/09/1999");

            Map<String, String> detalhes = Map.of(
                    invalidEx.getPath().get(0).getFieldName(),
                    "Data deve estar no formato dd/MM/yyyy"
            );
            erroPadrao.setErrors(detalhes);

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(erroPadrao);
        }

        erroPadrao.setCodigoErro(ErroCodigo.REQUISICAO_INVALIDA.name());
        erroPadrao.setMensagem("Não foi possível ler o JSON da requisição.");
        erroPadrao.setErrors(null);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(erroPadrao);
    }
}
