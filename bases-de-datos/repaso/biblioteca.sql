-- ============================================================
-- EJERCICIO: Biblioteca con préstamos
-- ============================================================

-- ------------------------------------------------------------
-- MODELO RELACIONAL
-- ------------------------------------------------------------
-- editorial (cod_editorial, nombre, pais)
--
-- libro (isbn, titulo, anio_edicion, cod_editorial)
--     cod_editorial clave foránea a editorial
--
-- ejemplar (cod_ejemplar, isbn, estado)
--     isbn clave foránea a libro
--
-- socio (nro_socio, dni, nombre, email, fecha_alta, categoria)
--
-- prestamo (cod_prestamo, nro_socio, cod_ejemplar, fecha_retiro,
--           fecha_vencimiento, fecha_devolucion)
--     nro_socio clave foránea a socio
--     cod_ejemplar clave foránea a ejemplar

-- ------------------------------------------------------------
-- REQUISITOS PARA EL SCHEMA
-- ------------------------------------------------------------
-- 1. Crear el schema biblioteca (con drop schema if exists ... cascade
--    al principio).
--
-- 2. Domains:
--    - tipoEstado: 'DISPONIBLE', 'PRESTADO', 'EN_REPARACION', 'PERDIDO'.
--    - tipoCategoria: 'ESTUDIANTE', 'DOCENTE', 'GENERAL'.
--    - tipoEmail: varchar con un check razonable (que tenga una '@').
--
-- 3. Constraints:
--    . dni único y positivo.
--    . anio edicion entre 1500 y el año actual.
--    . fecha_vencimiento posterior a fecha_retiro.
--    . fecha_devolucion, si no es null, no puede ser anterior a
--      fecha_retiro.
--    . estado de ejemplar con default 'DISPONIBLE'.
--    . No se puede borrar una editorial que tenga libros, pero si se
--      borra un libro se borran sus ejemplares (on delete).
--    . Un mismo ejemplar no puede tener dos préstamos abiertos a la vez
--      (pensar: índice único parcial sobre fecha_devolucion is null).

-- ------------------------------------------------------------
-- TRIGGERS A ESCRIBIR
-- ------------------------------------------------------------
-- 1. Al insertar un préstamo, verificar que el ejemplar esté
--    'DISPONIBLE' (si no, tirar excepción) y pasarlo a 'PRESTADO'.
--
-- 2. Al insertar un préstamo, rechazarlo si el socio ya tiene 3
--    préstamos sin devolver.
--
-- 3. Al actualizar un préstamo y completar fecha_devolucion, devolver
--    el ejemplar a 'DISPONIBLE'.
--
-- Pista: los tres son before/after sobre prestamo y se escriben con
-- create function ... returns trigger en plpgsql, más el
-- create trigger que la conecta.

-- ------------------------------------------------------------
-- DESPUÉS
-- ------------------------------------------------------------
-- Escribir inserts de prueba (incluyendo casos que deberían fallar
-- para probar los constraints y triggers) y revisar todo.

-- ============================================================
-- ACÁ EMPIEZA TU CÓDIGO
-- ============================================================

do $$
begin
  drop schema if exists biblioteca cascade;
  create schema biblioteca;
  
  set search_path to biblioteca;
  
  create domain tipoEstado as varchar(20)
    check (value in ('DISPONIBLE', 'PRESTADO', 'EN_REPARACION', 'PERDIDO'))
    default 'DISPONIBLE';
  
  create domain tipoCategoria as varchar(14)
   check (value in ('ESTUDIANTE', 'DOCENTE', 'GENERAL'));

  create domain tipoEmail as varchar(100)
    check (value like '%@%');


  create table editorial(
    cod_editorial int primary key,
    nombre varchar(100) not null,
    pais varchar(50) not null
  );

  create table libro (
    isbn int primary key,
    titulo varchar(150) not null,
    anio_edicion int not null,
    cod_editorial int references editorial on delete restrict,
    constraint validAnio check (anio_edicion between 1500 and (extract (year from now())))
  );

  -- ejemplar (cod_ejemplar, isbn, estado)
  create table ejemplar (
    cod_ejemplar int primary key,
    isbn int references libro on delete cascade,
    estado tipoEstado not null
  );

  create table socio (
    nro_socio int primary key,
    dni int not null unique,
    nombre varchar(100) not null,
    email tipoEmail not null,
    fecha_alta date not null,
    categoria tipoCategoria,
    constraint validDni check (dni > 0)
  );

  create table prestamo (
    cod_prestamo int primary key,
    nro_socio int references socio,
    cod_ejemplar int references ejemplar,
    fecha_retiro date,
    fecha_vencimiento date,
    fecha_devolucion date,
    constraint validFechaVencimiento check (fecha_vencimiento > fecha_retiro),
    constraint validFechaDevolucion check (fecha_devolucion is null or fecha_devolucion >= fecha_retiro)
  );

  create unique index idxEjemplarUnicoPrestamos
    on prestamo (cod_ejemplar)
    where fecha_devolucion is null;

--1. Al insertar un préstamo, verificar que el ejemplar esté
--    'DISPONIBLE' (si no, tirar excepción) y pasarlo a 'PRESTADO'.

  create function verificar_prestamo()
  returns trigger as $fn$
  declare
    estado tipoEstado := (select e.estado from biblioteca.ejemplar e where cod_ejemplar = new.cod_ejemplar);
  begin
    if estado != 'DISPONIBLE' then
      raise exception 'El ejemplar ya se encuentra prestado';
    end if;
    
    update biblioteca.ejemplar set estado = 'PRESTADO' where cod_ejemplar = new.cod_ejemplar;
    return new;
  end;
  $fn$ language plpgsql;
  
  create trigger estado_prestamo
  before insert on prestamo
  for each row
  execute function verificar_prestamo();

-- 2. Al insertar un préstamo, rechazarlo si el socio ya tiene 3
--    préstamos sin devolver.
  create function validate_max_tres_prestamos()
  returns trigger as $fn$
  declare
    cant_prestamos int := (
      select count(*)
      from biblioteca.prestamo
      where nro_socio = new.nro_socio and fecha_devolucion is null
    );
  begin
    if cant_prestamos >= 3 then
      raise exception 'El socio ya tiene 3 prestamos sin devolver';
    end if;
    return new;
  end;
  $fn$ language plpgsql;

  create trigger cant_prestamos
  before insert on prestamo
  for each row
  execute function validate_max_tres_prestamos();

  create function marcar_disponible_ejemplar()
  returns trigger as $fn$
  begin
    if new.fecha_devolucion is null or new.fecha_devolucion > now() then
      return new;
    end if;

    update biblioteca.ejemplar set estado = 'DISPONIBLE' where cod_ejemplar = old.cod_ejemplar;
    return new;
  end;
  $fn$ language plpgsql;

  create trigger actualizar_estado_prestamo
  after update of fecha_devolucion on biblioteca.prestamo
  for each row
  execute function marcar_disponible_ejemplar();

  insert into editorial (cod_editorial, nombre, pais)
  values
    (1, 'Anagrama', 'Argentina'),
    (2, 'Editorial Española', 'España');
 
  insert into libro (isbn, titulo, anio_edicion, cod_editorial)
  values
    (234932478, 'El extranjero', 2023, 1),
    (123123, 'Meditaciones', 2022, 1),
    (234234, 'Así habló Zaratustra', 2020, 2);
  
  insert into ejemplar (cod_ejemplar, isbn)
  values
    (1, 234932478),
    (2, 123123),
    (3, 234932478),
    (4, 234234);
  
  insert into socio (nro_socio, dni, nombre, email, fecha_alta, categoria)
  values
    (1, 3249798, 'Lautaro Luna', 'lautaroluna@protonmail.com', '2026-06-24', 'ESTUDIANTE');

  insert into prestamo (cod_prestamo, nro_socio, cod_ejemplar, fecha_retiro, fecha_vencimiento, fecha_devolucion)
  values
    (1, 1, 1, '2026-10-21', '2026-10-30', null),
    (2, 1, 2, '2026-10-21', '2026-10-30', null),
    (3, 1, 3, '2026-10-21', '2026-10-30', null);

insert into socio (nro_socio, dni, nombre, email, fecha_alta, categoria)
values (2, 11111111, 'Socio de prueba', 'prueba@mail.com', '2026-10-01', 'GENERAL');



end;
$$
