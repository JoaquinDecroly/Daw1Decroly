-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema VetDaw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema VetDaw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `VetDaw` DEFAULT CHARACTER SET utf8 ;
USE `VetDaw` ;

-- -----------------------------------------------------
-- Table `VetDaw`.`Propietario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetDaw`.`Propietario` (
  `dni` VARCHAR(10) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(12) NOT NULL,
  `Direcion` VARCHAR(100) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VetDaw`.`Tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetDaw`.`Tipo` (
  `idTipo` INT NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `idTipo_UNIQUE` (`idTipo` ASC) VISIBLE,
  UNIQUE INDEX `Tipo_UNIQUE` (`Tipo` ASC) VISIBLE,
  PRIMARY KEY (`idTipo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VetDaw`.`Mascota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetDaw`.`Mascota` (
  `Pasaporte` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Peso` DOUBLE NOT NULL,
  `FechaNacimiento` DATETIME NOT NULL,
  `Propietario_dni` VARCHAR(10) NOT NULL,
  `Tipo_idTipo` INT NOT NULL,
  PRIMARY KEY (`Pasaporte`, `Propietario_dni`, `Tipo_idTipo`),
  UNIQUE INDEX `Pasaporte_UNIQUE` (`Pasaporte` ASC) VISIBLE,
  INDEX `fk_Mascota_Propietario_idx` (`Propietario_dni` ASC) VISIBLE,
  INDEX `fk_Mascota_Tipo1_idx` (`Tipo_idTipo` ASC) VISIBLE,
  CONSTRAINT `fk_Mascota_Propietario`
    FOREIGN KEY (`Propietario_dni`)
    REFERENCES `VetDaw`.`Propietario` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mascota_Tipo1`
    FOREIGN KEY (`Tipo_idTipo`)
    REFERENCES `VetDaw`.`Tipo` (`idTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VetDaw`.`Consulta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VetDaw`.`Consulta` (
  `idConsulta` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATETIME NOT NULL,
  `Duracion` INT NOT NULL,
  `Observaciones` TEXT NULL,
  `Mascota_Pasaporte` VARCHAR(9) NOT NULL,
  `Mascota_Propietario_dni` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idConsulta`, `Mascota_Pasaporte`, `Mascota_Propietario_dni`),
  INDEX `fk_Consulta_Mascota1_idx` (`Mascota_Pasaporte` ASC, `Mascota_Propietario_dni` ASC) VISIBLE,
  CONSTRAINT `fk_Consulta_Mascota1`
    FOREIGN KEY (`Mascota_Pasaporte` , `Mascota_Propietario_dni`)
    REFERENCES `VetDaw`.`Mascota` (`Pasaporte` , `Propietario_dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
