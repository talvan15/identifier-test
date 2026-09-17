# Identifier — Testes Funcionais (JUnit 5)

Implementação dos testes automatizados do programa **Identifier**, seguindo os
casos de teste definidos.

## 📚 Documentação

- 📂 [Acessar documentação](./docs)

## Estrutura do projeto

```
identifier-project/
├── pom.xml
├── lib/
│   └── junit-platform-console-standalone-1.9.1.jar   (para rodar sem internet/Maven)
└── src/
    ├── main/java/testIdentifier/
    │   ├── Identifier.java        # lógica de validação (fornecida)
    │   └── IdentifierMain.java    # CLI (fornecida)
    └── test/java/testIdentifier/
        └── IdentifierTest.java    # suíte JUnit 5 (17 testes)
```

## Casos de teste cobertos

| # | Caso | Entrada | Esperado |
|---|------|---------|----------|
| TC1  | Identificador com 1 letra | `S` | Válido |
| TC2  | Somente letras | `model` | Válido |
| TC3  | Letras e dígitos | `p2p` | Válido |
| TC4  | 6 caracteres (limite sup. válido) | `abcdef` | Válido |
| TC5  | 7 caracteres (limite sup. inválido) | `abcdefg` | Inválido |
| TC6  | Identificador vazio (limite inf.) | `""` | Inválido |
| TC7  | Inicia com dígito | `100tidez` | Inválido |
| TC8  | Contém símbolo especial | `Te@st` | Inválido |
| TC9  | Contém espaço | `abc def` | Inválido |
| TC10 | Começa com espaço | `" 6seven"` | Inválido |
| TC11 | Muito grande | `stringmuitogrande` | Inválido |
| TC12 | Contém hífen | `abc-12` | Inválido |
| TC13 | Contém underscore | `abc_12` | Inválido |
| TC14 | Letras maiúsculas | `ABC123` | Válido |
| TC15 | 6 caracteres válidos | `a12345` | Válido |
| TC16 | Somente números | `123456` | Inválido |

Mais um teste extra de valor limite (0 caracteres), explicitando a análise de
valor limite.
## Como rodar

### Opção A — Com Maven (recomendado, requer internet na 1ª execução para baixar as dependências)

```bash
mvn test
```

### Opção B — Sem Maven, usando o jar incluído em `lib/`

```bash
# 1. Compilar o código de produção
javac -d target/classes src/main/java/testIdentifier/*.java

# 2. Compilar os testes contra o jar do JUnit 5 empacotado
javac -cp "target/classes:lib/junit-platform-console-standalone-1.9.1.jar" \
      -d target/test-classes src/test/java/testIdentifier/IdentifierTest.java

# 3. Executar a suíte
java -jar lib/junit-platform-console-standalone-1.9.1.jar execute \
     -cp target/classes:target/test-classes \
     --select-class testIdentifier.IdentifierTest \
     --details=tree
```

## Resultado obtido (validado nesta implementação)

```
[        17 tests found           ]
[        17 tests successful      ]
[         0 tests failed          ]
```

Todos os 17 casos passam nessa implementação.
