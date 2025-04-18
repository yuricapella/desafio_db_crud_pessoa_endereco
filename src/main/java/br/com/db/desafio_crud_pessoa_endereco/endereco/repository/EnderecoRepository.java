package br.com.db.desafio_crud_pessoa_endereco.endereco.repository;

import br.com.db.desafio_crud_pessoa_endereco.endereco.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
