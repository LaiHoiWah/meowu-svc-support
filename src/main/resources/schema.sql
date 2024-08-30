DROP TABLE IF EXISTS `st_group`;
CREATE TABLE `st_group` (
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `code`        VARCHAR(6)  NOT NULL,
    `description` VARCHAR(50) NOT NULL,
    `create_time` TIMESTAMP   NOT NULL,
    `update_time` TIMESTAMP   DEFAULT NULL,
    `delete_time` TIMESTAMP   DEFAULT NULL,
    PRIMARY KEY (`id`)
);