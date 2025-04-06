package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessBase {

    static List<String> getProductos() {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar todos los productos
        String sql = "SELECT * FROM productos";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                String ref = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String desc = dataSet.getString("desc");
                int tipo = dataSet.getInt("tipo");
                int cantidad = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(ref, nombre, desc, tipo, cantidad, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        }

        return productos;
    }

    static List<String> getProductoByReferencia(String ref) {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar productos por referencia
        String sql = "SELECT * FROM productos WHERE ref = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establece el parámetro de la consulta (referencia)
            statement.setString(1, ref);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                String referencia = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String desc = dataSet.getString("desc");
                int tipo = dataSet.getInt("tipo");
                int cantidad = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(referencia, nombre, desc, tipo, cantidad, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener producto por referencia: " + e.getMessage());
        }
        return productos;
    }

    static List<String> getProductoByTipo(int tipo) {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar productos por tipo
        String sql = "SELECT * FROM productos WHERE tipo = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establece el parámetro de la consulta (tipo)
            statement.setInt(1, tipo);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                String referencia = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String desc = dataSet.getString("desc");
                int tipoProducto = dataSet.getInt("tipo");
                int cantidad = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(referencia, nombre, desc, tipoProducto, cantidad, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener producto por tipo: " + e.getMessage());
        }
        return productos;
    }

    static List<String> getProductoByCantidad(int cantidad) {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar productos por cantidad
        String sql = "SELECT * FROM productos WHERE cantidad = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Establece el parámetro de la consulta (cantidad)
            statement.setInt(1, cantidad);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                String referencia = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String desc = dataSet.getString("desc");
                int tipo = dataSet.getInt("tipo");
                int cantidadProducto = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(referencia, nombre, desc, tipo, cantidadProducto, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener producto por cantidad: " + e.getMessage());
        }
        return productos;
    }

    static void insertProducto(Producto producto) {
        // Define la consulta SQL para insertar un nuevo producto
        String sql = "INSERT INTO productos (ref, nombre, desc, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Establece los parámetros de la consulta con los datos del producto
            statement.setString(1, producto.getRef());
            statement.setString(2, producto.getNombre());
            statement.setString(3, producto.getDesc());
            statement.setInt(4, producto.getTipo());
            statement.setInt(5, producto.getCantidad());
            statement.setDouble(6, producto.getPrecio());
            statement.setInt(7, producto.getDescuento());
            statement.setInt(8, producto.getIva());
            statement.setBoolean(9, producto.isAplicarDto());

            // Ejecuta la consulta de inserción
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar producto: " + e.getMessage());
        }
    }

    static void deleteProductoByReferencia(String referencia) {
        // Define la consulta SQL para eliminar un producto por referencia
        String sql = "DELETE FROM productos WHERE ref = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Establece el parámetro de la consulta (referencia)
            statement.setString(1, referencia);
            // Ejecuta la consulta de eliminación
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar producto por referencia: " + e.getMessage());
        }
    }

    static void updateProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, desc = ?, tipo = ?, cantidad = ?, precio = ?, descuento = ?, iva = ?, aplicarDto = ? WHERE ref = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Establece los parámetros de la consulta
            statement.setString(1, producto.getNombre());
            statement.setString(2, producto.getDesc());
            statement.setInt(3, producto.getTipo());
            statement.setInt(4, producto.getCantidad());
            statement.setDouble(5, producto.getPrecio());
            statement.setInt(6, producto.getDescuento());
            statement.setInt(7, producto.getIva());
            statement.setBoolean(8, producto.isAplicarDto());
            statement.setString(9, producto.getRef());

            // Ejecuta la consulta de actualización
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar producto: " + e.getMessage());
        }
    }

    // Verificar si la referencia ya existe
    static boolean existeReferencia(String referencia) {
        String sql = "SELECT COUNT(*) FROM productos WHERE ref = ?";
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, referencia);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar la referencia: " + e.getMessage());
        }
        return false;
    }

    // Insertar un nuevo tipo de producto
    static void insertarTipoProducto(String tipoProducto) {
        String sql = "INSERT INTO tipos (nombre) VALUES (?)";

        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tipoProducto);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar el tipo de producto: " + e.getMessage());
        }
    }
}