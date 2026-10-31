-- Modelo Relacional (Tabulado)
--  Categoria (cod_categoria, nombre_cat)
--       PK: cod_categoria
--  Producto (cod_producto, nombre, precio, stock, cod_categoria)
--       PK: cod_producto
--       FK: cod_categoria a Categoria
--  Auditoria_Precio (id_auditoria, cod_producto, precio_viejo, precio_nuevo, fecha_modificacion, usuario)
--       PK: id_auditoria (puedes usar el tipo de dato serial para que sea un identificador autoincrementado).

-- Crea un dominio definido por el usuario llamado TipoPrecio basado en el tipo FLOAT. Debe incluir un 
-- CHECK para garantizar que el precio siempre sea mayor a 0. Aplica este dominio al campo precio de la tabla Producto.

-- Asegúrate de que nombre_cat en la tabla Categoria tenga una restricción de clave secundaria (UNIQUE) y no acepte valores nulos (NOT NULL).   
-- Agrega una restricción CHECK directamente en la definición de la tabla Producto para asegurar que el stock sea siempre mayor o igual a 0

-- Diseña un trigger que actúe después de una actualización (AFTER UPDATE) en la tabla Producto. 
-- Deberás crear primero la función de auditoría en plpgsql y luego el trigger, de modo que cada vez que se modifique un producto, 
-- se inserte automáticamente un registro en Auditoria_Precio guardando el identificador del producto, el precio viejo (OLD.precio), 
-- el precio nuevo (NEW.precio), la fecha exacta de la modificación (now()) y el usuario que la realizó (current_user)

do $$
begin
  drop schema if exists super cascade;
  create schema super;
  set search_path to super;

  create domain tipoPrecio as float
    constraint valid_precio check (value > 0);

  create table categoria (
    cod_categoria integer not null primary key,
    nombre_cat varchar(100) unique not null
  );

  create table producto (
    cod_producto integer not null primary key,
    nombre varchar(100) not null,
    precio tipoPrecio not null,
    stock int not null,
    cod_categoria integer not null,
    constraint fk_categoria foreign key (cod_categoria) references categoria(cod_categoria),
    constraint valid_stock check (stock >= 0)
  );

  create table auditoria_precio (
    id_auditoria serial primary key,
    cod_producto integer references producto(cod_producto),
    precio_viejo float not null,
    precio_nuevo float not null,
    fecha_modificacion timestamp default now(),
    usuario varchar not null
  );

  create function auditar_actualizacion_precio() returns trigger as $fn$
  begin
    insert into auditoria_precio
      (cod_producto, precio_viejo, precio_nuevo, usuario)
      values
      (old.cod_producto, old.precio, new.precio, current_user);
    return new;
  end;
  $fn$ language plpgsql;

  create trigger auditar_cambio_precio
    after update of precio on producto
    for each row
    execute function auditar_actualizacion_precio();
end;
$$
