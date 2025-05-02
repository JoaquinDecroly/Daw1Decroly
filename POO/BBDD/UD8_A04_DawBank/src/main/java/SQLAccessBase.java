import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SQLAccessBase {
    

    static void addCuentaBancaria(CuentaBancaria cuentaBancaria) {
        List<String> productos = new LinkedList<>();

        // Define la consulta SQL para seleccionar todos los productos
        String sql = "INSERT INTO CUENTABANCARIA(IBAN, TITULAR) values(?, ?)";

        // Intenta establecer una conexión y preparar la consulta
        try (Connection connection = SQLManager.getConecction();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Ejecuta la consulta y obtiene el conjunto de resultados

            statement.setString(1, CuentaBancaria.getIban());
            statement.setString(2, CuentaBancaria.getTitular());

            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al insertar la cuentaBancaria: " + e.getMessage());
        }
    }
        static List<CuentaBancaria> getCuentasBancarias() {
            List<CuentaBancaria> cuentas = new LinkedList<>();
            String sql = "SELECT * FROM VISTA_SALDO VS JOIN CUENTABANCARIA CB ON VS.ID = CB.ID WHERE CB.TITULAR = ?";

            try (Connection connection = SQLManager.getConecction();
                 PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet rs = statement.executeQuery()) {

                while (rs.next()) {
                    CuentaBancaria cuenta = new CuentaBancaria(
                            rs.getString("IBAN"),
                            rs.getString("TITULAR"),
                            rs.getDouble("SALDO")
                    );
                    cuentas.add(cuenta);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener cuentas bancarias: " + e.getMessage());
            }
            return cuentas;
        }

    static List<Movimientos> getMovimientosFromCuenta(String titular) {
        List<Movimientos> movimientos = new LinkedList<>();
        String sql = "SELECT M.* FROM MOVIMIENTOS M " +
                "JOIN CUENTABANCARIA CB ON M.IBAN = CB.IBAN " +
                "WHERE CB.TITULAR = ? " +
                "ORDER BY M.FECHA DESC";

        try (Connection connection = SQLManager.getConecction();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, titular);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    try {
                        movimientos.add(new Movimientos(
                                rs.getInt("ID"),
                                rs.getString("IBAN"),
                                rs.getString("TITULAR"),
                                rs.getDate("FECHA").toLocalDate(),
                                tipo.valueOf(rs.getString("TIPO").toUpperCase()),
                                rs.getDouble("CANTIDAD")
                        ));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Error al convertir el tipo: " + e.getMessage());
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener movimientos: " + e.getMessage());
        }
        return movimientos;
    }

    static Map<String, Double> getSaldoFromVista(String iban) {
        Map<String, Double> saldos = new HashMap<>();
        String sql = "SELECT * FROM VISTA_SALDO WHERE IBAN = ?";

        try (Connection connection = SQLManager.getConecction();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, iban);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    saldos.put(rs.getString("IBAN"), rs.getDouble("SALDO"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener saldo de la vista: " + e.getMessage());
        }
        return saldos;
    }

    static List<Movimientos> getMovimientosPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Movimientos> movimientos = new LinkedList<>();
        String sql = "SELECT * FROM MOVIMIENTOS WHERE FECHA BETWEEN ? AND ? ORDER BY FECHA DESC";

        try (Connection connection = SQLManager.getConecction();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, Date.valueOf(fechaInicio));
            statement.setDate(2, Date.valueOf(fechaFin));

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    movimientos.add(new Movimientos(
                            rs.getInt("ID"),
                            rs.getString("IBAN"),
                            rs.getString("TITULAR"),
                            rs.getDate("FECHA").toLocalDate(),
                            tipo.valueOf(rs.getString("TIPO").toUpperCase()),
                            rs.getDouble("CANTIDAD")
                    ));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener movimientos por fecha: " + e.getMessage());
        }
        return movimientos;
    
    }
    
}
