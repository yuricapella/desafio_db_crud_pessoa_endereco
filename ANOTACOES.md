# 🗒️ Anotações do Projeto

## 📅 Formato de Datas
- Utilizado `@JsonFormat(pattern = "dd/MM/yyyy")` para exibir a data no Postman de forma amigável.
- No banco de dados, o formato permanece padrão (`LocalDate`, `LocalDateTime`).

## 📌 Validação de CPF
- Substituída a anotação `@CPF` por uma validação simples.
- Motivo: a anotação `@CPF` exige CPFs válidos, o que torna os testes repetitivos e cansativos.
- Além disso, havia inconsistências entre formatos `000.000.000-00` e `00000000000`, o que permitia duplicatas.
- Com a nova abordagem, é feita uma padronização interna e validação customizada.

## 🔒 Melhorias futuras de segurança
- Adicionar validações para impedir endereços duplicados para a mesma pessoa.
- Resgatar o uso da anotação `@CPF` com tratamento adequado.
- Impedir exclusão de todos os endereços de uma pessoa, mantendo ao menos um.

## 🌟 Diferenciais não implementados
- Garantir que apenas um endereço seja o principal por pessoa.
- Atualmente, é possível cadastrar múltiplos endereços com `enderecoPrincipal = true`.
- A lógica foi iniciada, mas não concluída por falta de tempo.

## 📆 Armazenamento de Datas
- Ainda em dúvida sobre o padrão ideal: armazenar como `String` e validar manualmente ou manter como `LocalDate`.
- Atualmente, utiliza-se `LocalDate` com captura de exceções.
- Um `HttpMessageNotReadableException` genérico é tratado via `if` para mostrar ao usuário o padrão correto de data (`dd/MM/yyyy`).
- Futuramente, refatorar para tratamento mais robusto e elegante.

## 🧪 Validações na Service
- Foram criadas as classes `PessoaValidator` e `EnderecoValidator`.
- Tentou-se validar regras de negócio nas Services.
- Contudo, isso interferiu no tratamento de exceções pelo `ControllerAdvice`, fazendo erros validados caírem como erro 500.
- As classes foram mantidas no projeto, mas desativadas temporariamente para evitar conflito.
