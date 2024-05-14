Drop database if exists Tienda;
Create database Tienda character set utf8mb4;
Use Tienda; 

CREATE table producto (
	id INT AUTO_INCREMENT primary key,
    codigo varchar(20),
	tipo_producto varchar(20),
    stock int,
    talla varchar(10),
    color varchar(10),
    marca varchar(20),
	precio DECIMAL(5,2),
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

CREATE TABLE venta(
    id int AUTO_INCREMENT primary key,
    id_producto int,
    unidades int,
    precio_unidad decimal(5,2),
    fecha datetime,
	total decimal(5,2)
);

delimiter $$
drop trigger if exists tg_beforeinsertventa$$
create trigger tg_beforeinsertventa
before insert on venta
for each row
begin
declare cont int;
set cont = (select count(*) from producto where id = new.id_producto);
if cont = 0 then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error: EL id introducido no pertenece a la tabla "producto"';
else
set new.precio_unidad = (select precio from producto where id = new.id_producto);
set new.total = new.precio_unidad * new.unidades;
set new.fecha = now();
    END IF;
end $$
delimiter ;

delimiter $$
drop trigger if exists tg_codigoproducto$$
create trigger tg_codigoproducto
before insert on producto
for each row
begin
declare cont int;
set cont = (select count(*) from producto where codigo = new.codigo);
if cont > 0 then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error: EL código del producto ya existe."';
    END IF;
end $$
delimiter ;

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P001', 'Camiseta', 50, 'M', 'Rojo', 'Nike', 19.99, 'Camiseta de algodón');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P002', 'Pantalón', 30, 'L', 'Azul', 'Adidas', 29.99, 'Pantalón deportivo');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P003', 'Zapatos', 20, '42', 'Negro', 'Puma', 49.99, 'Zapatos de running');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P004', 'Sudadera', 40, 'S', 'Gris', 'Reebok', 39.99, 'Sudadera con capucha');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P005', 'Chaqueta', 15, 'XL', 'Verde', 'The North Face', 99.99, 'Chaqueta impermeable');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto) 
VALUES ('12345678A', 'Juan', 'García', 'López', 'juan@example.com', 123456789, 'Gerente');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto) 
VALUES ('23456789B', 'María', 'Martínez', 'Pérez', 'maria@example.com', 987654321, 'Asistente');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto) 
VALUES ('34567890C', 'Pedro', 'Rodríguez', 'Sánchez', 'pedro@example.com', 654987321, 'Contador');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto) 
VALUES ('45678901D', 'Laura', 'López', 'Gómez', 'laura@example.com', 789654123, 'Vendedor');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto) 
VALUES ('56789012E', 'Carlos', 'Fernández', 'Díaz', 'carlos@example.com', 456789123, 'Recepcionista');

INSERT INTO venta (id, id_producto, unidades) 
VALUES(1, 4, 3);


