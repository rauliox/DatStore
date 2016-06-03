SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dat
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dat` ;
CREATE SCHEMA IF NOT EXISTS `dat` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `dat` ;

-- -----------------------------------------------------
-- Table `dat`.`Estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`Estado` (
  `estado` CHAR(1) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`estado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dat`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `apellido` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `pass` BLOB NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `estado` CHAR(1) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_Usuario_Estado1_idx` (`estado` ASC),
  UNIQUE INDEX `correo_UNIQUE` (`correo` ASC),
  CONSTRAINT `fk_Usuario_Estado1`
    FOREIGN KEY (`estado`)
    REFERENCES `dat`.`Estado` (`estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dat`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `estado` CHAR(1) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  INDEX `fk_Categoria_Estado1_idx` (`estado` ASC),
  CONSTRAINT `fk_Categoria_Estado1`
    FOREIGN KEY (`estado`)
    REFERENCES `dat`.`Estado` (`estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dat`.`Subcategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`Subcategoria` (
  `idSubcategoria` INT NOT NULL AUTO_INCREMENT,
  `idCategoria` INT NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `estado` CHAR(1) NOT NULL,
  PRIMARY KEY (`idSubcategoria`),
  INDEX `fk_Subcategoria_Estado1_idx` (`estado` ASC),
  INDEX `fk_Subcategoria_Categoria1_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_Subcategoria_Estado1`
    FOREIGN KEY (`estado`)
    REFERENCES `dat`.`Estado` (`estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subcategoria_Categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `dat`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dat`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `idVendedor` INT NOT NULL,
  `idSubcategoria` INT NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `imagen` VARCHAR(100) NOT NULL,
  `stock` INT NOT NULL,
  `vendidas` INT NOT NULL,
  `marca` VARCHAR(100) NULL,
  `modelo` VARCHAR(100) NULL,
  `estado` CHAR(1) NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Usuario1_idx` (`idVendedor` ASC),
  INDEX `fk_Producto_Estado1_idx` (`estado` ASC),
  INDEX `fk_Producto_Subcategoria1_idx` (`idSubcategoria` ASC),
  CONSTRAINT `fk_Producto_Usuario1`
    FOREIGN KEY (`idVendedor`)
    REFERENCES `dat`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Estado1`
    FOREIGN KEY (`estado`)
    REFERENCES `dat`.`Estado` (`estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Subcategoria1`
    FOREIGN KEY (`idSubcategoria`)
    REFERENCES `dat`.`Subcategoria` (`idSubcategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dat`.`Orden`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`Orden` (
  `idOrden` INT NOT NULL AUTO_INCREMENT,
  `idCliente` INT NOT NULL,
  `fechaCreada` DATETIME NULL,
  `estado` CHAR(1) NOT NULL,
  PRIMARY KEY (`idOrden`),
  INDEX `fk_Orden_Usuario1_idx` (`idCliente` ASC),
  INDEX `fk_Orden_Estado2_idx` (`estado` ASC),
  CONSTRAINT `fk_Orden_Usuario1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `dat`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orden_Estado2`
    FOREIGN KEY (`estado`)
    REFERENCES `dat`.`Estado` (`estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dat`.`OrdenxProducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`OrdenxProducto` (
  `idOrdenxProducto` INT NOT NULL AUTO_INCREMENT,
  `idOrden` INT NOT NULL,
  `idProducto` INT NOT NULL COMMENT 'Si Orden no es por producto, entonces debería haber una validación que agrupe los productos del carrito en ordenes por cada vendedor',
  `cantidad` INT NULL,
  `precio` DECIMAL(10,2) NULL,
  `fechaCreada` DATETIME NOT NULL,
  `fechaEnviada` DATETIME NULL,
  `fechaEntregada` DATETIME NULL,
  `fechaAnulada` DATETIME NULL,
  `valoracion` INT NULL,
  `comentarioCliente` VARCHAR(200) NULL,
  `comentarioVendedor` VARCHAR(200) NULL,
  `estado` CHAR(1) NOT NULL,
  PRIMARY KEY (`idOrdenxProducto`),
  INDEX `fk_Orden_Producto1_idx` (`idProducto` ASC),
  INDEX `fk_Orden_Estado1_idx` (`estado` ASC),
  INDEX `fk_OrdenxProducto_Orden1_idx` (`idOrden` ASC),
  CONSTRAINT `fk_Orden_Producto1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `dat`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orden_Estado1`
    FOREIGN KEY (`estado`)
    REFERENCES `dat`.`Estado` (`estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdenxProducto_Orden1`
    FOREIGN KEY (`idOrden`)
    REFERENCES `dat`.`Orden` (`idOrden`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dat`.`Log`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dat`.`Log` (
  `idlog` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(40) NULL,
  `mensaje` VARCHAR(100) NULL,
  `detalles` VARCHAR(1000) NULL,
  PRIMARY KEY (`idlog`))
ENGINE = InnoDB;

USE `dat` ;

-- -----------------------------------------------------
-- procedure listarProductos
-- -----------------------------------------------------

DELIMITER $$
USE `dat`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `listarProductos`(in codProducto int,in codVendedor int)
BEGIN
select idproducto,c.idCategoria,s.idSubcategoria,p.nombre,c.descripcion categoria,s.descripcion subcategoria, marca,modelo,p.descripcion,precio,vendidas,stock,imagen 
from producto p 
left join subcategoria s on p.idSubcategoria=s.idSubcategoria
left join categoria c on c.idCategoria =S.idCategoria
where (idproducto=codProducto or codProducto=-1) and
	  (idVendedor= codVendedor or codVendedor=-1) and
	  p.estado='A';

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure comboProducto
-- -----------------------------------------------------

DELIMITER $$
USE `dat`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `comboProducto`(in codCategoria int)
BEGIN
	select c.idcategoria, idsubcategoria, concat_ws(' - ', c.descripcion , s.descripcion) producto from categoria c left join subcategoria s on
	c.idcategoria = s.idcategoria
	where c.idcategoria=codCategoria or codCategoria=-1 ;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `dat`;

DELIMITER $$
USE `dat`$$
CREATE TRIGGER `Producto_BUPD` BEFORE UPDATE ON `Producto` FOR EACH ROW
	BEGIN
	DECLARE msg varchar(255);
	IF (NEW.stock<0)
	THEN
	SET msg = concat('El stock no puede ser menor a cero ', cast(new.stock as char));
	SIGNAL sqlstate '45000' SET message_text = msg;
	END IF; 
	END$$


DELIMITER ;
