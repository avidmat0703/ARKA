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

CREATE TABLE venta(
    id int AUTO_INCREMENT primary key,
    id_producto int,
    unidades int,
    fecha datetime,
    foreign key (id_producto) references producto(id)
);

delimiter $$
drop trigger if exists tg_beforeinsertventa$$
create trigger tg_beforeinsertventa
before insert on venta
for each row
begin
declare cont int;
set cont = (select count(*) from producto where id = new.id_producto);
if cont > 0 then
insert into ventas values(new.id, new.id_producto, new.unidades, new.fecha);
else
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error: EL id introducido no pertenece a la tabla "producto"';
    END IF;
end $$
delimiter ;

insert into venta values(
id, 1, 3, now()
);

INSERT INTO producto (tipo_producto, stock, talla, color, marca, descripcion) 
VALUES ('Camiseta', 100, 'M', 'Azul', 'Nike', 'Prenda');

INSERT INTO producto (tipo_producto, stock, talla, color, marca, descripcion) 
VALUES ('Pantalón', 80, 'L', 'Negro', 'Adidas', 'Prenda');

INSERT INTO producto (tipo_producto, stock, talla, color, marca, descripcion) 
VALUES ('Zapatos', 50, '42', 'Blanco', 'Reebok', 'Prenda');

INSERT INTO producto (tipo_producto, stock, talla, color, marca, descripcion) 
VALUES ('Gorra', 120, 'Única', 'Rojo', 'Puma', 'Accesorio');

INSERT INTO producto (tipo_producto, stock, talla, color, marca, descripcion) 
VALUES ('Calcetines', 200, 'S/M', 'Gris', 'Under Armour', 'Accesorio');
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
/*insert into producto values(
id, 'Pulsera', 4, 'S', 'Plata', 'Pandora', 'Accesorio'); 
insert into producto values(id, 'Camiseta', 5, 'M', 'Rojo', 'Calvin Klein', 'Prenda');
-- select * from producto;*/

