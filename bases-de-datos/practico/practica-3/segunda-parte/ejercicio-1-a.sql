-- a) Ejercicio 1 de la práctica 2 (Base de datos sobre artículos). Considerar que el Stock
-- mínimo no puede ser mayor que el Stock máximo; el precio no puede ser 0 ni negativo y
-- menor a 9999.
-- Artículo (#art, descripción, precio, cantidad, Stock_Min, Stock_Max, Mes_Ult_Movim, Fecha_Vto)

do $$
begin
  drop schema if exists p2ej1 cascade;
  create schema p2ej1;
  
  set search_path to p2ej1;

  create domain tipoMes as varchar(100)
    check (value in ('enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio', 'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'));

  create table articulo (
    nro_articulo serial primary key,
    descripcion varchar(100) not null,
    precio float not null,
    cantidad int not null,
    stock_min int,
    stock_max int,
    mes_ult_movim tipoMes not null,
    fecha_vto date,
    constraint validPrecio check (precio > 0 and precio < 9999)
  );

  create function articulo_descripcion_uppercase()
  returns trigger as $fn$
  begin
    new.descripcion := upper(new.descripcion);
    return new;
  end;
  $fn$ language plpgsql;

  create trigger uppercase_descripcion
    before insert on p2ej1.articulo
    for each row
    execute function articulo_descripcion_uppercase();


  insert into articulo (descripcion, precio, cantidad, stock_min, stock_max, mes_ult_movim, fecha_vto)
  values 
    ('masitas', 300, 5, 2, 10, 'marzo', '2026-12-2'),
    ('papitas', 340, 10, 2, 10, 'Marzo', '2026-12-24');
end
$$;
