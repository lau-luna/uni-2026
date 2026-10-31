-- b) Ejercicio 4 de la práctica 2 (Base de datos sobre Producción). Considerar que el
-- código de auto es un entero positivo, el dominio del atributo nombre_color es
-- {"BLANCO", "NEGRO", "GRIS","ROJO"} y nombre de auto es un varchar (30).

-- auto(cod_auto, nombre_auto)
-- color (cod_color, nombre_color)
-- produccion (mes_produccion, año_produccion, cod_auto, cod_color)
--		cod_auto clave foránea a auto
--		cod_color clave foránea a color

do $$
begin
  drop schema if exists p1ej4 cascade;
  create schema p1ej4;

  set search_path to p1ej4;
  
  create domain tipoColor as varchar(10)
    check (value in ('BLANCO', 'NEGRO', 'GRIS', 'ROJO'));

  create table auto(
    cod_auto int primary key,
    nombre_auto varchar(30) not null,
    constraint validCodigoAuto check (cod_auto > 0)
  );

  create table color(
    cod_color int primary key,
    nombre_color tipoColor not null 
  );

  create table produccion(
    mes_produccion varchar(7),
    anio_produccion int,
    cod_auto int references auto,
    cod_color int references color,
    constraint pkProduccion primary key (mes_produccion, anio_produccion, cod_auto, cod_color)
  );
  
  insert into auto (cod_auto, nombre_auto)
  values
  (1, 'Mitsubishi Lancer Evo'),
  (2, 'Toyota Corolla'),
  (3, 'Subaru Impreza'),
  (4, 'Subaru WRX STi'),
  (5, 'Honda Civic Type R'),
  (6, 'Volkswagen Golf GTI'),
  (7, 'Ford Focus RS'),          -- nunca se produjo
  (8, 'Nissan Skyline GT-R');    -- nunca se produjo

insert into color (cod_color, nombre_color)
  values
  (1, 'BLANCO'),
  (2, 'NEGRO'),
  (3, 'GRIS'),
  (4, 'ROJO');                   -- nunca se usó

insert into produccion (mes_produccion, anio_produccion, cod_auto, cod_color)
  values
  ('enero',   2003, 1, 1),
  ('febrero', 2004, 1, 2),
  ('marzo',   2007, 3, 3),
  ('febrero', 2003, 4, 1),
  ('mayo',    2010, 2, 3),
  ('abril',   2005, 5, 1),
  ('abril',   2005, 5, 2),
  ('junio',   2005, 6, 3),
  ('julio',   2006, 6, 1),
  ('agosto',  2006, 5, 3),
  ('octubre', 2008, 2, 2),
  ('marzo',   2007, 3, 1),
  ('enero',   2003, 1, 2),
  ('mayo',    2010, 2, 1),
  ('junio',   2010, 4, 3),
  ('enero',   2004, 6, 2),
  ('febrero', 2004, 2, 1),
  ('mayo',    2010, 3, 2);

end
$$;

-- Nombre de todos los autos que se produjeron alguna vez en color 'NEGRO'.
select distinct nombre_auto
from auto
natural join produccion
natural join color c
where c.nombre_color = 'NEGRO';

--Todos los meses/años en que se produjo el 'Toyota Corolla', ordenados cronológicamente por año.
select *
from produccion p
natural join auto a
where a.nombre_auto = 'Toyota Corolla'
order by p.anio_produccion;

-- Nombre de los autos producidos en 2005 o 2006 (sin repetidos).
select distinct a.nombre_auto
from auto a
natural join produccion p
where p.anio_produccion between 2005 and 2006;

-- 4. Cantidad de registros de producción por cada auto (mostrá el nombre, no el código).
select a.nombre_auto, count(*) as cant_registros_prod
from auto a
natural join produccion
group by a.cod_auto;

-- 5. Para cada color, cuántos autos distintos se produjeron en ese color.
select c.nombre_color, count(distinct cod_auto) as cant_autos_prod
from color c
natural join produccion p
group by c.cod_color;

-- 6. Los autos que se produjeron en más de un color.
select a.*, count(distinct cod_color) as cant_colores
from auto a
natural join produccion
group by a.cod_auto
having count(distinct cod_color) > 1; 

-- 7. Autos que nunca se produjeron.
select *
from auto a
where not exists (
  select 1
  from produccion p
  where p.cod_auto = a.cod_auto
);

-- 8. Colores que nunca se usaron.
select *
from color
where cod_color not in (
  select distinct cod_color from produccion
);

-- 9. Todos los autos con la cantidad de registros de producción que tienen, incluyendo los que tienen 0
select a.*, count(p.cod_auto) as cant_registros_prod
from auto a
left outer join produccion p on a.cod_auto = p.cod_auto
group by a.cod_auto;
-- no se como hacer para que los que no tenga produccion el conteo de 0

-- 10. Autos que se produjeron en 'BLANCO' y también en 'NEGRO'
select a.*
from auto a
natural join produccion
natural join color c
where c.nombre_color = 'BLANCO'
intersect
select a.*
from auto a
natural join produccion
natural join color c
where c.nombre_color = 'NEGRO';

-- 11. Autos que se produjeron en todos los colores que existen en la tabla color (división relacional, resolvela como puedas).


select * from auto natural join produccion natural join color;
-- 

-- 1) Cantidad total de registros en produccion.
select count(*) as cant_registros_prod
from produccion;

-- 2) Cantidad de autos distintos que se produjeron alguna vez.
select count(distinct cod_auto) cant_autos_prod
from produccion;

-- 3) Año mínimo y máximo de producción.
select min(anio_produccion) as min_anio, max(anio_produccion) as max_anio
from produccion;

-- 4) Cantidad de colores distintos utilizados en la producción.
select count(distinct cod_color) as cant_colores
from produccion;

-- 5) Cantidad de registros de producción por año.
select anio_produccion, count(*) as cant_reg
from produccion
group by anio_produccion;

-- 6) Cantidad de registros de producción por auto (mostrando cod_auto).
select cod_auto, count(*) as cant_reg
from produccion
group by cod_auto;

-- 7) Cantidad de registros por color (mostrando cod_color).
select cod_color, count(*) as cant_reg
from produccion
group by cod_color;

-- 8) Cantidad de colores distintos en los que se produjo cada auto.
select cod_auto, count(distinct cod_color) as cant_colores
from produccion
group by cod_auto;

-- 9) Cantidad de autos distintos producidos por año.
select anio_produccion, count(distinct cod_auto) as cant_autos
from produccion
group by anio_produccion;

-- Igual que el 6, pero mostrando nombre_auto en vez del código.
select a.nombre_auto, count(*) as cant_reg
from produccion p
natural join auto a
group by a.cod_auto;

-- Igual que el 7, pero mostrando nombre_color.
select c.nombre_color, count(*) as cant_reg
from produccion
natural join color c
group by c.cod_color;

-- Por cada año, la cantidad de registros de producción de cada color (año, nombre del color, cantidad).
select anio_produccion, c.nombre_color, count(*) as cant_reg
from produccion
natural join color c
group by (anio_produccion, c.cod_color);

-- Nombre de cada auto junto con el primer y el último año en que se produjo.
select a.nombre_auto, min(anio_produccion) as primer_anio, max(anio_produccion) as ultimo_anio
from produccion
natural join auto a
group by a.cod_auto;

-- Autos que se produjeron en más de un color (mostrar el nombre).
select a.nombre_auto
from auto a
natural join produccion
group by a.cod_auto
having count(distinct cod_color) > 1;

-- Años en los que se produjeron 3 o más registros.
select anio_produccion
from produccion
group by anio_produccion
having count(*) >= 3;

-- Colores que se usaron en más de 4 registros de producción.
select c.cod_color, c.nombre_color
from produccion
natural join color c
group by c.cod_color
having count(*) > 4;

-- Autos cuyo primer año de producción es anterior a 2005.
select a.*
from auto a
natural join produccion
group by a.cod_auto
having min(anio_produccion) < 2005;

-- Todos los autos con la cantidad de registros de producción, incluyendo los que tienen 0.
select a.*, count(p.cod_auto) as cant_registros_prod
from auto a
left outer join produccion p on a.cod_auto = p.cod_auto
group by a.cod_auto;

-- Todos los colores con la cantidad de veces que se usaron, incluyendo los que tienen 0.
select c.*, count(p.cod_color) as cant_usos
from color c
left outer join produccion p on c.cod_color = p.cod_color
group by c.cod_color;

-- Nombres de los autos que nunca se produjeron (hacelo con LEFT JOIN + HAVING COUNT(...) = 0, y después con NOT EXISTS o NOT IN para comparar).
select a.nombre_auto
from auto a
left outer join produccion p on a.cod_auto = p.cod_auto
group by a.cod_auto
having count(p.cod_auto) = 0;

-- Cantidad de autos que nunca se produjeron.
select count(*)
from auto a
left join produccion p on a.cod_auto = p.cod_auto
where p.cod_auto is null;


-- Todos los autos con la cantidad de registros del año 2010, incluyendo los que tienen 0.
select a.nombre_auto, count(p.cod_auto) as cant_2010
from auto a
left join produccion p on a.cod_auto = p.cod_auto and p.anio_produccion = 2010
group by a.cod_auto;


-- Todos los colores con la cantidad de registros del año 2010.
select c.cod_color, c.nombre_color, count(p.cod_color) as cant_col_2010
from color c
left join produccion p on c.cod_color = p.cod_color and p.anio_produccion = 2010
group by c.cod_color;

-- Todos los autos con la cantidad de registros posteriores a 2005 (anio_produccion > 2005).
select a.*, count(p.cod_auto) as cant_posteriores
from auto a
left join produccion p on a.cod_auto = p.cod_auto and p.anio_produccion > 2005
group by a.cod_auto;

