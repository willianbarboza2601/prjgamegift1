-- import.sql
-- Dados iniciais para o projeto GameGift.
-- Ajustado de acordo com as entidades atuais enviadas em server.zip.

-- =========================================================
-- CATEGORIAS
-- =========================================================
INSERT INTO tb_category (name) VALUES ('Ação');
INSERT INTO tb_category (name) VALUES ('RPG');
INSERT INTO tb_category (name) VALUES ('Indie');
INSERT INTO tb_category (name) VALUES ('Estratégia');
INSERT INTO tb_category (name) VALUES ('Esportes');

-- =========================================================
-- PRODUTOS
-- Product.category -> @ManyToOne
-- =========================================================
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Cyber Strike', 'Jogo de ação futurista com combates intensos.', 149.90, 'https://picsum.photos/seed/cyberstrike/600/400', (SELECT id FROM tb_category WHERE name = 'Ação'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Shadow Arena', 'Jogo de ação competitivo em arenas.', 89.90, 'https://picsum.photos/seed/shadowarena/600/400', (SELECT id FROM tb_category WHERE name = 'Ação'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Kingdom Legends', 'RPG de fantasia com exploração e evolução de personagem.', 199.90, 'https://picsum.photos/seed/kingdomlegends/600/400', (SELECT id FROM tb_category WHERE name = 'RPG'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Mystic Realms', 'RPG com mundo aberto, missões e criaturas fantásticas.', 129.90, 'https://picsum.photos/seed/mysticrealms/600/400', (SELECT id FROM tb_category WHERE name = 'RPG'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Pixel Valley', 'Jogo indie de exploração e construção.', 39.90, 'https://picsum.photos/seed/pixelvalley/600/400', (SELECT id FROM tb_category WHERE name = 'Indie'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Neon Runner', 'Jogo indie de plataforma com visual neon.', 29.90, 'https://picsum.photos/seed/neonrunner/600/400', (SELECT id FROM tb_category WHERE name = 'Indie'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Empire Tactics', 'Jogo de estratégia baseado em turnos.', 79.90, 'https://picsum.photos/seed/empiretactics/600/400', (SELECT id FROM tb_category WHERE name = 'Estratégia'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('World Commander', 'Estratégia militar com gerenciamento de recursos.', 99.90, 'https://picsum.photos/seed/worldcommander/600/400', (SELECT id FROM tb_category WHERE name = 'Estratégia'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Ultimate Soccer', 'Jogo de futebol com clubes e campeonatos.', 179.90, 'https://picsum.photos/seed/ultimatesoccer/600/400', (SELECT id FROM tb_category WHERE name = 'Esportes'));
INSERT INTO tb_product (name, description, price, url_image, category_id) VALUES ('Street Racing Pro', 'Jogo de corrida com personalização de veículos.', 119.90, 'https://picsum.photos/seed/streetracing/600/400', (SELECT id FROM tb_category WHERE name = 'Esportes'));

-- =========================================================
-- USUÁRIOS
-- As senhas atendem ao @Pattern atual: minúscula, maiúscula e número.
-- =========================================================
-- INSERT INTO tb_user (name, password, email) VALUES ('Tiago Deon', 'Senha123', 'tiago@email.com');
-- INSERT INTO tb_user (name, password, email) VALUES ('Ana Silva', 'Senha123', 'ana@email.com');
-- INSERT INTO tb_user (name, password, email) VALUES ('Carlos Souza', 'Senha123', 'carlos@email.com');

-- =========================================================
-- ENDEREÇOS
-- Address.user -> @ManyToOne
-- O primeiro usuário possui dois endereços para testar o requisito.
-- =========================================================
-- INSERT INTO tb_address (user_id, street, complement, cep) VALUES ((SELECT id FROM tb_user WHERE email = 'tiago@email.com'), 'Rua das Flores, 120', 'Apartamento 12', '85501-000');
-- INSERT INTO tb_address (user_id, street, complement, cep) VALUES ((SELECT id FROM tb_user WHERE email = 'tiago@email.com'), 'Avenida Brasil, 450', 'Casa', '85502-100');
-- INSERT INTO tb_address (user_id, street, complement, cep) VALUES ((SELECT id FROM tb_user WHERE email = 'ana@email.com'), 'Rua Paraná, 85', 'Bloco B', '85503-200');
-- INSERT INTO tb_address (user_id, street, complement, cep) VALUES ((SELECT id FROM tb_user WHERE email = 'carlos@email.com'), 'Rua Curitiba, 300', 'Casa 2', '85504-300');

-- =========================================================
-- PEDIDOS
-- Order.user -> @ManyToOne
-- Order.address -> @ManyToOne
-- A entidade usa LocalDate, portanto a data é gravada como yyyy-MM-dd.
-- =========================================================
-- INSERT INTO tb_order (date, usuario_id, address_id) VALUES ('2026-10-01', (SELECT id FROM tb_user WHERE email = 'tiago@email.com'), (SELECT id FROM tb_address WHERE street = 'Rua das Flores, 120'));
-- INSERT INTO tb_order (date, usuario_id, address_id) VALUES ('2026-10-02', (SELECT id FROM tb_user WHERE email = 'tiago@email.com'), (SELECT id FROM tb_address WHERE street = 'Avenida Brasil, 450'));
-- INSERT INTO tb_order (date, usuario_id, address_id) VALUES ('2026-10-03', (SELECT id FROM tb_user WHERE email = 'ana@email.com'), (SELECT id FROM tb_address WHERE street = 'Rua Paraná, 85'));
-- INSERT INTO tb_order (date, usuario_id, address_id) VALUES ('2026-10-05', (SELECT id FROM tb_user WHERE email = 'carlos@email.com'), (SELECT id FROM tb_address WHERE street = 'Rua Curitiba, 300'));

-- =========================================================
-- ITENS DOS PEDIDOS
-- OrderItems.order -> @ManyToOne
-- OrderItems.product -> @ManyToOne
-- Agora um pedido pode ter vários itens e o mesmo produto pode aparecer
-- em pedidos diferentes.
-- =========================================================
-- INSERT INTO tb_order_items (order_id, product_id, price, quantity) VALUES ((SELECT id FROM tb_order WHERE date = '2026-10-01' AND usuario_id = (SELECT id FROM tb_user WHERE email = 'tiago@email.com')), (SELECT id FROM tb_product WHERE name = 'Kingdom Legends'), 199.90, 1);
-- INSERT INTO tb_order_items (order_id, product_id, price, quantity) VALUES ((SELECT id FROM tb_order WHERE date = '2026-10-01' AND usuario_id = (SELECT id FROM tb_user WHERE email = 'tiago@email.com')), (SELECT id FROM tb_product WHERE name = 'Pixel Valley'), 39.90, 2);
-- INSERT INTO tb_order_items (order_id, product_id, price, quantity) VALUES ((SELECT id FROM tb_order WHERE date = '2026-10-02' AND usuario_id = (SELECT id FROM tb_user WHERE email = 'tiago@email.com')), (SELECT id FROM tb_product WHERE name = 'Cyber Strike'), 149.90, 1);
-- INSERT INTO tb_order_items (order_id, product_id, price, quantity) VALUES ((SELECT id FROM tb_order WHERE date = '2026-10-02' AND usuario_id = (SELECT id FROM tb_user WHERE email = 'tiago@email.com')), (SELECT id FROM tb_product WHERE name = 'Neon Runner'), 29.90, 1);
-- INSERT INTO tb_order_items (order_id, product_id, price, quantity) VALUES ((SELECT id FROM tb_order WHERE date = '2026-10-03' AND usuario_id = (SELECT id FROM tb_user WHERE email = 'ana@email.com')), (SELECT id FROM tb_product WHERE name = 'Empire Tactics'), 79.90, 1);
-- INSERT INTO tb_order_items (order_id, product_id, price, quantity) VALUES ((SELECT id FROM tb_order WHERE date = '2026-10-05' AND usuario_id = (SELECT id FROM tb_user WHERE email = 'carlos@email.com')), (SELECT id FROM tb_product WHERE name = 'Ultimate Soccer'), 179.90, 1);
-- INSERT INTO tb_order_items (order_id, product_id, price, quantity) VALUES ((SELECT id FROM tb_order WHERE date = '2026-10-05' AND usuario_id = (SELECT id FROM tb_user WHERE email = 'carlos@email.com')), (SELECT id FROM tb_product WHERE name = 'Street Racing Pro'), 119.90, 2);
