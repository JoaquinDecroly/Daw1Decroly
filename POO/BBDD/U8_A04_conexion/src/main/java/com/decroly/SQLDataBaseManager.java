package com.decroly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseManager {

    private static String DRIVER;
    static String URL;
    private static String SCHEMA;
    static String USUARIO;
    static String CLAVE;

    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/application.dat"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    switch (parts[0].trim()) {
                        case "driver":
                            DRIVER = parts[1].trim();
                            break;
                        case "url":
                            URL = parts[1].trim();
                            break;
                        case "schema":
                            SCHEMA = parts[1].trim();
                            break;
                        case "usuario":
                            USUARIO = parts[1].trim();
                            break;
                        case "clave":
                            CLAVE = parts[1].trim();
                            break;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        return connection;
    }
}
