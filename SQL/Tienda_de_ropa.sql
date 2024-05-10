Drop database if exists Tienda;
Create database Tienda character set utf8mb4;
Use Tienda; 

CREATE table producto (
	id INT AUTO_INCREMENT primary Key,
	tipo_producto varchar(20),
    stock int,
    talla varchar(10),
    color varchar(10),
    marca varchar(20),
    descripcion varchar(20)
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
insert into producto values(
id, 'dd', 8, 'd', 'd', 'd', 'Prenda'); 
insert into producto values(id, 'Camiseta', 5, 'M', 'Rojo', 'Calvin Klein', 'Accesorio');
-- select * from producto;

CREATE TABLE venta(
    id int AUTO_INCREMENT primary key,
    id_producto int,
    unidades int,
    fecha datetime,
    foreign key (id_producto) references producto(id)
);
insert into venta values(
id, 1, 3, now()
);
select * from producto;
-- select * from venta;