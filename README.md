# MOVIES-API

## Sobre esse projeto:

A API foi construída utilizando:

- Java 11
- Spring Boot 2.7.0
- Spring Web
- Spring Data JPA
- H2 Database

Ao startar o projeto a classe LocalConfig, dentro do package configs, cadastra alguns filmes e usuários para teste. 

Os seguintes endpoints foram implementados:

- `GET /movies` obtém todos os filmes
- `GET /movies/{id}` obtém os detalhes de um filme
- `POST /movies` insere um novo filme, apenas usuarios do tipo ROLE_ADMIN
- `PUT /movies/{id}` atualiza um filme
- `DELETE /movies/{id}` exclui um filme
- `POST /users` insere um novo usuario(ROLE_USER)
- `POST /users/admin` insere um novo usuario como admin(ROLE_ADMIN)
- `DELETE /users/{id}` desativa um usuario
- `POST /oauth/token` gera um novo token para utilizar na aplicacao

A aplicação conta com autenticação e token JWT, apenas os ENDPOINTS `/users` e `users/admin` estão liberados.

Collection no Postman utilizada para testes: https://www.getpostman.com/collections/d5dc2c3309d48b0aea65
