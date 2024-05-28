## Table Query

- uesr
- product
- orders
- oreder_product
- reviews

<br>

### user

```sql
CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(50) NOT NULL,
   `passwd` varchar(255) NOT NULL,
   `user_type` enum('seller','customer') NOT NULL,
   `user_grade` enum('브론즈','실버','골드','플레티넘') DEFAULT '브론즈',
   `del_YN` char(1) NOT NULL DEFAULT 'N',
   `created_at` timestamp NULL DEFAULT current_timestamp(),
   `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
   `email` varchar(255) NOT NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `email` (`email`)
 )
```

<br>

### product

```sql
CREATE TABLE `product` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(100) NOT NULL,
   `description` text DEFAULT NULL,
   `price` decimal(10,2) NOT NULL,
   `quantity` int(11) NOT NULL,
   `seller_id` int(11) DEFAULT NULL,
   `del_YN` char(1) NOT NULL DEFAULT 'N',
   `created_at` timestamp NULL DEFAULT current_timestamp(),
   `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
   PRIMARY KEY (`seller_id`),
   CONSTRAINT `product_ibfk_1` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`)
 )
```

<br>

### orders

```sql
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  `product_count` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
 ) 

```

<br>

### oreder_product

```sql
CREATE TABLE `order_product` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `order_id` int(11) DEFAULT NULL,
   `product_id` int(11) DEFAULT NULL,
   `quantity` int(11) NOT NULL,
   `price` decimal(10,2) NOT NULL,
   `created_at` timestamp NULL DEFAULT current_timestamp(),
   `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
   PRIMARY KEY (`id`),
   KEY `order_id` (`order_id`),
   KEY `product_id` (`product_id`),
   CONSTRAINT `order_product_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
   CONSTRAINT `order_product_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
 )
```

<br>

### reviews

```sql
CREATE TABLE `reviews` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `product_id` int(11) DEFAULT NULL,
   `user_id` int(11) DEFAULT NULL,
   `rating` int(11) DEFAULT NULL CHECK (`rating` >= 1 and `rating` <= 5),
   `review_text` text DEFAULT NULL,
   `created_at` timestamp NULL DEFAULT current_timestamp(),
   `updated_at` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
   PRIMARY KEY (`id`),
   KEY `product_id` (`product_id`),
   KEY `user_id` (`user_id`),
   CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
   CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
 )




