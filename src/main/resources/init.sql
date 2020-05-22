START TRANSACTION;
USE `computer_shop`;
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (1, 'Computer');
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (2, 'Laptop');
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (3, 'Monitor');
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (4, 'CPU');
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (5, 'GPU');
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (6, 'RAM');
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (7, 'Motherboard');
INSERT IGNORE INTO `computer_shop`.`categories` (`category_id`, `category_name`)
VALUES (8, 'Power_supply');

COMMIT;


-- -----------------------------------------------------
-- Data for table `computer_shop`.`shops`
-- -----------------------------------------------------
START TRANSACTION;
USE `computer_shop`;
INSERT IGNORE INTO `computer_shop`.`shops` (`shop_id`, `address`)
VALUES (1, 'Kharkiv,Pushkinska st., 67');
INSERT IGNORE INTO `computer_shop`.`shops` (`shop_id`, `address`)
VALUES (2, 'Kiev, Khreshchatyk st., 23');
INSERT IGNORE INTO `computer_shop`.`shops` (`shop_id`, `address`)
VALUES (3, 'Lviv, Derevyanko st., 42');

COMMIT;


-- -----------------------------------------------------
-- Data for table `computer_shop`.`products`
-- -----------------------------------------------------
START TRANSACTION;
USE `computer_shop`;
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (1, 'Macbook Pro ', 120000, 2);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (2, 'Asus monoblock', 20000, 1);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (3, 'Samsung monitor', 5000, 3);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (4, 'LG monitor', 10000, 3);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (5, 'AMD athlon X64', 3000, 4);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (6, 'Intel xeon ', 30000, 4);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (7, 'GeForce RTX 2080', 30000, 5);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (8, 'Radeon RX5800', 20000, 5);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (9, 'Hyperx Fury ', 8000, 6);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (10, 'Asus z370', 5000, 7);
INSERT IGNORE INTO `computer_shop`.`products` (`product_id`, `name`, `cost`, `category_id`)
VALUES (11, 'Chieftec 700w', 7000, 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `computer_shop`.`shops_has_products`
-- -----------------------------------------------------
START TRANSACTION;
USE `computer_shop`;
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (1, 1);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (1, 2);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (1, 3);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (1, 5);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (1, 8);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (2, 1);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (2, 2);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (2, 10);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (2, 11);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (2, 9);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (2, 7);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (3, 6);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (3, 7);
INSERT IGNORE INTO `computer_shop`.`shops_has_products` (`shop_id`, `product_id`)
VALUES (3, 8);

COMMIT;


-- -----------------------------------------------------
-- Data for table `computer_shop`.`description`
-- -----------------------------------------------------
START TRANSACTION;
USE `computer_shop`;
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (1, 'China', 'CPU: i7 8750h, GPU: RX 580 4 GB', 1);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (2, 'China', 'CPU: i5 9300 GPU: GeForce 660', 2);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (3, 'South Korea', 'Diagonal: 19\' , VA', 3);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (4, 'South Korea', 'Diagonal: 27 \' , IPS, 120 Hz', 4);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (5, 'China', '2 cores, 3.5 Ghz', 5);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (6, 'China', '8 cores, 2.8 - 3.8 Ghz', 6);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (7, 'China', '8GB, GDDR6', 7);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (8, 'China', '8GB,GDDR6', 8);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (9, 'USA', '16GB,3100 MHz', 9);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (10, 'China', 'Socket: 1151, 1x GPU', 10);
INSERT IGNORE INTO `computer_shop`.`description` (`description_id`, `maintainer`, `characteristics`, `product_id`)
VALUES (11, 'China', 'Atx20 + 4pin', 11);

COMMIT;