CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(15) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(35) DEFAULT NULL,
    `surname` VARCHAR(35) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
    `id` BIGINT(15) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(35) NOT NULL,
    `description` VARCHAR(250) NOT NULL,
    `price` DECIMAL(15,2) NOT NULL,
    `stock` INT(15) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
    `id` BIGINT(15) NOT NULL AUTO_INCREMENT,
    `fk_user_id` BIGINT(15) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY(fk_user_id) REFERENCES user(id)
    );