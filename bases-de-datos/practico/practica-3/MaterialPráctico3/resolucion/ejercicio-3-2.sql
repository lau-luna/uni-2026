set search_path to "ejercicio3";

--a) Proponer y resolver utilizando el álgebra relacional al menos 3 consultas. Los siguientes operadores: selección, proyección, unión, diferencia, producto cartesiano y outer join (left o right o full); deben participar en al menos una consulta.

-- a) 1)
-- Obtener todos los alumnos con su taller que realizan, incluyendo los alumnos que no están en ningún taller
-- Alumno ⧑ (Taller ⋈ Realiza)
select a.nro_alumno, a.nombre, a.apellido, t.nombre 
from alumno a
left outer join realiza r
on a.nro_alumno = r.nro_alumno
inner join taller t
on t.codigo_taller = r.codigo_taller;


-- 2) Obtener los datos alumnos que participan en un único taller
-- Alumno - (π nro_alumno (σ nro_alumno == na and codigo_taller != ct (Realiza * ρ nro_alumno ➡ na, codigo_taller, ct (Realiza))))
select a.*
from alumno a
natural join realiza
group by a.nro_alumno
having count(codigo_taller) = 1;

-- o tambien

-- 3) obtener los alumnos que participan en mas de un taller o participan en el taller 'Reparacion de PC'
-- (Alumno ⋈ (Realiza ⋈ σ nombre == "Reparacion de PC" (Taller))) ∪ Alumno ⋈ (π nro_alumno (σ nro_alumno == na and codigo_taller != ct (Realiza * ρ nro_alumno ➡ na, codigo_taller, ct (Realiza))))
select a.*
from alumno a
natural join realiza
group by a.nro_alumno
having count(codigo_taller) > 1
union
select a.*
from alumno a
natural join realiza
natural join taller t
where t.nombre = 'Reparacion de PC';
