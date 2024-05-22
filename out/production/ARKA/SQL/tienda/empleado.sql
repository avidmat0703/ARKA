create table empleado
(
    DNI         varchar(9)              not null
        primary key,
    nombre      varchar(20)             null,
    apellido    varchar(20)             null,
    apellido2   varchar(20)             null,
    email       varchar(50)             null,
    telefono    int                     null,
    puesto      varchar(20)             null,
    descripcion varchar(2) default 'aj' null
);

