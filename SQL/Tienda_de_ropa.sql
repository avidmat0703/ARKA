ºDrop database if exists Tienda_de_ropa;
Create database Tienda_de_ropa character set utf8mb4;
Use Tienda_de_ropa; 

CREATE table producto (
	id INT AUTO_INCREMENT primary Key,
	tipo_producto varchar(20),
    stock int,
    talla varchar(10),
    color varchar(10),
    marca varchar(20)
);

CREATE TABLE empleado (
	DNI varchar(9) primary key,
    nombre varchar(20),
    apellido varchar(20),
    apellido2 varchar(20),
    email varchar(50),
    telefono int,
    puesto varchar(20)
);

