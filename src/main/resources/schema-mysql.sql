-- Drop tables if they already exist
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS stock_items;

-- Creation of the categories table
CREATE TABLE categories
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Creation of the customers table
CREATE TABLE customers
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id    VARCHAR(255) NOT NULL,
    name           VARCHAR(255) NOT NULL,
    email          VARCHAR(255) NOT NULL,
    contact_number VARCHAR(255) NOT NULL,
    address        VARCHAR(255) NOT NULL,
    UNIQUE (customer_id),
    UNIQUE (email)
);

-- Creation of the products table with a foreign key to categories
CREATE TABLE products
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id  VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    category_id BIGINT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    UNIQUE (product_id)
);

CREATE TABLE order_items
(
    price_per_item FLOAT       NOT NULL,
    quantity       INTEGER     NOT NULL,
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id       BIGINT,
    product_id     VARCHAR(255) NOT NULL
);

CREATE TABLE orders
(
    id                  BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id            VARCHAR(255) NOT NULL,
    billing_information VARCHAR(255) NOT NULL,
    customer_id         VARCHAR(255) NOT NULL,
    shipping_address    VARCHAR(255) NOT NULL,
    status              VARCHAR(255) NOT NULL
);

CREATE TABLE stock_items
(
    reorder_threshold INTEGER      NOT NULL CHECK (reorder_threshold >= 0),
    stock_level       INTEGER      NOT NULL CHECK (stock_level >= 0),
    id                BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id        VARCHAR(255) NOT NULL,
    stock_item_id     VARCHAR(255)
);

-- Add foreign key constraints as before
ALTER TABLE order_items ADD CONSTRAINT FKbioxgbv59vetrxe0ejfubep1w FOREIGN KEY (order_id) REFERENCES orders(id);
