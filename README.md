# Cloud Parking Aju - Desafio Bootcamp Québec Java

Esse projeto foi o resultado do desafio final do Bootcamp Québec Java Digital realizado pela Digital Innovation, tendo como objetivo final em realizar o Deploy na Nuvem de um Conjunto de API’s Desenvolvida em Spring no Heroku. Neste desafio foram desenvolvidos um conjunto de API’s utilizando Spring Boot para controlar um estacionamento de veículos. O objetivo é fazer o controle da entrada, saída e valor a ser cobrado do cliente. Foram aplicados todas as boas práticas de desenvolvimento de API’s incluindo segurança com Spring Security e acesso a banco de dados PostgreSQL. Foram realizados testes e relatórios de cobertura de testes. Após a finalização da aplicação e ser enviado para o Github, foi feito o deploy na cloud do Heroku a fim de disponibilizar a API para a Internet.

Durante a sua construção, pois possível criar as principais funções básicas de uma api, sendo elas a de inserção de dados, visualização de uma lista completa de informações dos dados como também a visualização de um determinada informação de um único item identificado por um código ou id informado pelo usuário. Também foi criado a função para alterar uma informação específica de dados de acordo com o código do conjunto de dados informado pelo usuário, se o mesmo existir na base de dados. Por fim, foi também criado a função de deletar uma linha de informações de acordo com a instrução passada pelo usuário através de um código de identificação registrado na base de dados caso ela venha a existir.

Para concluir, nesse projeto tive que fazer algumas adaptações durante a sua construção devido as atualizações das dependências e plug-ins, como também as diferenças existente na IDE Intellij. Mas mesmo assim, conseguir fazer com que as aplicações funcionasse da mesmo forma aplicando os conhecimentos adquiridos durante o bootcamp e outras fontes. Portanto, gostaria de agradescer por encontrar pessoas tão capacitadas que usam seus conhecimentos e experiência para compartilhar com aqueles que desejam aprender e entrar nesse mercado tão amplo e democrático.

## Objetivos

Criar projeto Spring Boot Java.
Implementar modelo de domínio.
Estruturar camadas lógicas: config, controller, dto, mapper, exception, model, service, repository.
Configurar e testar banco de dados Postgres.
Povoar o banco de dados usando Swagger.
CRUD - Create, Retrieve, Update, Delete e outros.
Tratamento de exceções.

## Estrutura do Projeto

* config - configuração e beans manuais do projeto como Security e Open API - Swagger
* excepion - configuração do recusos comuns da aplicação como exceções globais
* model - classes de modelo da aplicação
* mapper - configuração manuais para simplificar as listas.
* dto - camada de tráfego de dados da aplicação
* repository - recursos de acesso a dados em uma base relacional da aplicação
* service - camada de regra de negócios da aplicação
* controller - serviços http baseados na arquitetura REST

## Diagrama Modelo conceitual UML

![cloud_parking_aju - Diagram Hierarchic Groups](https://user-images.githubusercontent.com/17755195/201374940-072bd81f-9494-4626-a26b-89de810743a9.png)

## Diagrama Modelo conceitual das Dependências

![cloud_parking_aju - Dependency](https://user-images.githubusercontent.com/17755195/201374995-10212a58-a258-41bc-9688-4ad85460a6b7.png)

# Documentação Navegável JavaDoc

Javadoc é um gerador de documentação criado pela Sun Microsystems para documentar a API dos programas em Java, a partir do código-fonte. O resultado é expresso em HTML. É constituído, basicamente, por algumas marcações muitos simples inseridas nos comentários do programa. Portanto, é uma ferramenta para a criação de documentação de pacotes, classes, atributos e métodos Java a partir do processamento do código fonte com comentários em formato adequado onde é possível navegar de um documento para outro de forma a ajudar em compreender a relação entre as classes e métodos.
Caso queira navegar e conhecer a extrutura do projeto, basta usar os recursos disponíveis pelo java doc por meio do link disponibilizado para que você posso já ter uma experiência com o projeto antes mesmo de instalar em sua máquina.

![api-gestao-do-estacionamento-javadoc](https://user-images.githubusercontent.com/17755195/201375859-5b1ccf8b-9293-4a1b-8ef3-fff5b161b1f6.png)

* https://adriano1976.github.io/gestao-de-estacionamento-javadoc/index.html

# Spring Rest API Swagger

O Swagger é um framework composto por diversas ferramentas que, independente da linguagem, auxilia a descrição, consumo e visualização de serviços de uma API REST. Em suma, o Swagger visa padronizar este tipo de integração, descrevendo os recursos que uma API deve possuir, como endpoints, dados recebidos, dados retornados, códigos HTTP e métodos de autenticação, entre outros. Portanto nessa Api podemos testar as operações de CRUD comuns em APIs REST que pode ser consumida por qualquer pessoa via heroku pelo link abaixo,  enquanto durar a sua hospedagem, ou executando no seu prório PC.

![api-gestao-de-estacionamento-swagger](https://user-images.githubusercontent.com/17755195/201376133-bfa405db-6fef-4f17-a901-4794033ffc1a.png)

* https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking_Controller

## Ferramentas

* Spring Boot
* Spring Boot Data JPA
* Spring Devtools
* Spring Security
* Apache Tomcat
* Maven
* JUnit 5
* Hibernate
* JPA Mapping
* PostgreSQL
* Open API - Swagger
* Heroku
* Intellij IDE

## Autor do Projeto

* <p dir="auto"><li><a href="https://github.com/Adriano1976">Adriano Santos</a></li></p>
* <p dir="auto"><a href="https://api.whatsapp.com/send?phone=5579998960414" rel="nofollow">(79) 99896-0414</a></p>
