# Gertrudes-Library-API

Olá! Esta API tem o objetivo de simular um sistema de cadastro de funcionarios e clientes para a Livraria da dona Gertrudes.

Como primeiras funcionalidades Gertrudes pediu:
  - Cadastro, Atualização, Remoção e Busca de funcionario e clientes em banco de dados.
  - Dados de endereço devem vir da API da ViaCep https://viacep.com.br/ws/{cep}/json/ 
  - API documentada no SWAGGER.
  - Buscas com dados paginados.
  - Busca personalizada de qual cep tem maior incidencia entre os funcionários.
  - Busca personalizada de qual cep tem maior incidencia entre os clientes.
  - Clientes deveriam ter nome completo, documento (utilizamos o CPF como documento) e endereço.
  - Versionamento do Banco de dados através do FlyWay Migrations.
  - Http Status codes adequados a cada resposta das controllers.
  - Testes automatizados da aplicação criada
  - Segurança na API com Token JWT

Você precisa ter o LOMBOK instalado na sua IDE para conseguir rodar a API.

Após iniciar o servidor da API acesse o swagger através do link abaixo:

http://localhost:8080/swagger-ui.html

#### Você precisa se autenticar no endpoint de Autenticação (Authentication Endpoint)
#### Há um usuario com role de ADMIN. No swagger já virá pronto o JSON com esses dados, mas caso precise, estão abaixo.
- username= rony
- password= 123456

#### Você pode utilizar os JSON pré-configurados no swagger ou testar com outros parâmetros.
#### Esta aplicação está no docker-hub você pode utilizar o arquivo docker-compose que está na raiz deste projeto para não ter que mudar suas configurações do MySQL ou instalá-lo caso você não o tenha

## Tecnologias utilizadas
  - Java com Spring Boot
  - Spring Security com Token JWT
  - Spring Cloud OpenFeign
  - Spring Data JPA
  - Docker
  - Spring Validation
  - RestTemplate
  - Banco de dados MySQL
  - FlyWay Migrations
  - Documentação com SpringDoc
  -	JUnit e Mockito
  -	Lombok

### Esta aplicação contém testes unitários das Controllers, Services, Repositories e classes de validação.

### Validações
 - Em nenhum formulário podem haver dados em branco ou nulos, exceto o campo "complement" que pode ser nulo.
 - CEPs são validados através da viaCep
 - CPF sao validados se são uma combinação possível 


