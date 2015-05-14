DROP DATABASE `sushidb`;
CREATE DATABASE IF NOT EXISTS `sushidb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sushidb`;

-- -----------------------------------------------------
-- Table `Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cliente`;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS cliente (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(20) NULL,
  `usuario` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(32) NOT NULL,
  `cpf` VARCHAR(25) NOT NULL,
  `endereco` VARCHAR(100) NULL,
  `numero` VARCHAR(10),
  `complemento` VARCHAR(100) NULL,
  `bairro` VARCHAR(100) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(2) NULL,
  `cep` varchar(9) NULL,
  `tipo` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`, `cpf`));

