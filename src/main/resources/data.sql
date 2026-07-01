INSERT INTO customers (id, first_name, last_name, email) VALUES
    (1, 'Maya', 'Nguyen', 'maya.nguyen@example.com'),
    (2, 'Daniel', 'Reed', 'daniel.reed@example.com'),
    (3, 'Priya', 'Shah', 'priya.shah@example.com');

INSERT INTO items (id, sku, name, unit_price) VALUES
    (1, 'KEY-001', 'Mechanical Keyboard', 129.99),
    (2, 'MOU-002', 'Wireless Mouse', 49.99),
    (3, 'MON-003', '27 Inch Monitor', 249.00),
    (4, 'USB-004', 'USB-C Hub', 79.50),
    (5, 'HDP-005', 'Noise Cancelling Headphones', 199.95);

INSERT INTO customer_orders (id, customer_id, order_number, order_date, status) VALUES
    (1, 1, 'ORD-1001', '2026-06-24', 'PAID'),
    (2, 1, 'ORD-1002', '2026-06-26', 'SHIPPED'),
    (3, 2, 'ORD-1003', '2026-06-27', 'PAID'),
    (4, 3, 'ORD-1004', '2026-06-29', 'PENDING');

INSERT INTO order_items (id, order_id, item_id, quantity, unit_price) VALUES
    (1, 1, 1, 1, 129.99),
    (2, 1, 2, 1, 49.99),
    (3, 1, 4, 2, 79.50),
    (4, 2, 3, 1, 249.00),
    (5, 2, 5, 1, 199.95),
    (6, 3, 2, 2, 49.99),
    (7, 3, 4, 1, 79.50),
    (8, 4, 1, 1, 129.99),
    (9, 4, 3, 2, 249.00),
    (10, 4, 5, 1, 199.95);
