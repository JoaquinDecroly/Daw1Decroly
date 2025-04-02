package com.decroly;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configLoader {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/";
    private static String SCHEMA = "tienda";
    private static String USUARIO = "root";
    private static String CLAVE = "daw12";


    private void loadConfig(){
       Properties properties = new Properties();
       try (FileInputStream input = new FileInputStream("productos.dat")){
           properties.load(input);
           DRIVER = properties.getProperty("DRIVER");
           URL = properties.getProperty("URL");
           SCHEMA = properties.getProperty("SCHEMA");
           USUARIO = properties.getProperty("USUARIO");
           CLAVE = properties.getProperty("CLAVE");

       } catch(FileNotFoundException e){
           e.printStackTrace();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    public static String getDriver() {
        return DRIVER;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getSchema() {
        return SCHEMA;
    }

    public static String getUsuario() {
        return USUARIO;
    }

    public static String getClave() {
        return CLAVE;
    }

}
