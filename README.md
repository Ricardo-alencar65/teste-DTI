# Teste-pratico-petshop

Instruções para executar o sistema:

Para executar o sistema, primeiro clone o repositorio.
Depois execute o mvn clean install para construir o projeto
e o execute com o comando mvn spring-boot:run
No front-end tem que da um npm install para instalar as dependências
e depois executar o npm start para iniciar o aplicativo React

Lista de premissas assumidas:

assumi que Os petshops e seus preços são pré-definidos e armazenados no banco de dados.
o seu back-end está configurada para rodar localmente no endereço http://localhost:8080
e que o seu font-end está configurado para rodar no http://localhost:3000/

Decisões do prjeto:

Spring Boot: Eu escolhi o Spring boot pois ele facilita a configuração e desenvolvimento do back-end
JPA/Hibernate: escolhi utiliza-lo para persistência de dados e interação com o banco de dados
Politica de Preços como Embedded Entity: Preferi fazer dessa maneira Para facilitar o cálculo dos preços com base em diferentes critérios.
banco de dados H2: acabei optando pelo banco de dados H2 por ser um banco de dados em memória, o que facilitaria o meu processo de desenvolvimento

Outras Informações Relevantes
Testes unitarios: fiz os testes para garantir a confiabilidade do sistema.

Pequeno video do sistema rodando na minha maquina:
https://youtu.be/N3FRmnEeW1c
