 CREATE TABLE categoria(
     id CHAR(32) NOT NULL PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     descricao VARCHAR(255) NOT NULL,
     marca VARCHAR(255) NOT NULL,
     categoria VARCHAR(255) NOT NULL,
     codigo_de_barras VARCHAR(255) NOT NULL,
     quantidade DECIMAL(10,2) NOT NULL,
     preco_custo DECIMAL(10,2) NOT NULL,
     preco_venda DECIMAL(10,2) NOT NULL,
     data_criacao TIMESTAMP NOT NULL
 );