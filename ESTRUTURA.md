```
├── .gitattributes
├── .gitignore
├── .mvn
    └── wrapper
    │   └── maven-wrapper.properties
├── ANOTACOES.md
├── README.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
        ├── java
        │   └── br
        │   │   └── com
        │   │       └── db
        │   │           └── desafio_crud_pessoa_endereco
        │   │               ├── DesafioCrudPessoaEnderecoApplication.java
        │   │               ├── config
        │   │                   └── ControllerAdviceRest.java
        │   │               ├── endereco
        │   │                   ├── controller
        │   │                   │   └── EnderecoController.java
        │   │                   ├── dto
        │   │                   │   ├── AtualizarEnderecoRequestDTO.java
        │   │                   │   ├── CriarEnderecoRequestDTO.java
        │   │                   │   ├── EnderecoResponseDTO.java
        │   │                   │   └── mapper
        │   │                   │   │   ├── AtualizarEnderecoRequestMapper.java
        │   │                   │   │   ├── CriarEnderecoRequestMapper.java
        │   │                   │   │   └── EnderecoResponseMapper.java
        │   │                   ├── model
        │   │                   │   └── Endereco.java
        │   │                   ├── repository
        │   │                   │   └── EnderecoRepository.java
        │   │                   ├── service
        │   │                   │   ├── AtualizarEnderecoService.java
        │   │                   │   ├── BuscarEnderecoService.java
        │   │                   │   ├── CriarEnderecoService.java
        │   │                   │   └── DeletarEnderecoService.java
        │   │                   └── validator
        │   │                   │   └── EnderecoValidator.java
        │   │               ├── exception
        │   │                   ├── EnderecoNaoEncontrado.java
        │   │                   ├── ErroCodigo.java
        │   │                   ├── ErroPadrao.java
        │   │                   └── PessoaNaoEncontradaException.java
        │   │               ├── pessoa
        │   │                   ├── controller
        │   │                   │   └── PessoaController.java
        │   │                   ├── dto
        │   │                   │   ├── AtualizarPessoaRequestDTO.java
        │   │                   │   ├── CriarPessoaRequestDTO.java
        │   │                   │   ├── PessoaResponseDTO.java
        │   │                   │   └── mapper
        │   │                   │   │   ├── AtualizarPessoaRequestMapper.java
        │   │                   │   │   ├── CriarPessoaRequestMapper.java
        │   │                   │   │   └── PessoaResponseMapper.java
        │   │                   ├── model
        │   │                   │   └── Pessoa.java
        │   │                   ├── repository
        │   │                   │   └── PessoaRepository.java
        │   │                   ├── service
        │   │                   │   ├── AtualizarPessoaService.java
        │   │                   │   ├── BuscarPessoaService.java
        │   │                   │   ├── CriarPessoaService.java
        │   │                   │   └── DeletarPessoaService.java
        │   │                   └── validator
        │   │                   │   └── PessoaValidator.java
        │   │               ├── postman
        │   │                   └── desafio-crud-db.postman_collection.json
        │   │               └── util
        │   │                   ├── FormataCPF.java
        │   │                   └── FormataData.java
        └── resources
        │   ├── application.properties
        │   └── data.sql
    └── test
        └── java
            └── br
                └── com
                    └── db
                        └── desafio_crud_pessoa_endereco
                            └── DesafioCrudPessoaEnderecoApplicationTests.java

```
