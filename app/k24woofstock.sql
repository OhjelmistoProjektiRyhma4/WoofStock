DROP TABLE IF EXISTS dog_product;
DROP TABLE IF EXISTS manufacturer;
DROP TABLE IF EXISTS product_type;
DROP TABLE IF EXISTS customer;

CREATE TABLE manufacturer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(35) NOT NULL
);
CREATE TABLE product_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE dog_product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(50) NOT NULL,
    stock INT NOT NULL,
    size VARCHAR(10) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    manufacturer_id INT NOT NULL,
    product_type_id INT NOT NULL,
    FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(id),
    FOREIGN KEY (product_type_id) REFERENCES product_type(id)
);
CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    phone VARCHAR(35) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    postcode VARCHAR(20) NOT NULL
);

-- Pöytien lisäämisen jälkeen voidaan lisätä 
-- tuotetyypit, koska ei ole tuotekontorlleria
INSERT INTO product_type (name)
VALUES 
	('Vaate'),
	('Lelu');