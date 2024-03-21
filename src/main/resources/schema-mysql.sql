-- Drop tables if they already exist
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS product_category;
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS stock_items;
SET FOREIGN_KEY_CHECKS = 1;

-- Creation of the categories table
CREATE TABLE categories
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Creation of the products table without category_id references
CREATE TABLE products
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id  VARCHAR(255) NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    price       DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    UNIQUE (product_id)
);

-- Creation of the product_category join table
CREATE TABLE product_category
(
    product_id  BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (product_id, category_id),
    FOREIGN KEY (product_id) REFERENCES products(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
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

-- Add foreign key constraints to order_items table
ALTER TABLE order_items
ADD CONSTRAINT FK_order_items_orders
FOREIGN KEY (order_id) REFERENCES orders(id),
ADD CONSTRAINT FK_order_items_products
FOREIGN KEY (product_id) REFERENCES products(id);

-- Add foreign key constraints to orders table
ALTER TABLE orders
ADD CONSTRAINT FK_orders_customers
FOREIGN KEY (customer_id) REFERENCES customers(id);

-- Add foreign key constraints to stock_items table
ALTER TABLE stock_items
ADD CONSTRAINT FK_stock_items_products
FOREIGN KEY (product_id) REFERENCES products(id);