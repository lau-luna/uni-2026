-- a) Obtener el auto (cod_auto) con mayor producción.

set local search_path to p2ej4;

SELECT cod_auto
FROM produccion
GROUP BY cod_auto
ORDER BY COUNT(*) DESC
LIMIT 1;
