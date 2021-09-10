<img src="https://upload.wikimedia.org/wikipedia/commons/8/8a/Banco_Ita%C3%BA_logo.svg" height="60"> [Backend Challenge](https://www.itau.com.br/)
===============================================

# Índice
- [Introdução](#introdução)
- [Teste via Cloud](#teste-via-cloud)
  - [Exemplo de request](#exemplo-de-request)
  - [Exemplo de response para uma senha válida](#exemplo-de-response-para-uma-senha-válida)
  - [Exemplo de response para uma senha inválida](#exemplo-de-response-para-uma-senha-inválida)

# Introdução

Esse repositório tem como objetivo resolver o desafio proposto pelo processo seletivo do [Banco Itaú](https://www.itau.com.br/). Para saber mais detalhes sobre o desafio, acesse o link: [itidigital/backend-challenge](https://github.com/itidigital/backend-challenge)

A documentação técnica pode ser encontrada em: [Documentação Swagger](https://password-challenge.herokuapp.com/swagger-ui/)

# Teste via Cloud

Esta API foi hospedada no Cloud da [Heroku](https://www.heroku.com/) e pode ser acessada através do Host: https://password-challenge.herokuapp.com.

Os seguintes endpoints estão disponíveis:

Host | Endpoint | Método HTTP | Parâmetro | Ação
:--: | :--: | :--: | :--: | :--:
https://password-challenge.herokuapp.com | /password/validate | POST | A senha deve ser informada como parâmetro no body da requisição | Retorna se a senha informada é válida ou não. Se não for válida, informa também, uma lista de motivos

## Exemplo de request

```
curl -X POST "https://password-challenge.herokuapp.com/password/validate" -H "accept: */*" -H "Content-Type: application/json" -d "aaaa"
```

## Exemplo de response para uma senha válida

```
{
  "isValid": true
}
```

## Exemplo de response para uma senha inválida

```
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
