-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Clinica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Clinica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Clinica` DEFAULT CHARACTER SET utf8 ;
USE `Clinica` ;

-- -----------------------------------------------------
-- Table `Clinica`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Primer_Apellido` VARCHAR(45) NOT NULL,
  `Segundo_Apellido` VARCHAR(45) NULL,
  `Calle` VARCHAR(45) NULL,
  `Num_Casa` INT NULL,
  `Colonia` VARCHAR(45) NULL,
  `CP` INT NULL,
  `Num_Telefono` INT NULL,
  `Puesto` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEmpleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Paciente` (
  `idPaciente` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Primer_Apellido` VARCHAR(45) NULL,
  `Segundo_Apellido` VARCHAR(45) NULL,
  `Fecha_Nacimiento` DATE NULL,
  `Sexo` VARCHAR(10) NULL,
  `Tipo_Sangre` VARCHAR(5) NULL,
  `Alergias` VARCHAR(45) NULL,
  `Num_Telefono` INT NULL,
  `Fecha_Registro` DATE NULL,
  PRIMARY KEY (`idPaciente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`PagoServicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`PagoServicio` (
  `idPagoServicio` INT NOT NULL AUTO_INCREMENT,
  `Monto_Restante` DECIMAL(10,2) NULL,
  PRIMARY KEY (`idPagoServicio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Diagnostico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Diagnostico` (
  `idDiagnostico` INT NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idDiagnostico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Cita` (
  `idCita` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Cita` DATE NULL,
  `Hora_Cita` TIME NULL,
  `Motivo_Cita` VARCHAR(45) NULL,
  `Estado` VARCHAR(15) NULL,
  `Costo_Cita` DECIMAL(10,2) NULL,
  `Paciente_idPaciente` INT NOT NULL,
  `Empleado_idEmpleado` INT NOT NULL,
  `PagoServicio_idPagoServicio` INT NOT NULL,
  `Diagnostico_idDiagnostico` INT NOT NULL,
  PRIMARY KEY (`idCita`, `Paciente_idPaciente`, `Empleado_idEmpleado`, `PagoServicio_idPagoServicio`),
  INDEX `fk_Cita_Paciente1_idx` (`Paciente_idPaciente` ASC) VISIBLE,
  INDEX `fk_Cita_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  INDEX `fk_Cita_PagoServicio1_idx` (`PagoServicio_idPagoServicio` ASC) VISIBLE,
  INDEX `fk_Cita_Diagnostico1_idx` (`Diagnostico_idDiagnostico` ASC) VISIBLE,
  CONSTRAINT `fk_Cita_Paciente1`
    FOREIGN KEY (`Paciente_idPaciente`)
    REFERENCES `Clinica`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `Clinica`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_PagoServicio1`
    FOREIGN KEY (`PagoServicio_idPagoServicio`)
    REFERENCES `Clinica`.`PagoServicio` (`idPagoServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cita_Diagnostico1`
    FOREIGN KEY (`Diagnostico_idDiagnostico`)
    REFERENCES `Clinica`.`Diagnostico` (`idDiagnostico`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Parto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Parto` (
  `idParto` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Parto` DATE NULL,
  `Hora_Parto` TIME NULL,
  `Tipo_Parto` VARCHAR(15) NULL,
  `Observaciones` VARCHAR(45) NULL,
  `Paciente_idPaciente` INT NOT NULL,
  PRIMARY KEY (`idParto`, `Paciente_idPaciente`),
  INDEX `fk_Parto_Paciente1_idx` (`Paciente_idPaciente` ASC) VISIBLE,
  CONSTRAINT `fk_Parto_Paciente1`
    FOREIGN KEY (`Paciente_idPaciente`)
    REFERENCES `Clinica`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Operacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Operacion` (
  `idOperacion` INT NOT NULL AUTO_INCREMENT,
  `Tipo_Operacion` VARCHAR(20) NULL,
  `Fecha_Operacion` DATE NULL,
  `Duracion` TIME NULL,
  `idPaciente` VARCHAR(45) NULL,
  `idEmpleado` VARCHAR(45) NULL,
  `Observaciones` VARCHAR(45) NULL,
  `Costo_Operacion` DECIMAL(10,2) NULL,
  `Paciente_idPaciente` INT NOT NULL,
  `PagoServicio_idPagoServicio` INT NOT NULL,
  PRIMARY KEY (`idOperacion`, `Paciente_idPaciente`, `PagoServicio_idPagoServicio`),
  INDEX `fk_Operacion_Paciente1_idx` (`Paciente_idPaciente` ASC) VISIBLE,
  INDEX `fk_Operacion_PagoServicio1_idx` (`PagoServicio_idPagoServicio` ASC) VISIBLE,
  CONSTRAINT `fk_Operacion_Paciente1`
    FOREIGN KEY (`Paciente_idPaciente`)
    REFERENCES `Clinica`.`Paciente` (`idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Operacion_PagoServicio1`
    FOREIGN KEY (`PagoServicio_idPagoServicio`)
    REFERENCES `Clinica`.`PagoServicio` (`idPagoServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `Monto` DECIMAL(10,2) NULL,
  `Fecha_Pago` DATE NULL,
  `Metodo_Pago` VARCHAR(25) NULL,
  `PagoServicio_idPagoServicio` INT NOT NULL,
  PRIMARY KEY (`idPago`, `PagoServicio_idPagoServicio`),
  INDEX `fk_Pago_PagoServicio1_idx` (`PagoServicio_idPagoServicio` ASC) VISIBLE,
  CONSTRAINT `fk_Pago_PagoServicio1`
    FOREIGN KEY (`PagoServicio_idPagoServicio`)
    REFERENCES `Clinica`.`PagoServicio` (`idPagoServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Emision` DATE NULL,
  `RFC` VARCHAR(15) NULL,
  `idPagoServicio` VARCHAR(45) NULL,
  `PagoServicio_idPagoServicio` INT NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_Factura_PagoServicio1_idx` (`PagoServicio_idPagoServicio` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_PagoServicio1`
    FOREIGN KEY (`PagoServicio_idPagoServicio`)
    REFERENCES `Clinica`.`PagoServicio` (`idPagoServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Empleado_has_Parto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Empleado_has_Parto` (
  `Empleado_idEmpleado` INT NOT NULL,
  `Parto_idParto` INT NOT NULL,
  `Parto_Paciente_idPaciente` INT NOT NULL,
  PRIMARY KEY (`Empleado_idEmpleado`, `Parto_idParto`, `Parto_Paciente_idPaciente`),
  INDEX `fk_Empleado_has_Parto_Parto1_idx` (`Parto_idParto` ASC, `Parto_Paciente_idPaciente` ASC) VISIBLE,
  INDEX `fk_Empleado_has_Parto_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_has_Parto_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `Clinica`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_has_Parto_Parto1`
    FOREIGN KEY (`Parto_idParto` , `Parto_Paciente_idPaciente`)
    REFERENCES `Clinica`.`Parto` (`idParto` , `Paciente_idPaciente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinica`.`Empleado_has_Operacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinica`.`Empleado_has_Operacion` (
  `Empleado_idEmpleado` INT NOT NULL,
  `Operacion_idOperacion` INT NOT NULL,
  `Operacion_Paciente_idPaciente` INT NOT NULL,
  `Operacion_PagoServicio_idPagoServicio` INT NOT NULL,
  PRIMARY KEY (`Empleado_idEmpleado`, `Operacion_idOperacion`, `Operacion_Paciente_idPaciente`, `Operacion_PagoServicio_idPagoServicio`),
  INDEX `fk_Empleado_has_Operacion_Operacion1_idx` (`Operacion_idOperacion` ASC, `Operacion_Paciente_idPaciente` ASC, `Operacion_PagoServicio_idPagoServicio` ASC) VISIBLE,
  INDEX `fk_Empleado_has_Operacion_Empleado1_idx` (`Empleado_idEmpleado` ASC) VISIBLE,
  CONSTRAINT `fk_Empleado_has_Operacion_Empleado1`
    FOREIGN KEY (`Empleado_idEmpleado`)
    REFERENCES `Clinica`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_has_Operacion_Operacion1`
    FOREIGN KEY (`Operacion_idOperacion` , `Operacion_Paciente_idPaciente` , `Operacion_PagoServicio_idPagoServicio`)
    REFERENCES `Clinica`.`Operacion` (`idOperacion` , `Paciente_idPaciente` , `PagoServicio_idPagoServicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
