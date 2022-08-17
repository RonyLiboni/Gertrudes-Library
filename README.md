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

Você precisa ter o LOMBOK instalado na sua IDE para conseguir rodar a API.

Após iniciar o servidor da API acesse o swagger através do link abaixo:

http://localhost:8080/swagger-ui.html

#### Você pode utilizar os JSON pré-configurados no swagger ou testar com outros parâmetros.

## Tecnologias utilizadas
  - Java com Spring Boot
  - Spring Cloud OpenFeign
  - Spring Data JPA
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


