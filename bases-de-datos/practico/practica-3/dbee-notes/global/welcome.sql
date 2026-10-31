-- b) Ejercicio 4 de la práctica 2 (Base de datos sobre Producción). Considerar que el
-- código de auto es un entero positivo, el dominio del atributo nombre_color es
-- {"BLANCO", "NEGRO", "GRIS","ROJO"} y nombre de auto es un varchar (30).

-- auto(cod_auto, nombre_auto)
-- color (cod_color, nombre_color)
-- produccion (mes_produccion, año_produccion, cod_auto, cod_color)
--		cod_auto clave foránea a auto
--		cod_color clave foránea a color

	DROP DATABASE IF EXISTS p4ej3b;
	CREATE DATABASE p4ej3b;
	USE p4ej3b;

	create table auto (
		cod_auto int,
		nombre_auto varchar(30) not null,
		primary key (cod_auto),
		constraint valid_cod_auto check (cod_auto > 0)
	);

	create table color (
		cod_color int,
		nombre_color ENUM('BLANCO', 'NEGRO', 'GRIS', 'ROJO') not null,
		primary key (cod_color)
	);

	create table produccion (
		mes_produccion varchar(15) not null,
		anio_produccion int not null,
		cod_color int not null,
		cod_auto int not null,
		primary key (mes_produccion, anio_produccion, cod_color, cod_auto),
    constraint fk_cod_color foreign key (cod_color)
      references color (cod_color)
      on delete restrict,
    constraint fk_cod_auto foreign key (cod_auto)
      references auto (cod_auto)
      on delete cascade
	);

	INSERT INTO auto
		(cod_auto, nombre_auto)
		VALUES 
		(4, 'Subaru Impreza'),
		(1, 'Subaru WRX STi'),
		(2, 'Mitsubishi Lancer Evo'),
		(3, 'Toyota Corolla');
	
	INSERT INTO color
		(cod_color, nombre_color)
		VALUES
		(0, 'ROJO'),
		(1, 'BLANCO'),
		(2, 'NEGRO');
	
	INSERT INTO produccion
		(mes_produccion, anio_produccion, cod_color, cod_auto)
		VALUES
    ('enero', 2001, 2, 1),
		('febrero', 204, 1, 2),
		('marzo', 2003, 0, 3),
		('noviembre', 2020, 2, 1),
		('diciembre', 2017, 1, 2);
