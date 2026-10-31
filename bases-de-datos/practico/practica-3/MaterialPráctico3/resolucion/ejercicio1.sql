-- a) Realizar una consulta que muestre los datos de todos los productos con precios menores a $150000.
select *
from productos
where precio < 150000;

-- b) Indicar el código y descripción de los productos que en alguna factura se ha vendido más de 2
-- unidades. El listado ordenarlo por descripción del producto
select *
from producto p
inner join (
  select *
  from itemfactura
  where cantidad >= 2
) as i on p.cod_producto = i.cod_producto
order by descripcion;

select p.cod_producto, p.descripcion
from producto p
inner join itemfactura i
on p.cod_producto = i.cod_producto
where i.cantidad >= 2
order by descripcion;


-- c) Listar los clientes (todos sus datos) que no se le han realizado ninguna venta (clientes que npellido y nombre en forma descendente.
select *
from cliente
natural join (
  select nro_cliente
  from cliente
  except
  select distinct nro_cliente
  from factura
)
order by (apellido, nombre) desc;

select *
from cliente c
where c.nro_cliente not in (
  select nro_cliente
  from factura
);



-- d) Listar los Productos que no se han vendido nunca.
select *
from producto
natural join (
  select p.cod_producto
  from producto p
  except
  select distinct i.cod_producto
  from itemfactura i
);

select *
from producto p
where p.cod_producto
not in (
  select distinct cod_producto
  from itemfactura
)

-- e) Listar los clientes con sus ventas (Facturas), si un cliente no tiene ventas asociadas también debe
-- ser listado.
select *
from cliente c
left outer join factura f
on c.nro_cliente = f.nro_cliente;
