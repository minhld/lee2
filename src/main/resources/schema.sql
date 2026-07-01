CREATE TABLE customers (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE items (
    id BIGINT PRIMARY KEY,
    sku VARCHAR(50) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE customer_orders (
    id BIGINT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    order_number VARCHAR(50) NOT NULL UNIQUE,
    order_date DATE NOT NULL,
    status VARCHAR(30) NOT NULL,
    CONSTRAINT fk_customer_orders_customer
        FOREIGN KEY (customer_id)
        REFERENCES customers (id)
);

CREATE TABLE order_items (
    id BIGINT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    item_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_order_items_order
        FOREIGN KEY (order_id)
        REFERENCES customer_orders (id),
    CONSTRAINT fk_order_items_item
        FOREIGN KEY (item_id)
        REFERENCES items (id),
    CONSTRAINT uq_order_items_order_item
        UNIQUE (order_id, item_id)
);
