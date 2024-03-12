
-- Inserting sample data into customers
INSERT INTO customers (customer_id, name, email, contact_number, address) VALUES
(UUID(), 'Alice Brown', 'alice.brown@example.com', '555-0101', '123 Maple Street'),
(UUID(), 'Bob Smith', 'bob.smith@example.com', '555-0102', '456 Oak Street'),
(UUID(), 'Carol Jones', 'carol.jones@example.com', '555-0103', '789 Pine Street'),
(UUID(), 'David Wilson', 'david.wilson@example.com', '555-0104', '101 Birch Street'),
(UUID(), 'Eva Black', 'eva.black@example.com', '555-0105', '234 Cedar Street'),
(UUID(), 'Frank White', 'frank.white@example.com', '555-0106', '567 Spruce Street'),
(UUID(), 'Grace Hall', 'grace.hall@example.com', '555-0107', '890 Ash Street'),
(UUID(), 'Henry Green', 'henry.green@example.com', '555-0108', '123 Walnut Street'),
(UUID(), 'Isla Young', 'isla.young@example.com', '555-0109', '456 Cherry Street'),
(UUID(), 'Jack King', 'jack.king@example.com', '555-0110', '789 Elm Street');

-- Inserting sample data into products with more specific categories
INSERT INTO products (product_id, name, description, price, category) VALUES
(UUID(), 'Rose', 'Elegant Red Rose', 10.00, 'Roses'),
(UUID(), 'Tulip', 'Bright Yellow Tulip', 8.50, 'Tulips'),
(UUID(), 'Daisy', 'Charming White Daisy', 5.00, 'Daisies'),
(UUID(), 'Orchid', 'Exotic Purple Orchid', 15.00, 'Orchids'),
(UUID(), 'Sunflower', 'Vibrant Sunflower', 7.00, 'Sunflowers'),
(UUID(), 'Lily', 'Serenic White Lily', 12.00, 'Lilies'),
(UUID(), 'Carnation', 'Delicate Pink Carnation', 6.50, 'Carnations'),
(UUID(), 'Hyacinth', 'Fragrant Blue Hyacinth', 9.00, 'Hyacinths'),
(UUID(), 'Chrysanthemum', 'Versatile Chrysanthemum', 8.00, 'Chrysanthemums'),
(UUID(), 'Peony', 'Lush Peony', 11.00, 'Peonies');
