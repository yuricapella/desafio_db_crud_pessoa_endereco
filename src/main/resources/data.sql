INSERT INTO pessoa (nome, cpf, data_nascimento, data_criacao)
VALUES
    ('João Silva', '153.921.000-66', '1995-04-16', NOW()),
    ('Maria Oliveira', '516.677.210-54', '1998-08-22', NOW()),
    ('Pedro Santos', '750.848.940-37', '1989-12-10', NOW());


INSERT INTO endereco (rua, numero, bairro, cidade, estado, cep, endereco_principal, pessoa_id, data_criacao)
VALUES
    ('Rua A', '123', 'Bairro X', 'Cidade Y', 'SP', '12345-678', TRUE, 1, NOW()),
    ('Rua B', '456', 'Bairro Z', 'Cidade W', 'RJ', '23456-789', FALSE, 1, NOW()),
    ('Rua C', '789', 'Bairro Y', 'Cidade V', 'MG', '34567-890', TRUE, 2, NOW()),
    ('Rua D', '101', 'Bairro W', 'Cidade U', 'BA', '45678-901', FALSE, 3, NOW());
