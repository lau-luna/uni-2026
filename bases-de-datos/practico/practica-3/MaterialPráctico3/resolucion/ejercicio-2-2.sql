set search_path to ejercicio2;

-- a) Listar las competencias cuya categoría es mayor a 2.
select * 
from competencia 
where "CATEGORIA" > 2;

-- b) Listar clubes que participaron en las competencias cuya categoría es 2.
select "NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO" 
from club
natural join participacion
natural join competencia c
where c."CATEGORIA" > 2;


-- c) Listar los nombres de los clubes que participaron en competencias cuya categoría es 2.
select "NOMBRE_CLUB"
from club
natural join participacion
natural join competencia c
where c."CATEGORIA" > 2;
