set search_path to "ejercicio3";

--a) Proponer y resolver utilizando el álgebra relacional al menos 3 consultas. Los siguientes operadores: selección, proyección, unión, diferencia, producto cartesiano y outer join (left o right o full); deben participar en al menos una consulta.

-- a) 1)
-- Obtener todos los alumnos con su taller que realizan, incluyendo los alumnos que no están en ningún taller
-- Alumno ⧑ (Taller ⋈ Realiza)
select a.nro_alumno, a.nombre, a.apellido, t.codigo_taller, t.nombre
from alumno a
left outer join taller t
natural join realiza as r on a.nro_alumno = r.nro_alumno;

-- 2) Obtener los datos alumnos que participan en un único taller
-- Alumno - (π nro_alumno (σ nro_alumno == na and codigo_taller != ct (Realiza * ρ nro_alumno ➡ na, codigo_taller, ct (Realiza))))
select a.*, count(distinct codigo_taller) as cant_talleres
from alumno a
natural join realiza r
group by a.nro_alumno
having count(distinct codigo_taller) = 1;

select * from alumno natural join realiza;

-- 3) obtener los alumnos que participan en mas de un taller o participan en el taller 'Reparacion de PC'
-- (Alumno ⋈ (Realiza ⋈ σ nombre == "Reparacion de PC" (Taller))) ∪ Alumno ⋈ (π nro_alumno (σ nro_alumno == na and codigo_taller != ct (Realiza * ρ nro_alumno ➡ na, codigo_taller, ct (Realiza))))
select a.*
from alumno a
natural join realiza r
group by a.nro_alumno
having count(r.codigo_taller) > 1;
