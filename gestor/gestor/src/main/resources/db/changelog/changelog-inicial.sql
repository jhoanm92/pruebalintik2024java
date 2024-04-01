-- liquibase formatted sql

-- changeset script:1
-- comment: Creation table estado
create table estado (
    id integer generated by default as identity,
    tipo varchar(255),
    primary key (id)
);
----
-- changeset script:15
-- comment: Creation asegurado
insert into estado (tipo) values
    ( 'Pendiente' ),
    ( 'En Progreso' ),
    ( 'Completada' );
