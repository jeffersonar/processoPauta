# Processo Pauta

O projeto foi desenvolvido o mais simples e mais rapido na medida do possivel.

Não foi implementado Apache Camel para o envio das filas
Não foi implementado spring eureka para serviço de discovery e escalabilidade vestical 

## Fluxo
1.Criar uma Pauta - [Documentação](http://localhost:8080/swagger-ui.html#/pauta-controller/criarPautaUsingPOST)
2.Criar uma Sessão - [Documentação](http://localhost:8080/swagger-ui.html#/sessao-controller/criarSessaoUsingPOST)
3.votar - [Documentação](http://localhost:8080/swagger-ui.html#/votacao-controller/votarUsingPOST)
4.consultar Pauta - [Documentaçao](http://localhost:8080/swagger-ui.html#/pauta-controller/countVotacaoUsingGET)

## Swagger Documentação

* [Swagger](http://localhost:8080/swagger-ui.html#/) Documentação endpoint do serviço

# Configuração do banco de dados Postgres!
Todas as configurações do  banco de dados se encontra application.properties
O arquivo de criação do banco se encontra raiz do projeto db.sql
```sh
spring.datasource.url=jdbc:postgresql://localhost:5433/pautadb
spring.datasource.username=postgres
spring.datasource.password=qwe123
spring.database.driverClassName=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL82Dialect
spring.jpa.show-sql=true
spring.jpa.format-sql=true
spring.jpa.properties.hibernate.jdbc.time_zone=UTC
```

### Requisitos

Requisitos obrigatorios:

* [Maven] - 5.3.xx
* [Java] - 1.8.xx
* [Postgres] - 9.5.xx

### Instalação

Dentro da pasta do pautaApi execute seguinte comando para copilar:

```sh
$ mvn clean install -U 
```
Ao finalizar a compilação o projeto ira criar uma pasta target.
Dentro da pasta target deverar um arquivo chamado: pautaApi-0.0.1-SNAPSHOT.jar


```sh
$ java -jar pautaApi-0.0.1-SNAPSHOT.jar
```

