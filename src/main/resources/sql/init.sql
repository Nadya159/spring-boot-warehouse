CREATE DATABASE warehouse;

CREATE TABLE IF NOT EXISTS products
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE,
    article VARCHAR(64) UNIQUE,
    description VARCHAR(128) NOT NULL UNIQUE,
    category VARCHAR(64) NOT NULL UNIQUE,
    price DECIMAL NOT NULL,
    amount INTEGER,
    created_at DATE,
    modified_amount_at TIMESTAMP
);