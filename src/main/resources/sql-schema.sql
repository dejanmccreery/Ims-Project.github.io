CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(15) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(35) DEFAULT NULL,
    `surname` VARCHAR(35) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
