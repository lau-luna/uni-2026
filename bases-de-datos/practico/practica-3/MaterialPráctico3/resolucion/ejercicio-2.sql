set search_path to ejercicio2;

-- a) Listar las competencias cuya categoría es mayor a 2.
select *
from competencia c 
where c."CATEGORIA" > 2;


-- b) Listar clubes que participaron en las competencias cuya categoría es 2.

select *
from club c natural join(
	select p."NRO_CLUB" 
	from participacion p natural join(
		select c."NRO_COMPETENCIA"
		from competencia c 
		where c."CATEGORIA" > 2
	)
);


-- c) Listar los nombres de los clubes que participaron en competencias cuya categoría es 2.

select c."NOMBRE_CLUB"
from club c natural join(
	select p."NRO_CLUB" 
	from participacion p natural join(
		select c."NRO_COMPETENCIA" 
		from competencia c
		where c."CATEGORIA" = 2
	)
);
