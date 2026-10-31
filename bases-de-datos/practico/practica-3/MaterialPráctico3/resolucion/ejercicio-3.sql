set search_path to ejercicio3;

--a) Proponer y resolver utilizando el álgebra relacional al menos 3 consultas. Los siguientes operadores: selección, proyección, unión, diferencia, producto cartesiano y outer join (left o right o full); deben participar en al menos una consulta.

-- a) 1)
-- Obtener todos los alumnos con su taller que realizan, incluyendo los alumnos que no están en ningún taller
-- Alumno ⧑ (Taller ⋈ Realiza)

select a.dni, a.nombre, a.apellido, tr.nombre
from alumno a left join (
	select r.nro_alumno,  t.nombre
	from realiza r natural join taller t
) as tr on a.nro_alumno = tr.nro_alumno;


-- 2) Obtener los datos alumnos que participan en un único taller
-- Alumno - (π nro_alumno (σ nro_alumno == na and codigo_taller != ct (Realiza * ρ nro_alumno ➡ na, codigo_taller, ct (Realiza))))

select *
from alumno
except
select a.*
from alumno a 
inner join (
		select r1.nro_alumno
		from realiza r1, realiza r2
		where r1.nro_alumno = r2.nro_alumno and r1.codigo_taller != r2.codigo_taller
) sub on a.nro_alumno = sub.nro_alumno;

-- o tambien
select *
from alumno
where nro_alumno in (
	select nro_alumno
	from realiza
	group by nro_alumno
	having count(codigo_taller ) = 1
);

-- 3) obtener los alumnos que participan en mas de un taller o participan en el taller 'Reparacion de PC'
-- (Alumno ⋈ (Realiza ⋈ σ nombre == "Reparacion de PC" (Taller))) ∪ Alumno ⋈ (π nro_alumno (σ nro_alumno == na and codigo_taller != ct (Realiza * ρ nro_alumno ➡ na, codigo_taller, ct (Realiza))))
select distinct a.*
from alumno a 
inner join (
	select r1.nro_alumno
	from realiza r1, realiza r2
	where r1.nro_alumno = r2.nro_alumno and r1.codigo_taller != r2.codigo_taller
) sub on a.nro_alumno = sub.nro_alumno
union
select a.*
from alumno a
natural join (
	select r.nro_alumno 
	from realiza r
	natural join(
		select *
		from taller t
		where t.nombre = 'Reparacion de PC'
	)
);
