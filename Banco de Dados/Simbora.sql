CREATE DATABASE simbora;

USE simbora;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    telefone VARCHAR(15),
    PRIMARY KEY(id)
);

CREATE TABLE destino (
    id INT AUTO_INCREMENT,
    partida VARCHAR(100),
    destino VARCHAR(100),
    data DATE,
    quantidade_de_passageiros INT,
    PRIMARY KEY(id)
);
