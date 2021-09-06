CREATE USER UserProyecto1 IDENTIFIED BY '12345678';
GRANT USAGE,INSERT,DELETE,UPDATE,SELECT ON Proyect1.* TO UserProyecto1;

CREATE DATABASE `Proyect1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE Proyect1;
CREATE TABLE Usuario(
nombre VARCHAR(40) NOT NULL,
passwordd VARCHAR(20) NOT NULL,
tipo INT NOT NULL, PRIMARY KEY (nombre)
);
CREATE TABLE Mueble (
nombre VARCHAR(40) NOT NULL,
precio FLOAT NOT NULL,
PRIMARY KEY (nombre)
);
CREATE TABLE Pieza (
nombre VARCHAR(40),PRIMARY KEY (nombre)
);
CREATE TABLE Precio (
id INT NOT NULL AUTO_INCREMENT,
costo VARCHAR(40) NOT NULL,
nombre_pieza VARCHAR(40),
PRIMARY KEY (id), CONSTRAINT FK_TO_pieza FOREIGN KEY (nombre_pieza) REFERENCES Pieza(nombre)
);
CREATE TABLE ensamble_pieza (
nombre_mueble VARCHAR(40) NOT NULL,
nombre_pieza VARCHAR(40) NOT NULL,
cantidad INT NOT NULL,
CONSTRAINT FK_TO_mueble_ensamble FOREIGN KEY (nombre_mueble) REFERENCES Mueble(nombre),
CONSTRAINT FK_TO_pieza_ensamble FOREIGN KEY (nombre_pieza) REFERENCES Pieza(nombre)
);
CREATE TABLE Ensamble_mueble (
id VARCHAR(5) NOT NULL,
nombre_mueble VARCHAR(40) NOT NULL,
nombre_usuario VARCHAR(40) NOT NULL,
fecha DATE NOT NULL,
costo DOUBLE NOT NULL,
PRIMARY KEY (id), CONSTRAINT FK_TO_mueble FOREIGN KEY (nombre_mueble) REFERENCES Mueble(nombre),
CONSTRAINT FK_TO_usuario FOREIGN KEY (nombre_usuario) REFERENCES Usuario(nombre)
);
CREATE TABLE Cliente (
nit VARCHAR(30) NOT NULL,
nombre VARCHAR(40) NOT NULL,
direccion VARCHAR(50) NOT NULL,
municipio VARCHAR(35),
departamento VARCHAR(40),
PRIMARY KEY (nit)
);
SHOW TABLES;
INSERT INTO Usuario VALUES ('admin','12345',1);

