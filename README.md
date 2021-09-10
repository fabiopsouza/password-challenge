<img src="https://upload.wikimedia.org/wikipedia/commons/8/8a/Banco_Ita%C3%BA_logo.svg" height="60"> [Backend Challenge](https://www.itau.com.br/)
===============================================

# Índice
- [Introdução](#introdução)
- [Teste via Cloud](#teste-via-cloud)
  - [Exemplo de request](#exemplo-de-request)
  - [Exemplo de response para uma senha válida](#exemplo-de-response-para-uma-senha-válida)
  - [Exemplo de response para uma senha inválida](#exemplo-de-response-para-uma-senha-inválida)
- [Execução Local](#execução-local)
- [Decisões de Projeto](#decisões-de-projeto)
- [Premissas Extras](#premissas-extras)

# Introdução

Esse repositório tem como objetivo resolver o desafio proposto pelo processo seletivo do [Banco Itaú](https://www.itau.com.br/). Para saber mais detalhes sobre o desafio, acesse o link: [itidigital/backend-challenge](https://github.com/itidigital/backend-challenge).

A documentação técnica pode ser encontrada em: [Swagger Documentation](https://password-challenge.herokuapp.com/swagger-ui/).

# Teste via Cloud

Esta API foi hospedada no Cloud da [Heroku](https://www.heroku.com/) e pode ser acessada através do Host: https://password-challenge.herokuapp.com.

Os seguintes endpoints estão disponíveis:

Host | Endpoint | Método HTTP | Parâmetro | Ação
:--: | :--: | :--: | :--: | :--:
https://password-challenge.herokuapp.com | /password/validate | POST | A senha deve ser informada como parâmetro no body do request | Retorna se a senha informada é válida ou não. Se não for válida, informa também, uma lista de motivos

## Exemplo de request

```cmd
curl -X POST "https://password-challenge.herokuapp.com/password/validate" -H "accept: */*" -H "Content-Type: application/json" -d "aaaa"
```

## Exemplo de response para uma senha válida

```json
{
  "isValid": true
}
```

## Exemplo de response para uma senha inválida

```json
{
  "isValid": false,
  "reazons": [
    "At least 9 characters is required",
    "At least 1 digit is required",
    "At least 1 upper case letter is required",
    "At least 1 special character is required",
    "Repeated character is invalid"
  ]
}
```

> **_Nota:_**  Por se tratar de uma hosédagem gratuita, pode acontecer da primeira requisição demorar para responder devido a API estar em "idle". A partir da requisição seguinte a API já está no ar e passa a responder normalmente.

# Execução Local

A maneira mais simples de se executar esta aplicação localmente é através do [Maven](https://password-challenge.herokuapp.com/swagger-ui/). Para saber como instalar, acesse o link: [Manual de Instalação do Maven](https://maven.apache.org/install).

Com o [Maven](https://password-challenge.herokuapp.com/swagger-ui/) instalado, basta executar o comando, abaixo dentro da pasta raiz da aplicação:

```cmd
mvn spring-boot:run
```

# Decisões de Projeto

Por se tratar de um case relativamente pequeno, foi optado por uma solução simples e direta, sem adição de complexidades desnecessárias.

O core dessa aplicação está na classe `DefaultValidatorEngine` que recebe em seu construtor uma coleção a partir da configuração `ValidationConfig`. Essa coleção é composta por classes que implementam a interface `Validator`. A `DefaultValidatorEngine` roda todas os validators configurados e para cada erro encontrado adiciona o motivo na resposta.

Provavelmente seria possível validar todas as regras da senha em regex, por exemplo, mas foi optado pela separação que gera os seguintes benefícios:
- Permite o **desacoplamento** do código
- Atende o princípio da **coesão** pois cada validador fica responsável por uma regra
- Diminui a **complexidade** e facilita a **manutenção** pois cada ajuste é focado em uma única regra
- Melhora a **testabilidade** pois assim como a implementação, cada teste valida uma regra específica
- Em uma situação real, no caso de surgir a necessidade de mais performance, ou ser implementado validadores mais pesados, o desacoplamento permitiria rodar as validações em **paralelo** através de **Threads**.

# Premissas Extras

Apesar de não estar descrito explicitamente nos requisitos, foi incluído uma lista de motivos no caso de uma senha inválida. Pensando em um cenário real, essa informação poderia ser útil.
