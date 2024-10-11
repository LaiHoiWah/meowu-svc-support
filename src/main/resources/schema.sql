CREATE TABLE `st_group` (
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `code`        VARCHAR(50) NOT NULL,
    `description` VARCHAR(50) NOT NULL,
    `create_time` TIMESTAMP   NOT NULL,
    `update_time` TIMESTAMP   DEFAULT NULL,
    `delete_time` TIMESTAMP   DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `st_dictionary` (
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `group_id`    BIGINT      NOT NULL,
    `code`        VARCHAR(50) NOT NULL,
    `display`     VARCHAR(50) NOT NULL,
    `description` VARCHAR(50) NOT NULL,
    `create_time` TIMESTAMP   NOT NULL,
    `update_time` TIMESTAMP   DEFAULT NULL,
    `delete_time` TIMESTAMP   DEFAULT NULL,
    PRIMARY KEY (`id`)
);