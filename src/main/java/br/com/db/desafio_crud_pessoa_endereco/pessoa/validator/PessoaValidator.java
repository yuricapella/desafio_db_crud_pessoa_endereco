package br.com.db.desafio_crud_pessoa_endereco.pessoa.validator;

import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.repository.PessoaRepository;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.service.BuscarPessoaService;
import org.springframework.stereotype.Component;

@Component
public class PessoaValidator {

    private final BuscarPessoaService buscarPessoaService;
    private final PessoaRepository pessoaRepository;

    public PessoaValidator(BuscarPessoaService buscarPessoaService, PessoaRepository pessoaRepository) {
        this.buscarPessoaService = buscarPessoaService;
        this.pessoaRepository = pessoaRepository;
    }

    public void validarPessoa(Pessoa pessoa, boolean isUpdate) {
        if (pessoa.getCpf() == null || pessoa.getCpf().isBlank()) {
            throw new IllegalArgumentException("CPF não pode estar vazio.");
        }

        if (!pessoa.getCpf().matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos, sem pontos ou traços.");
        }

        if (!isUpdate && pessoaRepository.existsByCpf(pessoa.getCpf())) {
            throw new IllegalArgumentException("Já existe uma pessoa com esse CPF.");
        }

        if (isUpdate) {
            Pessoa pessoaOriginal = buscarPessoaService.buscarPessoaPorId(pessoa.getId());

            if (!pessoa.getCpf().equals(pessoaOriginal.getCpf())) {
                throw new IllegalArgumentException("Não é permitido alterar o CPF.");
            }
        }

        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar vazio.");
        }

        if (pessoa.getNome().length() < 3) {
            throw new IllegalArgumentException("Nome deve conter no mínimo 3 caracteres.");
        }

        if (pessoa.getDataNascimento() == null) {
            throw new IllegalArgumentException("Data de nascimento é obrigatória.");
        }

        if (pessoa.getDataNascimento().isAfter(java.time.LocalDate.now())) {
            throw new IllegalArgumentException("A data de nascimento não pode ser no futuro.");
        }
    }
}


