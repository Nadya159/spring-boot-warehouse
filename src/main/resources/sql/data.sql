INSERT INTO products (id, name, article, description, category, price, amount)
VALUES (uuid_generate_v4(), 'Грецкий орех 500г', 'FD-001-505', 'Очищенный грецкий орех, упаковка 500г', 'FOOD', 550.00, 25),
       (uuid_generate_v4(), 'Смартфон Realme 12 PRO PLUS', 'DVC-001-317', 'Смартфон realme 10 Pro+ NFC 8/256 Гб', 'DEVICES', 28050.00, 10),
       (uuid_generate_v4(), 'Аккумуляторный шуруповерт Makita DTD152Z', 'TLS-003-578', 'Без аккумулятора и зарядного устройства', 'TOOLS', 6650.00, 15);