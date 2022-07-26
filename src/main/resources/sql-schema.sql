CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(15) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(35) DEFAULT NULL,
    `surname` VARCHAR(35) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `price` DECIMAL(15,2) NOT NULL,
    `stock` INT(11) NOT NULL,
    PRIMARY KEY (`id`)
);
