# Projeto1_tecweb

Rodar login.jsp

CREATE DATABASE meus_dados;
USE meus_dados;
CREATE TABLE tasks(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
usuario VARCHAR(32) NOT NULL,
tag VARCHAR(32) NOT NULL,
tarefa TEXT NOT NULL);
INSERT INTO tasks(usuario, tag, tarefa) VALUES ('CAROLINE', 'Insper', 'Trabalho de tecweb');
INSERT INTO tasks (usuario, tag, tarefa) VALUES ( 'ADRIANA', 'Familia', 'Preparar o jantar');
INSERT INTO tasks (usuario, tag, tarefa) VALUES ( 'MARCELO', 'lazer', 'Tocar piano');
INSERT INTO tasks(usuario, tag, tarefa) VALUES ('CAROLINE', 'Entidade', 'Estudar solidity');
USE meus_dados;
CREATE TABLE login (id INT NOT NULL PRIMARY KEY,
usuario VARCHAR(32) NOT NULL,
password INT NOT NULL);
INSERT INTO login (id, usuario, password) VALUES (1,'CAROLINE', 123);



