CREATE DATABASE IF NOT EXISTS prac4ej3a;

-- Artículo (#art, descripción, precio, cantidad, Stock_Min, Stock_Max, Mes_Ult_Movim, Fecha_Vto)

USE prac4ej3a;

DROP TABLE articulo;
CREATE TABLE articulo (
  n_art int AUTO_INCREMENT PRIMARY KEY,
  descripcion varchar(100) NOT NULL,
  precio float NOT NULL,
  cantidad int NOT NULL,
  stock_min int,
  stock_max int,
  mes_ult_movim varchar(12),
  fecha_vto date,
  CONSTRAINT valid_stock CHECK (stock_min <= stock_max),
  CONSTRAINT valid_precio CHECK (precio > 0 AND precio < 9999)
);

INSERT INTO articulo (
  descripcion,
  precio,
  cantidad,
  stock_min,
  stock_max,
  mes_ult_movim,
  fecha_vto
) VALUES
  ("Masitas", 100, 4, 2, 15, "enero", NULL),
  ("Milanesas", 200, 5, 1, 30, "febrero", NULL),
  ("Caramelos", 10, 75, 30, 100, "marzo", NULL),
  ("Fideos", 150, 20, 10, 30, "junio", "2026-05-25");
