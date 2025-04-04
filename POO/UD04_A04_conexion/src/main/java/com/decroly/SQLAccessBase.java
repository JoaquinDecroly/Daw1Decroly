package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessBase {
    static List<String> getProductos() {
        List<String> productos = new LinkedList<String>();

        // Define la consulta SQL para seleccionar todos los productos
        String sql = "SELECT * FROM productos";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            // Establece el parámetro de la consulta (aunque no se usa en esta consulta, se mantiene por consistencia)
            statement.setString(1, "");
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                int id = dataSet.getInt("id");
                String referencia = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String descripcion = dataSet.getString("desc");
                int tipo = dataSet.getInt("tipo");
                int cantidad = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
            // Captura cualquier excepción que pueda ocurrir durante la ejecución

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return productos;
    }


    static List<String> getProductoByReferencia(String ref) {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar productos por referencia
        String sql = "SELECT * FROM productos WHERE referencia = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            // Establece el parámetro de la consulta (referencia)
            statement.setString(1, ref);
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                int id = dataSet.getInt("id");
                String referencia = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String descripcion = dataSet.getString("desc");
                int tipo = dataSet.getInt("tipo");
                int cantidad = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
            // Captura cualquier excepción que pueda ocurrir durante la ejecución

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productos;
    }


    static List<String> getProductoByTipo(int tipe) {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar productos por tipo
        String sql = "SELECT * FROM productos WHERE tipo = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            // Establece el parámetro de la consulta (tipo)
            statement.setString(1, String.valueOf(tipe));
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                int id = dataSet.getInt("id");
                String referencia = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String descripcion = dataSet.getString("desc");
                int tipo = dataSet.getInt("tipo");
                int cantidad = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
            // Captura cualquier excepción que pueda ocurrir durante la ejecución

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productos;
    }


    static List<String> getProductoByCantidad(int cant) {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar productos por cantidad
        String sql = "SELECT * FROM productos WHERE cantidad = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            // Establece el parámetro de la consulta (cantidad)
            statement.setString(1, String.valueOf(cant));
            // Ejecuta la consulta y obtiene el conjunto de resultados
            ResultSet dataSet = statement.executeQuery();

            // Itera sobre cada fila del conjunto de resultados
            while (dataSet.next()) {
                // Extrae los datos de cada columna de la fila actual
                int id = dataSet.getInt("id");
                String referencia = dataSet.getString("ref");
                String nombre = dataSet.getString("nombre");
                String descripcion = dataSet.getString("desc");
                int tipo = dataSet.getInt("tipo");
                int cantidad = dataSet.getInt("cantidad");
                double precio = dataSet.getDouble("precio");
                int descuento = dataSet.getInt("descuento");
                int iva = dataSet.getInt("iva");
                boolean aplicarDto = dataSet.getBoolean("aplicarDto");

                // Crea un nuevo objeto Producto con los datos extraídos
                Producto p1 = new Producto(id, referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                // Añade la representación en String del producto a la lista de productos
                productos.add(String.valueOf(p1));
            }
            // Captura cualquier excepción que pueda ocurrir durante la ejecución

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productos;
    }


    private static void insertProducto(Producto producto) {
        // Define la consulta SQL para insertar un nuevo producto
        String sql = "INSERT INTO productos (id, ref, nombre, desc, tipo, cantidad, precio, descuento, iva, aplicarDto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Establece los parámetros de la consulta con los datos del producto
            statement.setInt(1, producto.getId());
            statement.setString(2, producto.getRef());
            statement.setString(3, producto.getNombre());
            statement.setString(4, producto.getDesc());
            statement.setInt(5, producto.getTipo());
            statement.setInt(6, producto.getCantidad());
            statement.setDouble(7, producto.getPrecio());
            statement.setInt(8, producto.getDescuento());
            statement.setInt(9, producto.getIva());
            statement.setBoolean(10, producto.isAplicarDto());

            // Ejecuta la consulta de inserción
            statement.executeUpdate();

            // Captura cualquier excepción que pueda ocurrir durante la ejecución
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static void deleteProductoByReferencia(String referencia) {
        // Define la consulta SQL para eliminar un producto por referencia
        String sql = "DELETE FROM productos WHERE referencia = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            // Establece el parámetro de la consulta (referencia)
            statement.setNString(1, referencia);
            // Ejecuta la consulta de eliminación
            statement.executeUpdate();
            // Captura cualquier excepción que pueda ocurrir durante la ejecución

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void updateProducto(int id) {
        String sql = "UPDATE  PRODUCTOS SET DESCRIPCION = ?, CANTIDAD = ?, PRECIO = ?, DESCUENTO = ?, APLICARDTO = ? WHERE ID = ?";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLDataBaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {

            // Establece el parámetro de la consulta (referencia)
            statement.setInt(1, id);
            statement.setNString(4, Producto.getDesc());
            statement.setInt(6, Producto.getCantidad());
            statement.setDouble(7, Producto.getPrecio());
            statement.setInt(8, Producto.getDescuento());
            statement.setBoolean(10, Producto.isAplicarDto());


            // Ejecuta la consulta de actualización
            statement.executeUpdate();
            // Captura cualquier excepción que pueda ocurrir durante la ejecución

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

