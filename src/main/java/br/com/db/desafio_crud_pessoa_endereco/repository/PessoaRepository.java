package br.com.db.desafio_crud_pessoa_endereco.repository;

import br.com.db.desafio_crud_pessoa_endereco.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
