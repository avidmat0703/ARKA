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
    puesto varchar(20),
    contrasena varchar(20)
);

CREATE TABLE venta(
    id int AUTO_INCREMENT primary key,
    id_producto int,
    unidades int,
    precio_unidad decimal(5,2),
	total decimal(5,2),
    fecha datetime
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
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El id introducido no pertenece a ningún producto.';
else
set new.precio_unidad = (select precio from producto where id = new.id_producto);
set new.total = new.precio_unidad * new.unidades;
set new.fecha = now();
    END IF;
end $$
delimiter ;

delimiter $$
drop trigger if exists tg_beforeinsertproducto$$
create trigger tg_beforeinsertproducto
before insert on producto
for each row
begin
declare cont int;
set cont = (select count(*) from producto where codigo = new.codigo);
if cont > 0 then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El código del producto ya existe.';
    END IF;
end $$
delimiter ;

delimiter $$
drop trigger if exists tg_beforeinsertempleado$$
create trigger tg_beforeinsertempleado
before insert on empleado
for each row
begin
declare cont int;
set cont = (select count(*) from empleado where dni = new.dni);
if cont > 0 then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ya existe un empleado con el DNI introducido.';
    END IF;
end $$
delimiter ;

delimiter $$
drop trigger if exists tg_beforedeleteproducto$$
create trigger tg_beforedeleteproducto
before delete on producto
for each row
begin
declare cont int;
set cont = (select count(*) from producto where codigo = old.codigo);
if cont = 0 then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe ningún producto con el id introducido.';
    END IF;
end $$
delimiter ;

delimiter $$
drop trigger if exists tg_beforedeleteempleado$$
create trigger tg_beforedeleteempleado
before delete on empleado
for each row
begin
declare cont int;
set cont = (select count(*) from empleado where dni = old.dni);
if cont = 0 then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe ningún empleado con el dni introducido.';
    END IF;
end $$
delimiter ;

DELIMITER //

CREATE PROCEDURE delete_empleado(IN dni_param VARCHAR(20))
BEGIN
    DECLARE dni_count INT;

    -- Contar el número de filas con el DNI especificado
    SELECT COUNT(*) INTO dni_count
    FROM empleado
    WHERE DNI = dni_param;

    -- Si no existe el DNI, lanzar una excepción
    IF dni_count = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El DNI especificado no existe en la tabla empleado';
    ELSE
        -- Si existe, eliminar el empleado
        DELETE FROM empleado
        WHERE DNI = dni_param;
    END IF;
END //

DELIMITER //

CREATE PROCEDURE delete_producto(IN id_param INT)
BEGIN
    DECLARE id_count INT;

    -- Contar el número de filas con el id especificado
    SELECT COUNT(*) INTO id_count
    FROM producto
    WHERE id = id_param;

    -- Si no existe el id, lanzar una excepción
    IF id_count = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El id especificado no existe en la tabla producto';
    ELSE
        -- Si existe, eliminar el producto
        DELETE FROM producto
        WHERE id = id_param;
    END IF;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE update_producto(IN id_param INT)
BEGIN
    DECLARE id_count INT;

    -- Contar el número de filas con el id especificado
    SELECT COUNT(*) INTO id_count
    FROM producto
    WHERE id = id_param;

    -- Si no existe el id, lanzar una excepción
    IF id_count = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El id especificado no existe en la tabla producto';
    END IF;
END //

/*CREATE PROCEDURE stock(IN id_param INT)
BEGIN
    DECLARE stockk INT;
	Declare mensaje varchar(20);
    SELECT stock INTO stockk
    FROM producto
    WHERE id = id_param;
    
    SELECT concat('ID: ', id_param, '. Stock: ', stockk) INTO mensaje;
	
    IF stockk < 5 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = mensaje;
	END IF;
END //*/

CREATE PROCEDURE update_empleado(IN dni_param varchar(9))
BEGIN
    DECLARE dni_count INT;

    -- Contar el número de filas con el id especificado
    SELECT COUNT(*) INTO dni_count
    FROM empleado
    WHERE dni = dni_param;

    -- Si no existe el id, lanzar una excepción
    IF dni_count = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El dni especificado no existe en la tabla "Empleado"';
    END IF;
END //

DELIMITER ;
INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P001', 'Camiseta', 50, 'M', 'Rojo', 'Nike', 19.99, 'Camiseta de algodón');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P002', 'Pantalón', 30, 'L', 'Azul', 'Adidas', 29.99, 'Pantalón deportivo');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P003', 'Zapatos', 20, '42', 'Negro', 'Puma', 49.99, 'Zapatos de running');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P004', 'Sudadera', 40, 'S', 'Gris', 'Reebok', 39.99, 'Sudadera con capucha');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P005', 'Chaqueta', 1, 'XL', 'Verde', 'The North Face', 99.99, 'Chaqueta impermeable');

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


