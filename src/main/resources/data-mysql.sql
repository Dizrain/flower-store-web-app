-- Inserting sample data into customers
INSERT INTO customers (customer_id, name, email, contact_number, address)
VALUES (UUID(), 'Alice Brown', 'alice.brown@example.com', '555-0101', '123 Maple Street'),
       (UUID(), 'Bob Smith', 'bob.smith@example.com', '555-0102', '456 Oak Street'),
       (UUID(), 'Carol Jones', 'carol.jones@example.com', '555-0103', '789 Pine Street'),
       (UUID(), 'David Wilson', 'david.wilson@example.com', '555-0104', '101 Birch Street'),
       (UUID(), 'Eva Black', 'eva.black@example.com', '555-0105', '234 Cedar Street'),
       (UUID(), 'Frank White', 'frank.white@example.com', '555-0106', '567 Spruce Street'),
       (UUID(), 'Grace Hall', 'grace.hall@example.com', '555-0107', '890 Ash Street'),
       (UUID(), 'Henry Green', 'henry.green@example.com', '555-0108', '123 Walnut Street'),
       (UUID(), 'Isla Young', 'isla.young@example.com', '555-0109', '456 Cherry Street'),
       (UUID(), 'Jack King', 'jack.king@example.com', '555-0110', '789 Elm Street');

-- Inserting sample data into orders
INSERT INTO orders (order_id, billing_information, customer_id, shipping_address, status)
VALUES (UUID(), 'Paid via Credit Card', (SELECT customer_id FROM customers WHERE name = 'Alice Brown'), '123 Maple Street', 'SHIPPED'),
       (UUID(), 'Paid via PayPal', (SELECT customer_id FROM customers WHERE name = 'Bob Smith'), '456 Oak Street', 'PLACED'),
       (UUID(), 'Paid via Credit Card', (SELECT customer_id FROM customers WHERE name = 'Carol Jones'), '789 Pine Street', 'DELIVERED'),
       (UUID(), 'Paid via Debit Card', (SELECT customer_id FROM customers WHERE name = 'David Wilson'), '101 Birch Street', 'CANCELLED'),
       (UUID(), 'Paid via Credit Card', (SELECT customer_id FROM customers WHERE name = 'Eva Black'), '234 Cedar Street', 'SHIPPED'),
       (UUID(), 'Paid via PayPal', (SELECT customer_id FROM customers WHERE name = 'Frank White'), '567 Spruce Street', 'PLACED'),
       (UUID(), 'Paid via Credit Card', (SELECT customer_id FROM customers WHERE name = 'Grace Hall'), '890 Ash Street', 'DELIVERED'),
       (UUID(), 'Paid via Debit Card', (SELECT customer_id FROM customers WHERE name = 'Henry Green'), '123 Walnut Street', 'CANCELLED'),
       (UUID(), 'Paid via Credit Card', (SELECT customer_id FROM customers WHERE name = 'Isla Young'), '456 Cherry Street', 'SHIPPED'),
       (UUID(), 'Paid via PayPal', (SELECT customer_id FROM customers WHERE name = 'Jack King'), '789 Elm Street', 'PLACED');

-- Inserting categories into categories table
INSERT INTO categories (category_id, name)
VALUES (UUID(), 'Roses'),
       (UUID(), 'Tulips'),
       (UUID(), 'Daisies'),
       (UUID(), 'Orchids'),
       (UUID(), 'Sunflowers'),
       (UUID(), 'Lilies'),
       (UUID(), 'Carnations'),
       (UUID(), 'Hyacinths'),
       (UUID(), 'Chrysanthemums'),
       (UUID(), 'Peonies');

-- Inserting sample data into products without category_id references
INSERT INTO products (product_id, name, description, price)
VALUES (UUID(), 'Rose', 'Elegant Red Rose', 10.00),
       (UUID(), 'Tulip', 'Bright Yellow Tulip', 8.50),
       (UUID(), 'Daisy', 'Charming White Daisy', 5.00),
       (UUID(), 'Orchid', 'Exotic Purple Orchid', 15.00),
       (UUID(), 'Sunflower', 'Vibrant Sunflower', 7.00),
       (UUID(), 'Lily', 'Serenic White Lily', 12.00),
       (UUID(), 'Carnation', 'Delicate Pink Carnation', 6.50),
       (UUID(), 'Hyacinth', 'Fragrant Blue Hyacinth', 9.00),
       (UUID(), 'Chrysanthemum', 'Versatile Chrysanthemum', 8.00),
       (UUID(), 'Peony', 'Lush Peony', 11.00);

-- Inserting sample data into product_category join table
INSERT INTO product_category (product_id, category_id)
VALUES ((SELECT id FROM products WHERE name = 'Rose'), (SELECT id FROM categories WHERE name = 'Roses')),
       ((SELECT id FROM products WHERE name = 'Tulip'), (SELECT id FROM categories WHERE name = 'Tulips')),
       ((SELECT id FROM products WHERE name = 'Daisy'), (SELECT id FROM categories WHERE name = 'Daisies')),
       ((SELECT id FROM products WHERE name = 'Orchid'), (SELECT id FROM categories WHERE name = 'Orchids')),
       ((SELECT id FROM products WHERE name = 'Sunflower'), (SELECT id FROM categories WHERE name = 'Sunflowers')),
       ((SELECT id FROM products WHERE name = 'Lily'), (SELECT id FROM categories WHERE name = 'Lilies')),
       ((SELECT id FROM products WHERE name = 'Carnation'), (SELECT id FROM categories WHERE name = 'Carnations')),
       ((SELECT id FROM products WHERE name = 'Hyacinth'), (SELECT id FROM categories WHERE name = 'Hyacinths')),
       ((SELECT id FROM products WHERE name = 'Chrysanthemum'), (SELECT id FROM categories WHERE name = 'Chrysanthemums')),
       ((SELECT id FROM products WHERE name = 'Peony'), (SELECT id FROM categories WHERE name = 'Peonies'));

-- Inserting sample data into order_items
INSERT INTO order_items (price_per_item, quantity, order_id, product_id)
VALUES (10.00, 2, 1, (SELECT product_id FROM products WHERE name = 'Rose')),
       (8.50, 3, 2, (SELECT product_id FROM products WHERE name = 'Tulip')),
       (5.00, 5, 3, (SELECT product_id FROM products WHERE name = 'Daisy')),
       (15.00, 1, 4, (SELECT product_id FROM products WHERE name = 'Orchid')),
       (7.00, 4, 5, (SELECT product_id FROM products WHERE name = 'Sunflower')),
       (12.00, 2, 6, (SELECT product_id FROM products WHERE name = 'Lily')),
       (6.50, 3, 7, (SELECT product_id FROM products WHERE name = 'Carnation')),
       (9.00, 2, 8, (SELECT product_id FROM products WHERE name = 'Hyacinth')),
       (8.00, 1, 9, (SELECT product_id FROM products WHERE name = 'Chrysanthemum')),
       (11.00, 1, 10, (SELECT product_id FROM products WHERE name = 'Peony'));

-- Inserting sample data into stock_items
INSERT INTO stock_items (reorder_threshold, stock_level, product_id, stock_item_id)
VALUES (5, 20, (SELECT product_id FROM products WHERE name = 'Rose'), UUID()),
       (3, 15, (SELECT product_id FROM products WHERE name = 'Tulip'), UUID()),
       (4, 25, (SELECT product_id FROM products WHERE name = 'Daisy'), UUID()),
       (2, 10, (SELECT product_id FROM products WHERE name = 'Orchid'), UUID()),
       (6, 30, (SELECT product_id FROM products WHERE name = 'Sunflower'), UUID()),
       (5, 20, (SELECT product_id FROM products WHERE name = 'Lily'), UUID()),
       (3, 15, (SELECT product_id FROM products WHERE name = 'Carnation'), UUID()),
       (4, 12, (SELECT product_id FROM products WHERE name = 'Hyacinth'), UUID()),
       (5, 18, (SELECT product_id FROM products WHERE name = 'Chrysanthemum'), UUID()),
       (2, 10, (SELECT product_id FROM products WHERE name = 'Peony'), UUID());


