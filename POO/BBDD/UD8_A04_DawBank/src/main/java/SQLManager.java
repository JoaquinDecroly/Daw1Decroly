import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLManager {
    private static String DRIVER;
    private static String URL;
    private static String USUARIO;
    private static String CLAVE;
    private static String SCHEMA;

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/application.dat"))){
        String linea;

        while ((linea = reader.readLine()) != null){
            String[] partes = linea.split("=");
            if(partes.length == 2){
                switch(partes[0].trim()){
                    case "driver":
                        DRIVER = partes[1].trim();
                        break;
                    case "url":
                        URL = partes[1].trim();
                        break;
                    case"schema":
                        SCHEMA = partes[1].trim();
                        break;
                    case "usuario":
                        USUARIO = partes[1].trim();
                        break;
                    case "clave":
                        CLAVE = partes[1].trim();
                        break;
                }
            }
        }
    } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Connection getConecction(){
    Connection conecction = null;
    try{
        Class.forName(DRIVER);
        conecction = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);
        
    } catch (ClassNotFoundException | SQLException e) {
        System.out.println(e.getMessage());
    }
    return conecction;
    }
}
