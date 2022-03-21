CREATE TABLE `holiday` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `is_active` tinyint NOT NULL DEFAULT '0',
  `is_deleted` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE `permission` (
    `id` int NOT NULL AUTO_INCREMENT,
    `user` int NOT NULL,
    `from_date` date DEFAULT NULL,
    `to_date` date DEFAULT NULL,
    `reason` varchar(45) NOT NULL,
    `business_days` int NOT NULL,
    `request_type` varchar(45) NOT NULL,
    `permission_status` varchar(45) NOT NULL,
    `is_deleted` tinyint NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
   `id` int NOT NULL AUTO_INCREMENT,
   `first_name` varchar(45) NOT NULL,
   `last_name` varchar(45) NOT NULL,
   `email` varchar(45) NOT NULL,
   `password` varchar(45) NOT NULL,
   `birthday` date DEFAULT NULL,
   `gender` varchar(45) NOT NULL,
   `hire_date` date DEFAULT NULL,
   `paid_time_off` int NOT NULL,
   `is_deleted` bit(1) NOT NULL DEFAULT b'0',
   PRIMARY KEY (`id`)
);

CREATE TABLE `department` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `description` varchar(45) NOT NULL,
    `department_leader` int NOT NULL,
    `is_deleted` tinyint NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
);

CREATE TABLE `role` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `description` varchar(45) NOT NULL,
    `is_deleted` tinyint NOT NULL DEFAULT '0',
    PRIMARY KEY (`id`)
)