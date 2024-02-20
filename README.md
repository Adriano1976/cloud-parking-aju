# Cloud Parking Aju - Desafio Bootcamp Québec Java

Esse projeto foi o resultado do desafio final do Bootcamp Québec Java Digital realizado pela Digital Innovation, tendo como objetivo final em realizar o Deploy na Nuvem de um Conjunto de API’s Desenvolvida em Spring no Heroku. Neste desafio foram desenvolvidos um conjunto de API’s utilizando Spring Boot para controlar um estacionamento de veículos. O objetivo é fazer o controle da entrada, saída e valor a ser cobrado do cliente. Foram aplicados todas as boas práticas de desenvolvimento de API’s incluindo segurança com Spring Security e acesso a banco de dados PostgreSQL. Foram realizados testes e relatórios de cobertura de testes. Após a finalização da aplicação e ser enviado para o Github, foi feito o deploy na cloud do Heroku a fim de disponibilizar a API para a Internet.

Durante a sua construção, pois possível criar as principais funções básicas de uma api, sendo elas a de inserção de dados, visualização de uma lista completa de informações dos dados como também a visualização de um determinada informação de um único item identificado por um código ou id informado pelo usuário. Também foi criado a função para alterar uma informação específica de dados de acordo com o código do conjunto de dados informado pelo usuário, se o mesmo existir na base de dados. Por fim, foi também criado a função de deletar uma linha de informações de acordo com a instrução passada pelo usuário através de um código de identificação registrado na base de dados caso ela venha a existir.

Para concluir, nesse projeto tive que fazer algumas adaptações durante a sua construção devido as atualizações das dependências e plug-ins, como também as diferenças existente na IDE Intellij. Mas mesmo assim, conseguir fazer com que as aplicações funcionasse da mesmo forma aplicando os conhecimentos adquiridos durante o bootcamp e outras fontes. Portanto, gostaria de agradescer por encontrar pessoas tão capacitadas que usam seus conhecimentos e experiência para compartilhar com aqueles que desejam aprender e entrar nesse mercado tão amplo e democrático.

![api-gestao-de-estacionamento-intellij-ide](https://user-images.githubusercontent.com/17755195/201702013-8fcbc1df-ad89-4299-b166-9a9f0b198c7a.png)

## Objetivos

Criar projeto Spring Boot Java.
Implementar modelo de domínio.
Estruturar camadas lógicas: config, controller, dto, mapper, exception, model, service, repository.
Configurar e testar banco de dados Postgres.
Povoar o banco de dados usando Swagger.
CRUD - Create, Retrieve, Update, Delete e outros.
Tratamento de exceções.

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

## Por que devo aprender a trabalhar com Spring Data jpa?

Aprender a trabalhar com Spring Data JPA pode ser benéfico por várias razões, incluindo:

* Produtividade: Com o Spring Data JPA, é possível criar rapidamente um acesso a dados de alto desempenho, permitindo que você se concentre em desenvolver recursos de negócios valiosos em vez de escrever código repetitivo.

* Flexibilidade: O Spring Data JPA é altamente personalizável e pode ser adaptado às necessidades específicas do seu projeto.

* Gerenciamento de entidades: O Spring Data JPA permite que você gerencie facilmente as entidades do seu banco de dados usando uma interface de programação de aplicativos (API) simples e intuitiva.

* Compatibilidade: O Spring Data JPA é compatível com vários bancos de dados relacionais e não relacionais, incluindo MySQL, PostgreSQL, Oracle e MongoDB.

* Boa documentação: O Spring Data JPA é bem documentado, com uma vasta comunidade de usuários e suporte disponível, o que pode ajudar a resolver problemas comuns e aprender mais rapidamente.

* Uso de padrões: O Spring Data JPA segue o padrão JPA (Java Persistence API), permitindo que você desenvolva aplicativos que possam ser facilmente portados para outras plataformas Java.

Esses são apenas alguns dos motivos pelos quais aprender a trabalhar com Spring Data JPA pode ser valioso para o seu conjunto de habilidades. É uma ferramenta poderosa que pode ajudá-lo a criar aplicativos de alta qualidade e eficientes, economizando tempo e esforço no processo.

## Por que devo aprender a trabalhar com Spring security?

Aprender a trabalhar com Spring Security pode ser benéfico por várias razões, incluindo:

* Segurança: Spring Security é uma estrutura de segurança poderosa que oferece várias camadas de proteção para seus aplicativos, incluindo autenticação, autorização e proteção contra ataques comuns, como cross-site scripting e SQL injection.

* Integração fácil: O Spring Security é facilmente integrado com outros recursos do Spring Framework, como Spring MVC, Spring Boot e Spring Data.

* Personalização: Com o Spring Security, é possível personalizar facilmente as configurações de segurança do seu aplicativo, incluindo a definição de permissões de usuário e configurações de login.

* Controle de acesso: O Spring Security permite que você controle o acesso de usuários a recursos específicos do aplicativo, como páginas da web, arquivos e serviços RESTful.

* Escalabilidade: O Spring Security é altamente escalável e pode lidar com aplicativos com um grande número de usuários simultâneos.

* Suporte: O Spring Security tem uma comunidade ativa de desenvolvedores e usuários, com documentação e suporte disponíveis para ajudá-lo a solucionar problemas e aprender a usar a estrutura.

Esses são apenas alguns dos motivos pelos quais aprender a trabalhar com o Spring Security pode ser valioso para o seu conjunto de habilidades. A segurança é uma consideração importante em muitos aplicativos e o Spring Security oferece uma solução abrangente e personalizável para proteger seu aplicativo e seus usuários.

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

## Documentação Navegável JavaDoc

Javadoc é um gerador de documentação criado pela Sun Microsystems para documentar a API dos programas em Java, a partir do código-fonte. O resultado é expresso em HTML. É constituído, basicamente, por algumas marcações muitos simples inseridas nos comentários do programa. Portanto, é uma ferramenta para a criação de documentação de pacotes, classes, atributos e métodos Java a partir do processamento do código fonte com comentários em formato adequado onde é possível navegar de um documento para outro de forma a ajudar em compreender a relação entre as classes e métodos.
Caso queira navegar e conhecer a extrutura do projeto, basta usar os recursos disponíveis pelo java doc por meio do link disponibilizado para que você posso já ter uma experiência com o projeto antes mesmo de instalar em sua máquina.

![api-gestao-do-estacionamento-javadoc](https://user-images.githubusercontent.com/17755195/201375859-5b1ccf8b-9293-4a1b-8ef3-fff5b161b1f6.png)

* https://adriano1976.github.io/gestao-de-estacionamento-javadoc/index.html

## Spring Rest API Swagger

O Swagger é um framework composto por diversas ferramentas que, independente da linguagem, auxilia a descrição, consumo e visualização de serviços de uma API REST. Em suma, o Swagger visa padronizar este tipo de integração, descrevendo os recursos que uma API deve possuir, como endpoints, dados recebidos, dados retornados, códigos HTTP e métodos de autenticação, entre outros. Portanto nessa Api podemos testar as operações de CRUD comuns em APIs REST que pode ser consumida por qualquer pessoa via heroku pelo link abaixo,  enquanto durar a sua hospedagem, ou executando no seu prório PC.

![api-gestao-de-estacionamento-swagger](https://user-images.githubusercontent.com/17755195/201376133-bfa405db-6fef-4f17-a901-4794033ffc1a.png)

* https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking_Controller

## Como Realizar o Teste

### ETAPA 1 - GET/parking Find all parkings 

* https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking%20Controller/findAllUsingGET

```bash
[
  {
    "id": "a46e42962ae547bdb4b7470543b5b6b6",
    "license": "JFZ-0547",
    "state": "BH",
    "model": "Vectra",
    "color": "Preto",
    "entryDate": "14/11/2022 19:15:41"
  }
]
```

### ETAPA 2 - POST/parking create

* https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking%20Controller/createUsingPOST

```bash
{
  "color": "Preto",
  "license": "JFZ-0547",
  "model": "Vectra",
  "state": "BH"
}
```

### ETAPA 3 - GET/parking/{id} findById

* https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking%20Controller/findByIdUsingGET

```bash
id: a46e42962ae547bdb4b7470543b5b6b6
```

### ETAPA 4 - PUT/parking/{id} update

* https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking%20Controller/updateUsingPUT

```bash
id: a46e42962ae547bdb4b7470543b5b6b6

{
  "color": "Verde",
  "license": "HTR-5047",
  "model": "Vectra",
  "state": "BH"
}
```

### ETAPA 5 - POST/parking/{id} checkOut

* https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking%20Controller/checkOutUsingPOST

```bash
id: a46e42962ae547bdb4b7470543b5b6b6
```

 ### ETAPA 6 - DELETE/parking/{id} delete
 
 * https://cloud-parking-aju.herokuapp.com/swagger-ui.html#/Parking%20Controller/deleteUsingDELETE
 
```bash
id: a46e42962ae547bdb4b7470543b5b6b6
```

## Autor do Projeto

* <p dir="auto"><a href="https://github.com/Adriano1976">Adriano Santos</a></p>
* <p dir="auto"><a href="https://api.whatsapp.com/send?phone=5579998960414" rel="nofollow">(79) 99896-0414</a></p>

<hr>

<div align="center">
<br><p align="centre"><b>Contagem de visitantes</b></p>  
<p align="center"><img align="center" src="https://profile-counter.glitch.me/{cloud-parking-aju}/count.svg" /></p> 
<br>  

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&color=87CEFA&height=120&section=footer"/>**** 
</div>
