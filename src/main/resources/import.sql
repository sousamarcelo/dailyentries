--CADASTRO CATEGORIAS:
INSERT INTO tb_category(name) VALUES ('Casa');
INSERT INTO tb_category(name) VALUES ('Estética');
INSERT INTO tb_category(name) VALUES ('Saude');
INSERT INTO tb_category(name) VALUES ('Pet');
INSERT INTO tb_category(name) VALUES ('Lazer');
INSERT INTO tb_category(name) VALUES ('Transporte');
INSERT INTO tb_category(name) VALUES ('Viagem');

--CADASTRO USUARIOS:
INSERT INTO tb_user (name, email, phone, password) VALUES ('Maria Brown', 'maria@gmail.com', '988888888', '1234567');
INSERT INTO tb_user (name, email, phone, password) VALUES ('Alex Green', 'alex@gmail.com', '977777777', '1234567');

--CADASTRO PERMISSÕES
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN')
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT')

-- CADASTRO DESPESAS USUARIO 1: Maria Brown
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Compra mensal', 'Atacadão', 1000.00, 'PENDING', '2025-08-08', 1, 1);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Manutenção jardim', 'Compra de plantas e adubo', 150.50, 'FINISHED', '2025-08-05', 1, 1);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Corte de cabelo', 'Salão Beleza VIP', 80.00, 'PENDING', '2025-08-06', 1, 2);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Consulta médica', 'Clínica Vida Saudável', 250.00, 'FINISHED', '2025-08-03', 1, 3);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Ração', 'Pet Shop Feliz', 120.00, 'INT_PROGRESS', '2025-08-04', 1, 4);

-- CADASTRO DESPESAS USUARIO 2: Alex Green
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Cinema', 'Ingresso + pipoca', 75.00, 'PENDING', '2025-08-07', 2, 5);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Combustível', 'Posto Shell', 200.00, 'PENDING', '2025-08-09', 2, 6);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Passagem aérea', 'Latam', 1500.00, 'INT_PROGRESS', '2025-08-10', 2, 7);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Hotel', 'Pousada Sol e Mar', 900.00, 'PENDING', '2025-08-11', 2, 7);
INSERT INTO tb_expenses (name, description, amount, status, date, user_id, category_id) VALUES ('Manutenção carro', 'Troca de óleo e filtros', 350.00, 'CANCELED', '2025-08-02', 2, 6);