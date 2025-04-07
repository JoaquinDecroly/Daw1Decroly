-- Crear la base de datos
DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda;
USE tienda;

-- Crear la tabla tipo
CREATE TABLE tipo (
id INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL
);

-- Crear la tabla productos
CREATE TABLE productos (
id INT PRIMARY KEY AUTO_INCREMENT,
referencia VARCHAR(50) NOT NULL UNIQUE,
nombre VARCHAR(100) NOT NULL,
descripcion TEXT,
tipo INT,
cantidad INT NOT NULL,
precio DOUBLE NOT NULL,
descuento INT NOT NULL,
iva INT NOT NULL,
aplicarDto BOOLEAN NOT NULL,
FOREIGN KEY (tipo) REFERENCES tipo(id)
);

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


INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;
INSERT INTO tipo (nombre) SELECT nombre FROM tipo;

-- Insertar datos en la tabla productos
INSERT INTO productos (referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES
    ('REF001', 'Producto 1', 'Descripción del producto 1', 1, 10, 100.0, 10, 21, TRUE),
    ('REF002', 'Producto 2', 'Descripción del producto 2', 3, 20, 200.0, 15, 21, FALSE),
    ('REF003', 'Producto 3', 'Descripción del producto 3', 5, 30, 300.0, 5, 21, TRUE),
    ('REF004', 'Producto 4', 'Descripción del producto 4', 8, 40, 400.0, 20, 21, FALSE),
    ('REF005', 'Producto 5', 'Descripción del producto 5', 10, 50, 500.0, 0, 21, TRUE),
    ('REF006', 'Producto 6', 'Descripción del producto 6', 5, 60, 600.0, 10, 21, FALSE),
    ('REF007', 'Producto 7', 'Descripción del producto 7', 4, 70, 700.0, 5, 21, TRUE),
    ('REF008', 'Producto 8', 'Descripción del producto 8', 2, 80, 800.0, 15, 21, FALSE),
    ('REF009', 'Producto 9', 'Descripción del producto 9', 9, 90, 900.0, 10, 21, TRUE),
    ('REF010', 'Producto 10', 'Descripción del producto 10', 4, 100, 1000.0, 20, 21, FALSE);'REF010', 'Producto 10', 'Descripción del producto 10', 4, 100, 1000.0, 20, 21, FALSE);
