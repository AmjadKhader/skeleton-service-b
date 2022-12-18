USE skeleton;

CREATE TABLE `order_details` (
`order_id` int NOT NULL AUTO_INCREMENT,
`order_description` text NOT NULL,
`user_id` int NOT NULL,
PRIMARY KEY (`order_id`),
UNIQUE KEY `order_id_UNIQUE` (`order_id`)
);

INSERT INTO `order_details` (`order_id`, `order_description`, `user_id`) VALUES (1 , 'MacBook pro 2020 M1' , 1);