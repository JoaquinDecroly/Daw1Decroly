package com.decroly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseManager {
    private static String DRIVER;
    private static String URL;
    private static String SCHEMA;
    private static String USUARIO;
    private static String CLAVE;

//     Método para cargar credenciales desde el archivo
    public static boolean cargarCredenciales(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            DRIVER = br.readLine(); // Driver de la base de datos
            URL = br.readLine(); // URL de la base de datos
            SCHEMA = br.readLine(); // Esquema de la base de datos
            USUARIO = br.readLine(); // Usuario
            CLAVE = br.readLine(); // Contraseña

            // Cargar el driver JDBC
            Class.forName(DRIVER);
            return true; // Credenciales cargadas correctamente
        } catch (IOException e) {
            System.err.println("Error al cargar las credenciales: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error de acceso al driver: " + e.getMessage());
        }
        return false; // Fallo al cargar las credenciales
    }

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }
        return connection;
    }
}