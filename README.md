```sql
-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS gestao_imobiliaria;
USE gestao_imobiliaria;

-- Tabela: cliente
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    email VARCHAR(100),
    endereco VARCHAR(255)
);

-- Tabela: imovel
CREATE TABLE imovel (
    id INT AUTO_INCREMENT PRIMARY KEY,
    endereco VARCHAR(255) NOT NULL,
    tipo VARCHAR(50) NOT NULL, 
    quartos INT,
    banheiros INT,
    disponivel BOOLEAN DEFAULT 1
);

-- Tabela: contrato
CREATE TABLE contrato (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_imovel INT NOT NULL,
    id_cliente INT NOT NULL,
    valor_aluguel DECIMAL(10,2) NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    
    CONSTRAINT fk_contrato_imovel FOREIGN KEY (id_imovel)
        REFERENCES imovel(id) ON DELETE CASCADE,
    
    CONSTRAINT fk_contrato_cliente FOREIGN KEY (id_cliente)
        REFERENCES cliente(id) ON DELETE CASCADE
);
