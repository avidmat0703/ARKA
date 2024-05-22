create table venta
(
    id          int auto_increment
        primary key,
    id_producto int      null,
    unidades    int      null,
    fecha       datetime null,
    constraint venta_ibfk_1
        foreign key (id_producto) references producto (id)
);

create index id_producto
    on venta (id_producto);

