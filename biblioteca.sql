# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: biblioteca
# ------------------------------------------------------
# Server version 5.5.5-10.4.11-MariaDB

#
# Source for table administracion
#

DROP TABLE IF EXISTS `administracion`;
CREATE TABLE `administracion` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(8) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Dumping data for table administracion
#

LOCK TABLES `administracion` WRITE;
/*!40000 ALTER TABLE `administracion` DISABLE KEYS */;
INSERT INTO `administracion` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `administracion` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table categoria
#

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `cod_categoria` varchar(11) NOT NULL DEFAULT '',
  `nombre_c` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`cod_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table categoria
#

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES ('035','Comida casera');
INSERT INTO `categoria` VALUES ('036','Cocina oriental');
INSERT INTO `categoria` VALUES ('3','Software');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table libro
#

DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `cod_libro` int(11) NOT NULL DEFAULT 0,
  `nombre_l` varchar(50) NOT NULL DEFAULT '',
  `cod_ejemplar_l` int(10) NOT NULL DEFAULT 0,
  `cod_categoria_l` varchar(10) NOT NULL DEFAULT '',
  `estado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod_libro`),
  KEY `cod_categoria_l` (`cod_categoria_l`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table libro
#

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'Comida China 1',358,'036','prestado');
INSERT INTO `libro` VALUES (2,'Comida casera vol 2',3,'035','disponible');
INSERT INTO `libro` VALUES (3,'programacion 1',5,'3','disponible');
INSERT INTO `libro` VALUES (35,'Java desde 0',28,'3','disponible');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table prestamo
#

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE `prestamo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cod_libro_p` int(11) NOT NULL DEFAULT 0,
  `cod_usu_p` int(11) NOT NULL DEFAULT 0,
  `fecha_entrega_p` varchar(10) DEFAULT NULL,
  `fecha_p` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`),
  KEY `cod_usu_p` (`cod_usu_p`),
  KEY `prestamo_ibfk_1` (`cod_libro_p`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Dumping data for table prestamo
#

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table usuario
#

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `cedula` int(11) NOT NULL DEFAULT 0,
  `nombre` varchar(40) NOT NULL DEFAULT '',
  `fecha_nac` varchar(20) NOT NULL DEFAULT '',
  `sexo` varchar(10) NOT NULL DEFAULT '',
  `tipo` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table usuario
#

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (123,'Luis Mariano','03/06/1999','Masculino',0);
INSERT INTO `usuario` VALUES (321,'Lauren de la Hoz','06/09/1991','Femenino',1);
INSERT INTO `usuario` VALUES (2586,'jose alberto ','03/06/1999','Masculino',1);
INSERT INTO `usuario` VALUES (3698,'Alberto macias','03/06/1990','Masculino',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table libro
#

ALTER TABLE `libro`
ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`cod_categoria_l`) REFERENCES `categoria` (`cod_categoria`);

#
#  Foreign keys for table prestamo
#

ALTER TABLE `prestamo`
ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`cod_libro_p`) REFERENCES `libro` (`cod_libro`),
ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`cod_usu_p`) REFERENCES `usuario` (`cedula`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
