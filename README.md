###启动要求

有MySQL，在resources/application.yml里配置MySQL连接，数据库名用cloth_arrangement

要有用户头像上传功能的话，要在src/main/java/com/hehe/boot/Utils/UploadUtils.java配置阿里云对象存储服务，功能有bug，只能上传emmmm



MySQL的SQL

```sql
create database if not exists cloth_arrangement

--------------------------------------------------------------------------------

CREATE TABLE user
(
	id BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
	username VARCHAR(30) NULL DEFAULT NULL COMMENT '用户名',
	password VARCHAR(50) NULL DEFAULT NULL COMMENT '密码'
);

INSERT INTO user (id, username, password) VALUES
(1, 'Jone','hehe123'),
(2, 'Bill','123456');

--------------------------------------------------------------------------------

CREATE TABLE statistics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_count INT NOT NULL,
    operation_count INT NOT NULL,
    product_count INT NOT NULL,
    order_count INT NOT NULL
);

INSERT INTO statistics (user_count, operation_count, product_count, order_count)
VALUES (6666,168,8888,569);

--------------------------------------------------------------------------------

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    color VARCHAR(50) NOT NULL,
    quality INT NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
		category VARCHAR(50) NOT NULL
);

INSERT INTO products (name, price, stock, color, quality, description, image_url, category) 
VALUES ('T-Shirt', 19.99, 100, 'Red', 1, 'A high-quality red T-shirt.', 'http://example.com/images/tshirt.jpg','Topwear');

INSERT INTO products (name, price, stock, color, quality, description, image_url, category) 
VALUES ('', 1, 0, '', 1, '', '.jpg','');

--------------------------------------------------------------------------------

CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    uid VARCHAR(50) NOT NULL UNIQUE,
    product_id INT NOT NULL,
		number INT NOT NULL,
    address VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    month INT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO orders (uid, product_id, number, address, status, phone, month) 
VALUES ('ORD123456789', 1, 1000, '123 Main St, Anytown, USA', '已收货 运输中 待发货', '123-456-7890', 1);

INSERT INTO orders (uid, product_id, number, address, status, phone, month) 
VALUES ('ORD123456774', 14, 1100, '青海', '待发货', '19546871644', 3);

--------------------------------------------------------------------------------

CREATE TABLE operations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    kind VARCHAR(50) NOT NULL,
    timestamp DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- timestamp：操作时间，使用 DATETIME 存储，并且默认值为当前时间戳。

INSERT INTO operations (name, kind) 
VALUES ('Jason', '用户评价');

```

