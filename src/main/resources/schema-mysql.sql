
-- Drop tables if they already exist
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS customers;

-- Creation of the customers table
CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    contact_number VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    UNIQUE (customer_id),
    UNIQUE (email)
);

-- Creation of the products table
CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL CHECK (price > 0),
    category VARCHAR(255) NOT NULL,
    UNIQUE (product_id)
);
