CREATE TABLE order_items
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_by    VARCHAR(255)          NOT NULL,
    created_time  datetime              NOT NULL,
    modified_by   VARCHAR(255)          NULL,
    modified_time datetime              NULL,
    product_id    BIGINT                NULL,
    quantity      INT                   NULL,
    unit_price    DECIMAL               NULL,
    order_id      BIGINT                NULL,
    CONSTRAINT pk_order_items PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_by    VARCHAR(255)          NOT NULL,
    created_time  datetime              NOT NULL,
    modified_by   VARCHAR(255)          NULL,
    modified_time datetime              NULL,
    status        VARCHAR(255)          NULL,
    user_id       BIGINT                NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE users
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    created_by    VARCHAR(255)          NOT NULL,
    created_time  datetime              NOT NULL,
    modified_by   VARCHAR(255)          NULL,
    modified_time datetime              NULL,
    full_name     VARCHAR(255)          NULL,
    age           SMALLINT              NULL,
    email         VARCHAR(255)          NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE order_items
    ADD CONSTRAINT FK_ORDER_ITEMS_ON_ORDER FOREIGN KEY (order_id) REFERENCES orders (id);