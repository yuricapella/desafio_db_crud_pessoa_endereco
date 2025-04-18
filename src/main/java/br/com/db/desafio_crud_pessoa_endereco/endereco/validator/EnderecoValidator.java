package br.com.db.desafio_crud_pessoa_endereco.endereco.validator;

import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.service.BuscarPessoaService;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EnderecoValidator {

    private final BuscarPessoaService buscarPessoaService;
    private static final Pattern NUMERO_PATTERN = Pattern.compile("\\d+[A-Za-z]?");
    private static final Pattern ESTADO_PATTERN = Pattern.compile("[A-Za-z]{2}");
    private static final Pattern CEP_PATTERN = Pattern.compile("\\d{8}");

    public EnderecoValidator(BuscarPessoaService buscarPessoaService) {
        this.buscarPessoaService = buscarPessoaService;
    }

    public void validarEndereco(Endereco endereco, boolean isUpdate) {
        if (!isUpdate) {
            Long pessoaId = endereco.getPessoa() != null ? endereco.getPessoa().getId() : null;
            if (pessoaId == null) {
                throw new IllegalArgumentException("ID da pessoa é obrigatório.");
            }
            buscarPessoaService.buscarPessoaPorId(pessoaId);
        }

        if (endereco.getRua() == null || endereco.getRua().isBlank()) {
            throw new IllegalArgumentException("Rua não pode estar vazia.");
        }
        if (endereco.getRua().length() < 3 || endereco.getRua().length() > 100) {
            throw new IllegalArgumentException("Rua deve conter entre 3 e 100 caracteres.");
        }

        if (endereco.getNumero() == null || endereco.getNumero().isBlank()) {
            throw new IllegalArgumentException("Número não pode estar vazio.");
        }
        if (endereco.getNumero().isEmpty() || endereco.getNumero().length() > 10) {
            throw new IllegalArgumentException("Número deve conter entre 1 e 10 caracteres.");
        }
        if (!NUMERO_PATTERN.matcher(endereco.getNumero()).matches()) {
            throw new IllegalArgumentException("Número deve conter apenas dígitos e opcionalmente letra (ex: 123 ou 123A).");
        }

        if (endereco.getBairro() == null || endereco.getBairro().isBlank()) {
            throw new IllegalArgumentException("Bairro não pode estar vazio.");
        }
        if (endereco.getBairro().length() < 3 || endereco.getBairro().length() > 50) {
            throw new IllegalArgumentException("Bairro deve conter entre 3 e 50 caracteres.");
        }

        if (endereco.getCidade() == null || endereco.getCidade().isBlank()) {
            throw new IllegalArgumentException("Cidade não pode estar vazia.");
        }
        if (endereco.getCidade().length() < 3 || endereco.getCidade().length() > 50) {
            throw new IllegalArgumentException("Cidade deve conter entre 3 e 50 caracteres.");
        }

        if (endereco.getEstado() == null || endereco.getEstado().isBlank()) {
            throw new IllegalArgumentException("Estado não pode estar vazio.");
        }
        if (!ESTADO_PATTERN.matcher(endereco.getEstado()).matches()) {
            throw new IllegalArgumentException("Estado deve conter exatamente 2 letras.");
        }

        if (endereco.getCep() == null || endereco.getCep().isBlank()) {
            throw new IllegalArgumentException("CEP não pode estar vazio.");
        }
        if (!CEP_PATTERN.matcher(endereco.getCep()).matches()) {
            throw new IllegalArgumentException("CEP deve conter exatamente 8 números, sem traços.");
        }
    }
}
