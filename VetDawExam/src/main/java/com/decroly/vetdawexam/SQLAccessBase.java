package com.decroly.vetdawexam;

import com.decroly.vetdawexam.model.Consulta;
import com.decroly.vetdawexam.model.Mascota;
import com.decroly.vetdawexam.model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessBase {
    static void addPropietario(Persona propietario) {
        List<Persona> propietarios = new LinkedList<>();

        // Define la consulta SQL para seleccionar todos los productos
        String sql = "INSERT INTO PROPIETARIO(DNI, NOMBRE, APELLIDO, TELEFONO, DIRECCION, EMAIL) values(?, ?, ?, ?, ?, ?)";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Ejecuta la consulta y obtiene el conjunto de resultados

            statement.setString(1, propietario.getDni());
            statement.setString(2, propietario.getNombre());
            statement.setString(1, propietario.getApellido());
            statement.setString(2, propietario.getTelefono());
            statement.setString(1, propietario.getDireccion());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al insertar la cuentaBancaria: " + e.getMessage());
        }
    }
    

  
}
