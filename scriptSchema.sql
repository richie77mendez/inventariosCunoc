CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `DPI` VARCHAR(45) NOT NULL,
  `FechaNacimiento` DATE NULL,
  `Cargo` VARCHAR(45) NOT NULL,
  `Profesion` VARCHAR(45) NOT NULL,
  `Division` VARCHAR(45) NOT NULL,
  `ModuloTrabajo` VARCHAR(45) NOT NULL,
  `TipoUsuario` INT NOT NULL,
  `Usuario` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`DPI`),
  UNIQUE INDEX `Usuario_UNIQUE` (`Usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tarjeta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Tarjeta` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Tarjeta` (
  `DPI` VARCHAR(45) NOT NULL,
  `codigoCorrelativo` VARCHAR(45) NOT NULL,
  `Division` VARCHAR(45) NOT NULL,
  `Modulo` VARCHAR(45) NOT NULL,
  `Salon` VARCHAR(45) NOT NULL,
  `FechaImpresion` DATE NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigoCorrelativo`),
  INDEX `fk_Tarjeta_Usuario1_idx` (`DPI` ASC),
  CONSTRAINT `fk_Tarjeta_Usuario1`
    FOREIGN KEY (`DPI`)
    REFERENCES `mydb`.`Usuario` (`DPI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TarjetaAuxiliar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TarjetaAuxiliar` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TarjetaAuxiliar` (
  `DPI` VARCHAR(45) NOT NULL,
  `codigoCorrelativo` VARCHAR(45) NOT NULL,
  `Division` VARCHAR(45) NOT NULL,
  `Modulo` VARCHAR(45) NOT NULL,
  `Salon` VARCHAR(45) NOT NULL,
  `FechaImpresion` VARCHAR(45) NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  INDEX `fk_TarjetaAuxiliar_Usuario1_idx` (`DPI` ASC),
  PRIMARY KEY (`codigoCorrelativo`),
  CONSTRAINT `fk_TarjetaAuxiliar_Usuario1`
    FOREIGN KEY (`DPI`)
    REFERENCES `mydb`.`Usuario` (`DPI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Bien`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Bien` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Bien` (
  `Nombre` VARCHAR(200) NOT NULL,
  `UnidadAcademica` VARCHAR(45) NOT NULL,
  `CodigoTipoBien` VARCHAR(10) NOT NULL,
  `Adquision` VARCHAR(45) NOT NULL,
  `Costo` DOUBLE NOT NULL,
  `Estado` VARCHAR(45) NOT NULL,
  `Cuenta` VARCHAR(45) NOT NULL,
  `Tarjeta_codigoCorrelativo` VARCHAR(45) NOT NULL,
  `TarjetaAuxiliar_codigoCorrelativo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Tarjeta_codigoCorrelativo`, `TarjetaAuxiliar_codigoCorrelativo`),
  INDEX `fk_Bien_TarjetaAuxiliar1_idx` (`TarjetaAuxiliar_codigoCorrelativo` ASC),
  CONSTRAINT `fk_Bien_Tarjeta1`
    FOREIGN KEY (`Tarjeta_codigoCorrelativo`)
    REFERENCES `mydb`.`Tarjeta` (`codigoCorrelativo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bien_TarjetaAuxiliar1`
    FOREIGN KEY (`TarjetaAuxiliar_codigoCorrelativo`)
    REFERENCES `mydb`.`TarjetaAuxiliar` (`codigoCorrelativo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`LogTraslados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`LogTraslados` ;

CREATE TABLE IF NOT EXISTS `mydb`.`LogTraslados` (
  `idLogTraslado` INT NOT NULL AUTO_INCREMENT,
  `dpiViejo` VARCHAR(45) NOT NULL,
  `dpiNuevo` VARCHAR(45) NOT NULL,
  `fechaTraslado` DATE NOT NULL,
  `codigoTarjeta` VARCHAR(45) NOT NULL,
  `TrasladoDe` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idLogTraslado`))
ENGINE = InnoDB;
