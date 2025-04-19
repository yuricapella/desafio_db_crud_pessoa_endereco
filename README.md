<a id="voltar-ao-topo"></a>
# 🧠 Projeto CRUD Pessoa e Endereço

## 💼 Desafio da Empresa

Este projeto foi desenvolvido como parte do programa **DB | CRESCER com propósito!** — Programa de Capacitação exclusivo para **PCDs**. O objetivo foi aplicar os conhecimentos práticos de Java e Spring Boot em um desafio real de construção de uma API RESTful com foco em boas práticas e qualidade de código.

---

## 🎯 Objetivo

Implementar uma API REST em Java usando **Spring Boot** que realize o CRUD completo para as entidades **Pessoa** e **Endereço**, com relacionamento **1:N (um-para-muitos)**, tratamento de exceções, validações e retorno em formato JSON.

---

## 📚 Funcionalidades

- Criar uma **Pessoa** com um ou mais **Endereços**
- Atualizar dados da pessoa e/ou de seus endereços
- Listar todas as pessoas com seus endereços
- Excluir uma pessoa e todos os seus endereços
- Mostrar a **idade** da pessoa com base na data de nascimento
- Definir qual é o **endereço principal**
- Tratamento global de exceções
- Validações básicas com Bean Validation
- Respostas padronizadas em JSON
- Banco de dados **H2** em memória
- Testes com **Postman** (collection inclusa no projeto)

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
- Java Bean Validation
- MapStruct

---

## 🧪 Testes

A collection do Postman cobre:

- ✅ **Casos de sucesso** (CRUD completo)
- ❌ **Casos de erro** (validações, dados inválidos, não encontrados)

Organizados por entidade (`Pessoa`, `Endereço`) e separados em pastas de **sucesso** e **erro**, garantindo cobertura dos principais cenários de teste.

📂 Acesse a collection no repositório:  
[🔗 Collection Postman](https://github.com/yuricapella/desafio_db_crud_pessoa_endereco/tree/main/src/main/java/br/com/db/desafio_crud_pessoa_endereco/postman)

---

## 🗂️ Arquivos Adicionais

### 🔹 [`ESTRUTURA.md`](./ESTRUTURA.md)
Contém a explicação das camadas do projeto, separação de DTOs, Mappers, Models, Services e Controllers, além do padrão adotado.

### 🔹 [`ANOTACOES.md`](./ANOTACOES.md)
Anotações pessoais e técnicas que apontam:
- Decisões tomadas durante o desenvolvimento
- Possíveis melhorias futuras (ex: utilização dos Validators criados)
- Dicas sobre boas práticas
- Motivos pelos quais algumas ideias não foram implementadas

### 🔹 [`DESAFIO.md`](./DESAFIO.md)
Documentação do desafio, incluindo os requisitos, pontos a serem avaliados e diferenciais.

---

## ✅ Requisitos Atendidos

| Implementado                                                     | Status |
|------------------------------------------------------------------|--------|
| Listar todas as pessoas e seus respectivos endereços             | ✅     |
| Criar uma nova pessoa com um ou mais endereços                   | ✅     |
| Atualizar os dados de uma pessoa e/ou seu(s) endereço(s)         | ✅     |
| Excluir uma pessoa e todos os seus endereços                     | ✅     |
| Mostrar a idade da pessoa                                        | ✅     |
| Implementar validações básicas para campos obrigatórios          | ✅     |
| Tratar exceções com @ControllerAdvice                            | ✅     |
| Banco de dados H2                                                | ✅     |
| Respostas JSON                                                   | ✅     |
| Boas práticas e arquitetura                                      | ✅     |
| Testes com Postman                                               | ✅     |

---

## 🌟 Diferenciais

| Diferencial                                       | Status |
|--------------------------------------------------|--------|
| Informar qual endereço é o principal             | ✅     |
| Swagger                                          | ✅     |
| Paginação                                        | ✅     |
| Teste de Integração                              | ❌     |

---

Feito com dedicação 💙 no desafio da **DB**.

[🔝 Voltar ao topo](#voltar-ao-topo)
