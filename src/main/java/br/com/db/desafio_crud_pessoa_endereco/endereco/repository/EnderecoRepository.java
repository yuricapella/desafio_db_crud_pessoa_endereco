package br.com.db.desafio_crud_pessoa_endereco.endereco.repository;

import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import br.com.db.desafio_crud_pessoa_endereco.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByPessoaAndEnderecoPrincipal(Pessoa pessoa, boolean enderecoPrincipal);
}
