# BDS04

Projeto proposto para avaliação de conhecimento do capítulo de validação e segurança do bootcamp Spring da escola Dev Superior.

## Como funciona?

Consiste em uma aplicação que disponibilida uma interface de cadastro de cidades, e vinculada as cidades é possível criar eventos. Todas operações são mediantes permissões de acordo com o perfil de cada usuário.

## Requisitos

- Java 11;
- Spring Boot 2.4.4;
- Spring OAuth2;
- Spring Security;
- H2 Database.

## Perfis para uso

- CLIENT;
- ADMIN.

## Endpoints

User - POST

Rota -> /oauth/token

### Request

Informar os campos abaixo no corpo da requisição:

![image](https://user-images.githubusercontent.com/76541826/220984042-137f0ef6-9b0b-41fe-b86f-6438fb1981a0.png)

### Response

~~~
Http Status 200
~~~

City - POST

Rota -> /cities

### Request

Informar o Json abaixo com o nome da cidade a ser cadastrada:

~~~
{
    "name": "New city"
}
~~~

### Response

~~~
Http Status 204
~~~

City - GET

Rota -> /cities

### Request

Ao enviar uma requisição para o endpoint de cidades com o método GET, será retornada todas as cidades ordenadas por nome.

### Response

~~~
[
    {
        "id": 11,
        "name": "Belo Horizonte"
    },
    {
        "id": 8,
        "name": "Belém"
    },
    {
        "id": 2,
        "name": "Brasília"
    }
    ...
 ]
~~~

~~~
Http Status 200
~~~

Events - POST

Rota - /events

### Request

Com pelo menos uma cidade previamente cadastrada, deverá ser passado o Json abaixo com os dados do evento e com o Id da respectiva cidade a que ele será vinculado:

~~~
{
    "name": "Novo evento",
    "url": "https://novoevento.com.br",
    "date": "2023-07-15",
    "cityId": 1
}
~~~

~~~
Http Status 201
~~~

Events - GET

Rota - /events

### Request

Ao enviar uma requisição para o endpoint de eventos com o método GET, será retornada todas os eventos com paginação.

~~~
{
    "content": [
        {
            "id": 1,
            "name": "Feira do Software",
            "date": "2021-05-16",
            "url": "https://feiradosoftware.com",
            "cityId": 1
        },
        {
            "id": 2,
            "name": "CCXP",
            "date": "2021-04-13",
            "url": "https://ccxp.com.br",
            "cityId": 1
        },
        {
            "id": 3,
            "name": "Congresso Linux",
            "date": "2021-05-23",
            "url": "https://congressolinux.com.br",
            "cityId": 2
        }
    ],
    ...
 }
~~~

~~~
Http Status 200
~~~

# Autoria do projeto

- Projeto Base - Escola Dev Superior;
- Implementação de validação e securança - Danilo Ewerton.
