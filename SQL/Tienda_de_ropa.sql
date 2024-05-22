DROP DATABASE IF EXISTS Tienda;
CREATE DATABASE Tienda CHARACTER SET utf8mb4;
Use Tienda;

CREATE TABLE producto (
                          id INT AUTO_INCREMENT primary key,
                          codigo VARCHAR(20),
                          tipo_producto VARCHAR(20),
                          stock INT,
                          talla VARCHAR(10),
                          color VARCHAR(10),
                          marca VARCHAR(20),
                          precio DECIMAL(5,2),
                          descripcion VARCHAR(20)
);

CREATE TABLE empleado (
                          DNI VARCHAR(9) primary key,
                          nombre VARCHAR(20),
                          apellido VARCHAR(20),
                          apellido2 VARCHAR(20),
                          email VARCHAR(50),
                          telefono INT,
                          puesto VARCHAR(20),
                          contrasena VARCHAR(20)
);

CREATE TABLE venta(
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      id_producto INT,
                      unidades INT,
                      precio_unidad DECIMAL(5,2),
                      total DECIMAL(5,2),
                      fecha DATETIME
);

delimiter $$
DROP TRIGGER IF EXISTS tg_beforeinsertventa$$
CREATE TRIGGER tg_beforeinsertventa
    BEFORE INSERT ON venta
    FOR EACH ROW
BEGIN
    DECLARE cont int;
    SET cont = (select count(*) from producto where id = new.id_producto);
    if cont = 0 then
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe ningún producto con el ID introducido.';
    elseif(select stock from producto where id = new.id_producto)<new.unidades then
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No hay suficiente stock para realizar esta venta.';
    else
        set new.precio_unidad = (select precio from producto where id = new.id_producto);
        set new.total = new.precio_unidad * new.unidades;
        set new.fecha = now();
    end if;
end $$
delimiter ;

delimiter $$
DROP TRIGGER IF EXISTS tg_beforeinsertproducto$$
CREATE TRIGGER tg_beforeinsertproducto
    BEFORE INSERT ON producto
    FOR EACH ROW
BEGIN
    DECLARE cont int;
    SET cont = (select count(*) from producto where codigo = new.codigo);
    if cont > 0 then
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ya existe un producto con el código introducido.';
    END IF;
end $$
delimiter ;

delimiter $$
DROP TRIGGER IF EXISTS tg_beforeinsertempleado$$
CREATE TRIGGER tg_beforeinsertempleado
    BEFORE INSERT ON empleado
    FOR EACH ROW
BEGIN
    DECLARE cont int;
    SET cont = (select count(*) from empleado where dni = new.dni);
    if cont > 0 then
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ya existe un empleado con el DNI introducido.';
    END IF;
end $$
delimiter ;

delimiter $$
DROP TRIGGER IF EXISTS tg_beforedeleteproducto$$
CREATE TRIGGER tg_beforedeleteproducto
    BEFORE DELETE ON PRODUCTO
    FOR EACH ROW
BEGIN
    DECLARE cont int;
    SET cont = (select count(*) from producto where codigo = old.codigo);
    if cont = 0 then
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe ningún producto con el ID introducido.';
    END IF;
end $$
delimiter ;

delimiter $$
DROP TRIGGER IF EXISTS tg_beforedeleteempleado$$
CREATE TRIGGER tg_beforedeleteempleado
    BEFORE DELETE ON Empleado
    FOR EACH ROW
BEGIN
    DECLARE cont int;
    SET cont = (select count(*) from empleado where dni = old.dni);
    if cont = 0 then
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No existe ningún empleado con el DNI introducido.';
    END IF;
end $$
delimiter ;

DELIMITER //

CREATE PROCEDURE existe_empleado(IN dni_param VARCHAR(20))
BEGIN
    DECLARE dni_count INT;

    SELECT COUNT(*) INTO dni_count
    FROM empleado
    WHERE DNI = dni_param;
    IF dni_count = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'No se encuentra ningún empleado con el DNI introducido';
    END IF;
END //
DELIMITER ;

DELIMITER //

CREATE PROCEDURE delete_producto(IN id_param INT)
BEGIN
    DECLARE id_count INT;

    SELECT COUNT(*) INTO id_count
    FROM producto
    WHERE id = id_param;

    IF id_count = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'No se encuentra ningún producto con el ID introducido.';
    ELSE
        DELETE FROM producto
        WHERE id = id_param;
    END IF;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE existe_producto(IN id_param INT)
BEGIN
    DECLARE id_count INT;

    SELECT COUNT(*) INTO id_count
    FROM producto
    WHERE id = id_param;

    IF id_count = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'No se encuentra ningún producto con el ID introducido.';
    END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_empleado(IN dni_param VARCHAR(9))
BEGIN
    DECLARE dni_count INT;

    SELECT COUNT(*) INTO dni_count
    FROM empleado
    WHERE dni = dni_param;

    IF dni_count = 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'No existe ningún empleado con el DNI introducido.';
    END IF;
END //
delimiter ;

DELIMITER //
CREATE PROCEDURE contrasena( IN dni_param VARCHAR(9), contrasena_param VARCHAR(16))
BEGIN
    DECLARE contrasena_count INT;

    SELECT COUNT(*) INTO contrasena_count
    FROM Empleado where dni = dni_param and contrasena = contrasena_param;

    IF contrasena_count = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La contraseña para este usuario es incorrecta.';
    END IF;
END //
delimiter ;

DELIMITER //

CREATE FUNCTION stock()
    RETURNS VARCHAR(255) DETERMINISTIC
BEGIN
    DECLARE vfinal INT DEFAULT 0;
    DECLARE vstock INT;
    DECLARE vid INT;
    DECLARE vcontador INT DEFAULT 0;
    DECLARE mensaje VARCHAR(255) DEFAULT '';

    DECLARE cursor1 CURSOR FOR
        SELECT id, stock FROM producto WHERE stock <= 5;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET vfinal = 1;
    OPEN cursor1;
    bucle: LOOP
        FETCH cursor1 INTO vid, vstock;
        IF vfinal = 1 THEN
            LEAVE bucle;
        ELSE
            SET vcontador = vcontador + 1;
            SET mensaje = CONCAT(mensaje, 'ID: ', vid, ' Stock: ', vstock, ',');
        END IF;
    END LOOP;
    CLOSE cursor1;

    IF vcontador > 0 THEN
        RETURN mensaje;
    END IF;
END //

DELIMITER ;

DELIMITER ;
INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P001', 'Camiseta', 1, 'M', 'Rojo', 'Nike', 19.99, 'Camiseta de algodón');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P002', 'Pantalón', 30, 'L', 'Azul', 'Adidas', 29.99, 'Pantalón deportivo');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P003', 'Zapatos', 20, '42', 'Negro', 'Puma', 49.99, 'Zapatos de running');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P004', 'Sudadera', 2, 'S', 'Gris', 'Reebok', 39.99, 'Sudadera con capucha');

INSERT INTO producto (codigo, tipo_producto, stock, talla, color, marca, precio, descripcion)
VALUES ('P005', 'Chaqueta', 1, 'XL', 'Verde', 'The North Face', 99.99, 'Chaqueta impermeable');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto, contrasena)
VALUES ('12345678A', 'Juan', 'García', 'López', 'juan@example.com', 123456789, 'Gerente', '1234');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto)
VALUES ('23456789B', 'María', 'Martínez', 'Pérez', 'maria@example.com', 987654321, 'Asistente');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto)
VALUES ('34567890C', 'Pedro', 'Rodríguez', 'Sánchez', 'pedro@example.com', 654987321, 'Contador');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto)
VALUES ('45678901D', 'Laura', 'López', 'Gómez', 'laura@example.com', 789654123, 'Vendedor');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto)
VALUES ('56789012E', 'Carlos', 'Fernández', 'Díaz', 'carlos@example.com', 456789123, 'Recepcionista');

INSERT INTO empleado (DNI, nombre, apellido, apellido2, email, telefono, puesto, contrasena)
VALUES ('a', 'a', 'a', 'a', 'a', 91, 'a', 'a');