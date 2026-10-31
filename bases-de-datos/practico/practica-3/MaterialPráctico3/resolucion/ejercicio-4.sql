-- Competidores del deporte “FUTBOL”.
--  σ denominacion == "FUTBOL" (Competidor ⋈ Deporte)

select c.*
from competidor c 
natural join deporte d
where d.denominacion  = 'FUTBOL';


-- Países que han competido y no ganaron ninguna medalla.
-- σ pais (Competencia) - σ pais (Medalla)

select pais
from competicion
except
select pais
from medalla;
