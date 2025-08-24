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
    ativo BOOLEAN DEFAULT 1
    
    CONSTRAINT fk_contrato_imovel FOREIGN KEY (id_imovel)
        REFERENCES imovel(id) ON DELETE CASCADE
);

INSERT INTO cliente (nome, cpf, telefone, email, endereco) VALUES
('Ana Beatriz Costa', '123.456.789-00', '11988887777', 'ana.costa@email.com', 'Rua das Flores, 123 - São Paulo'),
('Carlos Henrique Silva', '234.567.890-11', '21999998888', 'carlos.silva@email.com', 'Av. Brasil, 456 - Rio de Janeiro'),
('Juliana Souza', '345.678.901-22', '31977776666', 'juliana.souza@email.com', 'Rua Minas Gerais, 789 - Belo Horizonte'),
('Fernando Oliveira', '456.789.012-33', '41966665555', 'fernando.oliveira@email.com', 'Rua Paraná, 101 - Curitiba'),
('Camila Ribeiro', '567.890.123-44', '51955554444', 'camila.ribeiro@email.com', 'Av. Ipiranga, 202 - Porto Alegre'),
('Lucas Martins', '678.901.234-55', '61944443333', 'lucas.martins@email.com', 'Rua Goiás, 303 - Brasília'),
('Paula Fernandes', '789.012.345-66', '11933332222', 'paula.fernandes@email.com', 'Rua do Sol, 404 - São Paulo'),
('Rafael Lima', '890.123.456-77', '21922221111', 'rafael.lima@email.com', 'Rua Atlântica, 505 - Rio de Janeiro'),
('Larissa Mendes', '901.234.567-88', '31911110000', 'larissa.mendes@email.com', 'Av. Afonso Pena, 606 - Belo Horizonte'),
('Bruno Rocha', '012.345.678-99', '41900009999', 'bruno.rocha@email.com', 'Rua XV de Novembro, 707 - Curitiba');

INSERT INTO imovel (endereco, tipo, quartos, banheiros, descricao, disponivel) VALUES
('Rua das Palmeiras, 100 - São Paulo', 'Apartamento', 2, 1, 'Apartamento bem localizado, próximo ao metrô.', TRUE),
('Av. Copacabana, 200 - Rio de Janeiro', 'Apartamento', 3, 2, 'Vista para o mar, reformado recentemente.', TRUE),
('Rua da Bahia, 300 - Belo Horizonte', 'Casa', 4, 3, 'Casa ampla com quintal e garagem.', TRUE),
('Rua São José, 400 - Curitiba', 'Casa', 2, 1, 'Casa térrea com jardim frontal.', TRUE),
('Av. Farrapos, 500 - Porto Alegre', 'Apartamento', 1, 1, 'Apartamento compacto ideal para solteiros.', TRUE),
('Rua Brasília, 600 - Brasília', 'Casa', 3, 2, 'Casa moderna em bairro residencial.', TRUE),
('Rua das Laranjeiras, 700 - São Paulo', 'Apartamento', 2, 2, 'Apartamento em condomínio fechado.', TRUE),
('Av. Atlântica, 800 - Rio de Janeiro', 'Cobertura', 4, 4, 'Cobertura de luxo com piscina.', TRUE),
('Rua dos Andradas, 900 - Porto Alegre', 'Apartamento', 1, 1, 'Ideal para estudantes, perto da universidade.', TRUE),
('Rua Amazonas, 1000 - Belo Horizonte', 'Casa', 3, 2, 'Casa de esquina com grande potencial.', TRUE);

INSERT INTO contrato (id_imovel, id_cliente, valor_aluguel, data_inicio, data_fim) VALUES
(1, 1, 1800.00, '2025-01-10', '2026-01-09'),
(2, 2, 2500.00, '2025-03-01', '2026-02-28'),
(3, 3, 3000.00, '2025-02-15', '2026-02-14'),
(4, 4, 1500.00, '2025-04-01', '2026-03-31'),
(5, 5, 1200.00, '2025-05-20', '2026-05-19'),
(6, 6, 2200.00, '2025-06-01', '2026-05-31'),
(7, 7, 2000.00, '2025-07-10', '2026-07-09'),
(8, 8, 4500.00, '2025-08-01', '2026-07-31'),
(9, 9, 1300.00, '2025-08-15', '2026-08-14'),
(10, 10, 2800.00, '2025-08-20', '2026-08-19');
    
    CONSTRAINT fk_contrato_cliente FOREIGN KEY (id_cliente),
        REFERENCES cliente(id) ON DELETE CASCADE
);


<img width="1193" height="697" alt="image" src="https://github.com/user-attachments/assets/7b494afd-c97e-4bb2-8809-f6299815cdd1" />
<img width="361" height="348" alt="image" src="https://github.com/user-attachments/assets/3bacdc0b-6495-4d22-b744-99769f9b02e3" />
