# CRUD feito com JSF, JPA, Hibernate e PostgreSQL

# O que é o estoqueCRUD?
 O estoqueCRUD é uma aplicação web na qual o usuário pode controlar o estoque de uma loja cadastrando novos produtos, visualizando os produtos que foram cadastrados, removendo alguns produtos e alterando os dados de alguns produtos. Por esse motivo, o estoqueCRUD é uma aplicação web do tipo CRUD: o usuário pode criar dados (CREATE), pode visualizá-los
(READ), pode atualizá-los (UPDATE) e pode removê-los (DELETE).
 
# Itens cumpridos

- [X] A) A aplicação web foi construida utilizando JavaServer Faces (JSF)

- [X] B) Os dados são armazenados no banco de dados PostgreSQL

- [X] C) Foi utilizado Hibernate e Java Persistence API (JPA)

- [X] F) Alguns botões foram estilizados com o Bootstrap 4

- [X] G) A tabela inicial, os formulários de cadastro e atualização de produtos, mensagens de alerta e outros foram estilizados com o Primefaces

# Como utilizar o projeto em seu computador
 Para rodar o estoqueCRUD, é necessário ter o Eclipse IDE e Tomcat v8.5 instalado em sua máquina. Após isso, baixe o projeto, extraia a pasta do projeto, adicione o projeto no eclipse, e coloque-o para ser executado no Tomcat, após um tempo, a aplicação irá funcionar normalmente.
 
# O Problema de lentidão para executar o projeto e como resolvê-lo
 Para rodar o estoqueCRUD não é necessário instalar o PostgreSQL no seu computador, pois o banco de dados do estoqueCRUD está hospedado no HEROKU. Então, como o HEROKU é uma plataforma gratuita, o PostgreSQL que está rodando no HEROKU é lento, e consequentemente a aplicação demora um pouco para carregar. 
 Então, caso você queira utilizar o estoqueCRUD com um banco de dados local, instale o PostgreSQL em sua máquina, crie um banco de dados qualquer, e abra o aquivo persistence.xml localizado em /src/main/java/META-INF/ e faça o seguinte:

-Na linha 10 você verá isso: ```<property name="javax.persistence.jdbc.url" value="jdbc:postgresql://ec2-52-44-139-108.compute-1.amazonaws.com:5432/deeg844erf52l8"/>```
 
 Altere o value disso "jdbc:postgresql://ec2-52-44-139-108.compute-1.amazonaws.com:5432/deeg844erf52l8" para isso "jdbc:postgresql://localhost:5432/nomeDoBancoQueVocêCriou",
 ou seja, você está dizendo que agora você não vai mais utilizar o banco de dados do HEROKU, mas sim, o que está em sua máquina.
 
-Na linha 11 você verá isso: ```<property name="javax.persistence.jdbc.user" value="vzauntcntwhdgq"/>```
 
 Altere o value disso "vzauntcntwhdgq" para isso "postgres", ou seja, postgres é o nome do usuário do banco de dados que você criou.
 
-Na linha 12 você verá isso: ```<property name="javax.persistence.jdbc.password" value="8156e285d5fb0d16ffa9170b8d2f3320d46d01758bbc726bba51935ed0238e21"/>```
 
 Altere o value disso "vzauntcntwhdgq" para isso "senhaQueVocêColocou", ou seja, você deve colocar a senha do banco dados que você criou.
 
Ao executar estes três passos, o estoqueCRUD estará rodando com o banco de dados que está na sua máquina.
 
 
