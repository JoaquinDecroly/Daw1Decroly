-- Crear la base de datos
DROP DATABASE IF EXISTS tienda;
-- Comentario: Elimina la base de datos 'tienda' si existe, para empezar con una base de datos limpia.
CREATE DATABASE tienda;
-- Comentario: Crea una nueva base de datos llamada 'tienda'.
USE tienda;
-- Comentario: Selecciona la base de datos 'tienda' para que las siguientes operaciones se realicen en ella.

-- Crear la tabla tipo
CREATE TABLE tipo (
                      id INT PRIMARY KEY AUTO_INCREMENT,
    -- Comentario: 'id' es la clave primaria de la tabla, se incrementa automáticamente con cada nuevo registro.
                      nombre VARCHAR(100) NOT NULL
    -- Comentario: 'nombre' es el nombre del tipo, es una cadena de texto de hasta 100 caracteres y no puede ser nulo.
);
-- Comentario: Esta tabla almacena los diferentes tipos de productos.

-- Crear la tabla productos
CREATE TABLE productos (
                           id INT PRIMARY KEY AUTO_INCREMENT,
    -- Comentario: 'id' es la clave primaria de la tabla, se incrementa automáticamente con cada nuevo registro.
                           referencia VARCHAR(50) NOT NULL,
    -- Comentario: 'referencia' es un código único para cada producto, es una cadena de texto de hasta 50 caracteres y no puede ser nulo.
                           nombre VARCHAR(100) NOT NULL,
    -- Comentario: 'nombre' es el nombre del producto, es una cadena de texto de hasta 100 caracteres y no puede ser nulo.
                           descripcion TEXT,
    -- Comentario: 'descripcion' es una descripción del producto, puede ser un texto largo.
                           tipo INT,
    -- Comentario: 'tipo' es una clave foránea que referencia el 'id' de la tabla 'tipo', indica a qué tipo pertenece el producto.
                           cantidad INT NOT NULL,
    -- Comentario: 'cantidad' es la cantidad disponible del producto, no puede ser nulo.
                           precio DOUBLE NOT NULL,
    -- Comentario: 'precio' es el precio del producto, no puede ser nulo.
                           descuento INT NOT NULL,
    -- Comentario: 'descuento' es el descuento aplicado al producto, no puede ser nulo.
                           iva INT NOT NULL,
    -- Comentario: 'iva' es el IVA aplicado al producto, no puede ser nulo.
                           aplicarDto BOOLEAN NOT NULL,
    -- Comentario: 'aplicarDto' indica si se aplica un descuento al producto (TRUE o FALSE), no puede ser nulo.
                           FOREIGN KEY (tipo) REFERENCES tipo(id)
    -- Comentario: Define la clave foránea 'tipo' que referencia al 'id' de la tabla 'tipo'.
);
-- Comentario: Esta tabla almacena la información de cada producto.

-- Insertar datos en la tabla tipo
INSERT INTO tipo (nombre) VALUES
            ('Electrónica'),
            ('Ropa'),
            ('Alimentos'),
            ('Hogar'),
            ('Juguetes'),
            ('Libros'),
            ('Deportes'),
            ('Salud'),
            ('Belleza'),
            ('Automotriz');
-- Comentario: Este bloque inserta los 10 tipos iniciales en la tabla 'tipo'.

-- Generar 100 inserciones en la tabla tipo (repetimos los tipos)
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
-- Comentario: Este bloque duplica los registros de la tabla tipo 5 veces, generando 10*2^5 = 320 registros.

-- Insertar datos en la tabla productos (with specific types)
INSERT INTO productos (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES
        ('REF001', 'Producto 1', 'Descripción del producto 1', (SELECT id FROM tipo WHERE nombre = 'Electrónica' LIMIT 1), 10, 100.0, 10, 21, TRUE),
        ('REF002', 'Producto 2', 'Descripción del producto 2', (SELECT id FROM tipo WHERE nombre = 'Ropa' LIMIT 1), 20, 200.0, 15, 21, FALSE),
        ('REF003', 'Producto 3', 'Descripción del producto 3', (SELECT id FROM tipo WHERE nombre = 'Alimentos' LIMIT 1), 30, 300.0, 5, 21, TRUE),
        ('REF004', 'Producto 4', 'Descripción del producto 4', (SELECT id FROM tipo WHERE nombre = 'Hogar' LIMIT 1), 40, 400.0, 20, 21, FALSE),
        ('REF005', 'Producto 5', 'Descripción del producto 5', (SELECT id FROM tipo WHERE nombre = 'Juguetes' LIMIT 1), 50, 500.0, 0, 21, TRUE),
        ('REF006', 'Producto 6', 'Descripción del producto 6', (SELECT id FROM tipo WHERE nombre = 'Libros' LIMIT 1), 60, 600.0, 10, 21, FALSE),
        ('REF007', 'Producto 7', 'Descripción del producto 7', (SELECT id FROM tipo WHERE nombre = 'Deportes' LIMIT 1), 70, 700.0, 5, 21, TRUE),
        ('REF008', 'Producto 8', 'Descripción del producto 8', (SELECT id FROM tipo WHERE nombre = 'Salud' LIMIT 1), 80, 800.0, 15, 21, FALSE),
        ('REF009', 'Producto 9', 'Descripción del producto 9', (SELECT id FROM tipo WHERE nombre = 'Belleza' LIMIT 1), 90, 900.0, 10, 21, TRUE),
        ('REF010', 'Producto 10', 'Descripción del producto 10', (SELECT id FROM tipo WHERE nombre = 'Automotriz' LIMIT 1), 100, 1000.0, 20, 21, FALSE);
-- Comentario: This block insert 10 products with specific types.

-- Generar 90 inserciones adicionales en la tabla productos
-- Insertar datos en la tabla productos (generación masiva)
INSERT INTO productos (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto)
-- Seleccionar los datos para la inserción
SELECT
    -- Generar una referencia única: 'REF' seguido de un número de 3 dígitos con ceros a la izquierda.
    CONCAT('REF', LPAD(FLOOR(RAND() * 1000), 3, '0')),
    -- Generar un nombre aleatorio: 'Producto ' seguido de un número entre 0 y 99.
    CONCAT('Producto ', FLOOR(RAND() * 100)),
    -- Generar una descripción aleatoria: 'Descripción del producto ' seguido de un número entre 0 y 99.
    CONCAT('Descripción del producto ', CAST(FLOOR(RAND() * 100) AS CHAR)),
    -- Obtener el ID del tipo de producto de forma aleatoria
    (SELECT id FROM tipo ORDER BY RAND() LIMIT 1),
    -- Generar una cantidad aleatoria: un número entre 1 y 100.
    FLOOR(RAND() * 100) + 1,
    -- Generar un precio aleatorio: un número entre 0 y 1000 con dos decimales.
    ROUND(RAND() * 1000, 2),
    -- Generar un descuento aleatorio: un número entre 0 y 30.
    FLOOR(RAND() * 30),
    -- IVA fijo en 21.
    21,
    -- Generar un valor booleano aleatorio (TRUE o FALSE) para aplicarDto.
    (RAND() > 0.5)
-- De la siguiente fuente de datos
FROM
    -- Generar una tabla temporal con 10 filas (t1)
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL
     SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10) AS t1,
    -- Generar otra tabla temporal con 10 filas (t2)
    (SELECT 1 UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL
     SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10) AS t2
-- Limitar el número de filas insertadas a 90.
LIMIT 90;

-- Asegúrate de que el número de inserciones sea 100
SELECT COUNT(*) FROM productos;