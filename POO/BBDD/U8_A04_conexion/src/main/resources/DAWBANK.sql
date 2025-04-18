DROP DATABASE IF EXISTS DAWBANK;
CREATE DATABASE DAWBANK;
USE DAWBANK;

-- Crear la tabla CUENTABANCARIA
CREATE TABLE CUENTABANCARIA(
    IBAN VARCHAR(24) PRIMARY KEY,
    TITULAR VARCHAR(40) NOT NULL UNIQUE,
    SALDO DECIMAL(8,2) DEFAULT 0.00
);

-- Crear la tabla MOVIMIENTOS
CREATE TABLE MOVIMIENTOS(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    IBAN VARCHAR(24),
    FECHA DATE,
    CANTIDAD DECIMAL(8,2),
    TIPO ENUM('INGRESO', 'RETIRADA'),
    FOREIGN KEY (IBAN) REFERENCES CUENTABANCARIA(IBAN)
);

-- Inserción de datos en la tabla CUENTABANCARIA
INSERT INTO CUENTABANCARIA (IBAN, TITULAR, SALDO) 
VALUES ('ES1234567891012131415167', 'PEDRO SALAZAR', SALDO);

-- Inserción de datos en la tabla MOVIMIENTOS
INSERT INTO MOVIMIENTOS (IBAN, FECHA, CANTIDAD, TIPO)  
VALUES 
    ('ES1234567891012131415167', '2023-10-01', 100.00, 'INGRESO'),
    ('ES1234567891012131415167', '2023-10-05', 50.00, 'RETIRADA');

-- Crear el trigger para actualizar el saldo
-- DELIMITER //
-- CREATE TRIGGER actualizar_saldo
-- AFTER INSERT ON MOVIMIENTOS
-- FOR EACH ROW
-- BEGIN
--     IF NEW.TIPO = 'INGRESO' THEN
--         UPDATE CUENTABANCARIA
--         SET SALDO = SALDO + NEW.CANTIDAD
--         WHERE IBAN = NEW.IBAN;
--     ELSEIF NEW.TIPO = 'RETIRADA' THEN
--         -- Verificar que el saldo no se vuelva negativo
--         IF (SELECT SALDO FROM CUENTABANCARIA WHERE IBAN = NEW.IBAN) >= NEW.CANTIDAD THEN
--             UPDATE CUENTABANCARIA
--             SET SALDO = SALDO - NEW.CANTIDAD
--             WHERE IBAN = NEW.IBAN;
--         ELSE
--             SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente para realizar la retirada';
--         END IF;
--     END IF;
-- END;
-- //
-- ----------------------------------------------------------------------------------------------------------------
CREATE VIEW VISTA_SALDO AS 
SELECT 
    C.IBAN,
    C.TITULAR,
    COALESCE(SUM(CASE WHEN M.TIPO = 'INGRESO' THEN M.CANTIDAD ELSE 0 END), 0) - 
    COALESCE(SUM(CASE WHEN M.TIPO = 'RETIRADA' THEN M.CANTIDAD ELSE 0 END), 0) AS SALDO
FROM 
    CUENTABANCARIA C
LEFT JOIN 
    MOVIMIENTOS M ON C.IBAN = M.IBAN
GROUP BY 
    C.IBAN, C.TITULAR;


-- Consulta para verificar los datos
SELECT * FROM CUENTABANCARIA;
SELECT * FROM MOVIMIENTOS;
SELECT * FROM VISTA_SALDO;
