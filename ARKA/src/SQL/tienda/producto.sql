create table producto
(
    id            int auto_increment
        primary key,
    tipo_producto varchar(20) null,
    stock         int         null,
    talla         varchar(10) null,
    color         varchar(10) null,
    marca         varchar(20) null
);

